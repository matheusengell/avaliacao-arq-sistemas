package com.example.prova_arquitetura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "funcionario")

public class Funcionario {
    private Long id;
    private String funcNomes;
    private String funcCargos;
    private double funcSalarios;

    public Funcionario(String funcNomes, String funcCargos, double funcSalarios) {
        this.funcNomes = funcNomes;
        this.funcCargos = funcCargos;
        this.funcSalarios = funcSalarios;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuncNomes() {
        return funcNomes;
    }

    public void setFuncNomes(String funcNomes) {
        this.funcNomes = funcNomes;
    }

    public String getFuncCargos() {
        return funcCargos;
    }

    public void setFuncCargos(String funcCargos) {
        this.funcCargos = funcCargos;
    }

    public double getFuncSalarios() {
        return funcSalarios;
    }

    public void setFuncSalarios(double funcSalarios) {
        this.funcSalarios = funcSalarios;
    }
}


