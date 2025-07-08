package com.sagri.licenca.service;

import com.sagri.licenca.model.Usuario;
import com.sagri.licenca.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    // ✅ Cria usuário padrão ao iniciar
    @PostConstruct
    public void createUsuarioPadrao() {
        if (usuarioRepository.findByLogin("CRIATIVA").isEmpty()) {
            Usuario user = new Usuario();
            user.setLogin("CRIATIVA");
            user.setNome("Usuário Master");
            user.setSenha("1068"); // ❗ Sugestão futura: salvar senha criptografada
            user.setNivel("master");
            usuarioRepository.save(user);
            System.out.println("✅ Usuário padrão CRIATIVA criado.");
        }
    }
}