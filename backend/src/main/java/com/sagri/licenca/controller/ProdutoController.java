package com.sagri.licenca.controller;

import com.sagri.licenca.model.Produto;
import com.sagri.licenca.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/add")
    public Produto addProduto(@RequestBody Produto produto) {
        return produtoService.saveProduto(produto);
    }

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public Produto getProduto(@PathVariable Long id) {
        return produtoService.getProduto(id);
    }

    @PutMapping("/update/{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.updateProduto(id, produto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
    }
}