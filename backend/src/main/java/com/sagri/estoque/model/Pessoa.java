package com.sagri.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @Size(max = 14)
    private String cpf;

    @Size(max = 18)
    private String cnpj;

    @Size(max = 20)
    private String telefone;

    @Size(max = 100)
    @Email
    private String email;

    // Endereço
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    // Campos específicos para o setor agrícola
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String propriedade; // Nome da propriedade rural
    private String areaHectares; // Área da propriedade
    private String coordenadas; // Coordenadas GPS da propriedade

    // Tipo de pessoa (Física ou Jurídica)
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TipoPessoa tipoPessoa;

    // Tipo de relacionamento com a empresa
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TipoRelacionamento tipoRelacionamento;

    // Campos de controle
    private LocalDate dataCadastro;
    private Boolean ativo = true;
    private String observacoes;
}