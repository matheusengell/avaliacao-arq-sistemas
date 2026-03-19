package com.example.prova_arquitetura.service;


import com.example.prova_arquitetura.dto.funcionario.FuncionarioRequisicaoDto;
import com.example.prova_arquitetura.dto.funcionario.FuncionarioRespostaDto;
import com.example.prova_arquitetura.mapper.FuncionarioMapper;
import com.example.prova_arquitetura.model.Funcionario;
import com.example.prova_arquitetura.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service

public class FuncionarioService {


    private final FuncionarioMapper funcionarioMapper;
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioMapper funcionarioMapper, FuncionarioRepository funcionarioRepository) {
        this.funcionarioMapper = funcionarioMapper;
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<FuncionarioRespostaDto> listarFuncionarios()throws SQLException{
    List<Funcionario> funcionarios = funcionarioRepository.findAll();
    return funcionarios.stream()
            .map(funcionarioMapper::paraDto)
            .toList();
    }

    public FuncionarioRespostaDto contratar(FuncionarioRequisicaoDto funcionarioRequisicaoDto)throws SQLException{
        Funcionario funcionario = funcionarioMapper.paraEntidade(funcionarioRequisicaoDto);
        funcionarioRepository.save(funcionario);
        return funcionarioMapper.paraDto(funcionario);
    }


    public FuncionarioRespostaDto editar(FuncionarioRequisicaoDto funcionarioRequisicaoDto, Long id)throws SQLException{
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Funcionário não encontrado"));

        funcionario.setFuncNomes(funcionarioRequisicaoDto.funcNomes());
        funcionario.setFuncCargos(funcionarioRequisicaoDto.funcCargos());
        funcionario.setFuncSalarios(funcionarioRequisicaoDto.funcSalarios());

        Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);
        return funcionarioMapper.paraDto(funcionarioAtualizado);
    }

    public void deletar(long id)throws SQLException{
    funcionarioRepository.deleteById(id);
    }

}
