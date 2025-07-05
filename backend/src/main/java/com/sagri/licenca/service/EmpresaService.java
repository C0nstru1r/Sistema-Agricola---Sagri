package com.sagri.licenca.service;

import com.sagri.licenca.model.Empresa;
import com.sagri.licenca.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa saveEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa getEmpresa(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public Empresa updateEmpresa(Long id, Empresa empresa) {
        if (empresaRepository.existsById(id)) {
            empresa.setId(id);
            return empresaRepository.save(empresa);
        } else {
            return null;
        }
    }

    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}