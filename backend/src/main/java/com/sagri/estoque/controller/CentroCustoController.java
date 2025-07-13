package com.sagri.estoque.controller;

import com.sagri.estoque.model.CentroCusto;
import com.sagri.estoque.service.CentroCustoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centros-custo")
public class CentroCustoController {

    @Autowired
    private CentroCustoService service;

    @GetMapping
    public List<CentroCusto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscar")
    public List<CentroCusto> buscarPorDescricao(@RequestParam String descricao) {
        return service.buscarPorDescricao(descricao);
    }

    @PostMapping
    public CentroCusto salvar(@RequestBody CentroCusto cc) {
        return service.salvar(cc);
    }

    @PutMapping("/{id}")
    public CentroCusto atualizar(@PathVariable Long id, @RequestBody CentroCusto cc) {
        return service.atualizar(id, cc);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}