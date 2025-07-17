package com.sagri.estoque.repository;

import com.sagri.estoque.model.Transacao;
import com.sagri.estoque.model.TipoTransacao;
import com.sagri.estoque.model.StatusTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    // Buscar transações por pessoa
    List<Transacao> findByPessoaId(Long pessoaId);

    // Buscar transações por tipo (COMPRA ou VENDA)
    List<Transacao> findByTipo(TipoTransacao tipo);

    // Buscar transações por pessoa e tipo
    List<Transacao> findByPessoaIdAndTipo(Long pessoaId, TipoTransacao tipo);

    // Buscar transações por status
    List<Transacao> findByStatus(StatusTransacao status);

    // Buscar transações por período
    List<Transacao> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);

    // Buscar transações por produto
    List<Transacao> findByProdutoId(Long produtoId);

    // Buscar transações por fazenda
    List<Transacao> findByFazendaId(Long fazendaId);

    // Buscar transações por pessoa, tipo e período
    List<Transacao> findByPessoaIdAndTipoAndDataBetween(
        Long pessoaId, TipoTransacao tipo, LocalDate dataInicio, LocalDate dataFim);

    // Query personalizada para buscar resumo de transações por pessoa
    @Query("SELECT t.tipo, COUNT(t), SUM(t.valorTotal) FROM Transacao t " +
           "WHERE t.pessoa.id = :pessoaId GROUP BY t.tipo")
    List<Object[]> findResumoTransacoesPorPessoa(@Param("pessoaId") Long pessoaId);

    // Query para buscar total de compras e vendas por período
    @Query("SELECT t.tipo, SUM(t.valorTotal) FROM Transacao t " +
           "WHERE t.data BETWEEN :dataInicio AND :dataFim GROUP BY t.tipo")
    List<Object[]> findTotalTransacoesPorPeriodo(
        @Param("dataInicio") LocalDate dataInicio, 
        @Param("dataFim") LocalDate dataFim);
} 