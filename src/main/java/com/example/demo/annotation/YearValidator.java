package com.example.demo.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class YearValidator implements ConstraintValidator<YearValidatorAnnotation, Long> {

    public boolean isValid(Long object, ConstraintValidatorContext constraintContext) {
        int yearNow = LocalDate.now().getYear();
        if (object == null)
            return false;
        else if (object <= yearNow && object > 1970)
            return true;
        return false;
    }
}
