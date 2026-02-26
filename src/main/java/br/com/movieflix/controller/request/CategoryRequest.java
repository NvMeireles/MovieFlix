package br.com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "Objeto de requisição para cadastro de categoria")
public record CategoryRequest(

        @Schema(description = "Nome da categoria", example = "Comédia")
        @NotEmpty(message = "Nome da categoria é obrigatório.")
        String name
) {
}
