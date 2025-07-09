package com.sagri.estoque.service;

import com.sagri.estoque.model.Licenca;
import com.sagri.estoque.repository.LicencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicencaService {

    @Autowired
    private LicencaRepository licencaRepository;

    public Licenca save(Licenca licenca) {
        return licencaRepository.save(licenca);
    }

    public Licenca getById(Long id) {
        return licencaRepository.findById(id).orElse(null);
    }

    public List<Licenca> getAll() {
        return licencaRepository.findAll();
    }

    public Licenca update(Long id, Licenca licenca) {
        if (licencaRepository.existsById(id)) {
            licenca.setId(id);
            return licencaRepository.save(licenca);
        }
        return null;
    }

    public void delete(Long id) {
        licencaRepository.deleteById(id);
    }
}