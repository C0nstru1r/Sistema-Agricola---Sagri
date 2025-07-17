package com.sagri.estoque.service;

import com.sagri.estoque.dto.EmpresaDTO;
import com.sagri.estoque.model.Empresa;
import com.sagri.estoque.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa getEmpresa(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public Empresa updateEmpresa(Long id, EmpresaDTO dto) {
        Optional<Empresa> empresaOpt = empresaRepository.findById(id);
        if (empresaOpt.isPresent()) {
            Empresa empresa = empresaOpt.get();

            // Atualiza apenas os campos permitidos
            empresa.setEndereco(dto.getEndereco());
            empresa.setNumero(dto.getNumero());
            empresa.setComplemento(dto.getComplemento());
            empresa.setBairro(dto.getBairro());
            empresa.setCidade(dto.getCidade());
            empresa.setEstado(dto.getEstado());
            empresa.setCep(dto.getCep());
            empresa.setTelefone(dto.getTelefone());
            empresa.setEmail(dto.getEmail());
            empresa.setReferencia(dto.getReferencia());
            empresa.setLocalizacao(dto.getLocalizacao());

            return empresaRepository.save(empresa);
        }
        return null;
    }

    // ✅ Adicionado: permite criar empresa
    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}