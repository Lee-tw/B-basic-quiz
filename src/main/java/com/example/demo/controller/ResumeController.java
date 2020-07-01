package com.example.demo.controller;

import com.example.demo.Exception.ResumeException;
import com.example.demo.controller.dto.EducationInputDTO;
import com.example.demo.controller.dto.EducationOutputDTO;
import com.example.demo.controller.dto.UserInputDTO;
import com.example.demo.model.Education;
import com.example.demo.model.User;
import com.example.demo.service.ResumeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@CrossOrigin
public class ResumeController {
    private final ResumeService resumeService;

    // 异常可以在Service中直接抛出，而不用在Controller中判断返回值
    @GetMapping("/{id}")
    public User getUserById(@Valid @PathVariable("id") Integer id) {
        Optional<User> userById = resumeService.getUserById(id);
        if (userById.isPresent())
            return userById.get();
        throw new ResumeException("Not Found", 404, "Cannot find user with id " + id);
    }

    @GetMapping("/{id}/educations")
    // @RequestParam上validate失败后抛出的异常是 ConstraintViolationException
    public List<EducationOutputDTO> getUserEducationsById(@PathVariable("id") Integer id) {
        return resumeService.getUserEducationsById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // @RequestBody上validate失败后抛出的异常是 MethodArgumentNotValidException
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
