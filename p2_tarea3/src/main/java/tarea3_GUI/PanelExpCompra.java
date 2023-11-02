package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class PanelExpCompra extends JPanel {

    public PanelExpCompra(Color color) {
        super();
        this.setBackground(color);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        g.setColor(Color.gray);
        int rectWidth = 500; // Ancho del rectángulo
        int rectHeight = 130; // Alto del rectángulo
        int x = (width - rectWidth) / 2;
        int y = (height - rectHeight) / 2;
        g.fillRect(x, y, rectWidth, rectHeight);
    }


}
