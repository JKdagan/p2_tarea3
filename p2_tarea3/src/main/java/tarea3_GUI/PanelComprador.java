package tarea3_GUI;

import Monedas.Moneda;
import Monedas.Moneda100;
import Monedas.Moneda1000;
import Monedas.Moneda500;
import tarea3_logica.Comprador;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel {
    private ImageIcon imagenComprador;
    private Comprador comprador;
    private JLabel labelMonedas100;
    private JLabel labelMonedas500;
    private JLabel labelMonedas1000;

    public PanelComprador(Color color, Comprador comprador){
        super();
        this.comprador = comprador;
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

        //mostrar dinero del comprador
        labelMonedas100 = new JLabel("Monedas de 100: " + comprador.cuantasMonedas(100));
        labelMonedas500 = new JLabel("Monedas de 500: " + comprador.cuantasMonedas(500));
        labelMonedas1000 = new JLabel("Monedas de 1000: " + comprador.cuantasMonedas(1000));
        JPanel monedasPanel = new JPanel();
        monedasPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Utilizar FlowLayout alineado a la izquierda
        monedasPanel.add(labelMonedas100);
        monedasPanel.add(labelMonedas500);
        monedasPanel.add(labelMonedas1000);
        add(monedasPanel, BorderLayout.WEST);

        boton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Moneda moneda100 = new Moneda100(comprador.cuantasMonedas(100) + 1);
                comprador.addMoneda(moneda100);
                labelMonedas100.setText("Monedas 100: " + comprador.cuantasMonedas(100));
            }
        });

// ActionListener para el botón de agregar Moneda de 500
        boton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Moneda moneda500 = new Moneda500(comprador.cuantasMonedas(500) + 1);
                comprador.addMoneda(moneda500);
                // Actualiza el texto para mostrar la cantidad de Monedas de 500
                labelMonedas500.setText("Monedas de 500: " + comprador.cuantasMonedas(500));
            }
        });

// ActionListener para el botón de agregar Moneda de 1000
        boton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Moneda moneda1000 = new Moneda1000(comprador.cuantasMonedas(1000) + 1);
                comprador.addMoneda(moneda1000);
                // Actualiza el texto para mostrar la cantidad de Monedas de 1000
                labelMonedas1000.setText("Monedas de 1000: " + comprador.cuantasMonedas(1000));
            }
        });



    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
