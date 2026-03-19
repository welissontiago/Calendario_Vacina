package com.hackaton.grupo1.demo.entity;
import com.hackaton.grupo1.demo.enums.Sexo;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable{

    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer id;
    @Column(name = "nome_paciente", length = 60, nullable = false)
    private String nome;
    @Column(name = "cpf_paciente", length = 11)
    private String cpf;
    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate data_nascimento;

    public Paciente() {
    }

    public Paciente(String nome, String cpf, Sexo sexo, LocalDate data_nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
    }

    public Paciente(Integer id, String nome, String cpf, Sexo sexo, LocalDate data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
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

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Paciente paciente = (Paciente) object;
        return java.util.Objects.equals(id, paciente.id) && java.util.Objects.equals(nome, paciente.nome) && java.util.Objects.equals(cpf, paciente.cpf) && java.util.Objects.equals(sexo, paciente.sexo) && java.util.Objects.equals(data_nascimento, paciente.data_nascimento);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, nome, cpf, sexo, data_nascimento);
    }
}
