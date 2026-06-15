package com.brayan.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brayan.ecommerce.entity.Inventario;

public interface InventarioRepository
        extends JpaRepository<Inventario, Long> {

}
