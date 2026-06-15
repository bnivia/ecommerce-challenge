package com.brayan.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.brayan.ecommerce.entity.Orden;
import com.brayan.ecommerce.service.OrdenService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<Orden> listar() {
        return ordenService.listar();
    }

    @PostMapping
    public Orden guardar(@RequestBody Orden orden) {
        return ordenService.guardar(orden);
    }
}
