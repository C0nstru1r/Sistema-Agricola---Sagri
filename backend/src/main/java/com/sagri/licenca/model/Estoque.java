package com.sagri.licenca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    private Integer quantidadeAtual;

    @Min(0)
    private Integer quantidadeMinima;

    @Min(0)
    private Integer quantidadeMaxima;

    // Getters e Setters
    // ... (os mesmos que você já tem)
}