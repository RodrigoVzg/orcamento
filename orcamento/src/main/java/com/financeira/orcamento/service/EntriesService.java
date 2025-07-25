package com.financeira.orcamento.service;

import org.springframework.stereotype.Service;

import com.financeira.orcamento.model.Entries;
import com.financeira.orcamento.repository.EntriesRepository;


@Service
public class EntriesService {

    private final EntriesRepository entriesRepository;

    public EntriesService(EntriesRepository entriesRepository) {
        this.entriesRepository = entriesRepository;
    }

    public Entries save (Entries entries){
        return entriesRepository.save(entries);
    }

}
