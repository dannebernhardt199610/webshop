package com.example.webshopfinalversion.service;

import com.example.webshopfinalversion.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByUsername(String username);

    List<User> findAllUsers();

    Optional<User> verifyUserAndPass(User user);

}