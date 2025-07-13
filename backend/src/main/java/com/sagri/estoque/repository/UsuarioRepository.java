package com.sagri.estoque.repository;

import com.sagri.estoque.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para autenticar usando nome e senha
    Usuario findByNomeAndSenha(String nome, String senha);

}