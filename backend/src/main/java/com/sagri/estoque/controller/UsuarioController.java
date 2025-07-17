package com.sagri.estoque.controller;

import com.sagri.estoque.model.Usuario;
import com.sagri.estoque.response.LoginResponse;
import com.sagri.estoque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }

    // Endpoint de login simples
    @PostMapping("/login")
    public LoginResponse login(@RequestBody Usuario usuario) {
        Usuario autenticado = usuarioService.autenticar(usuario.getNome(), usuario.getSenha());
        if (autenticado != null) {
            return new LoginResponse(true, "Login bem-sucedido", autenticado);
        } else {
            return new LoginResponse(false, "Usuário ou senha inválidos", null);
        }
    }
}