package com.example.demo.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResult {
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
}
