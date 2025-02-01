package com.penovatech.shopping.utils;

import com.penovatech.shopping.config.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SessionUtility {

    public static UserPrincipal getCurrentUserPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserPrincipal) {
            return (UserPrincipal) authentication.getPrincipal();
        }
        throw new RuntimeException();
    }

    public static Long getCurrentUserId() {
        UserPrincipal currentUserPrincipal = getCurrentUserPrincipal();
        return currentUserPrincipal.getUserId();
    }
}
