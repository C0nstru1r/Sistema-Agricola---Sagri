package com.sagri.estoque;

import com.sagri.licenca.LicencaValidator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.sagri.estoque", "com.sagri.licenca"})
@EnableJpaAuditing
public class SagriEstoqueApplication implements CommandLineRunner {

    private final LicencaValidator licencaValidator;

    public SagriEstoqueApplication(LicencaValidator licencaValidator) {
        this.licencaValidator = licencaValidator;
    }

    public static void main(String[] args) {
        SpringApplication.run(SagriEstoqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (!licencaValidator.verificarLicenca()) {
            System.out.println("🔒 Licença inválida ou vencida. Encerrando sistema...");
            System.exit(1);
        } else {
            System.out.println("✅ Licença válida. Sistema iniciado com sucesso.");
        }
    }
}