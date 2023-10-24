package tarea3_logica;

import Excepciones.*;
import Productos.*;

public class DepositoSalida {

    private static Producto producto;

    public DepositoSalida() {
        this.producto = null;
    }

    public Producto getProducto() {
        if (this.producto == null) return null;

        Producto aux = this.producto;
        this.producto = null;
        return aux;
    }

    public void setProducto(Producto producto) throws DepositoOcupadoException {
        if (this.producto != null) {
            throw new DepositoOcupadoException("El deposito de salida esta ocupado");
        }
        this.producto = producto;
    }
}
