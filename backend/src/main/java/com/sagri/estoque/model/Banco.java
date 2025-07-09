package com.sagri.licenca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "codigo_banco", nullable = false, unique = true)
    private Integer codigoBanco;

    @NotBlank
    @Size(max = 100)
    private String nome;

    // Indica se o banco é do sistema (pré-cadastrado e protegido contra alteração/exclusão)
    private boolean sistema;
}