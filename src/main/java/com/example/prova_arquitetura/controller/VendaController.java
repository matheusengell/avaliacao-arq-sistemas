package com.example.prova_arquitetura.controller;

import com.example.prova_arquitetura.dto.venda.VendaRequisicao;
import com.example.prova_arquitetura.dto.venda.VendaRespostaDto;
import com.example.prova_arquitetura.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/vendas")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService vendaService;

    @PostMapping
    public VendaRespostaDto contratar(@RequestBody VendaRequisicao vendaRequisicao){
        try {
            return vendaService.criar(vendaRequisicao);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<VendaRespostaDto> ver(){
        try {
            return vendaService.listarVenda();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public VendaRespostaDto atualizar(@RequestBody VendaRequisicao vendaRequisicao, @PathVariable long id){
        try {
            return vendaService.editar(vendaRequisicao, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        try {
            vendaService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
