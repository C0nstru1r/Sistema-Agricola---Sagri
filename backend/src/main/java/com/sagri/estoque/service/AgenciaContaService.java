package com.sagri.licenca.service;

import com.sagri.licenca.model.AgenciaConta;
import com.sagri.licenca.repository.AgenciaContaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaContaService {

    @Autowired
    private AgenciaContaRepository agenciaContaRepository;

    public AgenciaConta save(AgenciaConta agenciaConta) {
        return agenciaContaRepository.save(agenciaConta);
    }

    public AgenciaConta update(Long id, AgenciaConta nova) {
        return agenciaContaRepository.findById(id).map(ag -> {
            nova.setId(id);
            return agenciaContaRepository.save(nova);
        }).orElseThrow(() -> new EntityNotFoundException("Agência/Conta não encontrada com ID: " + id));
    }

    public void delete(Long id) {
        agenciaContaRepository.deleteById(id);
    }

    public AgenciaConta getById(Long id) {
        return agenciaContaRepository.findById(id).orElse(null);
    }

    public List<AgenciaConta> getAll() {
        return agenciaContaRepository.findAll();
    }
}