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
            imagenComprador.setImage(imagenComprador.getImage().getScaledInstance(200, 500, Image.SCALE_DEFAULT));
            JLabel label = new JLabel(imagenComprador);
            add(label, BorderLayout.CENTER);
        }

        //botones para pagar
        JPanel botonesSuperior = new JPanel();
        botonesSuperior.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton boton1 = new JButton("Pagar en maquina con 100");
        JButton boton2 = new JButton("Pagar en maquina con 500");
        JButton boton3 = new JButton("Pagar en maquina con 1000");
        botonesSuperior.add(boton1);
        botonesSuperior.add(boton2);
        botonesSuperior.add(boton3);
        add(botonesSuperior, BorderLayout.NORTH);
        //botones para darle mas dinero al comprador
        JPanel botonesInferior = new JPanel();
        botonesInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton boton4 = new JButton("Añadirme una Moneda de 100");
        JButton boton5 = new JButton("Añadirme una Moneda de 500");
        JButton boton6 = new JButton("Añadirme una Moneda de 1000");
        botonesInferior.add(boton4);
        botonesInferior.add(boton5);
        botonesInferior.add(boton6);
        add(botonesInferior, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
