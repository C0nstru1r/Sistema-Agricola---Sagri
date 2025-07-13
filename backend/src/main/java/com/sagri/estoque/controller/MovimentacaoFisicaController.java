package com.sagri.estoque.controller;

import com.sagri.estoque.model.MovimentacaoFisica;
import com.sagri.estoque.service.MovimentacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimentacoes-fisicas")
public class MovimentacaoFisicaController {

    @Autowired
    private MovimentacaoFisicaService service;

    @PostMapping
    public MovimentacaoFisica criar(@RequestBody MovimentacaoFisica movimentacao) {
        return service.salvar(movimentacao);
    }

    @GetMapping
    public List<MovimentacaoFisica> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<MovimentacaoFisica> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.excluir(id);
    }
}