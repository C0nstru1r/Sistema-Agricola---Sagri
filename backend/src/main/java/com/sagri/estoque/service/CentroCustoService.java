package com.sagri.estoque.service;

import com.sagri.estoque.model.CentroCusto;
import com.sagri.estoque.repository.CentroCustoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroCustoService {

    @Autowired
    private CentroCustoRepository repository;

    public List<CentroCusto> listarTodos() {
        return repository.findAll();
    }

    public List<CentroCusto> buscarPorDescricao(String descricao) {
        return repository.findByDescricaoContainingIgnoreCase(descricao);
    }

    public CentroCusto salvar(CentroCusto cc) {
        return repository.save(cc);
    }

    public CentroCusto atualizar(Long id, CentroCusto atualizado) {
        CentroCusto existente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Centro de custo não encontrado"));

        if (existente.isPadrao()) {
            throw new UnsupportedOperationException("Registro padrão não pode ser alterado.");
        }

        atualizado.setId(id);
        atualizado.setPadrao(false);
        return repository.save(atualizado);
    }

    public void deletar(Long id) {
        CentroCusto existente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Centro de custo não encontrado"));

        if (existente.isPadrao()) {
            throw new UnsupportedOperationException("Registro padrão não pode ser excluído.");
        }

        repository.deleteById(id);
    }
}