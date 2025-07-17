package com.sagri.estoque.service;

import com.sagri.estoque.model.Usuario;
import com.sagri.estoque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(String nome, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByNomeIgnoreCaseAndSenha(nome, senha);
        return usuarioOptional.orElse(null);
    }
}