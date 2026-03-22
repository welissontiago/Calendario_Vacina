package com.hackaton.grupo1.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hackaton.grupo1.demo.exceptions.BadRequestException;
import com.hackaton.grupo1.demo.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.grupo1.demo.dto.PacienteDTO;
import com.hackaton.grupo1.demo.entity.Paciente;

import com.hackaton.grupo1.demo.repository.PacienteRepository;
import java.lang.RuntimeException;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<PacienteDTO> listar(){
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PacienteDTO findById(Integer id){
        Paciente paciente = repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Paciente não encontrado com o ID: " + id)
        );
        return toDTO(paciente);
    }

    public PacienteDTO criarPaciente(PacienteDTO pacienteDTO){
        // Valida se a data de nascimento está no futuro
        if (pacienteDTO.getData_nascimento() != null && pacienteDTO.getData_nascimento().isAfter(LocalDate.now())) {
            throw new BadRequestException("A data de nascimento não pode ser no futuro.");
        }

        if(pacienteDTO.getCpf() != null && repository.existsByCpf(pacienteDTO.getCpf())){
            // Substituímos o RuntimeException genérico por BadRequestException
            throw new BadRequestException("CPF já cadastrado.");
        }

        Paciente paciente = toEntity(pacienteDTO);
        return toDTO(repository.save(paciente));
    }

    public PacienteDTO atualizarPaciente(int id, PacienteDTO pacienteDTO){
        Paciente paciente = repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Paciente não encontrado")
        );

        if (pacienteDTO.getData_nascimento() != null &&
                pacienteDTO.getData_nascimento().isAfter(LocalDate.now())) {
            throw new BadRequestException("A data de nascimento não pode ser no futuro.");
        }

        if (pacienteDTO.getCpf() != null) {
            throw new BadRequestException("O CPF não pode ser alterado.");
        }


        if (pacienteDTO.getNome() != null) {
            paciente.setNome(pacienteDTO.getNome());
        }

        if (pacienteDTO.getCpf() != null) {
            paciente.setCpf(pacienteDTO.getCpf());
        }

        if (pacienteDTO.getSexo() != null) {
            paciente.setSexo(pacienteDTO.getSexo());
        }

        if (pacienteDTO.getData_nascimento() != null) {
            paciente.setData_nascimento(pacienteDTO.getData_nascimento());
        }

        return toDTO(repository.save(paciente));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    private PacienteDTO toDTO(Paciente paciente) {
        return new PacienteDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getSexo(),
                paciente.getData_nascimento()
        );
    }

    private Paciente toEntity(PacienteDTO dto) {
        return new Paciente(
                dto.getNome(),
                dto.getCpf(),
                dto.getSexo(),
                dto.getData_nascimento()
        );
    }

}