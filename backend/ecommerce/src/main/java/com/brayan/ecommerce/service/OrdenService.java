package com.brayan.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brayan.ecommerce.entity.Orden;
import com.brayan.ecommerce.repository.OrdenRepository;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> listar() {
        return ordenRepository.findAll();
    }

    public Orden guardar(Orden orden) {
        return ordenRepository.save(orden);
    }
}