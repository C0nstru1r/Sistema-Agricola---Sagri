package com.sagri.licenca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sagri.licenca.model.Empresa;
import com.sagri.licenca.service.EmpresaService;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/add")
    public Empresa addEmpresa(@RequestBody Empresa empresa) {
        return empresaService.saveEmpresa(empresa);
    }

    @GetMapping("/{id}")
    public Empresa getEmpresa(@PathVariable Long id) {
        return empresaService.getEmpresa(id);
    }

    @PutMapping("/update/{id}")
    public Empresa updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        return empresaService.updateEmpresa(id, empresa);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmpresa(@PathVariable Long id) {
        empresaService.deleteEmpresa(id);
    }
}