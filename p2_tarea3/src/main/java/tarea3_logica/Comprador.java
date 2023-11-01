package tarea3_logica;

import Excepciones.*;
import Monedas.*;
import Productos.*;

import java.util.ArrayList;

//* Comprador/Cliente que comprará algún Producto
class Comprador {

    private ArrayList<Moneda> monedas;
    private ArrayList<Producto> productos;
    private int vuelto;

    public Comprador() {
        this.monedas = new ArrayList<Moneda>();
        this.productos = new ArrayList<Producto>();
        this.vuelto = 0;
    }

    public int getVuelto() {
        return this.vuelto;
    }

    public void setVuelto(int vuelto) {
        this.vuelto = vuelto;
    }

    public Moneda getMoneda() {
        return this.monedas.get(0);
    }

    public void addMoneda(Moneda m) {
        this.monedas.add(m);
    }

    public void addProducto(Producto p) {
        this.productos.add(p);
    }

}
