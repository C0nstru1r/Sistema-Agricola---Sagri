package com.sagri.estoque.repository;

import com.sagri.estoque.model.MovimentacaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque, Long> {

    List<MovimentacaoEstoque> findByProdutoId(Long produtoId);

    List<MovimentacaoEstoque> findByDataBetween(LocalDate inicio, LocalDate fim);

    List<MovimentacaoEstoque> findByProdutoCategoriaId(Long categoriaId);
}