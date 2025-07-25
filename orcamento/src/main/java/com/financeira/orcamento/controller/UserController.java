package com.financeira.orcamento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeira.orcamento.model.User;
import com.financeira.orcamento.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List <User> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public User save(@RequestBody User user){
        System.out.println(user.getEmail()+ user.getName()+ user.getId() + user.getPassword());
        return userService.save(user);
    }
}
