package modelo;

public class ProductoNoPerecedero extends Producto {
    private String categoria;

    public ProductoNoPerecedero(String codigo, String nombre,
                               int cantidad, double precio,
                               String categoria) {
        super(codigo, nombre, cantidad, precio);
        this.categoria = categoria;
    }

    @Override
    public String detalle() {
        return "No perecedero | Categoria: " + categoria;
    }
}
