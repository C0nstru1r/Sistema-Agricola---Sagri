package com.sagri.licenca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 dígitos numéricos")
    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;

    @Size(max = 255)
    private String endereco;

    @Size(max = 100)
    private String cidade;

    @Size(max = 2, message = "Informe a sigla do estado (ex: SP, MG)")
    private String estado;

    @Version
    private Long versao;
}