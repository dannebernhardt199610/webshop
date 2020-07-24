package com.example.webshopfinalversion.controllers;

import com.example.webshopfinalversion.domain.CustomerTotal;
import com.example.webshopfinalversion.domain.ResponseMessage;
import com.example.webshopfinalversion.domain.Role;
import com.example.webshopfinalversion.domain.User;
import com.example.webshopfinalversion.service.RegisterService;
import com.example.webshopfinalversion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;
    private RegisterService registerService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService, RegisterService registerService) {
        this.userService = userService;
        this.registerService = registerService;
    }


    @RequestMapping(value = "/userByUsername/{username}")
    public User findUserbyUsername(@PathVariable String username) {
        return  userService.findByUsername(username);
    }


    @RequestMapping(value = "/users")
    public List<User> findAllUsers() {
        return  userService.findAllUsers();
    }


    @PostMapping("/user/addNewOrder")
    public ResponseMessage addNewOrder(@RequestBody CustomerTotal customerTotal) {
        String username = customerTotal.getUsername();
        List<String> productList = customerTotal.getProductList();
        double total = customerTotal.getTotal();
        registerService.addOrderItemList(username, productList, total);

        return new ResponseMessage("Order Added",false);
    }

    @PostMapping("/login")
    public ResponseMessage login(@RequestBody User user) {
        ResponseMessage response = new ResponseMessage("Not logged in",false);
        Optional<User> validUser = userService.verifyUserAndPass(user);

        validUser.ifPresent(theUser -> {
            response.setStatus(true);
            if (theUser.getRole() != Role.ADMIN) {
                response.setMessage("Customer logged in");
            } else {
                response.setMessage("Admin logged in");
            }
        });
        return response;
    }





}