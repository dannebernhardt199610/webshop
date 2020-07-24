package com.example.webshopfinalversion.service;

import com.example.webshopfinalversion.domain.*;
import com.example.webshopfinalversion.repository.OrderRepository;
import com.example.webshopfinalversion.repository.RegisterRepository;
import com.example.webshopfinalversion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    private RegisterRepository registerRepository;
    private ProductServiceImpl productService;
    private UserServiceImpl userService;
    private OrderRepository orderRepository;
    private UserRepository userRepository;


    public RegisterServiceImpl() {}

    @Autowired
    public RegisterServiceImpl(
            RegisterRepository registerRepository,
            ProductServiceImpl productService,
            UserServiceImpl userService,
            OrderRepository orderRepository,
            UserRepository userRepository
    ) {
        this.registerRepository = registerRepository;
        this.productService = productService;
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }


    @Transactional
    public ResponseMessage addUser(User newUser) {
        ResponseMessage response = new ResponseMessage("", false);
        if(newUser.getFirstname().equals("") || newUser.getLastname().equals("") || newUser.getAddress().equals("")
                || newUser.getUsername().equals("") || newUser.getPassword().equals("") || newUser.getEmail().equals("") ) {
            response.setMessage("One required parameter is not filled, please try again");
            return response;
        }

        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(newUser.getUsername())) {
                response.setMessage("username already in use, please try again");
                return response;
            }
        }

        registerRepository.save(newUser);
        response.setMessage("user registrated, redirecting in 2 seconds!");
        response.setStatus(true);
        return response;
    }

    @Transactional
    public void addOrderItemList (String username, List<String> productListString, double total) {

        User user = userService.findByUsername(username);
        List<Product> productList = new ArrayList<>();



        for (int i=0; i<productListString.size(); i++){
            productList.add(productService.findByName(productListString.get(i)));
        }


        Orders orders = new Orders();


        List<Order_Item> order_itemList = new ArrayList<>();


        for (Product product : productList) order_itemList.add(new Order_Item(orders, product, 1));


        orders.setUser(user);
        orders.setOrder_ItemList(order_itemList);


        List<Orders> ordersList = user.getOrdersList();
        ordersList.add(orders);

        orderRepository.save(orders);

        user.setTotalAmount(user.getTotalAmount() + total);
        if (user.getTotalAmount()>=500)
            user.setRole(Role.PREMIUM_CUSTOMER);
        userRepository.save(user);

        new ResponseMessage("ADDED", true);
    }
}