package tarea3_logica;

import Excepciones.*;
import Monedas.*;
import Productos.*;

import java.util.ArrayList;

//* Comprador/Cliente que comprará algún Producto
public class Comprador {

    private ArrayList<Deposito<Moneda>> monedas;
    private ArrayList<Producto> productos;
    private int vuelto;

    public Comprador(int monedas) {
        /* monedas[0] = monedas100
         * monedas[1] = monedas500
         * monedas[2] = monedas1000
         * monedas[3] = monedas1500 */

        this.monedas = new ArrayList<Deposito<Moneda>>(4);
        for (int i = 0; i < 4; i++)
            this.monedas.add(new Deposito<Moneda>());

        for (int j = 0; j < monedas; j++) {
            this.monedas.get(0).addToDeposito(new Moneda100(j));
            this.monedas.get(1).addToDeposito(new Moneda500(j));
            this.monedas.get(2).addToDeposito(new Moneda1000(j));
            this.monedas.get(3).addToDeposito(new Moneda1500(j));
        }

        this.productos = new ArrayList<Producto>();
        this.vuelto = 0;
    }

    public int getVuelto() {
        return this.vuelto;
    }
    public void setVuelto(int vuelto) {
        this.vuelto = vuelto;
    }
    public void addProducto(Producto p) {
        this.productos.add(p);
    }
    public Moneda getMoneda(int index) {
        return this.monedas.get(index).getFromDeposito();
    }
    public void addMoneda(Moneda m) {
        if (m instanceof Moneda100) {
            this.monedas.get(0).addToDeposito(m);
        } else if (m instanceof Moneda500) {
            this.monedas.get(1).addToDeposito(m);
        } else if (m instanceof Moneda1000) {
            this.monedas.get(2).addToDeposito(m);
        } else if (m instanceof Moneda1500) {
            this.monedas.get(3).addToDeposito(m);
        }
    }

}
