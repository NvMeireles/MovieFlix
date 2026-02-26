package br.com.movieflix.controller;

import br.com.movieflix.controller.request.MovieRequest;
import br.com.movieflix.controller.response.MovieResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Movie", description = "Recurso responsável pelo gerenciamento dos filmes.")
@SecurityRequirement(name = "bearerAuth")
public interface MovieController {

    @Operation(summary = "Cadastrar filme",
            description = "Realiza o cadastro de um novo filme.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filme cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    ResponseEntity<MovieResponse> save(
            @Valid @RequestBody MovieRequest request
    );

    @Operation(summary = "Listar todos os filmes",
            description = "Retorna uma lista com todos os filmes cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @GetMapping
    ResponseEntity<List<MovieResponse>> findAll();

    @Operation(summary = "Buscar filme por ID",
            description = "Retorna um filme específico a partir do seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filme encontrado"),
            @ApiResponse(responseCode = "404", description = "Filme não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<MovieResponse> findById(
            @Parameter(description = "ID do filme", example = "1")
            @PathVariable Long id
    );

    @Operation(summary = "Atualizar filme",
            description = "Atualiza os dados de um filme existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filme atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Filme não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<MovieResponse> update(
            @Parameter(description = "ID do filme", example = "1")
            @PathVariable Long id,
            @Valid @RequestBody MovieRequest request
    );

    @Operation(summary = "Buscar filmes por categoria",
            description = "Retorna todos os filmes associados a uma categoria específica.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @GetMapping("/search")
    ResponseEntity<List<MovieResponse>> findByCategory(
            @Parameter(description = "ID da categoria", example = "2")
            @RequestParam Long category
    );

    @Operation(summary = "Remover filme",
            description = "Remove um filme pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Filme removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Filme não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(
            @Parameter(description = "ID do filme", example = "1")
            @PathVariable Long id
    );
}