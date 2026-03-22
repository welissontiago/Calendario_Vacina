package com.hackaton.grupo1.demo.dto;

import java.time.LocalDate;

import com.hackaton.grupo1.demo.enums.Sexo;

public class PacienteDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private Sexo sexo;
    private LocalDate data_nascimento;

    public PacienteDTO() {
    }

    public PacienteDTO(String nome, String cpf, Sexo sexo, LocalDate data_nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
    }

    public PacienteDTO(Integer id, String nome, String cpf, Sexo sexo, LocalDate data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
    }

    public PacienteDTO(String nome, Sexo sexo, LocalDate data_nascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
