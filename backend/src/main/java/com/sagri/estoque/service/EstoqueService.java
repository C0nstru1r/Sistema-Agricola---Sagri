package com.sagri.estoque.service;

import com.sagri.estoque.model.Estoque;
import com.sagri.estoque.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public Estoque salvar(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public Estoque buscarPorId(Long id) {
        return estoqueRepository.findById(id).orElse(null);
    }

    public List<Estoque> listarTodos() {
        return estoqueRepository.findAll();
    }

    public Estoque atualizar(Long id, Estoque novo) {
        Estoque existente = buscarPorId(id);
        if (existente != null) {
            novo.setId(id);
            return estoqueRepository.save(novo);
        }
        return null;
    }

    public void deletar(Long id) {
        estoqueRepository.deleteById(id);
    }
}
