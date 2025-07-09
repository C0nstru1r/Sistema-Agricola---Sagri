package com.sagri.estoque.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Licenca {

    @Id
    private Long id;
    private String codigo;
    private String validade;
    private Boolean ativo;
}
