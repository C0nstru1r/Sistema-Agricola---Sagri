package com.sagri.estoque.service;

import com.sagri.estoque.model.MovimentacaoEstoque;
import com.sagri.estoque.repository.MovimentacaoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoEstoqueService {

    @Autowired
    private MovimentacaoEstoqueRepository repository;

    public MovimentacaoEstoque salvar(MovimentacaoEstoque movimentacao) {
        return repository.save(movimentacao);
    }

    public List<MovimentacaoEstoque> listarTodos() {
        return repository.findAll();
    }

    public Optional<MovimentacaoEstoque> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public List<MovimentacaoEstoque> listarPorProduto(Long produtoId) {
        return repository.findByProdutoId(produtoId);
    }

    public List<MovimentacaoEstoque> listarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return repository.findByDataBetween(inicio, fim);
    }

    public List<MovimentacaoEstoque> listarPorCategoria(Long categoriaId) {
        return repository.findByProdutoCategoriaId(categoriaId);
    }
}