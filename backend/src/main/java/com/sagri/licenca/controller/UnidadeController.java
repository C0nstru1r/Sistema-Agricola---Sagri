package com.sagri.licenca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sagri.licenca.model.Unidade;
import com.sagri.licenca.service.UnidadeService;

@RestController
@RequestMapping("/api/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @PostMapping("/add")
    public Unidade addUnidade(@RequestBody Unidade unidade) {
        return unidadeService.saveUnidade(unidade);
    }

    @GetMapping("/{id}")
    public Unidade getUnidade(@PathVariable Long id) {
        return unidadeService.getUnidade(id);
    }

    @PutMapping("/update/{id}")
    public Unidade updateUnidade(@PathVariable Long id, @RequestBody Unidade unidade) {
        return unidadeService.updateUnidade(id, unidade);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUnidade(@PathVariable Long id) {
        unidadeService.deleteUnidade(id);
    }
}