package com.brayan.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brayan.ecommerce.entity.Producto;
import com.brayan.ecommerce.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Optional<Producto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Producto actualizar(
            Long id,
            Producto productoActualizado) {

        Producto producto = repository.findById(id)
                .orElseThrow();

        producto.setNombre(
                productoActualizado.getNombre());

        producto.setDescripcion(
                productoActualizado.getDescripcion());

        producto.setPrecio(
                productoActualizado.getPrecio());

        producto.setActivo(
                productoActualizado.getActivo());

        return repository.save(producto);
    }

    public List<Producto> listarActivos() {
        return repository.findByActivoTrue();
    }
}