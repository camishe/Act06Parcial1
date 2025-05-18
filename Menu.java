package com.mycompany.actmaria;
/**
 *
 * @author Mishelle Nuñez
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Producto> inventario = new ArrayList<>();
    private CSVManager csvManager = new CSVManager();

    public void mostrarMenuPrincipal() {
        char opc;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Guardar en CSV");
            System.out.println("4. Salir");
            System.out.println("Digite una opcion: ");
            opc = sc.nextLine().charAt(0);

            switch (opc) {
                case '1':
                    registrarProducto();
                    break;
                case '2':
                    listarProductos();
                    break;
                case '3':
                    csvManager.guardarEnCSV(inventario, "inventario.csv");
                    System.out.println("Datos guardados en CSV exitosamente.");
                    break;
                case '4':
                    System.out.println("Hasta pronto! Datos asegurados.");
                    break;
                default:
                    System.out.println("ERROR: Opcion invalida.");
            }
        } while (opc != '4');
    }

    private void registrarProducto() {
        try {
            System.out.println("\n--- REGISTRO DE PRODUCTO ---");
            
            // Capturar datos de categoría
            System.out.print("ID de categoria (Formato CAT-001): ");
            String idCategoria = sc.nextLine();
            
            System.out.print("Nombre de categoria: ");
            String nombreCategoria = sc.nextLine();
            Categoria categoria = new Categoria(idCategoria, nombreCategoria);

            // Capturar datos del producto
            System.out.print("Codigo del producto: ");
            int codigo = Integer.parseInt(sc.nextLine());
            
            System.out.print("Nombre del producto: ");
            String nombre = sc.nextLine();
            
            System.out.print("Precio del producto: ");
            double precio = Double.parseDouble(sc.nextLine());

            // Validar duplicados
            verificarDuplicados(codigo, idCategoria);

            // Crear y agregar producto
            Producto producto = new Producto(nombre, categoria, codigo, precio);
            inventario.add(producto);
            
            System.out.println("Producto registrado exitosamente!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese valores numericos validos.");
        } catch (DatosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DatosDuplicadosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listarProductos() {
        ArrayList<Producto> productos = csvManager.cargarDesdeCSV("inventario.csv");
        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos registrados.");
            return;
        }

        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        productos.forEach(Producto::mostrarResumen);
    }

    private void verificarDuplicados(int codigo, String idCategoria) throws DatosDuplicadosException {
        for (Producto p : inventario) {
            if (p.getCodigo() == codigo) {
                throw new DatosDuplicadosException("El codigo ya esta registrado!!!");
            }
            if (p.getCategoria().getId().equals(idCategoria)) {
                throw new DatosDuplicadosException("El ID de categoría ya existe!!!");
            }
        }
    }
}