package tarea3_logica;

import Productos.*;

public class DepositoSalida {

    private static Producto producto;

    public DepositoSalida() {
        this.producto = null;
    }

    public Producto getProducto() {
        if (this.producto == null) return null;
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
