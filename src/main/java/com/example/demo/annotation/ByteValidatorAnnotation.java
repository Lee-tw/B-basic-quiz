package com.example.demo.annotation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ByteLengthValidator.class})
public @interface ByteValidatorAnnotation {

    int maxValue();

    int minValue();

    String message() default "长度错误";
}
