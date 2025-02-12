package com.penovatech.shopping.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank
    @Email(message = "INVALID_EMAIL_FORMAT")
    private String email;
    private String password;
}
