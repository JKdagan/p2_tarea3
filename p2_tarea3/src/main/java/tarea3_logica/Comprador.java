package tarea3_logica;

import Monedas.*;
import Productos.*;

import java.util.ArrayList;

//* Comprador/Cliente que comprará algún Producto
public class Comprador {

    // Array de depositos de monedas para guardar de 100,500,1000
    private ArrayList<Deposito<Moneda>> monedas;
    //Array de productos comprador
    private ArrayList<Producto> productos;

    //Constantes para representar las monedas en metodos
    public final int INDICE_MONEDA100 = 0;
    public final int INDICE_MONEDA500 = 1;
    public final int INDICE_MONEDA1000 = 2;
    public final int INDICE_MONEDA1500 = 3;

    /** Constructor de Comprador
     *
     * @param monedas cuantas monedas se le daran al comprador
     */
    public Comprador(int monedas) {
        /* monedas[0] = monedas100
         * monedas[1] = monedas500
         * monedas[2] = monedas1000
         * monedas[3] = monedas1500 */

        //Inicializa el deposito de todas las monedas
        this.monedas = new ArrayList<Deposito<Moneda>>(5);
        //Crea los depositos individuales de monedas para el tipo de moneda
        for (int i = 0; i < 4; i++)
            this.monedas.add(new Deposito<Moneda>());

        //Crea las monedas para darselas al comprador
        for (int j = 0; j < monedas; j++) {
            this.monedas.get(INDICE_MONEDA100).addToDeposito(new Moneda100(Moneda100.serie_100));
            this.monedas.get(INDICE_MONEDA500).addToDeposito(new Moneda500(Moneda500.serie_500));
            this.monedas.get(INDICE_MONEDA1000).addToDeposito(new Moneda1000(Moneda1000.serie_1000));
            this.monedas.get(INDICE_MONEDA1500).addToDeposito(new Moneda1500(Moneda1500.serie_1500));

            Moneda100.serie_100++;
            Moneda500.serie_500++;
            Moneda1000.serie_1000++;
            Moneda1500.serie_1500++;
        }

        //Inicializa el deposito de productos comprados
        this.productos = new ArrayList<Producto>();
    }

    /** Agrega el producto p al deposito interno
     *
     * @param p producto
     */
    public void addProducto(Producto p) {
        this.productos.add(p);
    }

    /** Agrega la moneda m al deposito interno
     *
     * @param m moneda
     */
    public void addMoneda(Moneda m) {
        if (m instanceof Moneda100) {
            this.monedas.get(INDICE_MONEDA100).addToDeposito(m);
        } else if (m instanceof Moneda500) {
            this.monedas.get(INDICE_MONEDA500).addToDeposito(m);
        } else if (m instanceof Moneda1000) {
            this.monedas.get(INDICE_MONEDA1000).addToDeposito(m);
        } else if (m instanceof Moneda1500) {
            this.monedas.get(INDICE_MONEDA1500).addToDeposito(m);
        }
    }

    /** Le quita una moneda valor del deposito correspondiente
     *
     * @param valor valormonedas
     * @return moneda
     */
    public Moneda getMoneda(int valor) {
        Moneda aux;

        switch (valor) {
            case 100:
                if (cuantasMonedas(100) > 0) {
                    // Resta una moneda de 100 al comprador
                    aux = monedas.get(INDICE_MONEDA100).getFromDeposito();
                    return aux;
                }
            case 500:
                if (cuantasMonedas(500) > 0) {
                    // Resta una moneda de 500 al comprador
                    aux = monedas.get(INDICE_MONEDA500).getFromDeposito();
                    return aux;
                }
            case 1000:
                if (cuantasMonedas(1000) > 0) {
                    // Resta una moneda de 1000 al comprador
                    aux = monedas.get(INDICE_MONEDA1000).getFromDeposito();
                    return aux;
                }
            case 1500:
                if (cuantasMonedas(1500) > 0) {
                    // Resta una moneda de 1500 al comprador
                    aux = monedas.get(INDICE_MONEDA1500).getFromDeposito();
                    return aux;
                }
            default:
                return null;
        }

    }

    /**
     *
     * @return el deposito interno de monedas
     */
    public ArrayList<Deposito<Moneda>> getDepositoMonedas() {
        return this.monedas;
    }

    /**
     *
     * @param valorMoneda valor de la moneda
     * @return la cantidad de monedas en el deposito
     */
    public int cuantasMonedas(int valorMoneda) {
        return switch (valorMoneda) {
            case 100 -> this.monedas.get(INDICE_MONEDA100).cuantoHay();
            case 500 -> this.monedas.get(INDICE_MONEDA500).cuantoHay();
            case 1000 -> this.monedas.get(INDICE_MONEDA1000).cuantoHay();
            case 1500 -> this.monedas.get(INDICE_MONEDA1500).cuantoHay();
            default -> 0;
        };
    }

    /**
     *
     * @return el deposito interno de productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     *
     * @return si el deposito de productos esta vacio o no
     */
    public boolean isEmpty() {
        return productos.isEmpty();
    }

}