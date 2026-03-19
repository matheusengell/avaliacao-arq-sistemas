package com.example.prova_arquitetura.service;


import com.example.prova_arquitetura.dto.prato.PratoRequisicaoDto;
import com.example.prova_arquitetura.dto.prato.PratoRespostaDto;
import com.example.prova_arquitetura.dto.venda.VendaRequisicao;
import com.example.prova_arquitetura.dto.venda.VendaRespostaDto;
import com.example.prova_arquitetura.mapper.VendaMapper;
import com.example.prova_arquitetura.model.Prato;
import com.example.prova_arquitetura.model.Venda;
import com.example.prova_arquitetura.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;

    private final VendaMapper vendaMapper;

    public VendaRespostaDto criar(VendaRequisicao vendaRequisicao)throws SQLException {
        Venda venda = vendaMapper.paraEntidade(vendaRequisicao);
        vendaRepository.save(venda);
        return vendaMapper.paraDto(venda);
    }


    public List<VendaRespostaDto> listarVenda()throws SQLException {
        List<Venda> vendas = vendaRepository.findAll();
        return vendas.stream()
                .map(vendaMapper::paraDto)
                .toList();
    }

    public VendaRespostaDto editar(VendaRequisicao vendaRequisicao, Long id)throws SQLException{
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Venda não encontrado"));


       venda.setIdPrato(venda.getIdPrato());
        venda.setQuantidade(venda.getQuantidade());

        Venda vendaAtualizadoa = vendaRepository.save(venda);
        return vendaMapper.paraDto(vendaAtualizadoa);
    }

    public void deletar(Long id)throws SQLException{
        vendaRepository.deleteById(id);
    }

}
