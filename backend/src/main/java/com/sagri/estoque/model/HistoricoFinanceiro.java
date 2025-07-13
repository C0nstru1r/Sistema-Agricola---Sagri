package com.sagri.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoFinanceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String descricao;

    @Column(nullable = false)
    private boolean padrao = false;

    public HistoricoFinanceiro(String descricao, boolean padrao) {
        this.descricao = descricao;
        this.padrao = padrao;
    }
}