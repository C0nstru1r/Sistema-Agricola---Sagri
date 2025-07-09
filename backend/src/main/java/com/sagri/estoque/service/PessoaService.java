package com.sagri.estoque.service;

import com.sagri.estoque.model.Pessoa;
import com.sagri.estoque.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    public Pessoa atualizar(Long id, Pessoa nova) {
        Pessoa existente = buscarPorId(id);
        if (existente != null) {
            existente.setNome(nova.getNome());
            existente.setCpf(nova.getCpf());
            existente.setTelefone(nova.getTelefone());
            existente.setEmail(nova.getEmail());
            existente.setTipo(nova.getTipo());
            return pessoaRepository.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }
}