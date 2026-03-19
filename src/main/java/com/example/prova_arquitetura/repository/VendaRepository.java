package com.example.prova_arquitetura.repository;

import com.example.prova_arquitetura.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
