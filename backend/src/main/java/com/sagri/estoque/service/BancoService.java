package com.sagri.estoque.service;

import com.sagri.estoque.model.Banco;
import com.sagri.estoque.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    public Banco save(Banco banco) {
        return bancoRepository.save(banco);
    }

    public Banco getById(Long id) {
        return bancoRepository.findById(id).orElse(null);
    }

    public List<Banco> getAll() {
        return bancoRepository.findAll();
    }

    public Banco update(Long id, Banco banco) {
        if (bancoRepository.existsById(id)) {
            banco.setId(id);
            return bancoRepository.save(banco);
        }
        return null;
    }

    public void delete(Long id) {
        bancoRepository.deleteById(id);
    }
}