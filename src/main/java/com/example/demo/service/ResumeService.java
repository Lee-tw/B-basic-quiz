package com.example.demo.service;

import com.example.demo.model.Education;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResumeService {
    private final Map<Integer, User> userMap = new HashMap<>();
    private final Map<Integer, List<Education>> educationMap = new HashMap<>();

    public ResumeService() {
        List<Education> educations = new ArrayList<>();
        educations.add(new Education(1, 2005L, "Secondary school specializing in artistic", "Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur"));
        educations.add(new Education(2, 2009L, "First level graduation in Graphic Design", "Aspernatur, mollitia, quos maxime eius suscipit sed"));

        userMap.put(1, new User(1, "KAMIL", 24L, "https://inews.gtimg.com/newsapp_match/0/3581582328/0", "Lorem ipsum dolor sit amet, consectetur"));
        educationMap.put(1, educations);
    }

    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(userMap.get(id));
    }

    public Optional<List<Education>> getUserEducationsById(Integer id) {
        return Optional.ofNullable(educationMap.get(id));
    }

    public User createUser(User user) {
        int size = getUsers().size();
        user.setId(size + 1);
        userMap.put(user.getId(), user);
        educationMap.put(user.getId(), new ArrayList<>());
        return user;
    }

    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }

    public boolean createEducationForUser(Integer id, Education education) {
        Optional<List<Education>> educations = Optional.ofNullable(educationMap.get(id));
        if (educations.isPresent()) {
            int educationId = educations.get().size() + 1;
            education.setId(educationId);
            educations.get().add(education);
            return true;
        }
        return false;
    }
}
