package com.sagri.estoque.repository;

import com.sagri.estoque.model.HistoricoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoFinanceiroRepository extends JpaRepository<HistoricoFinanceiro, Long> {
    List<HistoricoFinanceiro> findByDescricaoContainingIgnoreCase(String descricao);
    List<HistoricoFinanceiro> findByPadraoTrue();
}