package tarea3_logica;
import java.util.ArrayList;

import Excepciones.NoHayProductoException;
import Excepciones.PagoIncorrectoException;
import Excepciones.PagoInsuficienteException;
import Monedas.*;
import Productos.*;

public class Expendedor {

//  private ArrayList<Deposito> depositos;  Por Hacer

    private Deposito<Bebida> dep_cocacola;
    private Deposito<Bebida> dep_fanta;
    private Deposito<Bebida> dep_sprite;
    private Deposito<Dulce> dep_super8;
    private Deposito<Dulce> dep_snickers;
    private Deposito<Moneda> dep_monedasvuelto;
    
    private Deposito<Moneda> dep_monedaspagadas;
    private DepositoSalida salida;

    private void llenarDepositos(int cantidadInicial) {
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
        llenarDepositos(cantidadInicial);
    }

    public void comprarProducto(Moneda m, ProductEnum cualProducto) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {

        int precio_producto = cualProducto.getPrecio();

        if (m == null) {
            throw new PagoIncorrectoException("La moneda introducida es nula"); //Pendiente, meter excepciones de la tarea 2
        }

        //Si la moneda es menor al precio.
        if (m.getValor() < precio_producto) {
            //Se da la misma moneda de vuelto, PagoInsuficienteExepcion.
            dep_monedasvuelto.addToDeposito(m);
            throw new PagoInsuficienteException("La moneda no alcanza para comprar el producto.");
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
                dep_monedasvuelto.addToDeposito(m);
                throw new NoHayProductoException("El deposito seleccionado no existe");
            }
        }

        if (producto == null) {
            //Si se acabaron los productos: NoHayProductioExcepcion.
            dep_monedasvuelto.addToDeposito(m);
            throw new NoHayProductoException("No quedan del producto seleccionado o no existe en el deposito.");
        }
        else {
            //Compra exitosa.

            if (m.getValor() == precio_producto) {
                //No hay vuelto
                dep_monedaspagadas.addToDeposito(m);
                salida.setProducto(producto);
            }

            else {
                //Si hay vuelto y se devuelve de a 100.
                int cambio = (m.getValor() - precio_producto)/100;
                dep_monedaspagadas.addToDeposito(m);

                for (int i = 0; i < cambio; i++) {
                    Moneda m_aux = new Moneda100(100 + i);
                    dep_monedasvuelto.addToDeposito(m_aux);
                }

                salida.setProducto(producto);
            }
        }
    }


}


