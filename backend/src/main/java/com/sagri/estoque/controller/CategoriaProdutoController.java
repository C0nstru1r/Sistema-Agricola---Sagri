package com.sagri.estoque.controller;

import com.sagri.estoque.model.CategoriaProduto;
import com.sagri.estoque.service.CategoriaProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias-produto")
public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping
    public CategoriaProduto criar(@Valid @RequestBody CategoriaProduto categoria) {
        return categoriaProdutoService.save(categoria);
    }

    @GetMapping
    public List<CategoriaProduto> listar() {
        return categoriaProdutoService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaProduto buscarPorId(@PathVariable Long id) {
        return categoriaProdutoService.findById(id);
    }

    @PutMapping("/{id}")
    public CategoriaProduto atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaProduto categoria) {
        return categoriaProdutoService.update(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaProdutoService.delete(id);
    }
}