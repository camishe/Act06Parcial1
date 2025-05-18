
package com.mycompany.actmaria;
/**
 *
 * @author Mishelle Nuñez
 */
public class Producto {
    private String nombre;
    private Categoria categoria;
    private int codigo;
    private double precio;

    public Producto(String nombre, Categoria categoria, int codigo, double precio) {
        setNombre(nombre);
        setCategoria(categoria);
        setCodigo(codigo);
        setPrecio(precio);
    }

    // Getters
    public String getNombre() { return nombre; }
    public Categoria getCategoria() { return categoria; }
    public int getCodigo() { return codigo; }
    public double getPrecio() { return precio; }

    // Setters con validaciones
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre del producto no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public void setCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("La categoria no puede ser nula");
        }
        this.categoria = categoria;
    }

    public void setCodigo(int codigo) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("El codigo debe ser mayor a cero");
        }
        this.codigo = codigo;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero");
        }
        this.precio = precio;
    }

    public void mostrarResumen() {
        System.out.println("\n--- RESUMEN PRODUCTO ---");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Categoria: " + categoria.getNombreCategoria());
        System.out.println("ID Categoría: " + categoria.getId());
    }
}