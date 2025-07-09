package com.sagri.licenca.repository;

import com.sagri.licenca.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Banco, Long> {
}