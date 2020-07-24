package com.example.webshopfinalversion.controllers;


import com.example.webshopfinalversion.domain.ResponseMessage;
import com.example.webshopfinalversion.domain.User;
import com.example.webshopfinalversion.service.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    private RegisterServiceImpl registerService;

    public RegisterController() {
    }

    @Autowired
    public RegisterController(RegisterServiceImpl registerService) {
        this.registerService = registerService;
    }


    @PostMapping("/user/add")
    public ResponseMessage addUser(@RequestBody User newUser) {
        return registerService.addUser(newUser);
    }


}

