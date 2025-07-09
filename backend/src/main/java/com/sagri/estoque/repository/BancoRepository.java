package com.sagri.estoque.repository;

import com.sagri.estoque.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Banco, Long> {
}