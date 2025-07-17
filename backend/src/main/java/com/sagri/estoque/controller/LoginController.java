package com.sagri.estoque.controller;

import com.sagri.estoque.model.Usuario;
import com.sagri.estoque.usuario.LoginRequest;
import com.sagri.estoque.response.LoginResponse;
import com.sagri.estoque.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*") // Habilita requisições do frontend (localhost:5173)
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest request) {
        String nome = request.getNome();
        String senha = request.getSenha();

        Usuario usuario = loginService.autenticar(nome, senha);

        if (usuario != null) {
            return new LoginResponse(true, "Login efetuado com sucesso", usuario);
        } else {
            return new LoginResponse(false, "Usuário ou senha inválidos", null);
        }
    }
}