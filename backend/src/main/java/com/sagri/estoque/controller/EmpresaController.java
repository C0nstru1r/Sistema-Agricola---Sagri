package com.sagri.estoque.controller;

import com.sagri.estoque.dto.EmpresaDTO;
import com.sagri.estoque.model.Empresa;
import com.sagri.estoque.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/{id}")
    public Empresa getEmpresa(@PathVariable Long id) {
        return empresaService.getEmpresa(id);
    }

    @PutMapping("/{id}")
    public Empresa updateEmpresa(@PathVariable Long id, @RequestBody EmpresaDTO dto) {
        return empresaService.updateEmpresa(id, dto);
    }

    @PostMapping
public Empresa criarEmpresa(@RequestBody Empresa empresa) {
    return empresaService.salvar(empresa);
}
}