package negocio;

import modelo.Producto;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void registrar(Producto producto) {
        if (buscar(producto.getCodigo()) != null) {
            throw new IllegalArgumentException("El codigo ya existe.");
        }

        if (productos.size() >= 50) {
            throw new IllegalArgumentException("Inventario lleno.");
        }

        productos.add(producto);
    }

    public Producto buscar(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Producto> listar() {
        return new ArrayList<>(productos);
    }

    public void actualizar(String codigo, int cantidad) {
        Producto p = buscar(codigo);

        if (p == null) {
            throw new IllegalArgumentException("Producto no encontrado.");
        }

        p.setCantidad(cantidad);
    }

    public void eliminar(String codigo) {
        Producto p = buscar(codigo);

        if (p == null) {
            throw new IllegalArgumentException("Producto no encontrado.");
        }

        productos.remove(p);
    }

    public double calcularTotal() {
        double total = 0;

        for (Producto p : productos) {
            total += p.calcularValor();
        }

        return total;
    }
}
