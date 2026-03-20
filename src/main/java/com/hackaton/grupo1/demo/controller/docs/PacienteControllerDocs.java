package com.hackaton.grupo1.demo.controller.docs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.hackaton.grupo1.demo.dto.PacienteDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface PacienteControllerDocs {
    @Operation(summary = "Finds a paciente",
            description = "Find a specific paciente by your id",
            tags = "Pacientes",
            responses = {@ApiResponse(description = "Success",
                    responseCode = "200", content = @Content(schema = @Schema(implementation = PacienteDTO.class))
            ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Resquest", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<PacienteDTO> listarPacientesID(@PathVariable("id") Integer id);

    @Operation(summary = "Create a Paciente",
            description = "Create a specific Paciente by your id",
            tags = "Pacientes",
            responses = {@ApiResponse(description = "Success",
                    responseCode = "200", content = @Content(schema = @Schema(implementation = PacienteDTO.class))
            ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Resquest", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    PacienteDTO criarPaciente(@RequestBody PacienteDTO person);


    @Operation(summary = "Update a Paciente information",
            description = "Update a specific Paciente by your id",
            tags = "Pacientes",
            responses = {@ApiResponse(description = "Success",
                    responseCode = "200", content = @Content(schema = @Schema(implementation = PacienteDTO.class))
            ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Resquest", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    PacienteDTO atualizarPaciente(@PathVariable Integer id, @RequestBody PacienteDTO person);

    @Operation(summary = "Delete a Paciente",
            description = "Delete a specific Paciente by your id",
            tags = "Pacientes",
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Resquest", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<?> apagarPacienteID(@PathVariable("id") Integer id);
}
