package com.hackaton.grupo1.demo.repository;

import com.hackaton.grupo1.demo.enums.PublicoAlvo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.hackaton.grupo1.demo.entity.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Integer> {

    List<Vacina> findByPublicoAlvo(PublicoAlvo publicoAlvo);

    @Query("SELECT v FROM Vacina v WHERE v.limiteAplicacao > :meses OR v.limiteAplicacao IS NULL")
    List<Vacina> findVacinasAcimaIdadeOuSemLimite(@Param("meses") int meses);

    // Nova query para contar os maiores que 'meses' E as vacinas sem limite (nulas)
    @Query("SELECT COUNT(v) FROM Vacina v WHERE v.limiteAplicacao > :meses OR v.limiteAplicacao IS NULL")
    long countVacinasAcimaIdadeOuSemLimite(@Param("meses") int meses);

    @Query("SELECT v FROM Vacina v WHERE v.id NOT IN " +
            "(SELECT i.dose.vacina.id FROM Imunizacao i WHERE i.paciente.id = :idPaciente)")
    List<Vacina> findVacinasNaoAplicadas(Integer idPaciente);
}