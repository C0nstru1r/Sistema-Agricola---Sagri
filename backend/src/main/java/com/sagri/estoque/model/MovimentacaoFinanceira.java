package com.sagri.estoque.model;

import com.sagri.estoque.model.Pessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimentacaoFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotNull
    private LocalDate dataAberturaCaixa;

    @NotNull
    private LocalDate dataMovimentacao;

    @DecimalMin("0.00")
    private BigDecimal valor;

    @DecimalMin("0.00")
    private BigDecimal credito;

    @DecimalMin("0.00")
    private BigDecimal debito;
}