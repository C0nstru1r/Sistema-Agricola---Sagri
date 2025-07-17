package com.sagri.estoque.service;

import com.sagri.estoque.model.Pessoa;
import com.sagri.estoque.model.TipoRelacionamento;
import com.sagri.estoque.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {
        // Definir data de cadastro se não informada
        if (pessoa.getDataCadastro() == null) {
            pessoa.setDataCadastro(LocalDate.now());
        }
        
        // Definir como ativo se não informado
        if (pessoa.getAtivo() == null) {
            pessoa.setAtivo(true);
        }
        
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    public List<Pessoa> listarAtivas() {
        return pessoaRepository.findByAtivoTrue();
    }

    public List<Pessoa> buscarPorTipoRelacionamento(TipoRelacionamento tipo) {
        return pessoaRepository.findByTipoRelacionamento(tipo);
    }

    public List<Pessoa> buscarPorNome(String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Pessoa> buscarPorCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    public List<Pessoa> buscarPorCnpj(String cnpj) {
        return pessoaRepository.findByCnpj(cnpj);
    }

    public Pessoa atualizar(Long id, Pessoa nova) {
        Pessoa existente = buscarPorId(id);
        if (existente != null) {
            // Atualizar campos básicos
            existente.setNome(nova.getNome());
            existente.setCpf(nova.getCpf());
            existente.setCnpj(nova.getCnpj());
            existente.setTelefone(nova.getTelefone());
            existente.setEmail(nova.getEmail());
            
            // Atualizar endereço
            existente.setEndereco(nova.getEndereco());
            existente.setNumero(nova.getNumero());
            existente.setComplemento(nova.getComplemento());
            existente.setBairro(nova.getBairro());
            existente.setCidade(nova.getCidade());
            existente.setEstado(nova.getEstado());
            existente.setCep(nova.getCep());
            
            // Atualizar campos específicos do setor agrícola
            existente.setInscricaoEstadual(nova.getInscricaoEstadual());
            existente.setInscricaoMunicipal(nova.getInscricaoMunicipal());
            existente.setPropriedade(nova.getPropriedade());
            existente.setAreaHectares(nova.getAreaHectares());
            existente.setCoordenadas(nova.getCoordenadas());
            
            // Atualizar tipos
            existente.setTipoPessoa(nova.getTipoPessoa());
            existente.setTipoRelacionamento(nova.getTipoRelacionamento());
            
            // Atualizar campos de controle
            existente.setAtivo(nova.getAtivo());
            existente.setObservacoes(nova.getObservacoes());
            
            return pessoaRepository.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }

    /**
     * Desativa uma pessoa (soft delete)
     */
    public Pessoa desativar(Long id) {
        Pessoa pessoa = buscarPorId(id);
        if (pessoa != null) {
            pessoa.setAtivo(false);
            return pessoaRepository.save(pessoa);
        }
        return null;
    }

    /**
     * Reativa uma pessoa
     */
    public Pessoa reativar(Long id) {
        Pessoa pessoa = buscarPorId(id);
        if (pessoa != null) {
            pessoa.setAtivo(true);
            return pessoaRepository.save(pessoa);
        }
        return null;
    }
}