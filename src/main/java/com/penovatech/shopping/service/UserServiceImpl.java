package com.penovatech.shopping.service;

import com.penovatech.common.base.service.AbstractServiceImpl;
import com.penovatech.shopping.config.security.JwtTokenProvider;
import com.penovatech.shopping.dto.RegisterRequest;
import com.penovatech.shopping.mapper.UserMapper;
import com.penovatech.shopping.model.User;
import com.penovatech.shopping.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, Long, UserRepository> implements UserService {
    public UserServiceImpl(UserRepository repository,
                           UserMapper mapper,
                           JwtTokenProvider jwtTokenProvider,
                           PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public String register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Hash the password
        user.setRoles("USER");
        User savedUser = repository.save(user);

        // Create an authentication object for the new user
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                null,
                Collections.singletonList(new SimpleGrantedAuthority("USER"))
        );

        // Generate a JWT token
        return jwtTokenProvider.generateToken(authentication, savedUser.getId());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
