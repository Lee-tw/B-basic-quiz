package com.example.demo.controller.dto;

import com.example.demo.annotation.ByteValidatorAnnotation;
import com.example.demo.annotation.YearValidatorAnnotation;
import com.example.demo.model.Education;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

@AllArgsConstructor
public class EducationInputDTO {

    @YearValidatorAnnotation
    @NotNull(message = "year不能为空")
    private final Long year;

    @NotNull(message = "title不能为空")
    @ByteValidatorAnnotation(minValue = 1, maxValue = 256, message = "title长度应该在 1 - 256 bytes之间")
    private final String title;

    @NotNull(message = "description不能为空")
    @ByteValidatorAnnotation(minValue = 1, maxValue = 4096, message = "description长度应该在 1 - 4096 bytes之间")
    private final String description;

    public Education toEducation() {
        return Education.builder().year(year).title(title).description(description).build();
    }
}
