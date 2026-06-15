package com.brayan.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.brayan.ecommerce.entity.Inventario;
import com.brayan.ecommerce.service.InventarioService;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {

    private final InventarioService service;

    public InventarioController(
            InventarioService service) {

        this.service = service;
    }

    @GetMapping
    public List<Inventario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Inventario> buscarPorId(
            @PathVariable Long id) {

        return service.buscarPorId(id);
    }

    @PostMapping
    public Inventario guardar(
            @RequestBody Inventario inventario) {

        return service.guardar(inventario);
    }

    @PutMapping("/{id}")
    public Inventario actualizar(
            @PathVariable Long id,
            @RequestBody Inventario inventario) {

        return service.actualizar(
                id,
                inventario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id) {

        service.eliminar(id);
    }
}
