
package com.sagri.licenca.service;

import com.sagri.licenca.model.Licenca;
import com.sagri.licenca.repository.LicencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicencaService {

    @Autowired
    private LicencaRepository licencaRepository;

    public Licenca saveLicenca(Licenca licenca) {
        return licencaRepository.save(licenca);
    }

    public List<Licenca> getAllLicencas() {
        return licencaRepository.findAll();
    }

    public Optional<Licenca> getLicencaById(Long id) {
        return licencaRepository.findById(id);
    }

    public void deleteLicenca(Long id) {
        licencaRepository.deleteById(id);
    }
}
