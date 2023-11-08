package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
public class PanelExpDinero extends JPanel {

    public static JLabel labelMonedasPagadas;
    public static JLabel labelVuelto;
    public PanelExpDinero(Color color) {
        super(new BorderLayout());
        this.setBackground(color);

        JPanel labelsPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int rectWidth = getWidth() / 2;
                int rectHeight = getHeight();

                g.setColor(color1);
                g.fillRect(0, 0, rectWidth, rectHeight);

                g.setColor(color2);
                g.fillRect(rectWidth, 0, rectWidth, rectHeight);
            }
        };

        labelMonedasPagadas = new JLabel("Monto ingresado: 0");
        labelVuelto = new JLabel("Vuelto: 0");

        labelsPanel.setLayout(new BorderLayout());
        labelsPanel.add(labelMonedasPagadas, BorderLayout.WEST);
        labelsPanel.add(labelVuelto, BorderLayout.EAST);

        add(labelsPanel, BorderLayout.CENTER);
    }

    Color color1=new Color( 183,146 ,224 );
    Color color2=new Color(203 , 123, 224);
    public static void actualizarVuelto(int vuelto) {
        labelVuelto.setText("Vuelto: " + vuelto);
    }

}


