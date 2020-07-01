package com.example.demo.service;

import com.example.demo.Exception.ResumeException;
import com.example.demo.controller.dto.EducationOutputDTO;
import com.example.demo.model.Education;
import com.example.demo.model.EducationJpaRepo;
import com.example.demo.model.User;
import com.example.demo.model.UserJpaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class ResumeService {
    private final EducationJpaRepo educationJpaRepo;
    private final UserJpaRepo userJpaRepo;

    public Optional<User> getUserById(int id) {
        return userJpaRepo.findUserById(id);
    }

    public List<EducationOutputDTO> getUserEducationsById(Integer id) {
        Optional<User> user = userJpaRepo.findUserById(id);
        if (user.isPresent()) {
            return educationJpaRepo.findAllByUser(user.get()).stream().map(EducationOutputDTO::of).collect(toList());
        }
        throw new ResumeException("Not Found", 404, "Cannot find user with id " + id);
    }

    public User createUser(User user) {
        return userJpaRepo.save(user);
    }

    public void createEducationForUser(Integer id, Education education) {
        Optional<User> user = userJpaRepo.findUserById(id);
        if (user.isPresent()) {
            education.setUser(user.get());
            educationJpaRepo.save(education);
        } else {
            throw new ResumeException("Not Found", 404, "Cannot find user with id " + id);
        }
    }
}
