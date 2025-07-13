package com.sagri.estoque.config;

import com.sagri.estoque.model.Banco;
import com.sagri.estoque.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class BancoDataLoader implements CommandLineRunner {

    @Autowired
    private BancoRepository bancoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se já existem bancos cadastrados
        if (bancoRepository.count() > 0) {
            return;
        }

        ClassPathResource resource = new ClassPathResource("Bancos/Bancos Associados.csv");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {

            String linha;
            boolean primeiraLinha = true;

            while ((linha = reader.readLine()) != null) {
                // Pula o cabeçalho
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] partes = linha.split(";");
                if (partes.length < 2) continue;

                String numeroStr = partes[0].trim();
                String nome = partes[1].trim();

                Integer codigoBanco = null;
                if (!numeroStr.isEmpty()) {
                    try {
                        codigoBanco = Integer.parseInt(numeroStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Número inválido para banco: " + numeroStr + " - " + nome);
                    }
                }

                Banco banco = new Banco();
                banco.setCodigoBanco(codigoBanco);
                banco.setNome(nome);
                banco.setSistema(true); // ou false, dependendo da regra de negócio

                bancoRepository.save(banco);
            }
        }
    }
}