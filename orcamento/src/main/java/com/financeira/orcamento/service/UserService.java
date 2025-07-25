package com.financeira.orcamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financeira.orcamento.model.User;
import com.financeira.orcamento.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List <User> getAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

}
