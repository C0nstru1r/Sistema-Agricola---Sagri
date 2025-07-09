package com.sagri.estoque.repository;

import com.sagri.estoque.model.AgenciaConta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaContaRepository extends JpaRepository<AgenciaConta, Long> {
}