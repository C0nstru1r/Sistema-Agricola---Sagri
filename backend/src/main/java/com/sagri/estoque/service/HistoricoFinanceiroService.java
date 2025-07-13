package com.sagri.estoque.service;

import com.sagri.estoque.model.HistoricoFinanceiro;
import com.sagri.estoque.repository.HistoricoFinanceiroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoFinanceiroService {

    @Autowired
    private HistoricoFinanceiroRepository repository;

    public List<HistoricoFinanceiro> listarTodos() {
        return repository.findAll();
    }

    public List<HistoricoFinanceiro> buscarPorDescricao(String descricao) {
        return repository.findByDescricaoContainingIgnoreCase(descricao);
    }

    public HistoricoFinanceiro salvar(HistoricoFinanceiro hist) {
        return repository.save(hist);
    }

    public HistoricoFinanceiro atualizar(Long id, HistoricoFinanceiro atualizado) {
        HistoricoFinanceiro existente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Histórico não encontrado"));

        if (existente.isPadrao()) {
            throw new UnsupportedOperationException("Histórico padrão não pode ser alterado.");
        }

        atualizado.setId(id);
        atualizado.setPadrao(false);
        return repository.save(atualizado);
    }

    public void deletar(Long id) {
        HistoricoFinanceiro existente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Histórico não encontrado"));

        if (existente.isPadrao()) {
            throw new UnsupportedOperationException("Histórico padrão não pode ser excluído.");
        }

        repository.deleteById(id);
    }
}