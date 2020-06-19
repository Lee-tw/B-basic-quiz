package com.example.demo.controller.dto;

import com.example.demo.model.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserInputDTO {
    private String name;
    private Long age;
    private String avatar;
    private String description;

    public User toUser() {
        return User.builder().name(name).age(age).avatar(avatar).description(description).build();
    }
}
