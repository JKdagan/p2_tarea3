package tarea3_GUI;
import Monedas.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;


//Ventana que mostrará las Monedas que posee el Comprador
public class VentanaBolsillo extends JFrame{
    //Constructor por defecto; le ponemos titutlo y un tamaño, se le añade un panel en donde iremos pintando
    public VentanaBolsillo() {
        super("Bolsillo del Comprador");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                // Dibuja un círculo azul para cada Moneda100 que tenga el Comprador
                g2d.setColor(Color.BLUE);
                for (int i = 0; i < PanelPrincipal.comprador.cuantasMonedas(100); i++) {
                    Ellipse2D circle = new Ellipse2D.Double(10 + i * 40, 50, 30, 30);
                    g2d.fill(circle);
                }
                // Dibuja un círculo rojo para cada Moneda500 que tenga el Comprador
                g2d.setColor(Color.RED);
                for (int i = 0; i < PanelPrincipal.comprador.cuantasMonedas(500); i++) {
                    Ellipse2D circle = new Ellipse2D.Double(10 + i * 40, 100, 30, 30);
                    g2d.fill(circle);
                }
                // Dibuja un círculo verde para cada Moneda1000 que tenga el Comprador
                g2d.setColor(Color.GREEN);
                for (int i = 0; i < PanelPrincipal.comprador.cuantasMonedas(1000); i++) {
                    Ellipse2D circle = new Ellipse2D.Double(10 + i * 40, 150, 30, 30);
                    g2d.fill(circle);
                }
            }
        };
        add(panel);
    }
}
