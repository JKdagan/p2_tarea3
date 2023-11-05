package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
public class PanelExpDinero extends JPanel {

    public static JLabel labelMonedasPagadas;
    public PanelExpDinero(Color color) {
        super();
        this.setBackground(color);
        labelMonedasPagadas = new JLabel("Monto ingresado: ");
        add(labelMonedasPagadas);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        // Define el ancho y alto de los rectángulos
        int rectWidth = 200; // Ancho de los rectángulos
        int rectHeight = 70; // Alto de los rectángulos
        int y=80;

        int x2= 460;
        g.fillRect(x2, y, rectWidth, rectHeight+90);

    }
}


