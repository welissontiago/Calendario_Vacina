package com.hackaton.grupo1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hackaton.grupo1.demo.entity.Imunizacao;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ImunizacaoRepository extends JpaRepository<Imunizacao, Integer> {

    List<Imunizacao> findByPaciente_Id(Integer idPaciente);

    List<Imunizacao> findByPaciente_IdAndDataAplicacaoBetween(
            Integer idPaciente, LocalDate dataInicio, LocalDate dataFim);

    void deleteByPaciente_Id(Integer idPaciente);

    long countByPaciente_Id(Integer idPaciente);

    long countByPacienteId(Integer idPaciente);

    boolean existsByPaciente_IdAndDose_Id(Integer idPaciente, Integer idDose);

}