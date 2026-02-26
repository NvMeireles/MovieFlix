package br.com.movieflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "Objeto de resposta que representa uma categoria de filme")
public record CategoryResponse(

        @Schema(description = "Código da categoria", example = "1")
        Long id,

        @Schema(description = "Nome da categoria", example = "Ação")
        String name
) {
}
