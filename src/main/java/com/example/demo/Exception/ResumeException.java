package com.example.demo.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResumeException extends RuntimeException {
    private final String error;
    private final Integer status;
    private final String message;
}
