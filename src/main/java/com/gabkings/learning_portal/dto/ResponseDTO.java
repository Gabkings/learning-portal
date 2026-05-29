package com.gabkings.learning_portal.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ResponseDTO <T>{
    private String message;
    private T data;
    private Long totalCount;
    private LocalDateTime timestamp = LocalDateTime.now();

}
