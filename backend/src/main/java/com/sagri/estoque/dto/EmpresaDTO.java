package com.sagri.estoque.dto;

import lombok.Data;

@Data
public class EmpresaDTO {

    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String telefone;
    private String email;
    private String referencia;
    private String localizacao;
}