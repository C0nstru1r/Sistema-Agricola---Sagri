package com.sagri.estoque.model;

public enum StatusTransacao {
    PENDENTE,    // Transação registrada, aguardando confirmação
    CONFIRMADA,  // Transação confirmada e processada
    CANCELADA,   // Transação cancelada
    FINALIZADA   // Transação finalizada (pagamento realizado)
} 