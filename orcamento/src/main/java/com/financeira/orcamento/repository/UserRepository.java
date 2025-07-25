package com.financeira.orcamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeira.orcamento.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
