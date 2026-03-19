package com.example.prova_arquitetura.dto.venda;

import jakarta.validation.constraints.Positive;

public record VendaRequisicao(

        Long idPrato,

        @Positive(message = "O estoque deve ser positivo")
        int quantidade
) {
}
