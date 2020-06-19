package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.ResumeService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class ResumeController {
    private ResumeService resumeService;

    @GetMapping("/{id}")
    public User getUserById(@Valid @PathVariable("id") Integer id) {
        return resumeService.getUserById(id);
    }
}
