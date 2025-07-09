package com.sagri.estoque.service;

import com.sagri.estoque.model.Fazenda;
import com.sagri.estoque.repository.FazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FazendaService {

    @Autowired
    private FazendaRepository fazendaRepository;

    public Fazenda salvar(Fazenda fazenda) {
        return fazendaRepository.save(fazenda);
    }

    public Fazenda buscarPorId(Long id) {
        return fazendaRepository.findById(id).orElse(null);
    }

    public List<Fazenda> listarTodas() {
        return fazendaRepository.findAll();
    }

    public Fazenda atualizar(Long id, Fazenda nova) {
        Fazenda existente = buscarPorId(id);
        if (existente != null) {
            existente.setNome(nova.getNome());
            existente.setLocalizacao(nova.getLocalizacao());
            existente.setTamanhoHectares(nova.getTamanhoHectares());
            existente.setProprietario(nova.getProprietario());
            return fazendaRepository.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        fazendaRepository.deleteById(id);
    }
}