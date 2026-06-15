package com.brayan.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brayan.ecommerce.entity.Inventario;
import com.brayan.ecommerce.repository.InventarioRepository;

@Service
public class InventarioService {

    private final InventarioRepository repository;

    public InventarioService(
            InventarioRepository repository) {

        this.repository = repository;
    }

    public Inventario guardar(
            Inventario inventario) {

        return repository.save(inventario);
    }

    public List<Inventario> listar() {
        return repository.findAll();
    }

    public Optional<Inventario> buscarPorId(
            Long id) {

        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Inventario actualizar(
            Long id,
            Inventario inventarioActualizado) {

        Inventario inventario =
                repository.findById(id)
                .orElseThrow();

        inventario.setStock(
                inventarioActualizado.getStock());

        inventario.setProducto(
                inventarioActualizado.getProducto());

        return repository.save(inventario);
    }
}