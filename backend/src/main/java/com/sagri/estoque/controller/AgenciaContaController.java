package com.sagri.estoque.controller;

import com.sagri.estoque.model.AgenciaConta;
import com.sagri.estoque.service.AgenciaContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agencias")
@CrossOrigin("*")
public class AgenciaContaController {

    @Autowired
    private AgenciaContaService agenciaContaService;

    @PostMapping
    public AgenciaConta criar(@RequestBody AgenciaConta agenciaConta) {
        return agenciaContaService.save(agenciaConta);
    }

    @GetMapping
    public List<AgenciaConta> listar() {
        return agenciaContaService.getAll();
    }

    @GetMapping("/{id}")
    public AgenciaConta buscar(@PathVariable Long id) {
        return agenciaContaService.getById(id);
    }

    @PutMapping("/{id}")
    public AgenciaConta atualizar(@PathVariable Long id, @RequestBody AgenciaConta agenciaConta) {
        return agenciaContaService.update(id, agenciaConta);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        agenciaContaService.delete(id);
    }
}