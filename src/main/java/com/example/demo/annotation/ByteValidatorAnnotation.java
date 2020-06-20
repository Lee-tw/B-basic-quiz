package com.example.demo.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ByteLengthValidator.class})
public @interface ByteValidatorAnnotation {

    int maxValue();

    int minValue();

    String message() default "长度错误";

    // 约束注解在验证时所属的组别，必须
    Class<?>[] groups() default {};

    // 约束注解的有效负载，必须
    Class<? extends Payload>[] payload() default {};
}
