package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class PanelComprador extends JPanel {
    private ImageIcon imagenComprador;

    public PanelComprador(Color color){
        super();
        this.setBackground(color);
        this.setSize(100,100);
        imagenComprador = new ImageIcon(getClass().getResource("/imagenes/Comprador.jpeg"));
        if (imagenComprador != null) {
            JLabel label = new JLabel(imagenComprador);
            add(label);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
