package com.sagri.estoque.controller;

import com.sagri.estoque.model.Pessoa;
import com.sagri.estoque.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/add")
    public Pessoa adicionar(@RequestBody Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Long id) {
        return pessoaService.buscarPorId(id);
    }

    @GetMapping("/all")
    public List<Pessoa> listarTodas() {
        return pessoaService.listarTodas();
    }

    @PutMapping("/update/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return pessoaService.atualizar(id, pessoa);
    }

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
    }
}