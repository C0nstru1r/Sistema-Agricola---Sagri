package com.sagri.estoque.service;

import com.sagri.estoque.model.Usuario;
import com.sagri.estoque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizar(Long id, Usuario atualizado) {
        Usuario existente = buscarPorId(id);
        if (existente != null) {
            existente.setNome(atualizado.getNome());
            existente.setEmail(atualizado.getEmail());
            existente.setSenha(atualizado.getSenha());
            existente.setPerfil(atualizado.getPerfil());
            return usuarioRepository.save(existente);
        }
        return null;
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}