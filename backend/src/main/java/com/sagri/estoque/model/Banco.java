package com.sagri.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Agora pode ser nulo e não é mais unique
    @Column(name = "codigo_banco", nullable = true, unique = false)
    private Integer codigoBanco;

    @NotBlank
    @Size(max = 100)
    private String nome;

    // Indica se o banco é do sistema (pré-cadastrado e protegido contra alteração/exclusão)
    private boolean sistema;
}