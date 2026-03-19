package com.example.prova_arquitetura.infra.strategies;


import com.example.prova_arquitetura.model.ICalculoFreteStrategy;

public class PrecoDelivery implements ICalculoFreteStrategy {
    @Override
    public double calcularFrete(double valorBase, double desconto) {
        return valorBase += 15.0;
    }
}
