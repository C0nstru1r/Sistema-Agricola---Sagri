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
public class MovimentacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name =produto_id")
    private Produto produto;

    @ManyToOne(optional = false)
    @JoinColumn(name =cliente_id")
    private Pessoa cliente;

    @ManyToOne
    @JoinColumn(name =usuario_id")
    private Pessoa operador;

    @ManyToOne(optional = false)
    @JoinColumn(name = plano_conta_id")
    private PlanoConta planoConta;

    @ManyToOne(optional = false)
    @JoinColumn(name = "centro_custo_id")
    private CentroCusto centroCusto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "historico_id")
    private HistoricoFinanceiro historico;

    @ManyToOne(optional = false)
    @JoinColumn(name =fazenda_id)   private Fazenda fazenda;

    @NotNull
    private LocalDate dataAberturaCaixa;

    @NotNull
    private LocalDate dataMovimentacao;

    @Column(nullable = false)
    private LocalTime horaMovimentacao;

    @DecimalMin("0private BigDecimal valorDolar;

    @DecimalMin("0private BigDecimal valorBolsa;

    @DecimalMin("0private BigDecimal valorDiferencial;

    @DecimalMin("0private BigDecimal quantidade;

    @DecimalMin("0private BigDecimal credito;

    @DecimalMin("0private BigDecimal debito;

    // Novos campos para entrega de armazenamento
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoEntrega tipoEntrega;

    @Size(max = 50)
    private String numeroContrato; // Número do contrato para abatimento

    @Size(max = 100)
    private String observacoes;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StatusEntrega statusEntrega = StatusEntrega.ENTREGUE;

    // Campos para controle de qualidade
    private String qualidade; // Qualidade do produto entregue
    private String umidade; // Percentual de umidade
    private String impurezas; // Percentual de impurezas
    private String pesoBruto; // Peso bruto
    private String pesoLiquido; // Peso líquido

    // Campos para rastreamento
    private String numeroNotaFiscal;
    private String placaVeiculo;
    private String motorista;
} 