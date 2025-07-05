package com.sagri.licenca.service;

import com.sagri.licenca.model.Produto;
import com.sagri.licenca.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

   public Produto updateProduto(Long id, Produto novoProduto) {
    Optional<Produto> produtoExistente = produtoRepository.findById(id);
    if (produtoExistente.isPresent()) {
        Produto produto = produtoExistente.get();
        produto.setNome(novoProduto.getNome());
        produto.setDescricao(novoProduto.getDescricao());
        produto.setUnidade(novoProduto.getUnidade());
        // Adicione mais campos aqui, se houver
        return produtoRepository.save(produto);
    }
    return null;
}

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}