package tarea3_logica;

import Excepciones.DepositoOcupadoException;
import Excepciones.NoHayProductoException;
import Excepciones.PagoIncorrectoException;
import Excepciones.PagoInsuficienteException;
import Monedas.*;
import Productos.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {

    private Expendedor exp;
    private Moneda m;


    @BeforeEach
    void setUp() {
        exp = new Expendedor(5);
        m = new Moneda1500(1);
    }

    @Test
    @DisplayName("Test de comprarProducto")
    public void test_compra() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException, DepositoOcupadoException {
        exp.comprarProducto(m, ProductEnum.COCA_COLA);
        Producto c1 = exp.getProducto();
        Producto c2 = exp.getProducto();

        assertNotNull(c1);
        assertNull(c2);
    }

    @Test
    @DisplayName("Test de deposito de salida")
    public void test_depSalida() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException, DepositoOcupadoException {
        //Este test hace el loop donde corre el expendedor y se asegura que si el deposito de salida esta lleno
        //entonces en vez de reiniciar todo vuelve al inicio del loop para que el comprador pueda retirar el producto

        int aux = 0;
        Producto p;

        while (aux < 2) {
            try {

                exp.comprarProducto(m, ProductEnum.COCA_COLA);
                if (aux == 1) {
                    p = exp.getProducto();
                    System.out.println(p.toString());
                }
                exp.comprarProducto(m, ProductEnum.COCA_COLA);
                break;
            } catch (DepositoOcupadoException e) {
                System.out.println("Deposito ocupado, retire el producto");
                aux++;
                continue;
            }
        }

    }
}