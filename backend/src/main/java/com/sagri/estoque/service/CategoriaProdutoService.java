package com.sagri.estoque.service;

import com.sagri.estoque.model.CategoriaProduto;
import com.sagri.estoque.repository.CategoriaProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    public CategoriaProduto save(CategoriaProduto categoriaProduto) {
        return categoriaProdutoRepository.save(categoriaProduto);
    }

    public List<CategoriaProduto> findAll() {
        return categoriaProdutoRepository.findAll();
    }

    public CategoriaProduto findById(Long id) {
        return categoriaProdutoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + id));
    }

    public CategoriaProduto update(Long id, CategoriaProduto novaCategoria) {
        CategoriaProduto existente = findById(id);
        existente.setNome(novaCategoria.getNome());
        return categoriaProdutoRepository.save(existente);
    }

    public void delete(Long id) {
        categoriaProdutoRepository.deleteById(id);
    }
}