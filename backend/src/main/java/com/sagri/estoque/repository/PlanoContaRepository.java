package com.sagri.estoque.repository;

import com.sagri.estoque.model.PlanoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {
    List<PlanoConta> findByDescricaoContainingIgnoreCase(String descricao);
    List<PlanoConta> findByCodigo(String codigo);
}