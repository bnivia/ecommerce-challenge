package com.brayan.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.brayan.ecommerce.entity.DetalleOrden;
import com.brayan.ecommerce.service.DetalleOrdenService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detalle-orden")
public class DetalleOrdenController {

    @Autowired
    private DetalleOrdenService service;

    @GetMapping
    public List<DetalleOrden> listar() {
        return service.listar();
    }

    @GetMapping("/top-productos")
    public List<Object[]> topProductosVendidos() {
        return service.topProductosVendidos();
    }

    @GetMapping("/top-clientes")
    public List<Object[]> topClientesFrecuentes() {
        return service.topClientesFrecuentes();
    }

    @PostMapping
    public DetalleOrden guardar(
            @RequestBody DetalleOrden detalleOrden) {

        return service.guardar(detalleOrden);
    }
}
