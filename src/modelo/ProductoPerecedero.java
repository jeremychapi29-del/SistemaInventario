package modelo;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto {
    private LocalDate fechaCaducidad;

    public ProductoPerecedero(String codigo, String nombre,
                             int cantidad, double precio,
                             LocalDate fechaCaducidad) {
        super(codigo, nombre, cantidad, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String detalle() {
        return "Perecedero | Caducidad: " + fechaCaducidad;
    }
}
