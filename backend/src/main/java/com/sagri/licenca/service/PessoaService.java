package com.sagri.licenca.service;

import com.sagri.licenca.model.Pessoa;
import com.sagri.licenca.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa savePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa getPessoa(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa updatePessoa(Long id, Pessoa pessoa) {
        if (pessoaRepository.existsById(id)) {
            pessoa.setId(id);
            return pessoaRepository.save(pessoa);
        } else {
            return null;
        }
    }

    public void deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}