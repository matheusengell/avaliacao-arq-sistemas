package com.example.prova_arquitetura.mapper;

import com.example.prova_arquitetura.dto.prato.PratoRequisicaoDto;
import com.example.prova_arquitetura.dto.prato.PratoRespostaDto;
import com.example.prova_arquitetura.model.Prato;
import org.springframework.stereotype.Component;

@Component
public class PratoMapper {

    public Prato paraEntidade(PratoRequisicaoDto pratoRequisicaoDto){
        return new Prato(
                pratoRequisicaoDto.pratoNomes(),
                pratoRequisicaoDto.pratoPrecos(),
                pratoRequisicaoDto.pratoEstoque()
        );
    }

    public PratoRespostaDto paraDto(Prato prato){
        return new PratoRespostaDto(
                prato.getId(),
                prato.getPratoNomes(),
                prato.getPratoPrecos(),
                prato.getPratoEstoque()
        );
    }
}
