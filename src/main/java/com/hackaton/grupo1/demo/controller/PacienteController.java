package com.hackaton.grupo1.demo.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.grupo1.demo.controller.docs.PacienteControllerDocs;
import com.hackaton.grupo1.demo.dto.PacienteDTO;
import com.hackaton.grupo1.demo.exceptions.BadRequestException;
import com.hackaton.grupo1.demo.exceptions.ResourceNotFoundException;
import com.hackaton.grupo1.demo.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController implements PacienteControllerDocs{
    
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/consultar")
    public ResponseEntity<List> listarPacientes(){
        List<PacienteDTO> ninjas = pacienteService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(ninjas);
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<PacienteDTO> listarPacientesID(@PathVariable Integer id){
        PacienteDTO paciente = pacienteService.findById(id);
        return ResponseEntity.ok(paciente);
    }

    @PostMapping("/inserir")
    public PacienteDTO criarPaciente(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.criarPaciente(pacienteDTO);
    }

    @PutMapping("/alterar/{id}")
    public PacienteDTO atualizarPaciente(@PathVariable Integer id, @RequestBody PacienteDTO pacienteDTO){
        return pacienteService.atualizarPaciente(id, pacienteDTO);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable("id") Integer id) {

    if (pacienteService.findById(id) == null) {
        throw new ResourceNotFoundException("Paciente não encontrado com o ID: " + id);
    }

    pacienteService.deletar(id);
    return ResponseEntity.noContent().build(); // 204
    }
    
}
