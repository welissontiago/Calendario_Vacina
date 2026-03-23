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
import com.hackaton.grupo1.demo.enums.Sexo;
import com.hackaton.grupo1.demo.repository.PacienteRepository;
import java.lang.RuntimeException;
import com.hackaton.grupo1.demo.validation.utils.CpfValidator;

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
        
        if (pacienteDTO.getData_nascimento() != null && pacienteDTO.getData_nascimento().isAfter(LocalDate.now())) {
            throw new BadRequestException("A data de nascimento não pode ser no futuro.");
        }

        if(CpfValidator.ValidarCpf(pacienteDTO.getCpf()) == false){
            throw new BadRequestException("CPF inválido.");
        }

        if(repository.existsByCpf(pacienteDTO.getCpf())){
            throw new BadRequestException("CPF já cadastrado.");
        }

        if(pacienteDTO.getNome().length() > 60 || repository.existsByNome(pacienteDTO.getNome())){
            throw new BadRequestException("O nome não pode ter mais de 60 caracteres e não pode repetir.");
        }

        Paciente paciente = toEntity(pacienteDTO);
        return toDTO(repository.save(paciente));
    }

    public PacienteDTO atualizarPaciente(int id, PacienteDTO pacienteDTO){
        Paciente paciente = repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Paciente não encontrado")
        );

        if (pacienteDTO.getNome() != null) {
            if(pacienteDTO.getNome().length() > 60 || (repository.existsByNome(pacienteDTO.getNome()) && !paciente.getNome().equals(pacienteDTO.getNome()))){
                throw new BadRequestException("O nome não pode ter mais de 60 caracteres ou já existir com outra usuário.");
            }
            paciente.setNome(pacienteDTO.getNome());
        }

        if (pacienteDTO.getSexo() != null) {
            paciente.setSexo(pacienteDTO.getSexo());
        }

        if (pacienteDTO.getData_nascimento() != null) {
            if(pacienteDTO.getData_nascimento().isAfter(LocalDate.now())){
                throw new BadRequestException("A data de nascimento não pode ser no futuro.");
            }
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