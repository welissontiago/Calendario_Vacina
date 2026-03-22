package com.hackaton.grupo1.demo.controller.docs;

import com.hackaton.grupo1.demo.dto.ImunizacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.util.List;

@Tag(name = "Imunizações", description = "Gerenciamento de aplicações de vacinas")
public interface ImunizacaoControllerDocs {

    @Operation(summary = "Adicionar imunização", responses = {
            @ApiResponse(responseCode = "201", description = "Imunização cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<ImunizacaoDTO> inserir(ImunizacaoDTO dto);

    @Operation(summary = "Alterar imunização", responses = {
            @ApiResponse(responseCode = "200", description = "Alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Imunização não encontrada")
    })
    ResponseEntity<String> alterar(Integer id, ImunizacaoDTO dto);

    @Operation(summary = "Excluir imunização", responses = {
            @ApiResponse(responseCode = "200", description = "Excluído com sucesso")
    })
    ResponseEntity<String> excluir(Integer id);

    @Operation(summary = "Excluir todas as imunizações de um paciente")
    ResponseEntity<String> excluirPorPaciente(Integer idPaciente);

    @Operation(summary = "Consultar todas as imunizações")
    ResponseEntity<List<ImunizacaoDTO>> consultarTodas();

    @Operation(summary = "Consultar por ID")
    ResponseEntity<ImunizacaoDTO> consultarPorId(Integer id);

    @Operation(summary = "Consultar por Paciente")
    ResponseEntity<List<ImunizacaoDTO>> consultarPorPaciente(Integer idPaciente);

    @Operation(summary = "Consultar por Paciente e Período")
    ResponseEntity<List<ImunizacaoDTO>> consultarPorPacienteEPeriodo(Integer id, LocalDate inicio, LocalDate fim);
}