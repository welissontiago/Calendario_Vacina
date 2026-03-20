package com.hackaton.grupo1.demo.entity;
import java.io.Serializable;
import java.util.List;

import com.hackaton.grupo1.demo.enums.PublicoAlvo;
import jakarta.persistence.*;

@Entity
@Table(name = "vacina")
public class Vacina implements Serializable {

    private static final long serialVersionUID = 1L;
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

    @OneToMany(mappedBy = "vacina", cascade = CascadeType.ALL)
    private List<Dose> doses;

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

    public Vacina(List<Dose> doses, PublicoAlvo publicoAlvo, int limiteAplicacao, String descricao, String nome, Integer id) {
        this.doses = doses;
        this.publicoAlvo = publicoAlvo;
        this.limiteAplicacao = limiteAplicacao;
        this.descricao = descricao;
        this.nome = nome;
        this.id = id;
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

    public List<Dose> getDoses() {
        return doses;
    }

    public void setDoses(List<Dose> doses) {
        this.doses = doses;
    }
}