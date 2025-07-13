package com.sagri.estoque.controller;

import com.sagri.estoque.model.Usuario;
import com.sagri.estoque.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login"; // Vai buscar login.html em src/main/resources/templates
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam("nome") String nome,
                                 @RequestParam("senha") String senha,
                                 HttpSession session,
                                 Model model) {

        Usuario usuario = usuarioRepository.findByNomeAndSenha(nome, senha);

        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/home";
        } else {
            model.addAttribute("erro", "Nome ou senha inválidos.");
            return "login";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Vai buscar home.html
    }

    @GetMapping("/")
    public String redirecionarParaLogin() {
        return "redirect:/login";
    }
}