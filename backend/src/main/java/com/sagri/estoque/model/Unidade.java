package com.sagri.estoque.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sigla; // Ex: KG, L, UN, CX, etc.
}