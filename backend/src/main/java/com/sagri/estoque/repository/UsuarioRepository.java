package com.sagri.estoque.repository;

import com.sagri.estoque.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNomeIgnoreCaseAndSenha(String nome, String senha);
}