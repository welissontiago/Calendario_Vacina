package com.hackaton.grupo1.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "imunizacoes")
public class Imunizacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imunizacao")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_dose", nullable = false)
    private Dose dose;

    @Column(name = "data_aplicacao", nullable = false)
    private LocalDate dataAplicacao;

    @Column(name = "fabricante", length = 45)
    private String fabricante;

    @Column(name = "lote", length = 45)
    private String lote;

    @Column(name = "local_aplicacao", length = 45)
    private String localAplicacao;

    @Column(name = "profissional_aplicador", length = 45)
    private String profissionalAplicador;

    public Imunizacao() {
    }

    public Imunizacao(Integer id, Paciente paciente, Dose dose, LocalDate dataAplicacao, String fabricante, String lote, String localAplicacao, String profissionalAplicador) {
        this.id = id;
        this.paciente = paciente;
        this.dose = dose;
        this.dataAplicacao = dataAplicacao;
        this.fabricante = fabricante;
        this.lote = lote;
        this.localAplicacao = localAplicacao;
        this.profissionalAplicador = profissionalAplicador;
    }

    public Imunizacao(Paciente paciente, Dose dose, LocalDate dataAplicacao, String fabricante, String lote, String localAplicacao, String profissionalAplicador) {
        this.paciente = paciente;
        this.dose = dose;
        this.dataAplicacao = dataAplicacao;
        this.fabricante = fabricante;
        this.lote = lote;
        this.localAplicacao = localAplicacao;
        this.profissionalAplicador = profissionalAplicador;
    }

    public Imunizacao(Integer id, LocalDate dataAplicacao, Dose dose, Paciente paciente) {
        this.id = id;
        this.dataAplicacao = dataAplicacao;
        this.dose = dose;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dose getDose() {
        return dose;
    }

    public void setDose(Dose dose) {
        this.dose = dose;
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
