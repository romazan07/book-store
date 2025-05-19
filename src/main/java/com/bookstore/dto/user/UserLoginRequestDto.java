package com.bookstore.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class UserLoginRequestDto {
    @NotBlank
    @Email
    @Length(min = 4, max = 20)
    private String email;
    @NotBlank
    @Length(min = 4, max = 20)
    private String password;
}
