package com.sagri.licenca.service;

import com.sagri.licenca.model.Banco;
import com.sagri.licenca.repository.BancoRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Banco update(Long id, Banco bancoAtualizado) {
        return bancoRepository.findById(id).map(bancoExistente -> {
            if (bancoExistente.isSistema()) {
                throw new RuntimeException("Este banco é do sistema e não pode ser alterado.");
            }
            bancoAtualizado.setId(id);
            return bancoRepository.save(bancoAtualizado);
        }).orElseThrow(() -> new EntityNotFoundException("Banco não encontrado com ID: " + id));
    }

    public void delete(Long id) {
        Banco banco = bancoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Banco não encontrado"));
        if (banco.isSistema()) {
            throw new RuntimeException("Este banco é do sistema e não pode ser excluído.");
        }
        bancoRepository.deleteById(id);
    }

    public List<Banco> getAll() {
        return bancoRepository.findAll();
    }

    public Banco getById(Long id) {
        return bancoRepository.findById(id).orElse(null);
    }
}