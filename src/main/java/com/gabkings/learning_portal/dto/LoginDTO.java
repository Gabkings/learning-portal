package com.gabkings.learning_portal.dto;

//import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Schema(description = "DTO (Data Transfer Object) for login API.")
public class LoginDTO {

    @NotBlank(message = "Username is required")
    @Size(max = 150, message = "Username cannot be more than 150 characters")
//    @Schema(description = "username of the existing user details", example = "piyushthedeveloper")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 12, message = "Password should lie in between 8-12 characters")
//    @Schema(description = "password required to login into application along with username.")
    private String password;
}
