package tarea3_logica;

import Monedas.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {

    private Comprador comprador;

    @BeforeEach
    void setUp() {
        comprador = new Comprador(5);
    }

    @Test
    @DisplayName("Test de creacion de comprador")
    public void testCreacionComprador() {
        assertNotNull(comprador);
    }

    @Test
    @DisplayName("Test de monedas creadas en constructor")
    public void testMonedasComprador() {
        ArrayList<Deposito<Moneda>> monedas = comprador.getDepositoMonedas();

        for (int i = 0; i < 4; i++) {
            Deposito<Moneda> aux_dep = monedas.get(i);
            ArrayList<Moneda> aux_dep_monedas = aux_dep.getDeposito();
            assertNotNull(aux_dep_monedas);
            for (int j = 0; j < aux_dep_monedas.size(); j++) {
                System.out.println(aux_dep_monedas.get(j).getValor());
            }
        }

        assertEquals(100, comprador.getMoneda(0).getValor());
        assertEquals(500, comprador.getMoneda(1).getValor());
        assertEquals(1000, comprador.getMoneda(2).getValor());
        assertEquals(1500, comprador.getMoneda(3).getValor());
    }
}