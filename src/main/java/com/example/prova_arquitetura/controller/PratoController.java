package com.example.prova_arquitetura.controller;

import com.example.prova_arquitetura.dto.funcionario.FuncionarioRequisicaoDto;
import com.example.prova_arquitetura.dto.funcionario.FuncionarioRespostaDto;
import com.example.prova_arquitetura.dto.prato.PratoRequisicaoDto;
import com.example.prova_arquitetura.dto.prato.PratoRespostaDto;
import com.example.prova_arquitetura.service.PratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/pratos")
public class PratoController {

    private final PratoService pratoService;

    public PratoController(PratoService pratoService) {
        this.pratoService = pratoService;
    }

    @PostMapping
    public PratoRespostaDto contratar(@RequestBody PratoRequisicaoDto pratoRequisicaoDto){
        try {
            return pratoService.contratar(pratoRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<PratoRespostaDto> ver(){
        try {
            return pratoService.listarPrato();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public PratoRespostaDto atualizar(@RequestBody PratoRequisicaoDto pratoRequisicaoDto, @PathVariable long id){
        try {
            return pratoService.editar(pratoRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        try {
            pratoService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
