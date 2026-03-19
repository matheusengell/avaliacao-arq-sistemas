package com.example.prova_arquitetura.service;


import com.example.prova_arquitetura.dto.prato.PratoRequisicaoDto;
import com.example.prova_arquitetura.dto.prato.PratoRespostaDto;
import com.example.prova_arquitetura.mapper.PratoMapper;
import com.example.prova_arquitetura.model.Prato;
import com.example.prova_arquitetura.repository.PratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PratoService {

    private final PratoMapper pratoMapper;
    private final PratoRepository pratoRepository;

    public PratoService(PratoMapper pratoMapper, PratoRepository pratoRepository) {
        this.pratoMapper = pratoMapper;
        this.pratoRepository = pratoRepository;
    }

    public List<PratoRespostaDto> listarPrato()throws SQLException {
        List<Prato> pratos = pratoRepository.findAll();
        return pratos.stream()
                .map(pratoMapper::paraDto)
                .toList();
    }

    public PratoRespostaDto contratar(PratoRequisicaoDto pratoRequisicaoDto)throws SQLException{
        Prato prato = pratoMapper.paraEntidade(pratoRequisicaoDto);
        pratoRepository.save(prato);
        return pratoMapper.paraDto(prato);
    }


    public PratoRespostaDto editar(PratoRequisicaoDto pratoRequisicaoDto, Long id)throws SQLException{
        Prato prato = pratoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Prato não encontrado"));

        prato.setPratoNomes(prato.getPratoNomes());
        prato.setPratoPrecos(prato.getPratoPrecos());
        prato.setPratoEstoque(prato.getPratoEstoque());

        Prato pratoAtualizado = pratoRepository.save(prato);
        return pratoMapper.paraDto(pratoAtualizado);
    }

    public void deletar(long id)throws SQLException{
        pratoRepository.deleteById(id);
    }

}
