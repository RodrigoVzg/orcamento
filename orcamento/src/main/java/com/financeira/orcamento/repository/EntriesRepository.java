package com.financeira.orcamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeira.orcamento.model.Entries;

public interface EntriesRepository extends JpaRepository<Entries, Long>{

}
