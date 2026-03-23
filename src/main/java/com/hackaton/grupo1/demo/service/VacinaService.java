package com.hackaton.grupo1.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.hackaton.grupo1.demo.dto.VacinaDTO;
import com.hackaton.grupo1.demo.enums.PublicoAlvo;
import com.hackaton.grupo1.demo.exceptions.BadRequestException;
import com.hackaton.grupo1.demo.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.grupo1.demo.entity.Vacina;
import com.hackaton.grupo1.demo.repository.VacinaRepository;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;


    public List<VacinaDTO> listarTodas() {
        return vacinaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<VacinaDTO> listarPorFaixaEtaria(String faixa) {
        PublicoAlvo publico = PublicoAlvo.valueOf(faixa.toUpperCase());
        return vacinaRepository.findByPublicoAlvo(publico)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<VacinaDTO> listarPorIdadeMaior(int meses) {
        if (meses < 0) {
            throw new BadRequestException("O número de meses não pode ser negativo.");
        }

        List<Vacina> vacinas = vacinaRepository.findVacinasAcimaIdadeOuSemLimite(meses);

        if (vacinas.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma vacina encontrada para a idade de " + meses + " meses.");
        }

        return vacinas.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private VacinaDTO convertToDTO(Vacina vacina) {
        return new VacinaDTO(
                vacina.getId(),
                vacina.getNome(),
                vacina.getDescricao(),
                vacina.getLimiteAplicacao(),
                vacina.getPublicoAlvo()
        );
    }
}
