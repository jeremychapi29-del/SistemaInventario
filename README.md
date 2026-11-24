# Sistema de Inventario

Proyecto de Programación II (ISWZ1103) · Universidad de las Américas · Grupo 3.

Sistema de consola para gestionar el inventario de una pequeña tienda de alimentos. Registra y muestra productos perecederos y no perecederos, busca por código, actualiza cantidades, elimina productos y calcula el valor total. La lista admite hasta 50 productos y se conserva en memoria durante la ejecución.

| Paquete | Clases |
| --- | --- |
| `modelo` | `Producto`, `ProductoPerecedero`, `ProductoNoPerecedero` |
| `negocio` | `Inventario` |
| `interfaz` | `Main` |

Abre la carpeta `SistemaInventario` en IntelliJ IDEA, selecciona un JDK 17 o posterior y ejecuta `interfaz.Main`. Usa el formato AAAA-MM-DD para la fecha de caducidad. La opción 0 cierra el programa.
