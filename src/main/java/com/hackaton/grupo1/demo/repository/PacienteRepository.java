package com.hackaton.grupo1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.grupo1.demo.entity.Paciente;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Boolean existsByCpf(String cpf);
    Boolean existsByNome(String nome);

    Optional<Paciente> findByCpf(String cpf);
    Optional<Paciente> findByNome(String nome);
}
