package com.penovatech.shopping.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank
    private String name;

    @NotBlank
    @Email(message = "INVALID_EMAIL_FORMAT")
    private String email;

    @NotBlank
    @Size(min = 8, max = 50, message = "INVALID_PASSWORD_LENGTH")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "INVALID_PASSWORD_DIGIT"
    )
    private String password;
}
