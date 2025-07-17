package com.sagri.estoque.repository;

import com.sagri.estoque.model.Pessoa;
import com.sagri.estoque.model.TipoRelacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    // Buscar pessoas ativas
    List<Pessoa> findByAtivoTrue();
    
    // Buscar por tipo de relacionamento
    List<Pessoa> findByTipoRelacionamento(TipoRelacionamento tipoRelacionamento);
    
    // Buscar por nome (case insensitive)
    List<Pessoa> findByNomeContainingIgnoreCase(String nome);
    
    // Buscar por CPF
    List<Pessoa> findByCpf(String cpf);
    
    // Buscar por CNPJ
    List<Pessoa> findByCnpj(String cnpj);
    
    // Buscar por cidade
    List<Pessoa> findByCidade(String cidade);
    
    // Buscar por estado
    List<Pessoa> findByEstado(String estado);
    
    // Buscar pessoas ativas por tipo de relacionamento
    List<Pessoa> findByAtivoTrueAndTipoRelacionamento(TipoRelacionamento tipoRelacionamento);
}