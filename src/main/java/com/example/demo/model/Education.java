package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Repository
public class Education {
    private Integer id;
    private Long year;
    private String title;
    private String description;
}
