package com.sagri.estoque.controller;

import com.sagri.estoque.model.HistoricoFinanceiro;
import com.sagri.estoque.service.HistoricoFinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historicos")
public class HistoricoFinanceiroController {

    @Autowired
    private HistoricoFinanceiroService service;

    @GetMapping
    public List<HistoricoFinanceiro> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscar")
    public List<HistoricoFinanceiro> buscarPorDescricao(@RequestParam String descricao) {
        return service.buscarPorDescricao(descricao);
    }

    @PostMapping
    public HistoricoFinanceiro salvar(@RequestBody HistoricoFinanceiro hist) {
        return service.salvar(hist);
    }

    @PutMapping("/{id}")
    public HistoricoFinanceiro atualizar(@PathVariable Long id, @RequestBody HistoricoFinanceiro hist) {
        return service.atualizar(id, hist);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}