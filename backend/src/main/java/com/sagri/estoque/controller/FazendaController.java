package com.sagri.estoque.controller;

import com.sagri.estoque.model.Fazenda;
import com.sagri.estoque.service.FazendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fazenda")
public class FazendaController {

    @Autowired
    private FazendaService fazendaService;

    @PostMapping("/add")
    public Fazenda adicionar(@RequestBody Fazenda fazenda) {
        return fazendaService.salvar(fazenda);
    }

    @GetMapping("/{id}")
    public Fazenda buscarPorId(@PathVariable Long id) {
        return fazendaService.buscarPorId(id);
    }

    @GetMapping("/all")
    public List<Fazenda> listarTodas() {
        return fazendaService.listarTodas();
    }

    @PutMapping("/update/{id}")
    public Fazenda atualizar(@PathVariable Long id, @RequestBody Fazenda fazenda) {
        return fazendaService.atualizar(id, fazenda);
    }

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable Long id) {
        fazendaService.deletar(id);
    }
}