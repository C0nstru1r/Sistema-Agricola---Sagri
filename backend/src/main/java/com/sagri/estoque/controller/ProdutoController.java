package com.sagri.estoque.controller;

import com.sagri.estoque.model.Produto;
import com.sagri.estoque.service.ProdutoService;
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
        return produtoService.salvar(produto);
    }

    @GetMapping("/{id}")
    public Produto getProduto(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @GetMapping("/all")
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @PutMapping("/update/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }
}