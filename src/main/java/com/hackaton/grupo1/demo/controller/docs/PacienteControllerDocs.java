package com.hackaton.grupo1.demo.controller.docs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.hackaton.grupo1.demo.dto.PacienteDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Pacientes", description = "Endpoints para gerenciar Pacientes")
public interface PacienteControllerDocs {

        @Operation(summary = "Consultar todos os pacientes",
                description = "Retorna todos os pacientes.",
                tags = "Pacientes",
                responses = {@ApiResponse(description = "Sucesso",
                        responseCode = "200", content = @Content(schema = @Schema(implementation = PacienteDTO.class))
                ),
                        @ApiResponse(description = "Sem conteúdo", responseCode = "204", content = @Content),
                        @ApiResponse(description = "Requisição inválida", responseCode = "400", content = @Content),
                        @ApiResponse(description = "Não autorizado", responseCode = "401", content = @Content),
                        @ApiResponse(description = "Não encontrado", responseCode = "404", content = @Content),
                        @ApiResponse(description = "Erro interno do servidor", responseCode = "500", content = @Content)
                }
        )
        ResponseEntity<List> listarPacientes();

        @Operation(summary = "Buscar um paciente",
                description = "Busca um paciente específico pelo seu id",
                tags = "Pacientes",
                responses = {@ApiResponse(description = "Sucesso",
                        responseCode = "200", content = @Content(schema = @Schema(implementation = PacienteDTO.class))
                ),
                        @ApiResponse(description = "Sem conteúdo", responseCode = "204", content = @Content),
                        @ApiResponse(description = "Requisição inválida", responseCode = "400", content = @Content),
                        @ApiResponse(description = "Não autorizado", responseCode = "401", content = @Content),
                        @ApiResponse(description = "Não encontrado", responseCode = "404", content = @Content),
                        @ApiResponse(description = "Erro interno do servidor", responseCode = "500", content = @Content)
                }
        )
        ResponseEntity<PacienteDTO> listarPacientesID(@PathVariable("id") Integer id);

        @Operation(summary = "Criar um paciente",
                description = "Cria um paciente",
                tags = "Pacientes",
                responses = {@ApiResponse(description = "Sucesso",
                        responseCode = "200", content = @Content(schema = @Schema(implementation = PacienteDTO.class))
                ),
                        @ApiResponse(description = "Sem conteúdo", responseCode = "204", content = @Content),
                        @ApiResponse(description = "Requisição inválida", responseCode = "400", content = @Content),
                        @ApiResponse(description = "Não autorizado", responseCode = "401", content = @Content),
                        @ApiResponse(description = "Não encontrado", responseCode = "404", content = @Content),
                        @ApiResponse(description = "Erro interno do servidor", responseCode = "500", content = @Content)
                }
        )
        PacienteDTO criarPaciente(@RequestBody PacienteDTO person);


        @Operation(summary = "Atualizar informações do paciente",
                description = "Atualiza um paciente específico pelo seu id",
                tags = "Pacientes",
                responses = {@ApiResponse(description = "Sucesso",
                        responseCode = "200", content = @Content(schema = @Schema(implementation = PacienteDTO.class))
                ),
                        @ApiResponse(description = "Sem conteúdo", responseCode = "204", content = @Content),
                        @ApiResponse(description = "Requisição inválida", responseCode = "400", content = @Content),
                        @ApiResponse(description = "Não autorizado", responseCode = "401", content = @Content),
                        @ApiResponse(description = "Não encontrado", responseCode = "404", content = @Content),
                        @ApiResponse(description = "Erro interno do servidor", responseCode = "500", content = @Content)
                }
        )
        PacienteDTO atualizarPaciente(@PathVariable Integer id, @RequestBody PacienteDTO person);

        @Operation(summary = "Deletar um paciente",
                description = "Deleta um paciente específico pelo seu id",
                tags = "Pacientes",
                responses = {
                        @ApiResponse(description = "Sem conteúdo", responseCode = "204", content = @Content),
                        @ApiResponse(description = "Requisição inválida", responseCode = "400", content = @Content),
                        @ApiResponse(description = "Não autorizado", responseCode = "401", content = @Content),
                        @ApiResponse(description = "Não encontrado", responseCode = "404", content = @Content),
                        @ApiResponse(description = "Erro interno do servidor", responseCode = "500", content = @Content)
                }
        )
        ResponseEntity<Void> deletarPaciente(@PathVariable("id") Integer id);
}
