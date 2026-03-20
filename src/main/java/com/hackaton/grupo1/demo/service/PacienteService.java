package com.hackaton.grupo1.demo.service;

import java.util.List;
import java.util.stream.Collectors;

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
        if(pacienteDTO.getCpf() != null && repository.existsByCpf(pacienteDTO.getCpf())){
            throw new RuntimeException("cpf já cadastrado");
        }
        Paciente paciente = toEntity(pacienteDTO);
        return toDTO(repository.save(paciente));
    }

    public PacienteDTO atualizarPaciente(int id, PacienteDTO pacienteDTO){
    
        Paciente paciente = repository.findById(id).orElseThrow(()
            -> new ResourceNotFoundException("paciente não encontrado")
        );
        paciente.setNome(pacienteDTO.getNome());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setSexo(pacienteDTO.getSexo());
        paciente.setData_nascimento(pacienteDTO.getData_nascimento());
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