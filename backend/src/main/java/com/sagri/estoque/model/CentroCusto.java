package com.sagri.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CentroCusto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 10)
    private String codigo;

    @NotBlank
    @Size(max = 100)
    private String descricao;

    @Column(nullable = false)
    private boolean padrao = false;

    public CentroCusto(String codigo, String descricao, boolean padrao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.padrao = padrao;
    }
}