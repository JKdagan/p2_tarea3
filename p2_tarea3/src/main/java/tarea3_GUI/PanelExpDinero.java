package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
public class PanelExpDinero extends JPanel {

    public static JLabel labelMonedasPagadas;
    public static JLabel labelVuelto;
    public PanelExpDinero(Color color) {
        super(new BorderLayout());
        this.setBackground(color);

        labelMonedasPagadas = new JLabel();
        labelMonedasPagadas.setText("Monto ingresado: 0");
        labelVuelto=new JLabel();
        labelVuelto.setText("Vuelto: 0");
        add(labelMonedasPagadas, BorderLayout.WEST);
        add(labelVuelto,BorderLayout.EAST);
    }


    public static void actualizarVuelto(int vuelto) {
        labelVuelto.setText("Vuelto: " + vuelto);
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


