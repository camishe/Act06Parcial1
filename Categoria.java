
package com.mycompany.actmaria;
/**
 *
 * @author Mishelle Nuñez
 */

public class Categoria {
    private String id,NombreCategoria;

    public Categoria(String id, String NombreCategoria) {
        this.id = id;
        this.NombreCategoria = NombreCategoria;
    }

    // Getters
    public String getId() { return id; }
    public String getNombreCategoria() { return NombreCategoria; }

    // Setters con validaciones
       public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID de categoria no puede estar vacio");
        }
        this.id = id;
    }

    public void setNombreCategoria(String nombreCategoria) {
        if (nombreCategoria == null || nombreCategoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre de categoria no puede estar vacio");
        }
        this.NombreCategoria = nombreCategoria;
    }
}
