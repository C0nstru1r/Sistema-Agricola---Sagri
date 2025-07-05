package com.sagri.licenca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sagri.licenca.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Métodos personalizados, se necessário
}