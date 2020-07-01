package com.example.demo.controller.dto;

import com.example.demo.model.Education;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationOutputDTO {
    private Integer id;
    private Long year;
    private String title;
    private String description;

    public static EducationOutputDTO of(Education education) {
        return EducationOutputDTO.builder()
                .id(education.getId())
                .year(education.getYear())
                .title(education.getTitle())
                .description(education.getDescription())
                .build();
    }
}
