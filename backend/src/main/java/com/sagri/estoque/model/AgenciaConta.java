package com.sagri.licenca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class AgenciaConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer codigo;

    @NotBlank
    @Size(max = 20)
    private String numeroAgencia;

    @NotBlank
    @Size(max = 100)
    private String nomeAgencia;

    @Size(max = 30)
    private String numeroConta;

    @Size(max = 100)
    private String municipio;

    @Size(max = 100)
    private String nomeTitular;

    @Size(max = 100)
    private String gerente;

    @Size(max = 20)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "banco_id", nullable = false)
    private Banco banco;
}