package br.com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Objeto de requisição para autenticação do usuário")
public record LoginRequest(

        @Schema(description = "Email do usuário cadastrado",
                example = "usuario@email.com")
        @NotBlank
        String email,

        @Schema(description = "Senha do usuário",
                example = "123456")
        @NotBlank
        String password
) {
}
