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
public class User {
    private Integer id;
    private String name;
    private Long age;
    private String avatar;
    private String description;
}
