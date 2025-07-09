package com.sagri.licenca.controller;

import com.sagri.licenca.model.AgenciaConta;
import com.sagri.licenca.service.AgenciaContaService;
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