package br.com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
@Schema(description = "Objeto de requisição para cadastro de serviço de streaming")
public record StreamingRequest(

        @Schema(description = "Nome do serviço de streaming", example = "Amazon Prime Video")
        @NotEmpty(message = "Nome do serviço de streaming é obrigatório.")
        String name
) {
}
