package com.example.webshopfinalversion.service;

import com.example.webshopfinalversion.domain.ResponseMessage;
import com.example.webshopfinalversion.domain.User;

import java.util.List;

public interface RegisterService {
    ResponseMessage addUser(User newUser);

    void addOrderItemList(String username, List<String> productList, double total);

}