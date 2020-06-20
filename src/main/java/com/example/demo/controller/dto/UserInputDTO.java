package com.example.demo.controller.dto;

import com.example.demo.annotation.ByteValidatorAnnotation;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
public class UserInputDTO {

    @NotNull(message = "name不能为空")
    @ByteValidatorAnnotation(minValue = 1, maxValue = 128, message = "name长度应该在 1 - 128 bytes之间")
    private final String name;

    @NotNull(message = "age不能为空")
    @Min(value = 17, message = "年龄需大于16")
    private final Long age;

    @NotNull(message = "avatar不能为空")
    @ByteValidatorAnnotation(minValue = 8, maxValue = 512, message = "avatar长度应该在 8 - 512 bytes之间")
    private final String avatar;

    @NotNull(message = "description不能为空")
    @ByteValidatorAnnotation(minValue = 0, maxValue = 1024, message = "description长度应该在 0 - 1024 bytes之间")
    private final String description;

    public User toUser() {
        return User.builder().name(name).age(age).avatar(avatar).description(description).build();
    }
}
