package com.sagri.licenca.service;

import com.sagri.licenca.model.Fazenda;
import com.sagri.licenca.repository.FazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FazendaService {

    @Autowired
    private FazendaRepository fazendaRepository;

    public Fazenda save(Fazenda fazenda) {
        return fazendaRepository.save(fazenda);
    }

    public List<Fazenda> findAll() {
        return fazendaRepository.findAll();
    }

    public Optional<Fazenda> findById(Long id) {
        return fazendaRepository.findById(id);
    }

    public void delete(Long id) {
        fazendaRepository.deleteById(id);
    }
}