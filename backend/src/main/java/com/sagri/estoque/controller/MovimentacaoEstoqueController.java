package com.sagri.estoque.controller;

import com.sagri.estoque.model.MovimentacaoEstoque;
import com.sagri.estoque.service.MovimentacaoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoEstoqueController {

    @Autowired
    private MovimentacaoEstoqueService service;

    @PostMapping
    public MovimentacaoEstoque criar(@RequestBody MovimentacaoEstoque movimentacao) {
        return service.salvar(movimentacao);
    }

    @GetMapping
    public List<MovimentacaoEstoque> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<MovimentacaoEstoque> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.excluir(id);
    }

    @GetMapping("/produto/{produtoId}")
    public List<MovimentacaoEstoque> listarPorProduto(@PathVariable Long produtoId) {
        return service.listarPorProduto(produtoId);
    }

    @GetMapping("/periodo")
    public List<MovimentacaoEstoque> listarPorPeriodo(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim) {
        return service.listarPorPeriodo(inicio, fim);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<MovimentacaoEstoque> listarPorCategoria(@PathVariable Long categoriaId) {
        return service.listarPorCategoria(categoriaId);
    }
}