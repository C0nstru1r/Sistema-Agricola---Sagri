package com.sagri.licenca.controller;

import com.sagri.licenca.model.Pessoa;
import com.sagri.licenca.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/add")
    public Pessoa addPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.savePessoa(pessoa);
    }

    @GetMapping
    public List<Pessoa> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }

    @GetMapping("/{id}")
    public Pessoa getPessoa(@PathVariable Long id) {
        return pessoaService.getPessoa(id);
    }

    @PutMapping("/update/{id}")
    public Pessoa updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return pessoaService.updatePessoa(id, pessoa);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePessoa(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
    }
}