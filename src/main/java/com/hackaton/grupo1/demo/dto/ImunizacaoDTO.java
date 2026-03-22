package com.hackaton.grupo1.demo.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

import com.hackaton.grupo1.demo.enums.Sexo;

public class ImunizacaoDTO {

    private Integer id;

    private Integer idPaciente;

    private Integer idDose;

    private LocalDate dataAplicacao;

    private String fabricante;

    private String lote;

    private String localAplicacao;

    private String profissionalAplicador;

    public ImunizacaoDTO() {
    }

    public ImunizacaoDTO(Integer id, Integer idPaciente, Integer idDose, LocalDate dataAplicacao) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idDose = idDose;
        this.dataAplicacao = dataAplicacao;
    }

    public ImunizacaoDTO(Integer id, Integer idPaciente, Integer idDose, LocalDate dataAplicacao, String fabricante, String lote, String localAplicacao, String profissionalAplicador) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idDose = idDose;
        this.dataAplicacao = dataAplicacao;
        this.fabricante = fabricante;
        this.lote = lote;
        this.localAplicacao = localAplicacao;
        this.profissionalAplicador = profissionalAplicador;
    }

    public ImunizacaoDTO(Integer idPaciente, Integer idDose, LocalDate dataAplicacao, String fabricante, String lote, String localAplicacao, String profissionalAplicador) {
        this.idPaciente = idPaciente;
        this.idDose = idDose;
        this.dataAplicacao = dataAplicacao;
        this.fabricante = fabricante;
        this.lote = lote;
        this.localAplicacao = localAplicacao;
        this.profissionalAplicador = profissionalAplicador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdDose() {
        return idDose;
    }

    public void setIdDose(Integer idDose) {
        this.idDose = idDose;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getLocalAplicacao() {
        return localAplicacao;
    }

    public void setLocalAplicacao(String localAplicacao) {
        this.localAplicacao = localAplicacao;
    }

    public String getProfissionalAplicador() {
        return profissionalAplicador;
    }

    public void setProfissionalAplicador(String profissionalAplicador) {
        this.profissionalAplicador = profissionalAplicador;
    }
}
