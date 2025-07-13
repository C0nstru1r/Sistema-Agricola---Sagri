package com.sagri.estoque.controller;

import com.sagri.estoque.model.PlanoConta;
import com.sagri.estoque.service.PlanoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planoconta")
public class PlanoContaController {

    @Autowired
    private PlanoContaService service;

    @PostMapping
    public ResponseEntity<PlanoConta> salvar(@RequestBody PlanoConta plano) {
        return ResponseEntity.ok(service.salvar(plano));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoConta> atualizar(@PathVariable Long id, @RequestBody PlanoConta plano) {
        return ResponseEntity.ok(service.atualizar(id, plano));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<PlanoConta> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscar")
    public List<PlanoConta> buscarPorDescricao(@RequestParam String descricao) {
        return service.buscarPorDescricao(descricao);
    }

    @GetMapping("/codigo")
    public List<PlanoConta> buscarPorCodigo(@RequestParam String codigo) {
        return service.buscarPorCodigo(codigo);
    }
}