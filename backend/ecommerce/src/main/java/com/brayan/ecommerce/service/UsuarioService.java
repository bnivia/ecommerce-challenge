package com.brayan.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brayan.ecommerce.entity.Usuario;
import com.brayan.ecommerce.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Usuario actualizar(
        Long id,
        Usuario usuarioActualizado) {

    Usuario usuario = repository.findById(id)
            .orElseThrow();

    usuario.setNombre(
            usuarioActualizado.getNombre());

    usuario.setEmail(
            usuarioActualizado.getEmail());

    usuario.setPassword(
            usuarioActualizado.getPassword());

    usuario.setRol(
            usuarioActualizado.getRol());

    return repository.save(usuario);
    }

    public boolean login(
        String email,
        String password) {

    Optional<Usuario> usuario =
            repository.findByEmail(email);

    if (usuario.isPresent()) {

        return usuario.get().getPassword().equals(password);
    }

    return false;
}
public Usuario autenticar(
        String email,
        String password) {

    Optional<Usuario> usuario =
            repository.findByEmail(email);

    if (usuario.isPresent() &&
        usuario.get().getPassword().equals(password)) {

        return usuario.get();
    }

    return null;
}
}
