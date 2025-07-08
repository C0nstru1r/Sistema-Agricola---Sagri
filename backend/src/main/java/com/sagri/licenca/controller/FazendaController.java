package com.sagri.licenca.controller;

import com.sagri.licenca.model.Fazenda;
import com.sagri.licenca.service.FazendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fazendas")
public class FazendaController {

    @Autowired
    private FazendaService fazendaService;

    @GetMapping
    public List<Fazenda> listar() {
        return fazendaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fazenda> buscarPorId(@PathVariable Long id) {
        return fazendaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fazenda> criar(@Valid @RequestBody Fazenda fazenda) {
        return ResponseEntity.ok(fazendaService.save(fazenda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fazenda> atualizar(@PathVariable Long id, @Valid @RequestBody Fazenda fazenda) {
        return fazendaService.findById(id)
                .map(f -> {
                    fazenda.setId(id);
                    return ResponseEntity.ok(fazendaService.save(fazenda));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        fazendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}