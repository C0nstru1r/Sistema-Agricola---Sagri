package com.sagri.estoque.service;

import com.sagri.estoque.model.Produto;
import com.sagri.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto atualizar(Long id, Produto atualizado) {
        Produto existente = buscarPorId(id);
        if (existente != null) {
            existente.setNome(atualizado.getNome());
            existente.setCodigo(atualizado.getCodigo());
            existente.setPreco(atualizado.getPreco());
            existente.setUnidade(atualizado.getUnidade());
            existente.setCategoria(atualizado.getCategoria());
            existente.setFornecedor(atualizado.getFornecedor());
            return produtoRepository.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}