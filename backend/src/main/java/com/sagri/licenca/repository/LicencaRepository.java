package com.sagri.licenca.repository;

import com.sagri.licenca.model.Licenca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicencaRepository extends JpaRepository<Licenca, Long> {
}