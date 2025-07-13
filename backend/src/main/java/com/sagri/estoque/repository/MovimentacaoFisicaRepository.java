package com.sagri.estoque.repository;

import com.sagri.estoque.model.MovimentacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoFisicaRepository extends JpaRepository<MovimentacaoFisica, Long> {
    // Filtros personalizados podem ser adicionados aqui futuramente
}