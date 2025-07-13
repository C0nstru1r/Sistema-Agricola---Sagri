package com.sagri.estoque.controller;

import com.sagri.estoque.model.FormaPagamento;
import com.sagri.estoque.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forma-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService service;

    @PostMapping
    public FormaPagamento create(@RequestBody FormaPagamento forma) {
        return service.save(forma);
    }

    @GetMapping
    public List<FormaPagamento> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FormaPagamento getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public FormaPagamento update(@PathVariable Long id, @RequestBody FormaPagamento forma) {
        forma.setId(id);
        return service.save(forma);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}