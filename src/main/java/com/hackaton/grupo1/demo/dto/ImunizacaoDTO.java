package com.hackaton.grupo1.demo.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class ImunizacaoDTO {

    private Integer id;

    private Integer idPaciente;

    private Integer idDose;

    private LocalDate dataAplicacao;

    private String fabricante;

    private String lote;

    private String localAplicacao;

    private String profissionalAplicador;
}
