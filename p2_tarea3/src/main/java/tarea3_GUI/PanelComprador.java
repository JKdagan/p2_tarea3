package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class PanelComprador extends JPanel {
    private ImageIcon imagenComprador;

    public PanelComprador(Color color){
        super();
        this.setBackground(color);
        this.setLayout(new BorderLayout());
        imagenComprador = new ImageIcon(getClass().getResource("/imagenes/Comprador.jpeg"));
        if (imagenComprador != null) {
            JLabel label = new JLabel(imagenComprador);
            add(label, BorderLayout.CENTER);
        }
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.PAGE_AXIS));

        JButton boton1 = new JButton("Agregar Moneda de 100");
        JButton boton2 = new JButton("Agregar Moneda de 500");
        JButton boton3 = new JButton("Agregar Moneda de 1000");

        botonesPanel.add(Box.createVerticalGlue());
        botonesPanel.add(boton1);
        botonesPanel.add(boton2);
        botonesPanel.add(boton3);
        botonesPanel.add(Box.createVerticalGlue());
        //los glues es para tener espacio por arriba y por abajo

        add(botonesPanel, BorderLayout.EAST);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
