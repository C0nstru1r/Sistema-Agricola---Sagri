package com.sagri.estoque.controller;

import com.sagri.estoque.model.Preco;
import com.sagri.estoque.service.PrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preco")
public class PrecoController {

    @Autowired
    private PrecoService precoService;

    @PostMapping("/add")
    public Preco adicionar(@RequestBody Preco preco) {
        return precoService.salvar(preco);
    }

    @GetMapping("/{id}")
    public Preco buscarPorId(@PathVariable Long id) {
        return precoService.buscarPorId(id);
    }

    @GetMapping("/all")
    public List<Preco> listarTodos() {
        return precoService.listarTodos();
    }

    @PutMapping("/update/{id}")
    public Preco atualizar(@PathVariable Long id, @RequestBody Preco preco) {
        return precoService.atualizar(id, preco);
    }

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable Long id) {
        precoService.deletar(id);
    }
}