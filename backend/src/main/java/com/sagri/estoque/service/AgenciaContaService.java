package com.sagri.estoque.service;

import com.sagri.estoque.model.AgenciaConta;
import com.sagri.estoque.repository.AgenciaContaRepository;
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

    public AgenciaConta getById(Long id) {
        return agenciaContaRepository.findById(id).orElse(null);
    }

    public List<AgenciaConta> getAll() {
        return agenciaContaRepository.findAll();
    }

    public AgenciaConta update(Long id, AgenciaConta agenciaConta) {
        if (agenciaContaRepository.existsById(id)) {
            agenciaConta.setId(id);
            return agenciaContaRepository.save(agenciaConta);
        }
        return null;
    }

    public void delete(Long id) {
        agenciaContaRepository.deleteById(id);
    }
}