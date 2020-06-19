package com.example.demo.controller.dto;

import com.example.demo.model.Education;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EducationInputDTO {
    private Long year;
    private String title;
    private String description;

    public Education toEducation() {
        return Education.builder().year(year).title(title).description(description).build();
    }
}
