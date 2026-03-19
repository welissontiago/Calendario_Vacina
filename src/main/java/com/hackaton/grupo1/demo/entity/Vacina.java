package com.hackaton.grupo1.demo.entity;
import java.io.Serializable;

import com.hackaton.grupo1.demo.enums.PublicoAlvo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vacina")
public class Vacina implements Serializable {

    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacina")
    private Integer id;
    @Column(name = "nome_vacina", length = 50, nullable = false)
    private String nome;
    @Column(name = "descricao_vacina", length = 200, nullable = false)
    private String descricao;
    @Column(name = "limite_aplicacao")
    private int limiteAplicacao;
    @Column(name = "publico_alvo", nullable = false)
    @Enumerated(EnumType.STRING)
    private PublicoAlvo publicoAlvo;

    public Vacina(){

    }

    public Vacina(String nome, String descricao, int limiteAplicacao, PublicoAlvo publicoAlvo){
        this.nome = nome;
        this.descricao = descricao;
        this.limiteAplicacao = limiteAplicacao;
        this.publicoAlvo = publicoAlvo;
    }

    public Vacina(Integer id, String nome, String descricao, int limiteAplicacao, PublicoAlvo publicoAlvo){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.limiteAplicacao = limiteAplicacao;
        this.publicoAlvo = publicoAlvo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getLimiteAplicacao() {
        return limiteAplicacao;
    }

    public PublicoAlvo getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLimiteAplicacao(Integer limiteAplicacao) {
        this.limiteAplicacao = limiteAplicacao;
    }

    public void setPublicoAlvo(PublicoAlvo publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    
}