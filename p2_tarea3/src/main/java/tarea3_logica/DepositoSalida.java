package tarea3_logica;

import Excepciones.*;
import Productos.*;

/**
 * Clase que representa el deposito de salida de la maquina (1 producto solamente)
 */
public class DepositoSalida {
    /**
     * Producto comprado en la maquina
     */
    private static Producto producto;
    //* Constructor
    public DepositoSalida() {
        this.producto = null;
    }

    /**
     * Devuelve el producto comprado en la maquina
     * @return
     */
    public Producto getProducto() {
        if (this.producto == null) return null;

        Producto aux = this.producto;
        this.producto = null;
        return aux;
    }

    /**
     * Establece el producto comprado en la maquina
     * @param producto el producto comprado
     * @throws DepositoOcupadoException si no se saca el producto comprado anteriormente
     */
    public void setProducto(Producto producto) throws DepositoOcupadoException {
        if (this.producto != null) {
            throw new DepositoOcupadoException("El deposito de salida esta ocupado");
        }
        this.producto = producto;
    }
}
