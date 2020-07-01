package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<User, Integer>  {
    Optional<User> findUserById(Integer id);
}
