package com.gabkings.learning_portal.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDTO {

    private String path;

    private String message;

    private LocalDateTime timestamp = LocalDateTime.now();

    private List<FieldValidationErrorDTO> fieldValidationErrors;
}
