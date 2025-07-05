package com.sagri.licenca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Unidade {

    @Id
    private Long id;
    private String nome;
    private String descricao;
    private Integer quantidadePorUnidade;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadePorUnidade() {
        return quantidadePorUnidade;
    }

    public void setQuantidadePorUnidade(Integer quantidadePorUnidade) {
        this.quantidadePorUnidade = quantidadePorUnidade;
    }
}