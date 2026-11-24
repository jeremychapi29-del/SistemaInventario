package modelo;

public abstract class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String codigo, String nombre, int cantidad, double precio) {
        if (codigo.trim().isEmpty() || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Datos obligatorios vacios.");
        }

        if (precio <= 0 || !Double.isFinite(precio)) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero.");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        setCantidad(cantidad);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("Cantidad no valida.");
        }
        this.cantidad = cantidad;
    }

    public double calcularValor() {
        return cantidad * precio;
    }

    public abstract String detalle();

    public String toString() {
        return codigo + " | " + nombre + " | Cantidad: " + cantidad
                + " | Precio: $" + precio + " | " + detalle();
    }
}
