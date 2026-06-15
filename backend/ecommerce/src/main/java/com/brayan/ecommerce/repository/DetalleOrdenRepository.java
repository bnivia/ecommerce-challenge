package com.brayan.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brayan.ecommerce.entity.DetalleOrden;

public interface DetalleOrdenRepository
        extends JpaRepository<DetalleOrden, Long> {
    @Query("""
            SELECT d.producto.nombre, SUM(d.cantidad)
            FROM DetalleOrden d
            GROUP BY d.producto.nombre
            ORDER BY SUM(d.cantidad) DESC
            """)
    List<Object[]> topProductosVendidos();
}