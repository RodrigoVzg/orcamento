package com.financeira.orcamento.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeira.orcamento.model.User;
import com.financeira.orcamento.repository.UserRepository;


@RestController
@RequestMapping("/login")
public class LoginController {

        private final UserRepository userRepository;

        public LoginController(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @PostMapping
        public ResponseEntity<String> login(@RequestBody LoginRequest request) {
            System.out.println("Email recebido: " + request.getEmail());
            System.out.println("Senha recebida: " + request.getPassword());

            Optional<User> userOpt = userRepository.findByEmail(request.getEmail());

            System.out.println(userOpt.isPresent());

            if (userOpt.isPresent() && userOpt.get().getPassword().equals(request.getPassword())) {
                return ResponseEntity.ok("Login realizado");
            } 
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("E-mail ou senha inválidos");
            
        }

        public static class LoginRequest {
            private String email;
            private String password;

            public String getEmail() {
                return email;
            }
            public void setEmail(String email) {
                this.email = email;
            }
            public String getPassword() {
                return password;
            }
            public void setPassword(String password) {
                this.password = password;
            }
            

        }


}
