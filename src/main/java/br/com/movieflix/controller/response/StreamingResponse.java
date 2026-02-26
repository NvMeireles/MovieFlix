package br.com.movieflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "Objeto de resposta que representa um serviço de streaming")
public record StreamingResponse(

        @Schema(description = "Código do serviço de streaming", example = "1")
        Long id,

        @Schema(description = "Nome do serviço de streaming", example = "Netflix")
        String name
) {
}
