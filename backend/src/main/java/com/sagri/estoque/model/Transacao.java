package com.sagri.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TipoTransacao tipo; // COMPRA ou VENDA

    @Positive
    @Column(nullable = false)
    private BigDecimal quantidade;

    @DecimalMin("0.00")
    @Column(nullable = false)
    private BigDecimal valorUnitario;

    @DecimalMin("0.00")
    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime hora;

    @Size(max = 50)
    private String documento; // Nota fiscal, recibo, etc.

    @ManyToOne(optional = false)
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "fazenda_id")
    private Fazenda fazenda; // Fazenda de origem ou destino

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id")
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StatusTransacao status = StatusTransacao.PENDENTE;

    @Size(max = 255)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario; // Usuário que registrou a transação

    // Campos para controle de qualidade
    private String qualidade; // Qualidade do produto
    private String umidade; // Percentual de umidade
    private String impurezas; // Percentual de impurezas
} 