package tarea3_logica;
import java.util.ArrayList;

import Excepciones.*;
import Monedas.*;
import Productos.*;

/**
 * Clase Expendedor
 */
public class Expendedor {
    /**
     * Atributos de la clase Expendedor, Depositos internos de productos y monedas
     */
    public Deposito<Bebida> dep_cocacola;
    public Deposito<Bebida> dep_fanta;
    public Deposito<Bebida> dep_sprite;
    public Deposito<Dulce> dep_super8;
    public Deposito<Dulce> dep_snickers;
    private Deposito<Moneda> dep_monedaspagadas;
    private Deposito<Moneda> dep_monedasvuelto;
    private DepositoSalida salida;
    /**
     * @param pago: int, monto total de monedas ingresadas por el usuario
     * @param aux_serie: int, auxiliar para generar el numero de serie de las monedas
     * @param cualProducto: ProductEnum, enum que contiene los productos disponibles
     */
    public int pago;
    public static int aux_serie = 100;
    private ProductEnum cualProducto;

    //* flag para saber si el deposito de salida esta ocupado
    public static boolean flag_deposito_ocupado;

    /**
     * Metodo para llenar los depositos con productos
     * @param cantidadInicial cuantos productos
     */
    public void llenarDepositos(int cantidadInicial) {
        for (int i = 0; i < cantidadInicial; i++) {
            //aux para denotar que son temporales solo para llenar los depositos
            Bebida aux_coca = new CocaCola(i);
            Bebida aux_sprite = new Sprite(i);
            Bebida aux_fanta = new Fanta(i);
            Dulce aux_super8 = new Super8(i);
            Dulce aux_snickers = new Snickers(i);

            dep_cocacola.addToDeposito(aux_coca);
            dep_fanta.addToDeposito(aux_fanta);
            dep_sprite.addToDeposito(aux_sprite);
            dep_super8.addToDeposito(aux_super8);
            dep_snickers.addToDeposito(aux_snickers);
        }
    }
    //* constructor por defecto, crear los Depositos y luego los llena con el llenarDepositos
    public Expendedor(int cantidadInicial) {
        this.dep_cocacola = new Deposito<Bebida>();
        this.dep_fanta = new Deposito<Bebida>();
        this.dep_sprite = new Deposito<Bebida>();
        this.dep_super8 = new Deposito<Dulce>();
        this.dep_snickers = new Deposito<Dulce>();
        this.dep_monedasvuelto = new Deposito<Moneda>();
        this.dep_monedaspagadas = new Deposito<Moneda>();
        this.salida = new DepositoSalida();
        this.flag_deposito_ocupado = false;
        llenarDepositos(cantidadInicial);
        this.pago = 0;
    }

    /**
     * Metodo para comprar un producto
     * @throws NoHayProductoException no quedan productos
     * @throws PagoIncorrectoException moneda nula
     * @throws PagoInsuficienteException no alcanza el pago
     * @throws DepositoOcupadoException no se ha sacado el producto comprado anteriormente
     */
    public void comprarProducto() throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException, DepositoOcupadoException {

        if (salida.getProducto() != null) {
            this.flag_deposito_ocupado = true;
        }

        if (flag_deposito_ocupado == false) {

            int precio_producto = cualProducto.getPrecio();

            //Si la moneda es menor al precio.
            if (pago < precio_producto) {
                throw new PagoInsuficienteException("No alcanza el pago");
            }

            Producto producto;

            switch (cualProducto) {
                case COCA_COLA -> producto = dep_cocacola.getFromDeposito();
                case SPRITE -> producto = dep_sprite.getFromDeposito();
                case FANTA -> producto = dep_fanta.getFromDeposito();
                case SUPER8 -> producto = dep_super8.getFromDeposito();
                case SNICKERS -> producto = dep_snickers.getFromDeposito();
                default -> {
                    //Numero erroneo de deposito (No existe) NoHayProductoExcepcion
                    throw new NoHayProductoException("El deposito seleccionado no existe");
                }
            }

            if (producto == null) {
                //Si se acabaron los productos: NoHayProductioExcepcion.
                throw new NoHayProductoException("No quedan del producto seleccionado o no existe en el deposito.");
            }
            else {
                //Compra exitosa.

                if (pago == precio_producto) {
                    //No hay vuelto
                    pago = 0;
                    salida.setProducto(producto);
                }
                else {
                    //Si hay vuelto y se devuelve de a 100.
                    int cambio = (pago - precio_producto) / 100;
                    pago = 0;
                    for (int i = 0; i < cambio; i++) {
                        Moneda m_aux = new Moneda100(Moneda100.serie_100);
                        Moneda100.serie_100++;
                        dep_monedasvuelto.addToDeposito(m_aux);
                    }
                    salida.setProducto(producto);
                }
            }
        }
        else {
            throw new DepositoOcupadoException("El deposito de salida esta ocupado, retire el producto antes de la siguiente compra");
        }

    }

    /**
     * Metodo para agregar monedas al pago
     * @param m moneda ingresada
     */
    public void addMonedaPago(Moneda m) {
        if (m == null) pago += 0;
        else {
            this.dep_monedaspagadas.addToDeposito(m);
            pago += m.getValor();
        }
    }

    /**
     * Metodo para elegir el producto a comprar
     * @param cualProducto enum del producto
     */
    public void elegirProducto(ProductEnum cualProducto) {
        this.cualProducto = cualProducto;
    }

    /**
     * Getter del pago
     * @return pago: int de monedas ingresadas
     */
    public int getPago() {
        return this.pago;
    }

    /**
     * Getter del producto comprado desde el deposito de salida
     * @return producto
     */
    public Producto getProducto() {
        this.flag_deposito_ocupado = false;
        return this.salida.getProducto();
    }

    /**
     * Getter de la moneda de vuelto
     * @return moneda
     */
    public Moneda getMonedaVuelto() {
        Moneda aux = this.dep_monedasvuelto.getFromDeposito();
        if (aux == null) return null;
        else return aux;
    }

    /**
     * Getter del deposito de monedas pagadas
     * @return deposito monedas
     */
    public Deposito<Moneda> getDepMonedasPagadas() {
        return this.dep_monedaspagadas;
    }

    /**
     * Getter del deposito de monedas de vuelto
     * @return deposito monedas
     */
    public Deposito<Moneda> getDepMonedasVuelto() {
        return this.dep_monedasvuelto;
    }

    /**
     * Calcula el vuelto total
     * @return vuelto: int
     */
    public int calcularVuelto() {
        // Calcula el vuelto a partir de las monedas en dep_monedasvuelto
        int vuelto = dep_monedasvuelto.cuantoHay() * 100; // Cada moneda de 100 suma 100 al vuelto
        return vuelto;
    }
}

