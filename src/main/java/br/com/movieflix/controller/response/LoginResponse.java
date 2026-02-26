package br.com.movieflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta contendo o token JWT gerado após autenticação")
public record LoginResponse(

        @Schema(description = "Token JWT para autenticação nas demais requisições",
                example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
        String token
) {
}
