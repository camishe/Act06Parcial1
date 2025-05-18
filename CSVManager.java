package com.mycompany.actmaria;
/**
 *
 * @author Mishelle Nuñez
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Personal
 */
public class CSVManager {
    
    public void guardarEnCSV(ArrayList<Producto> inventario, String nombreArchivo) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo, true))) {
        if(new File(nombreArchivo).length() == 0){
            writer.println("Codigo,Nombre,Precio,ID_Categoria,Categoria");
        }
        
        for(Producto p : inventario){
            writer.println(
                p.getCodigo() + "," +
                "\"" + p.getNombre().replace("\"", "\"\"") + "\"," +
                p.getPrecio() + "," +
                p.getCategoria().getId() + "," +
                p.getCategoria().getNombreCategoria()
            );
        }
    } catch (IOException e) {
        System.out.println("Error critico: " + e.getMessage());
    }
}
    
 public ArrayList<Producto> cargarDesdeCSV(String nombreArchivo) {
    ArrayList<Producto> inventario = new ArrayList<>();
    
    try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        boolean primeraLinea = true;
        
        while ((linea = br.readLine()) != null) {
            if (primeraLinea) {
                primeraLinea = false;
                continue; // Saltar encabezado
            }
            
            String[] datos = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            
            if (datos.length == 5) {
                int codigo = Integer.parseInt(datos[0]);
                String nombre = datos[1].replaceAll("^\"|\"$", "");
                double precio = Double.parseDouble(datos[2]);
                String idCategoria = datos[3];
                String nombreCategoria = datos[4];
                
                Categoria categoria = new Categoria(idCategoria, nombreCategoria);
                inventario.add(new Producto(nombre, categoria, codigo, precio));
            }
        }
    } catch (IOException | NumberFormatException e) {
        System.out.println("Error leyendo CSV: " + e.getMessage());
    }
    
    return inventario;
}
    
}
