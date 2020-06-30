package com.example.demo.Exception;

import com.example.demo.error.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Iterator;

@RestControllerAdvice
public class ControllerExceptionAdvice {
    @ExceptionHandler(ResumeException.class)
    // @ResponseBody   表示该方法的返回结果直接写入 HTTP response body 中
    public ResponseEntity<ErrorResult> handleAccountException(ResumeException e) {
        ErrorResult errorResult = new ErrorResult(OffsetDateTime.now().toString(), e.getStatus(), e.getError(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorResult> handleValidationException(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        String message = fieldError.getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(OffsetDateTime.now().toString(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
