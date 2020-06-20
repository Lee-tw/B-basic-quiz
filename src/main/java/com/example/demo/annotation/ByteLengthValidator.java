package com.example.demo.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.nio.charset.StandardCharsets;

public class ByteLengthValidator implements ConstraintValidator<ByteValidatorAnnotation, String> {
    private int max;
    private int min;

    public void initialize(ByteValidatorAnnotation constraintAnnotation) {
        this.max = constraintAnnotation.maxValue();
        this.min = constraintAnnotation.minValue();
    }

    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if (object == null)
            return false;
        else if (object.getBytes(StandardCharsets.UTF_8).length >= this.min && object.getBytes(StandardCharsets.UTF_8).length <= this.max)
            return true;
        else
            return false;
    }
}
