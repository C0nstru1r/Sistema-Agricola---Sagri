package com.sagri.estoque.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String produto;

    private Double valor;

    private String unidade;

    private String dataAtualizacao;
}