package com.brayan.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.brayan.ecommerce.entity.Producto;

public interface ProductoRepository
                extends JpaRepository<Producto, Long> {
        List<Producto> findByActivoTrue();
}