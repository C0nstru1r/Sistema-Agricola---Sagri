package com.sagri.estoque.controller;

import com.sagri.estoque.model.Licenca;
import com.sagri.estoque.service.LicencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/licencas")
@CrossOrigin("*")
public class LicencaController {

    @Autowired
    private LicencaService licencaService;

    @PostMapping
    public Licenca criar(@RequestBody Licenca licenca) {
        return licencaService.save(licenca);
    }

    @GetMapping
    public List<Licenca> listar() {
        return licencaService.getAll();
    }

    @GetMapping("/{id}")
    public Licenca buscar(@PathVariable Long id) {
        return licencaService.getById(id);
    }

    @PutMapping("/{id}")
    public Licenca atualizar(@PathVariable Long id, @RequestBody Licenca licenca) {
        return licencaService.update(id, licenca);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        licencaService.delete(id);
    }
}