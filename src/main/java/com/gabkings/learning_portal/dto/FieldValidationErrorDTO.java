package com.gabkings.learning_portal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldValidationErrorDTO {

    private String fieldName;

    private String message;
}
