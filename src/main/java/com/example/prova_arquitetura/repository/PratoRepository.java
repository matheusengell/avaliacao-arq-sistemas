package com.example.prova_arquitetura.repository;

import com.example.prova_arquitetura.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PratoRepository extends JpaRepository<Prato, Long> {
}
