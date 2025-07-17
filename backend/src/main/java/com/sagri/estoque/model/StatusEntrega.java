package com.sagri.estoque.model;

public enum StatusEntrega {
    ENTREGUE,           // Produto entregue e armazenado
    EM_ANALISE,         // Produto em análise de qualidade
    APROVADO,           // Produto aprovado para armazenamento
    REJEITADO,          // Produto rejeitado
    PROCESSADO,         // Produto processado (vendido ou usado para abatimento)
    DEVOLVIDO           // Produto devolvido ao cliente
} 