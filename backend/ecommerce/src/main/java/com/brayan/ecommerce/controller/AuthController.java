package com.brayan.ecommerce.controller;

import org.springframework.web.bind.annotation.*;

import com.brayan.ecommerce.entity.LoginRequest;
import com.brayan.ecommerce.service.UsuarioService;
import com.brayan.ecommerce.entity.Usuario;
import com.brayan.ecommerce.entity.LoginResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService service;

    public AuthController(UsuarioService service) {
        this.service = service;
    }

@PostMapping("/login")
public LoginResponse login(
        @RequestBody LoginRequest request) {

    Usuario usuario =
            service.autenticar(request.getEmail(), request.getPassword());

    if (usuario != null) {

        return new LoginResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getRol(),
                "Login exitoso");
    }

    return new LoginResponse(
            null,
            null,
            null,
            null,
            "Correo o contraseña incorrectos");
}
}
