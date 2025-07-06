package com.sagri.licenca.service;

import com.sagri.licenca.model.Empresa;
import com.sagri.licenca.repository.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional
    public Empresa saveEmpresa(Empresa empresa) {
        try {
            return empresaRepository.save(empresa);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro: CNPJ já cadastrado.");
        }
    }

    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa getEmpresa(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com ID: " + id));
    }

    @Transactional
    public Empresa updateEmpresa(Long id, Empresa empresaAtualizada) {
        return empresaRepository.findById(id).map(empresaExistente -> {
            empresaAtualizada.setId(id);
            empresaAtualizada.setVersao(empresaExistente.getVersao());
            try {
                return empresaRepository.save(empresaAtualizada);
            } catch (OptimisticLockingFailureException e) {
                throw new RuntimeException("Erro: A empresa foi modificada por outro usuário.");
            } catch (DataIntegrityViolationException e) {
                throw new RuntimeException("Erro: CNPJ já cadastrado.");
            }
        }).orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com ID: " + id));
    }

    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}