package com.hackaton.grupo1.demo.entity;
import com.hackaton.grupo1.demo.enums.Sexo;

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
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;
    @Column(name = "nome_paciente", length = 60, nullable = false)
    private String nome;
    @Column(name = "cpf_paciente", length = 11)
    private String cpf;
    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(name = "limite_aplicacao")
    private int limiteAplicacao;
}
