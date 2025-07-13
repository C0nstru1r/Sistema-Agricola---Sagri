package com.sagri.estoque.service;

import com.sagri.estoque.model.FormaPagamento;
import com.sagri.estoque.model.TipoPagamento;
import com.sagri.estoque.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository repository;

    private final List<TipoPagamento> TIPOS_BANCARIOS = Arrays.asList(
        TipoPagamento.BANCO, TipoPagamento.BOLETO, TipoPagamento.PIX
    );

    public FormaPagamento save(FormaPagamento forma) {
        if (TIPOS_BANCARIOS.contains(forma.getTipo()) && forma.getAgenciaConta() == null) {
            throw new IllegalArgumentException("Formas de pagamento do tipo bancário devem ter uma conta vinculada.");
        }
        return repository.save(forma);
    }

    public List<FormaPagamento> findAll() {
        return repository.findAll();
    }

    public Optional<FormaPagamento> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}