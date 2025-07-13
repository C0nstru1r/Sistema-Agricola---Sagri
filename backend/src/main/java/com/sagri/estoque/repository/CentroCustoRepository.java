package com.sagri.estoque.repository;

import com.sagri.estoque.model.CentroCusto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CentroCustoRepository extends JpaRepository<CentroCusto, Long> {
    List<CentroCusto> findByDescricaoContainingIgnoreCase(String descricao);
    List<CentroCusto> findByPadraoTrue();
}