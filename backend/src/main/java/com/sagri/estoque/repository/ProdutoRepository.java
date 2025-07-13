package com.sagri.estoque.repository;

import com.sagri.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Filtro para listar produtos por ID da categoria
    List<Produto> findByCategoriaId(Long categoriaId);
}