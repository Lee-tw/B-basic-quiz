package com.example.demo.controller.dto;

import com.example.demo.annotation.ByteValidatorAnnotation;
import com.example.demo.model.Education;
import lombok.AllArgsConstructor;

import javax.validation.constraints.Past;

@AllArgsConstructor
public class EducationInputDTO {

    @Past
    private final Long year;

    @ByteValidatorAnnotation(minValue = 1, maxValue = 256, message = "长度应该在 1 - 256 bytes之间")
    private final String title;

    @ByteValidatorAnnotation(minValue = 1, maxValue = 4096, message = "长度应该在 1 - 4096 bytes之间")
    private final String description;

    public Education toEducation() {
        return Education.builder().year(year).title(title).description(description).build();
    }
}
