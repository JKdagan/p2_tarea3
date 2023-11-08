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

    }

    @Test
    @DisplayName("Creacion de Expendedor")
    void testCreacionExpendedor() {
        assertNotNull(exp);
        assertEquals(5, exp.dep_cocacola.getDeposito().size());
    }

    @Test
    void testComprarProducto() throws DepositoOcupadoException, NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        exp.elegirProducto(ProductEnum.COCA_COLA);
        exp.addMonedaPago(new Moneda1000(1));
        exp.addMonedaPago(new Moneda100(1));
        exp.addMonedaPago(new Moneda100(2));
        exp.comprarProducto();
        Producto producto = exp.getProducto();
        assertNotNull(producto);
    }

    @Test
    @DisplayName("Test vuelto")
    void testVuelto() throws DepositoOcupadoException, NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        exp.elegirProducto(ProductEnum.COCA_COLA);
        exp.addMonedaPago(new Moneda1000(1));
        exp.addMonedaPago(new Moneda1000(1));
        exp.comprarProducto();
        Producto producto = exp.getProducto();
        assertEquals(800, exp.getDepMonedasVuelto().cuantoHay() * 100);
    }

    @Test
    @DisplayName("Test Deposito Ocupado")
    void testDepositoOcupado() throws DepositoOcupadoException, NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        exp.elegirProducto(ProductEnum.COCA_COLA);
        exp.addMonedaPago(new Moneda1000(1));
        exp.addMonedaPago(new Moneda1000(2));
        exp.comprarProducto();
        exp.elegirProducto(ProductEnum.SUPER8);
        exp.addMonedaPago(new Moneda1000(3));
        assertThrows(DepositoOcupadoException.class, () -> exp.comprarProducto());
    }

    @Test
    @DisplayName("Test No Hay Producto")
    void testNoHayProducto() throws DepositoOcupadoException, NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        for (int i = 0; i < 5; i++) {
            exp.elegirProducto(ProductEnum.FANTA);
            exp.addMonedaPago(new Moneda1000(i));
            exp.comprarProducto();
            exp.getProducto();
        }

        exp.elegirProducto(ProductEnum.FANTA);
        exp.addMonedaPago(new Moneda1000(6));
        assertThrows(NoHayProductoException.class, () -> exp.comprarProducto());
    }

    @Test
    @DisplayName("Test Pago Insuficiente")
    void testPagoInsuficiente() throws DepositoOcupadoException, NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        exp.elegirProducto(ProductEnum.COCA_COLA);
        exp.addMonedaPago(new Moneda1000(1));
        assertThrows(PagoInsuficienteException.class, () -> exp.comprarProducto());
    }
}