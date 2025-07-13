package com.sagri.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer codigo;

    @NotBlank
    @Size(max = 100)
    private String descricao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipo;

    @ManyToOne
    @JoinColumn(name = "agencia_conta_id")
    private AgenciaConta agenciaConta;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public AgenciaConta getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(AgenciaConta agenciaConta) {
        this.agenciaConta = agenciaConta;
    }
}