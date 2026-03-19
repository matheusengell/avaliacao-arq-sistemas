package com.example.prova_arquitetura.mapper;

import com.example.prova_arquitetura.dto.venda.VendaRequisicao;
import com.example.prova_arquitetura.dto.venda.VendaRespostaDto;
import com.example.prova_arquitetura.model.Venda;
import org.springframework.stereotype.Component;

@Component
public class VendaMapper {

    public Venda paraEntidade(VendaRequisicao vendaRequisicao){
        return new Venda(
                vendaRequisicao.quantidade(),
                vendaRequisicao.idPrato()
                );
    }

    public VendaRespostaDto paraDto(Venda venda){
        return new VendaRespostaDto(
                venda.getId(),
                venda.getIdPrato(),
                venda.getQuantidade()
        );
    }
}
