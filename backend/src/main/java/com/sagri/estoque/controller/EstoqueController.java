package com.sagri.estoque.controller;

import com.sagri.estoque.model.Estoque;
import com.sagri.estoque.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping("/add")
    public Estoque addEstoque(@RequestBody Estoque estoque) {
        return estoqueService.salvar(estoque);
    }

    @GetMapping("/{id}")
    public Estoque getEstoque(@PathVariable Long id) {
        return estoqueService.buscarPorId(id);
    }

    @GetMapping("/all")
    public List<Estoque> listarTodos() {
        return estoqueService.listarTodos();
    }

    @PutMapping("/update/{id}")
    public Estoque atualizar(@PathVariable Long id, @RequestBody Estoque estoque) {
        return estoqueService.atualizar(id, estoque);
    }

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable Long id) {
        estoqueService.deletar(id);
    }
}