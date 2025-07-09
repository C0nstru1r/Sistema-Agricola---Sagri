package com.sagri.estoque.controller;

import com.sagri.estoque.model.Unidade;
import com.sagri.estoque.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @PostMapping("/add")
    public Unidade adicionar(@RequestBody Unidade unidade) {
        return unidadeService.salvar(unidade);
    }

    @GetMapping("/{id}")
    public Unidade buscarPorId(@PathVariable Long id) {
        return unidadeService.buscarPorId(id);
    }

    @GetMapping("/all")
    public List<Unidade> listarTodas() {
        return unidadeService.listarTodas();
    }

    @PutMapping("/update/{id}")
    public Unidade atualizar(@PathVariable Long id, @RequestBody Unidade unidade) {
        return unidadeService.atualizar(id, unidade);
    }

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable Long id) {
        unidadeService.deletar(id);
    }
}