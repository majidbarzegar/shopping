package com.penovatech.shopping.config;

import java.security.Principal;

public class UserPrincipal implements Principal {

    private final String username;
    private final Long userId;

    public UserPrincipal(String username, Long userId) {
        this.username = username;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String getName() {
        return username;
    }
}