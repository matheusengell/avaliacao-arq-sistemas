package com.example.prova_arquitetura.repository;

import com.example.prova_arquitetura.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


}
