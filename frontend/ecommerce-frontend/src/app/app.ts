import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ecommerce-frontend');

  correo: string = '';
  password: string = '';
  usuario: any = null;
  productos: any[] = [];
  topProductos: any[] = [];
  topClientes: any[] = [];
  textoBusqueda: string = '';

  constructor(private http: HttpClient) {
  }

  ingresar() {

    const datosLogin = {
      email: this.correo,
      password: this.password
    };

    this.http.post(
      'http://localhost:8080/auth/login',
      datosLogin
    ).subscribe(response => {

      console.log(response);

      this.usuario = response;

      // Cargar productos
      this.http.get<any[]>(
        'http://localhost:8080/productos'
      ).subscribe(productos => {

        this.productos = productos;

      });

      // Cargar top productos
      this.http.get<any[]>(
        'http://localhost:8080/detalle-orden/top-productos'
      ).subscribe(data => {

        console.log('Top productos:', data);

        this.topProductos = data;

      });

      // Cargar top clientes
      this.http.get<any[]>(
        'http://localhost:8080/detalle-orden/top-clientes'
      ).subscribe(data => {

        console.log('Top clientes:', data);

        this.topClientes = data;

      });

    });

  }

  cerrarSesion() {

    this.usuario = null;

    this.correo = '';

    this.password = '';

    this.productos = [];

    this.topProductos = [];

    this.topClientes = [];

    this.textoBusqueda = '';

  }

  filtrarProductos() {

    const texto = this.textoBusqueda.toLowerCase();

    return this.productos.filter(producto =>

      producto.nombre?.toLowerCase().includes(texto) ||

      producto.descripcion?.toLowerCase().includes(texto) ||

      String(producto.precio).includes(texto) ||

      String(producto.activo).toLowerCase().includes(texto)

    );

  }

}
