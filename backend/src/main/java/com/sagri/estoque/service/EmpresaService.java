package com.sagri.estoque.service;

import com.sagri.estoque.model.Empresa;
import com.sagri.estoque.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa saveEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa getEmpresa(Long id) {
        Optional<Empresa> optional = empresaRepository.findById(id);
        return optional.orElse(null);
    }

    public Empresa updateEmpresa(Long id, Empresa empresaAtualizada) {
        Empresa existente = getEmpresa(id);
        if (existente != null) {
            existente.setNome(empresaAtualizada.getNome());
            existente.setCnpj(empresaAtualizada.getCnpj());
            existente.setEmail(empresaAtualizada.getEmail());
            existente.setTelefone(empresaAtualizada.getTelefone());
            return empresaRepository.save(existente);
        }
        return null;
    }

    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}