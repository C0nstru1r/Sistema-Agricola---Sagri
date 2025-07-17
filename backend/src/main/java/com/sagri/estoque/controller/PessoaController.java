package com.sagri.estoque.controller;

import com.sagri.estoque.model.Pessoa;
import com.sagri.estoque.model.TipoRelacionamento;
import com.sagri.estoque.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin(origins = "*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/add")
    public ResponseEntity<Pessoa> adicionar(@RequestBody Pessoa pessoa) {
        Pessoa novaPessoa = pessoaService.salvar(pessoa);
        return ResponseEntity.ok(novaPessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.buscarPorId(id);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pessoa>> listarTodas() {
        List<Pessoa> pessoas = pessoaService.listarTodas();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/ativas")
    public ResponseEntity<List<Pessoa>> listarAtivas() {
        List<Pessoa> pessoas = pessoaService.listarAtivas();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Pessoa>> buscarPorTipoRelacionamento(@PathVariable TipoRelacionamento tipo) {
        List<Pessoa> pessoas = pessoaService.buscarPorTipoRelacionamento(tipo);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Pessoa>> buscarPorNome(@PathVariable String nome) {
        List<Pessoa> pessoas = pessoaService.buscarPorNome(nome);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<Pessoa>> buscarPorCpf(@PathVariable String cpf) {
        List<Pessoa> pessoas = pessoaService.buscarPorCpf(cpf);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<List<Pessoa>> buscarPorCnpj(@PathVariable String cnpj) {
        List<Pessoa> pessoas = pessoaService.buscarPorCnpj(cnpj);
        return ResponseEntity.ok(pessoas);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa pessoaAtualizada = pessoaService.atualizar(id, pessoa);
        if (pessoaAtualizada != null) {
            return ResponseEntity.ok(pessoaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/desativar")
    public ResponseEntity<Pessoa> desativar(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.desativar(id);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/reativar")
    public ResponseEntity<Pessoa> reativar(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.reativar(id);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}