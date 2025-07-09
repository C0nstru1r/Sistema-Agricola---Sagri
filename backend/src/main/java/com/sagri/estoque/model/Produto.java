package com.sagri.estoque.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String codigo;

    private Double preco;

    private String unidade;

    private String categoria;

    private String fornecedor;
}