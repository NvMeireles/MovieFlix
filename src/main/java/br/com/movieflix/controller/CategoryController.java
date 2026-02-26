package br.com.movieflix.controller;

import br.com.movieflix.controller.request.CategoryRequest;
import br.com.movieflix.controller.response.CategoryResponse;
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

@Tag(name = "Category", description = "Recurso responsável pelo gerenciamento das categorias de filmes.")
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/movieflix/category")
public interface CategoryController {

    @Operation(summary = "Listar todas as categorias",
            description = "Retorna todas as categorias cadastradas no sistema.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @GetMapping
    ResponseEntity<List<CategoryResponse>> getAllCategories();


    @Operation(summary = "Cadastrar nova categoria",
            description = "Realiza o cadastro de uma nova categoria.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    ResponseEntity<CategoryResponse> saveCategory(
            @Valid @RequestBody CategoryRequest request
    );


    @Operation(summary = "Buscar categoria por ID",
            description = "Retorna uma categoria específica pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria encontrada"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    @GetMapping("/{id}")
    ResponseEntity<CategoryResponse> getByCategoryId(
            @Parameter(description = "ID da categoria", example = "1")
            @PathVariable Long id
    );


    @Operation(summary = "Remover categoria",
            description = "Remove uma categoria pelo ID informado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categoria removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCategoryById(
            @Parameter(description = "ID da categoria", example = "1")
            @PathVariable Long id
    );
}
