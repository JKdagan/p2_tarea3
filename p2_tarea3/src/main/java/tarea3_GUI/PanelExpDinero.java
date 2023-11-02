package tarea3_GUI;

import javax.swing.*;
import java.awt.*;


public class PanelExpDinero extends JPanel {
    private JTextField textField;

    public PanelExpDinero(Color color) {
        super();
        this.setBackground(color);
        textField = new JTextField(50);
        textField.setBounds(80, (80 - textField.getPreferredSize().height) / 2, 200, textField.getPreferredSize().height);
        add(textField);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        // Define el ancho y alto de los rectángulos
        int rectWidth = 200; // Ancho de los rectángulos
        int rectHeight = 80; // Alto de los rectángulos

        int x1 = 80;
        int y = (rectHeight - textField.getPreferredSize().height) / 2;
        g.setColor(Color.gray);
        g.fillRect(x1, y, rectWidth, rectHeight);
        textField.setBounds(x1, y, 200, rectHeight);

        g.drawString("Ingrese el dinero",80,y+95);

        int x2= 460;
        g.fillRect(x2, y, rectWidth, rectHeight+100);

    }
}


