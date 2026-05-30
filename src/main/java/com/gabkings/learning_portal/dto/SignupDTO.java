package com.gabkings.learning_portal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDTO {

    @NotBlank(message = "first name is required")
    @Size(max = 150, message = "first name cannot be more than 100 characters")
    @Pattern(regexp = "[A-Z][A-Za-z ]*", message = "First name should follow this pattern - [A-Z][A-Za-z ]*")
    private String firstName;

    @Size(max = 150, message = "last name cannot be more than 100 characters")
    @Pattern(regexp = "[A-Z][A-Za-z ]*", message = "Last name should follow this pattern - [A-Z][A-Za-z ]*")
    private String lastName;

    @NotBlank(message = "username is required")
    @Size(max = 150, message = "Username cannot be more than 150 characters")
    private String username;

    @NotBlank(message = "email is required")
    @Email(message = "email should be according to email pattern")
    @Size(max = 150, message = "Email cannot be greater than 150 characters")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 8, max = 12, message = "password should lie in between 8-12 characters")
    private String password;
}
