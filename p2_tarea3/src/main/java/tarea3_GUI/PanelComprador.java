package tarea3_GUI;

import Monedas.*;
import tarea3_logica.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static tarea3_GUI.PanelExpDinero.labelMonedasPagadas;

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

        BotonesMonedaComprador boton_add100 = new BotonesMonedaComprador("Añadirme una Moneda de 100",100);
        BotonesMonedaComprador boton_add500 = new BotonesMonedaComprador("Añadirme una Moneda de 500",500);
        BotonesMonedaComprador boton_add1000 = new BotonesMonedaComprador("Añadirme una Moneda de 1000",1000);
        botonesInferior.add(boton_add100);
        botonesInferior.add(boton_add500);
        botonesInferior.add(boton_add1000);
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

    }

    private class BotonesMonedaComprador extends JButton {

        public Moneda aux_moneda;
        public int valor_moneda;
        BotonesMonedaComprador(String texto,int valor_moneda) {
            super(texto);
            this.valor_moneda = valor_moneda;
            this.addActionListener(new EscuchadorBoton());
        }

        private class EscuchadorBoton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                switch (valor_moneda) {
                    case 100:
                        aux_moneda = new Moneda100(Moneda100.serie_100);
                        comprador.addMoneda(aux_moneda);
                        labelMonedas100.setText("Monedas de 100: " + comprador.cuantasMonedas(100));
                        break;
                    case 500:
                        aux_moneda = new Moneda500(Moneda500.serie_500);
                        comprador.addMoneda(aux_moneda);
                        labelMonedas500.setText("Monedas de 500: " + comprador.cuantasMonedas(500));
                        break;
                    case 1000:
                        aux_moneda = new Moneda1000(Moneda1000.serie_1000);
                        comprador.addMoneda(aux_moneda);
                        labelMonedas1000.setText("Monedas de 1000: " + comprador.cuantasMonedas(1000));
                        break;
                    default:
                        break;
                }
                Moneda.incrementarSerie();
            }
        });


        //agregarle dinero a la maquina
        Expendedor expendedor = new Expendedor(10);
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comprador.cuantasMonedas(100) > 0) {
                    // Resta una moneda de 100 al comprador
                    comprador.restarMoneda(100);
                    labelMonedas100.setText("Monedas de 100: " + comprador.cuantasMonedas(100));


                    expendedor.addMonedaPago(new Moneda100(0));
                    String textoActual = labelMonedasPagadas.getText();
                    int montoIngresado = 0;
                    try {
                        montoIngresado = Integer.parseInt(textoActual.replace("Monto ingresado: ", ""));
                    } catch (NumberFormatException ex) {
                    }
                    montoIngresado += 100;
                    // Actualiza el label con el monto actualizado
                    labelMonedasPagadas.setText("Monto ingresado: " + montoIngresado);
                }
            }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comprador.cuantasMonedas(500) > 0) {
                    // Resta una moneda de 500 al comprador
                    comprador.restarMoneda(500);
                    labelMonedas500.setText("Monedas de 500: " + comprador.cuantasMonedas(500));


                    expendedor.addMonedaPago(new Moneda500(0));
                    String labelText = labelMonedasPagadas.getText();
                    int montoIngresado = 0;
                    try {
                        montoIngresado = Integer.parseInt(labelText.replace("Monto ingresado: ", ""));
                    } catch (NumberFormatException ex) {
                    }
                    montoIngresado += 500;
                    labelMonedasPagadas.setText("Monto ingresado: " + montoIngresado);
                }
            }
        });

        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comprador.cuantasMonedas(1000) > 0) {
                    // Resta una moneda de 1000 al comprador
                    comprador.restarMoneda(1000);
                    labelMonedas1000.setText("Monedas de 1000: " + comprador.cuantasMonedas(1000));


                    expendedor.addMonedaPago(new Moneda1000(0));
                    String labelText = labelMonedasPagadas.getText();
                    int montoIngresado = 0;
                    try {
                        montoIngresado = Integer.parseInt(labelText.replace("Monto ingresado: ", ""));
                    } catch (NumberFormatException ex) {
                    }
                    montoIngresado += 1000;
                    labelMonedasPagadas.setText("Monto ingresado: " + montoIngresado);
                }
            }
        });







    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
