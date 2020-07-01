package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationJpaRepo extends JpaRepository<Education, Integer> {
    List<Education> findAllByUser(User user);
}
