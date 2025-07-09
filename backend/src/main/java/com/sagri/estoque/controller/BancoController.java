package com.sagri.licenca.controller;

import com.sagri.licenca.model.Banco;
import com.sagri.licenca.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bancos")
@CrossOrigin("*")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @PostMapping
    public Banco criar(@RequestBody Banco banco) {
        return bancoService.save(banco);
    }

    @GetMapping
    public List<Banco> listar() {
        return bancoService.getAll();
    }

    @GetMapping("/{id}")
    public Banco buscarPorId(@PathVariable Long id) {
        return bancoService.getById(id);
    }

    @PutMapping("/{id}")
    public Banco atualizar(@PathVariable Long id, @RequestBody Banco banco) {
        return bancoService.update(id, banco);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        bancoService.delete(id);
    }
}