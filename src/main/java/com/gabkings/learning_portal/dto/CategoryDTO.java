package com.gabkings.learning_portal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO {

    private Long id;
    @NotBlank(message = "name cannot be blank.")
    @Size(max = 100, message = "name cannot be greater than 100 characters.")
    @Pattern(regexp = "[A-Z][a-zA-Z0-9 ]*", message = "name should follow this regex- [A-Z][a-zA-Z0-9 ]*")
//    @Schema(description = "Name of the category", defaultValue = "Generative AI", example = "Generative AI")
    private String name;

    @Size(message = "description cannot be greater than 255 characters")
    private String description;
}
