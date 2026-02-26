package br.com.movieflix.controller;

import br.com.movieflix.controller.request.StreamingRequest;
import br.com.movieflix.controller.response.StreamingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Streaming", description = "Recurso responsável pelo gerenciamento dos serviços de streaming.")
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/movieflix/streaming")
public interface StreamingController {

    @Operation(summary = "Listar todos os serviços de streaming",
            description = "Retorna todos os serviços de streaming cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @GetMapping
    ResponseEntity<List<StreamingResponse>> getAllStreamings();


    @Operation(summary = "Cadastrar serviço de streaming",
            description = "Realiza o cadastro de um novo serviço de streaming.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Serviço cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    ResponseEntity<StreamingResponse> save(
            @Valid @RequestBody StreamingRequest request
    );


    @Operation(summary = "Buscar serviço de streaming por ID",
            description = "Retorna um serviço específico pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço encontrado"),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<StreamingResponse> getById(
            @Parameter(description = "ID do serviço de streaming", example = "1")
            @PathVariable Long id
    );


    @Operation(summary = "Remover serviço de streaming",
            description = "Remove um serviço de streaming pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Serviço removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(
            @Parameter(description = "ID do serviço de streaming", example = "1")
            @PathVariable Long id
    );
}