package com.brayan.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.brayan.ecommerce.entity.Producto;
import com.brayan.ecommerce.repository.ProductoRepository;
import com.brayan.ecommerce.service.ProductoService;

public class ProductoServiceTest {

    @Test
    void debeListarProductos() {

        ProductoRepository repository = Mockito.mock(ProductoRepository.class);

        ProductoService service = new ProductoService(repository);

        Producto producto = new Producto();
        producto.setNombre("Portátil Lenovo");

        when(repository.findAll())
                .thenReturn(List.of(producto));

        List<Producto> productos = service.listar();

        assertEquals(1, productos.size());
        assertEquals(
                "Portátil Lenovo",
                productos.get(0).getNombre());
    }
}