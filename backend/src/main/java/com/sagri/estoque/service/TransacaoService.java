package com.sagri.estoque.service;

import com.sagri.estoque.model.*;
import com.sagri.estoque.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @Autowired
    private MovimentacaoFinanceiraService movimentacaoFinanceiraService;

    /**
     * Registra uma nova transação (compra ou venda)
     */
    @Transactional
    public Transacao registrarTransacao(Transacao transacao) {
        // Validar se a pessoa pode realizar este tipo de transação
        validarTipoRelacionamento(transacao);

        // Definir data e hora se não informadas
        if (transacao.getData() == null) {
            transacao.setData(LocalDate.now());
        }
        if (transacao.getHora() == null) {
            transacao.setHora(LocalTime.now());
        }

        // Calcular valor total se não informado
        if (transacao.getValorTotal() == null) {
            transacao.setValorTotal(
                transacao.getValorUnitario().multiply(transacao.getQuantidade())
            );
        }

        // Salvar a transação
        Transacao transacaoSalva = repository.save(transacao);

        // Atualizar estoque baseado no tipo de transação
        atualizarEstoque(transacaoSalva);

        return transacaoSalva;
    }

    /**
     * Confirma uma transação pendente
     */
    @Transactional
    public Transacao confirmarTransacao(Long transacaoId) {
        Optional<Transacao> opt = repository.findById(transacaoId);
        if (opt.isPresent()) {
            Transacao transacao = opt.get();
            if (transacao.getStatus() == StatusTransacao.PENDENTE) {
                transacao.setStatus(StatusTransacao.CONFIRMADA);
                return repository.save(transacao);
            }
        }
        return null;
    }

    /**
     * Cancela uma transação
     */
    @Transactional
    public Transacao cancelarTransacao(Long transacaoId) {
        Optional<Transacao> opt = repository.findById(transacaoId);
        if (opt.isPresent()) {
            Transacao transacao = opt.get();
            if (transacao.getStatus() != StatusTransacao.FINALIZADA) {
                transacao.setStatus(StatusTransacao.CANCELADA);
                return repository.save(transacao);
            }
        }
        return null;
    }

    /**
     * Finaliza uma transação (pagamento realizado)
     */
    @Transactional
    public Transacao finalizarTransacao(Long transacaoId) {
        Optional<Transacao> opt = repository.findById(transacaoId);
        if (opt.isPresent()) {
            Transacao transacao = opt.get();
            if (transacao.getStatus() == StatusTransacao.CONFIRMADA) {
                transacao.setStatus(StatusTransacao.FINALIZADA);
                return repository.save(transacao);
            }
        }
        return null;
    }

    /**
     * Busca transações por pessoa
     */
    public List<Transacao> buscarPorPessoa(Long pessoaId) {
        return repository.findByPessoaId(pessoaId);
    }

    /**
     * Busca transações por tipo (COMPRA ou VENDA)
     */
    public List<Transacao> buscarPorTipo(TipoTransacao tipo) {
        return repository.findByTipo(tipo);
    }

    /**
     * Busca transações por pessoa e tipo
     */
    public List<Transacao> buscarPorPessoaETipo(Long pessoaId, TipoTransacao tipo) {
        return repository.findByPessoaIdAndTipo(pessoaId, tipo);
    }

    /**
     * Busca transações por período
     */
    public List<Transacao> buscarPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        return repository.findByDataBetween(dataInicio, dataFim);
    }

    /**
     * Busca resumo de transações por pessoa
     */
    public List<Object[]> buscarResumoPorPessoa(Long pessoaId) {
        return repository.findResumoTransacoesPorPessoa(pessoaId);
    }

    /**
     * Busca total de transações por período
     */
    public List<Object[]> buscarTotalPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        return repository.findTotalTransacoesPorPeriodo(dataInicio, dataFim);
    }

    /**
     * Valida se a pessoa pode realizar o tipo de transação
     */
    private void validarTipoRelacionamento(Transacao transacao) {
        Pessoa pessoa = transacao.getPessoa();
        TipoTransacao tipoTransacao = transacao.getTipo();

        if (pessoa.getTipoRelacionamento() == null) {
            throw new IllegalArgumentException("Pessoa deve ter um tipo de relacionamento definido");
        }

        switch (pessoa.getTipoRelacionamento()) {
            case COMPRADOR:
                if (tipoTransacao == TipoTransacao.COMPRA) {
                    throw new IllegalArgumentException("Cliente comprador não pode vender produtos");
                }
                break;
            case VENDEDOR:
                if (tipoTransacao == TipoTransacao.VENDA) {
                    throw new IllegalArgumentException("Fornecedor não pode comprar produtos");
                }
                break;
            case AMBOS:
                // Pode realizar ambos os tipos de transação
                break;
        }
    }

    /**
     * Atualiza o estoque baseado no tipo de transação
     */
    private void atualizarEstoque(Transacao transacao) {
        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
        movimentacao.setProduto(transacao.getProduto());
        movimentacao.setUnidade(transacao.getUnidade());
        movimentacao.setQuantidade(transacao.getQuantidade().doubleValue());
        movimentacao.setValorUnitario(transacao.getValorUnitario());
        movimentacao.setData(transacao.getData());
        movimentacao.setHora(transacao.getHora());
        movimentacao.setDocumento(transacao.getDocumento());
        movimentacao.setObservacao(transacao.getObservacoes());
        movimentacao.setUsuario(transacao.getUsuario());

        // Define o tipo de movimentação baseado na transação
        if (transacao.getTipo() == TipoTransacao.COMPRA) {
            movimentacao.setTipo(TipoMovimentacao.ENTRADA);
            movimentacao.setDestinatario(transacao.getPessoa()); // Fornecedor
        } else {
            movimentacao.setTipo(TipoMovimentacao.SAIDA);
            movimentacao.setDestinatario(transacao.getPessoa()); // Cliente
        }

        movimentacaoEstoqueService.salvar(movimentacao);
    }

    // Métodos CRUD básicos
    public List<Transacao> listarTodas() {
        return repository.findAll();
    }

    public Optional<Transacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
} 