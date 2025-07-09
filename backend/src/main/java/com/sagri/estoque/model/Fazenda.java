package com.sagri.estoque.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String localizacao;

    private Double tamanhoHectares;

    private String proprietario;
}