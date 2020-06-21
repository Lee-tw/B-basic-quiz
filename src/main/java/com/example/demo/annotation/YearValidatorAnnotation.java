package com.example.demo.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {YearValidator.class})
public @interface YearValidatorAnnotation {

    String message() default "年份错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
