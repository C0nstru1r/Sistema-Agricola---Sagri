package com.sagri.licenca.controller;

import com.sagri.licenca.model.Licenca;
import com.sagri.licenca.repository.LicencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicencaController {

    @Autowired
    private LicencaRepository licencaRepository;

    public Licenca saveLicenca(Licenca licenca) {
        return licencaRepository.save(licenca);
    }

    public List<Licenca> getAllLicencas() {
        return licencaRepository.findAll();
    }

    public Licenca getLicenca(Long id) {
        return licencaRepository.findById(id).orElse(null);
    }

    public Licenca updateLicenca(Long id, Licenca licenca) {
        if (licencaRepository.existsById(id)) {
            licenca.setId(id);
            return licencaRepository.save(licenca);
        } else {
            return null;
        }
    }

    public void deleteLicenca(Long id) {
        licencaRepository.deleteById(id);
    }
}