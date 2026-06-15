package com.brayan.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brayan.ecommerce.entity.DetalleOrden;
import com.brayan.ecommerce.repository.DetalleOrdenRepository;
import com.brayan.ecommerce.repository.OrdenRepository;

@Service
public class DetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository repository;
    @Autowired
    private OrdenRepository ordenRepository;

    public List<DetalleOrden> listar() {
        return repository.findAll();
    }

    public DetalleOrden guardar(
            DetalleOrden detalleOrden) {

        return repository.save(detalleOrden);
    }

    public List<Object[]> topProductosVendidos() {
        return repository.topProductosVendidos();
    }

    public List<Object[]> topClientesFrecuentes() {
        return ordenRepository.topClientesFrecuentes();
    }
}