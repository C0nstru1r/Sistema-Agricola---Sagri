package com.sagri.licenca.repository;

import com.sagri.licenca.model.Preco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecoRepository extends JpaRepository<Preco, Long> {
}