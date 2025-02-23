package com.penovatech.shopping.controller;

import com.penovatech.common.dto.ResultDto;
import com.penovatech.common.exception.BusinessException;
import com.penovatech.shopping.config.security.JwtTokenProvider;
import com.penovatech.shopping.dto.LoginRequest;
import com.penovatech.shopping.dto.RegisterRequest;
import com.penovatech.shopping.model.User;
import com.penovatech.shopping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.penovatech.shopping.exception.ShoppingExceptionMessage.INVALID_USERNAME_OR_PASSWORD;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;


    @PostMapping("login")
    public ResultDto<String> login(@RequestBody LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            User user = userService.findByEmail(request.getEmail())
                    .orElseThrow(() -> new BusinessException(INVALID_USERNAME_OR_PASSWORD));
            return new ResultDto<>(
                    jwtTokenProvider.generateToken(authentication, user.getId()),
                    "Login",
                    "Login successful"
            );
        } catch (AuthenticationException e) {
            throw new BusinessException(INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @PostMapping("register")
    public ResultDto<String> register(@RequestBody @Validated RegisterRequest request) {
        return new ResultDto<>(
                userService.register(request),
                "Registration",
                "Registration successful"
        );
    }

}