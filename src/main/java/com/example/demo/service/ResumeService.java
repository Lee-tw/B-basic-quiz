package com.example.demo.service;

import com.example.demo.model.Education;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResumeService {
    private Map<Integer, User> userMap = new HashMap<>();
    private Map<Integer, List<Education>> educationMap = new HashMap<>();

    public ResumeService() {
        List<Education> educations = new ArrayList<>();
        educations.add(new Education(1, 2005L, "Secondary school specializing in artistic", "Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur"));

        userMap.put(1, new User(1, "KAMIL", 24L, "https://inews.gtimg.com/newsapp_match/0/3581582328/0", "Lorem ipsum dolor sit amet, consectetur"));
        educationMap.put(1, educations);
    }

    public User getUserById(int id) {
        return userMap.get(id);
    }

    public List<Education> getUserEducationsById(Integer id) {
        return educationMap.get(id);
    }

    public User createUser(User user) {
        int size = getUsers().size();
        user.setId(size + 1);
        return userMap.put(user.getId(), user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }

    public void createEducationForUser(Integer id, Education education) {
        List<Education> educations = educationMap.get(id);
        int educationId = educations.size() + 1;
        education.setId(educationId);
        educations.add(education);
    }
}
