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
@Table(name = "prato")
public class Prato {
    private Long id;
    private String pratoNomes;
    private double pratoPrecos;
    private int pratoEstoque;

    public Prato(String pratoNomes, double pratoPrecos, int pratoEstoque) {
        this.pratoNomes = pratoNomes;
        this.pratoPrecos = pratoPrecos;
        this.pratoEstoque = pratoEstoque;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPratoNomes() {
        return pratoNomes;
    }

    public void setPratoNomes(String pratoNomes) {
        this.pratoNomes = pratoNomes;
    }

    public double getPratoPrecos() {
        return pratoPrecos;
    }

    public void setPratoPrecos(double pratoPrecos) {
        this.pratoPrecos = pratoPrecos;
    }

    public int getPratoEstoque() {
        return pratoEstoque;
    }

    public void setPratoEstoque(int pratoEstoque) {
        this.pratoEstoque = pratoEstoque;
    }
}
