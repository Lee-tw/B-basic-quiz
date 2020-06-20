package com.example.demo.controller;

import com.example.demo.controller.dto.EducationInputDTO;
import com.example.demo.controller.dto.UserInputDTO;
import com.example.demo.model.Education;
import com.example.demo.model.User;
import com.example.demo.service.ResumeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@CrossOrigin
public class ResumeController {
    private final ResumeService resumeService;

    @GetMapping("/{id}")
    public User getUserById(@Valid @PathVariable("id") Integer id) {
        return resumeService.getUserById(id);
    }

    @GetMapping("/{id}/educations")
    public List<Education> getUserEducationsById(@Valid @PathVariable("id") Integer id) {
        return resumeService.getUserEducationsById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createUser(@Valid @RequestBody UserInputDTO userInputDTO) {
        User user = userInputDTO.toUser();
        User createdUser = resumeService.createUser(user);
        return createdUser.getId();
    }

    @PostMapping("/{id}/educations")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEducationsForUser(@Valid @PathVariable("id") Integer id, @Valid @RequestBody EducationInputDTO educationInputDTO) {
        Education education = educationInputDTO.toEducation();
        resumeService.createEducationForUser(id, education);
    }
}
