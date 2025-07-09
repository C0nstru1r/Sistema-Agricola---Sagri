package com.sagri.estoque.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String produto;

    private Integer quantidade;

    private String unidade;

    private String categoria;

    private String fornecedor;
}