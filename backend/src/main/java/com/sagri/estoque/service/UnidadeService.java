package com.sagri.estoque.service;

import com.sagri.estoque.model.Unidade;
import com.sagri.estoque.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public Unidade salvar(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    public Unidade buscarPorId(Long id) {
        return unidadeRepository.findById(id).orElse(null);
    }

    public List<Unidade> listarTodas() {
        return unidadeRepository.findAll();
    }

    public Unidade atualizar(Long id, Unidade nova) {
        Unidade existente = buscarPorId(id);
        if (existente != null) {
            existente.setNome(nova.getNome());
            existente.setSigla(nova.getSigla());
            return unidadeRepository.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        unidadeRepository.deleteById(id);
    }
}