package tarea3_logica;

import Excepciones.*;
import Monedas.*;
import Productos.*;

import java.util.ArrayList;

//* Comprador/Cliente que comprará algún Producto
class Comprador {

    private String nombre_producto;
    private int vuelto;
    private ArrayList<Moneda> monedas;

    public Comprador(Moneda m)  {

    }

    public int getVuelto() {
        return this.vuelto;
    }
    public String getNombreProducto() {
        return this.nombre_producto;
    }
    public void addMoneda(Moneda m) {
        this.monedas.add(m);
    }

    /* metodo toString para la representación de la cadena del Comprador actual, tiene el nombre de su Producto y su vuelto
    @return una cadena que representa el Comprador en el formato "Comprador= nombre del producto es: [nombre_producto]. Vuelto es: [vuelto]"
     */
    public String toString() {
        return "Comprador=" +
                "Producto:" + nombre_producto + '\'' +
                "Vuelto: " + vuelto ;
    }
}
