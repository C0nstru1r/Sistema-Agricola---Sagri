package com.sagri.estoque.service;

import com.sagri.estoque.model.PlanoConta;
import com.sagri.estoque.repository.PlanoContaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoContaService {

    @Autowired
    private PlanoContaRepository repository;

    public PlanoConta salvar(PlanoConta plano) {
        return repository.save(plano);
    }

    public PlanoConta atualizar(Long id, PlanoConta planoAtualizado) {
        PlanoConta plano = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plano de Conta não encontrado"));
        if (plano.isPadrao()) {
            throw new RuntimeException("Registro padrão não pode ser alterado");
        }
        planoAtualizado.setId(id);
        planoAtualizado.setPadrao(plano.isPadrao());
        return repository.save(planoAtualizado);
    }

    public void excluir(Long id) {
        PlanoConta plano = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plano de Conta não encontrado"));
        if (plano.isPadrao()) {
            throw new RuntimeException("Registro padrão não pode ser excluído");
        }
        repository.deleteById(id);
    }

    public List<PlanoConta> listarTodos() {
        return repository.findAll();
    }

    public List<PlanoConta> buscarPorDescricao(String descricao) {
        return repository.findByDescricaoContainingIgnoreCase(descricao);
    }

    public List<PlanoConta> buscarPorCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }
}