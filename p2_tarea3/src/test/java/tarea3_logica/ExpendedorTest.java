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
    private Comprador c;
    private Moneda m;

    @BeforeEach
    void setUp() {
        exp = new Expendedor(5);
        c = new Comprador(5);

    }

    @Test
    @DisplayName("Test de agregar monedas")
    public void testAgregarMonedas() {
        m = c.getMoneda(0);
        exp.addMonedaPago(m);
        assertEquals(100, exp.getDepMonedasPagadas().getDeposito().get(0).getValor());

        m = c.getMoneda(1);
        exp.addMonedaPago(m);
        assertEquals(500, exp.getDepMonedasPagadas().getDeposito().get(1).getValor());

        m = c.getMoneda(2);
        exp.addMonedaPago(m);
        assertEquals(1000, exp.getDepMonedasPagadas().getDeposito().get(2).getValor());

        m = c.getMoneda(3);
        exp.addMonedaPago(m);
        assertEquals(1500, exp.getDepMonedasPagadas().getDeposito().get(3).getValor());

    }

    @Test
    @DisplayName("Test de compra producto. Pago insuficiente")
    public void testPagoInsuficiente() throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException, DepositoOcupadoException {
        m = c.getMoneda(0);
        exp.addMonedaPago(m);

        try {
            exp.elegirProducto(ProductEnum.COCA_COLA);
            exp.comprarProducto();
            Producto producto = exp.getProducto();
            producto.toString();
        }
        catch (PagoInsuficienteException e) {
            assertEquals("No alcanza el pago", e.getMessage());
        }
    }

    @Test
    @DisplayName("Test de compra producto. Pago Correcto y da vuelto")
    public void testCompraCorrecta() throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException, DepositoOcupadoException {
        m = c.getMoneda(3);
        exp.addMonedaPago(m);
        int vuelto = 0;

        exp.elegirProducto(ProductEnum.COCA_COLA);
        exp.comprarProducto();
        Producto producto = exp.getProducto();
        assertEquals("Coca-Cola", producto.getNombre());

        for (int i = 0; i < exp.getDepMonedasVuelto().getDeposito().size(); i++) {
            Moneda m = exp.getDepMonedasVuelto().getDeposito().get(i);
            System.out.println(m.getValor());
            assertEquals(100, m.getValor());
            vuelto += 100;
        }
        System.out.println("Vuelto: " + vuelto);
    }
}