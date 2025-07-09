package com.sagri.licenca;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LicencaValidator {

    // Exemplo simplificado: data fictícia de validade
    private final LocalDate dataValidade = LocalDate.of(2025, 7, 17); // 10 dias após hoje (exemplo)

    public boolean verificarLicenca() {
        LocalDate hoje = LocalDate.now();

        if (hoje.isAfter(dataValidade)) {
            System.out.println("⚠️ Licença expirada em " + dataValidade);
            return false;
        }

        System.out.println("🔓 Licença válida até " + dataValidade);
        return true;
    }
}