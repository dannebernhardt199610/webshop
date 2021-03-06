package com.example.webshopfinalversion.service;

import com.example.webshopfinalversion.domain.User;
import com.example.webshopfinalversion.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsernameIgnoreCase(username);
        log.info("findByUsername " + result);
        return result;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> verifyUserAndPass(User user) {
        List<User> users = userRepository.findAll();

        for (User userInDB : users) {
            if(user.getUsername().equalsIgnoreCase(userInDB.getUsername())) {
                if(user.getPassword().equals(userInDB.getPassword())) {
                    return Optional.of(userInDB);
                }
            }
        }
        return Optional.empty();
    }

}