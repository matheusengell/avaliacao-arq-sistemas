package com.example.prova_arquitetura.infra.strategies;


import com.example.prova_arquitetura.model.ICalculoPrecoStrategy;

public class PrecoEspecie implements ICalculoPrecoStrategy {

    @Override
    public double calcularPreco(double valorFinal, double desconto) {
        return valorFinal * 0.92;
    }
}
