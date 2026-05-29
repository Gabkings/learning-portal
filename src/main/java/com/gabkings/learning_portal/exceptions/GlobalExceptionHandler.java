package com.gabkings.learning_portal.exceptions;

import com.gabkings.learning_portal.dto.ErrorResponseDTO;
import com.gabkings.learning_portal.dto.FieldValidationErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest webRequest) {
     ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
     errorResponseDTO.setPath(webRequest.getDescription(false));

     List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

     List<FieldValidationErrorDTO> fieldValidationErrorDTOS = fieldErrors.stream().map(err -> {
         FieldValidationErrorDTO fieldValidationErrorDTO = new FieldValidationErrorDTO();
         fieldValidationErrorDTO.setFieldName(err.getField());
         fieldValidationErrorDTO.setMessage(err.getDefaultMessage());
         return fieldValidationErrorDTO;
     }).toList();

     errorResponseDTO.setFieldValidationErrors(fieldValidationErrorDTOS);
     errorResponseDTO.setMessage("Validation error failed");
     return errorResponseDTO;
    }
}
