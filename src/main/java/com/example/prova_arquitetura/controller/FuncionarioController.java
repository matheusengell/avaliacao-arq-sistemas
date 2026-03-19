package com.example.prova_arquitetura.controller;

import com.example.prova_arquitetura.dto.funcionario.FuncionarioRequisicaoDto;
import com.example.prova_arquitetura.dto.funcionario.FuncionarioRespostaDto;
import com.example.prova_arquitetura.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public FuncionarioRespostaDto contratar(@RequestBody FuncionarioRequisicaoDto funcionarioRequisicaoDto){
    try {
        return funcionarioService.contratar(funcionarioRequisicaoDto);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    @GetMapping
    public List<FuncionarioRespostaDto> ver(){
    try {
        return funcionarioService.listarFuncionarios();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    @PutMapping("/{id}")
    public FuncionarioRespostaDto atualizar(@RequestBody FuncionarioRequisicaoDto funcionarioRequisicaoDto, @PathVariable long id){
    try {
        return funcionarioService.editar(funcionarioRequisicaoDto, id);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
    try {
        funcionarioService.deletar(id);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
}
