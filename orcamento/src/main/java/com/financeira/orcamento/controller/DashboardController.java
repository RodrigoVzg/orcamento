package com.financeira.orcamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeira.orcamento.model.User;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping
    public ResponseEntity<?> dashboard(HttpSession session) {
        User user = (User) session.getAttribute("usuarioLogado");

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não está logado");
        }

        return ResponseEntity.ok("Bem-vindo, " + user.getName() + "!");
    }
}