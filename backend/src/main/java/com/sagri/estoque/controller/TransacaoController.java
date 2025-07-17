package com.sagri.estoque.controller;

import com.sagri.estoque.model.Transacao;
import com.sagri.estoque.model.TipoTransacao;
import com.sagri.estoque.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacoes")
@CrossOrigin(origins = "*")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    /**
     * Registra uma nova transação (compra ou venda)
     */
    @PostMapping
    public ResponseEntity<Transacao> registrarTransacao(@RequestBody Transacao transacao) {
        try {
            Transacao novaTransacao = service.registrarTransacao(transacao);
            return ResponseEntity.ok(novaTransacao);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Confirma uma transação pendente
     */
    @PutMapping("/{id}/confirmar")
    public ResponseEntity<Transacao> confirmarTransacao(@PathVariable Long id) {
        Transacao transacao = service.confirmarTransacao(id);
        if (transacao != null) {
            return ResponseEntity.ok(transacao);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Cancela uma transação
     */
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Transacao> cancelarTransacao(@PathVariable Long id) {
        Transacao transacao = service.cancelarTransacao(id);
        if (transacao != null) {
            return ResponseEntity.ok(transacao);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Finaliza uma transação (pagamento realizado)
     */
    @PutMapping("/{id}/finalizar")
    public ResponseEntity<Transacao> finalizarTransacao(@PathVariable Long id) {
        Transacao transacao = service.finalizarTransacao(id);
        if (transacao != null) {
            return ResponseEntity.ok(transacao);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Lista todas as transações
     */
    @GetMapping
    public ResponseEntity<List<Transacao>> listarTodas() {
        List<Transacao> transacoes = service.listarTodas();
        return ResponseEntity.ok(transacoes);
    }

    /**
     * Busca transação por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Long id) {
        Optional<Transacao> transacao = service.buscarPorId(id);
        return transacao.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Busca transações por pessoa
     */
    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<Transacao>> buscarPorPessoa(@PathVariable Long pessoaId) {
        List<Transacao> transacoes = service.buscarPorPessoa(pessoaId);
        return ResponseEntity.ok(transacoes);
    }

    /**
     * Busca transações por tipo (COMPRA ou VENDA)
     */
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Transacao>> buscarPorTipo(@PathVariable TipoTransacao tipo) {
        List<Transacao> transacoes = service.buscarPorTipo(tipo);
        return ResponseEntity.ok(transacoes);
    }

    /**
     * Busca transações por pessoa e tipo
     */
    @GetMapping("/pessoa/{pessoaId}/tipo/{tipo}")
    public ResponseEntity<List<Transacao>> buscarPorPessoaETipo(
            @PathVariable Long pessoaId, 
            @PathVariable TipoTransacao tipo) {
        List<Transacao> transacoes = service.buscarPorPessoaETipo(pessoaId, tipo);
        return ResponseEntity.ok(transacoes);
    }

    /**
     * Busca transações por período
     */
    @GetMapping("/periodo")
    public ResponseEntity<List<Transacao>> buscarPorPeriodo(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        List<Transacao> transacoes = service.buscarPorPeriodo(dataInicio, dataFim);
        return ResponseEntity.ok(transacoes);
    }

    /**
     * Busca resumo de transações por pessoa
     */
    @GetMapping("/pessoa/{pessoaId}/resumo")
    public ResponseEntity<List<Object[]>> buscarResumoPorPessoa(@PathVariable Long pessoaId) {
        List<Object[]> resumo = service.buscarResumoPorPessoa(pessoaId);
        return ResponseEntity.ok(resumo);
    }

    /**
     * Busca total de transações por período
     */
    @GetMapping("/periodo/resumo")
    public ResponseEntity<List<Object[]>> buscarTotalPorPeriodo(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        List<Object[]> resumo = service.buscarTotalPorPeriodo(dataInicio, dataFim);
        return ResponseEntity.ok(resumo);
    }

    /**
     * Deleta uma transação
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
} 