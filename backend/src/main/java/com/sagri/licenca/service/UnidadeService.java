package com.sagri.licenca.service;

import com.sagri.licenca.model.Unidade;
import com.sagri.licenca.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public Unidade saveUnidade(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    public List<Unidade> getAllUnidades() {
        return unidadeRepository.findAll();
    }

    public Unidade getUnidade(Long id) {
        return unidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidade não encontrada com id: " + id));
    }

    public Unidade updateUnidade(Long id, Unidade novaUnidade) {
        Unidade unidadeExistente = unidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidade não encontrada com id: " + id));

        unidadeExistente.setNome(novaUnidade.getNome());
        unidadeExistente.setDescricao(novaUnidade.getDescricao());
        // adicione outros campos se necessário

        return unidadeRepository.save(unidadeExistente);
    }

    public void deleteUnidade(Long id) {
        unidadeRepository.deleteById(id);
    }
}
