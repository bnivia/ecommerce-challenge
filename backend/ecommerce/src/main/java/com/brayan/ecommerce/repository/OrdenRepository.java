package com.brayan.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brayan.ecommerce.entity.Orden;

public interface OrdenRepository
        extends JpaRepository<Orden, Long> {

    @Query("""
            SELECT o.usuario.nombre, COUNT(o.id)
            FROM Orden o
            GROUP BY o.usuario.nombre
            ORDER BY COUNT(o.id) DESC
            """)
    List<Object[]> topClientesFrecuentes();

}