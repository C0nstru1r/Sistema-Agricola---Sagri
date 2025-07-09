package com.sagri.estoque.service;

import com.sagri.estoque.model.Preco;
import com.sagri.estoque.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecoService {

    @Autowired
    private PrecoRepository precoRepository;

    public Preco salvar(Preco preco) {
        return precoRepository.save(preco);
    }

    public Preco buscarPorId(Long id) {
        return precoRepository.findById(id).orElse(null);
    }

    public List<Preco> listarTodos() {
        return precoRepository.findAll();
    }

    public Preco atualizar(Long id, Preco novo) {
        Preco existente = buscarPorId(id);
        if (existente != null) {
            existente.setProduto(novo.getProduto());
            existente.setValor(novo.getValor());
            existente.setUnidade(novo.getUnidade());
            existente.setDataAtualizacao(novo.getDataAtualizacao());
            return precoRepository.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        precoRepository.deleteById(id);
    }
}