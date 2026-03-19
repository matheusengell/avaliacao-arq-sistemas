package com.example.prova_arquitetura.dto.funcionario;

public record FuncionarioRespostaDto(
        Long id,
        String funcNomes,
        String funcCargos,
        double funcSalarios
) {
}
