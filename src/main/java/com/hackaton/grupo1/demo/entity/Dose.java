package com.hackaton.grupo1.demo.entity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "dose")
public class Dose implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dose")
    private Integer id;
    @Column(name = "descricao_dose", length = 45, nullable = false)
    private String descricao;

    @Column(name = "idade_recomendada_aplicacao", nullable = false)
    private int idadeRecomendadaAplicacao;

    @ManyToOne
    @JoinColumn(name = "id_vacina", nullable = false)
    private Vacina vacina;

    @OneToMany(mappedBy = "dose", cascade = CascadeType.ALL)
    private List<Imunizacao> imunizacoes;


    public Dose() {
    }

    public Dose(String descricao, Vacina vacina, int idadeRecomendadaAplicacao) {
        this.descricao = descricao;
        this.vacina = vacina;
        this.idadeRecomendadaAplicacao = idadeRecomendadaAplicacao;
    }

    public Dose(Integer id, String descricao, int idadeRecomendadaAplicacao, Vacina vacina) {
        this.id = id;
        this.descricao = descricao;
        this.idadeRecomendadaAplicacao = idadeRecomendadaAplicacao;
        this.vacina = vacina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdadeRecomendadaAplicacao() {
        return idadeRecomendadaAplicacao;
    }

    public void setIdadeRecomendadaAplicacao(int idadeRecomendadaAplicacao) {
        this.idadeRecomendadaAplicacao = idadeRecomendadaAplicacao;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dose dose)) return false;
        return getIdadeRecomendadaAplicacao() == dose.getIdadeRecomendadaAplicacao() && Objects.equals(getId(), dose.getId()) && Objects.equals(getDescricao(), dose.getDescricao()) && Objects.equals(getVacina(), dose.getVacina());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao(), getIdadeRecomendadaAplicacao(), getVacina());
    }
}
