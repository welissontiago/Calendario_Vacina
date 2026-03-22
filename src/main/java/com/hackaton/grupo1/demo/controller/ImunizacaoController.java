package com.hackaton.grupo1.demo.controller;

import com.hackaton.grupo1.demo.controller.docs.ImunizacaoControllerDocs;
import com.hackaton.grupo1.demo.dto.ImunizacaoDTO;
import com.hackaton.grupo1.demo.entity.Imunizacao;
import com.hackaton.grupo1.demo.exceptions.ResourceNotFoundException;
import com.hackaton.grupo1.demo.service.ImunizacaoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/imunizacao")
public class ImunizacaoController implements ImunizacaoControllerDocs {

    private final ImunizacaoService service;

    public ImunizacaoController(ImunizacaoService service) {
        this.service = service;
    }

    @PostMapping("/inserir")
    public ResponseEntity<ImunizacaoDTO> inserir(@RequestBody ImunizacaoDTO dto) {
        Imunizacao salva = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterar(@PathVariable Integer id, @RequestBody ImunizacaoDTO dto) {
        service.alterar(id, dto);
        return ResponseEntity.ok("Imunização alterada com sucesso.");
    }

    @DeleteMapping("/excluir/{id_imunizacao}")
    public ResponseEntity<String> excluir(@PathVariable("id_imunizacao") Integer id) {
        service.excluir(id);
        return ResponseEntity.ok("Imunização excluída com sucesso.");
    }

    @DeleteMapping("/excluir/paciente/{id_paciente}")
    public ResponseEntity<String> excluirPorPaciente(@PathVariable("id_paciente") Integer id) {
        service.excluirPorPaciente(id);
        return ResponseEntity.ok("Todas as imunizações do paciente foram excluídas.");
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<ImunizacaoDTO>> consultarTodas() {
        List<ImunizacaoDTO> dtos = service.consultarTodas().stream()
                .map(this::mapToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<ImunizacaoDTO> consultarPorId(@PathVariable Integer id) {
        return service.consultarPorId(id)
                .map(imun -> ResponseEntity.ok(mapToDTO(imun)))
                .orElseThrow(() -> new ResourceNotFoundException("Imunização não encontrada com ID: " + id));
    }

    @GetMapping("/consultar/paciente/{id}")
    public ResponseEntity<List<ImunizacaoDTO>> consultarPorPaciente(@PathVariable Integer id) {
        List<ImunizacaoDTO> dtos = service.consultarPorPaciente(id).stream()
                .map(this::mapToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/consultar/paciente/{id}/aplicacao/{dt_ini}/{dt_fim}")
    public ResponseEntity<List<ImunizacaoDTO>> consultarPorPacienteEPeriodo(
            @PathVariable Integer id,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dt_ini,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dt_fim) {

        List<ImunizacaoDTO> dtos = service.consultarPorPacienteEPeriodo(id, dt_ini, dt_fim).stream()
                .map(this::mapToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    private ImunizacaoDTO mapToDTO(Imunizacao i) {
        ImunizacaoDTO dto = new ImunizacaoDTO();
        dto.setId(i.getId());
        dto.setDataAplicacao(i.getDataAplicacao());
        dto.setFabricante(i.getFabricante());
        dto.setLote(i.getLote());
        dto.setLocalAplicacao(i.getLocalAplicacao());
        dto.setProfissionalAplicador(i.getProfissionalAplicador());
        dto.setIdPaciente(i.getPaciente().getId());
        dto.setIdDose(i.getDose().getId());
        return dto;
    }
}