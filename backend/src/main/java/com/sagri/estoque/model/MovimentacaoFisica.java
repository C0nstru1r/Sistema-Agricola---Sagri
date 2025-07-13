package com.sagri.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimentacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Pessoa cliente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Pessoa operador;

    @ManyToOne(optional = false)
    @JoinColumn(name = "plano_conta_id")
    private PlanoConta planoConta;

    @ManyToOne(optional = false)
    @JoinColumn(name = "centro_custo_id")
    private CentroCusto centroCusto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "historico_id")
    private HistoricoFinanceiro historico;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fazenda_id")
    private Fazenda fazenda;

    @NotNull
    private LocalDate dataAberturaCaixa;

    @NotNull
    private LocalDate dataMovimentacao;

    @DecimalMin("0.00")
    private BigDecimal valorDolar;

    @DecimalMin("0.00")
    private BigDecimal valorBolsa;

    @DecimalMin("0.00")
    private BigDecimal valorDiferencial;

    @DecimalMin("0.00")
    private BigDecimal quantidade;

    @DecimalMin("0.00")
    private BigDecimal credito;

    @DecimalMin("0.00")
    private BigDecimal debito;
}