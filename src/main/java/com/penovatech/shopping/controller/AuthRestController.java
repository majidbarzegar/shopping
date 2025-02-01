package com.penovatech.shopping.controller;

import com.penovatech.common.dto.ResultDto;
import com.penovatech.shopping.config.JwtTokenProvider;
import com.penovatech.shopping.dto.LoginRequest;
import com.penovatech.shopping.dto.RegisterRequest;
import com.penovatech.shopping.model.User;
import com.penovatech.shopping.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public AuthRestController(AuthenticationManager authenticationManager,
                              JwtTokenProvider jwtTokenProvider,
                              UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResultDto<String> login(@RequestBody LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            User user = userService.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            return new ResultDto<>(
                    jwtTokenProvider.generateToken(authentication, user.getId()),
                    "Login",
                    "Login successful"
            );
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @PostMapping("register")
    public ResultDto<String> register(@RequestBody RegisterRequest request) {
        return new ResultDto<>(
                userService.register(request),
                "Registration",
                "Registration successful"
        );
    }

}