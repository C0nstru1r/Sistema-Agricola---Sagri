package com.sagri.licenca.config;

import com.sagri.licenca.model.Banco;
import com.sagri.licenca.repository.BancoRepository;
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
        if (bancoRepository.count() == 0) {
            ClassPathResource resource = new ClassPathResource("bancos/Bancos Associados.csv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                String linha;
                boolean primeiraLinha = true;
                while ((linha = reader.readLine()) != null) {
                    if (primeiraLinha) {
                        primeiraLinha = false; // Ignora o cabeçalho
                        continue;
                    }

                    String[] campos = linha.split(";", -1);
                    if (campos.length >= 2) {
                        Banco banco = new Banco();
                        banco.setCodigoBanco(Integer.parseInt(campos[0].trim()));
                        banco.setNome(campos[1].trim());
                        banco.setSistema(true);

                        bancoRepository.save(banco);
                    }
                }
                System.out.println("Bancos do sistema carregados com sucesso.");
            }
        }
    }
}