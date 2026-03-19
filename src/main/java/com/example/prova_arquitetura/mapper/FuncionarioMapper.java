package com.example.prova_arquitetura.mapper;

import com.example.prova_arquitetura.dto.funcionario.FuncionarioRequisicaoDto;
import com.example.prova_arquitetura.dto.funcionario.FuncionarioRespostaDto;
import com.example.prova_arquitetura.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public Funcionario paraEntidade(FuncionarioRequisicaoDto funcionarioRequisicaoDto){
        return new Funcionario(
                funcionarioRequisicaoDto.funcNomes(),
                funcionarioRequisicaoDto.funcCargos(),
                funcionarioRequisicaoDto.funcSalarios()
        );
    }

    public FuncionarioRespostaDto paraDto(Funcionario funcionario){
        return new FuncionarioRespostaDto(
                funcionario.getId(),
                funcionario.getFuncNomes(),
                funcionario.getFuncCargos(),
                funcionario.getFuncSalarios()
        );
    }
}
