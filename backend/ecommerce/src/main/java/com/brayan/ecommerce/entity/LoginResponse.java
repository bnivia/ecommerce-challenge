package com.brayan.ecommerce.entity;

public class LoginResponse {
    private Long id;
    private String nombre;
    private String email;
    private String rol;
    private String mensaje;

    public LoginResponse() {
    }

    public LoginResponse(Long id, String nombre,
                         String email, String rol,
                         String mensaje) {

        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }

    public String getMensaje() {
        return mensaje;
    }
}
