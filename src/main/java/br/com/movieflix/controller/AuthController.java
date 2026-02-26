package br.com.movieflix.controller;

import br.com.movieflix.controller.request.LoginRequest;
import br.com.movieflix.controller.request.UserRequest;
import br.com.movieflix.controller.response.LoginResponse;
import br.com.movieflix.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth", description = "Recurso responsável pela autenticação e registro de usuários.")
@RequestMapping("/movieflix/auth")
public interface AuthController {

    @Operation(summary = "Registrar novo usuário",
            description = "Realiza o cadastro de um novo usuário no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping("/register")
    ResponseEntity<UserResponse> register(
            @Valid @RequestBody UserRequest request
    );


    @Operation(summary = "Autenticar usuário",
            description = "Realiza autenticação e retorna um token JWT válido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autenticação realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Usuário ou senha inválidos")
    })
    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    );
}
