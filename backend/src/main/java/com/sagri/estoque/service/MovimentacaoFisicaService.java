package com.sagri.estoque.service;

import com.sagri.estoque.model.MovimentacaoFisica;
import com.sagri.estoque.repository.MovimentacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoFisicaService {

    @Autowired
    private MovimentacaoFisicaRepository repository;

    public MovimentacaoFisica salvar(MovimentacaoFisica movimentacao) {
        return repository.save(movimentacao);
    }

    public List<MovimentacaoFisica> listarTodas() {
        return repository.findAll();
    }

    public Optional<MovimentacaoFisica> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}