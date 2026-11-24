package interfaz;

import modelo.*;
import negocio.Inventario;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Inventario inventario = new Inventario();

    public static void main(String[] args) {
        String opcion;

        do {
            System.out.println("\n--- SISTEMA DE INVENTARIO ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Buscar producto");
            System.out.println("4. Actualizar cantidad");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Valor total del inventario");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextLine();

            try {
                switch (opcion) {
                    case "1":
                        registrar();
                        break;

                    case "2":
                        if (inventario.listar().isEmpty()) {
                            System.out.println("Inventario vacio.");
                        }

                        for (Producto p : inventario.listar()) {
                            System.out.println(p);
                        }
                        break;

                    case "3":
                        Producto p = inventario.buscar(leer("codigo"));

                        if (p != null) {
                            System.out.println(p);
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                        break;

                    case "4":
                        String codigo = leer("codigo");
                        int cantidad = Integer.parseInt(leer("cantidad"));
                        inventario.actualizar(codigo, cantidad);
                        System.out.println("Cantidad actualizada.");
                        break;

                    case "5":
                        inventario.eliminar(leer("codigo"));
                        System.out.println("Producto eliminado.");
                        break;

                    case "6":
                        System.out.printf(java.util.Locale.US, "Valor total: $%.2f%n",
                                inventario.calcularTotal());
                        break;

                    case "0":
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no valida.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (!opcion.equals("0"));

        sc.close();
    }

    public static String leer(String campo) {
        System.out.print("Ingrese " + campo + ": ");
        String dato = sc.nextLine().trim();

        if (dato.isEmpty()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio.");
        }

        return dato;
    }

    public static void registrar() {
        System.out.println("1. Perecedero");
        System.out.println("2. No perecedero");

        String tipo = leer("tipo");

        if (!tipo.equals("1") && !tipo.equals("2")) {
            System.out.println("Tipo no valido.");
            return;
        }

        String codigo = leer("codigo");
        String nombre = leer("nombre");
        int cantidad = Integer.parseInt(leer("cantidad"));
        double precio = Double.parseDouble(
                leer("precio").replace(",", "."));

        Producto p;

        if (tipo.equals("1")) {
            LocalDate fecha = LocalDate.parse(
                    leer("fecha de caducidad (AAAA-MM-DD)"));

            p = new ProductoPerecedero(
                    codigo, nombre, cantidad, precio, fecha);
        } else {
            String categoria = leer("categoria");

            p = new ProductoNoPerecedero(
                    codigo, nombre, cantidad, precio, categoria);
        }

        inventario.registrar(p);
        System.out.println("Producto registrado.");
    }
}
