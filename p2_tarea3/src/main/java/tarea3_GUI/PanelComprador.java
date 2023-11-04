package tarea3_GUI;

import Monedas.*;
import tarea3_logica.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel {
    private ImageIcon imagenComprador;
    private JLabel labelMonedas100;
    private JLabel labelMonedas500;
    private JLabel labelMonedas1000;
    private JLabel labelMonedasPagadas;
    private BotonesMonedaComprador boton_add100;
    private BotonesMonedaComprador boton_add500;
    private BotonesMonedaComprador boton_add1000;
    private BotonesPagoExpendedor boton_pagar100;
    private BotonesPagoExpendedor boton_pagar500;
    private BotonesPagoExpendedor boton_pagar1000;

    private Expendedor expendedor;
    private Comprador comprador;

    public PanelComprador(Color color, Comprador comprador, Expendedor expendedor, JLabel labelMonedasPagadas) {
        super();
        this.comprador = comprador;
        this.expendedor = expendedor;
        this.labelMonedasPagadas = labelMonedasPagadas;

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

        boton_pagar100 = new BotonesPagoExpendedor("Pagar en maquina con 100", 100);
        boton_pagar500 = new BotonesPagoExpendedor("Pagar en maquina con 500", 500);
        boton_pagar1000 = new BotonesPagoExpendedor("Pagar en maquina con 1000", 1000);
        botonesSuperior.add(boton_pagar100);
        botonesSuperior.add(boton_pagar500);
        botonesSuperior.add(boton_pagar1000);
        add(botonesSuperior, BorderLayout.NORTH);

        //botones para darle mas dinero al comprador
        JPanel botonesInferior = new JPanel();
        botonesInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
        boton_add100 = new BotonesMonedaComprador("Añadirme una Moneda de 100",100);
        boton_add500 = new BotonesMonedaComprador("Añadirme una Moneda de 500",500);
        boton_add1000 = new BotonesMonedaComprador("Añadirme una Moneda de 1000",1000);
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

    public void updateLabelMonedasText() {
        labelMonedas100.setText("Monedas de 100: " + comprador.cuantasMonedas(100));
        labelMonedas500.setText("Monedas de 500: " + comprador.cuantasMonedas(500));
        labelMonedas1000.setText("Monedas de 1000: " + comprador.cuantasMonedas(1000));
    }

    private class BotonesMonedaComprador extends JButton {
        public Moneda aux_moneda;
        public int valor_moneda;
        BotonesMonedaComprador(String texto, int valor_moneda) {
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
        }
    }
    private class BotonesPagoExpendedor extends JButton {

        public int valor_moneda;
        public Moneda aux_moneda;
        BotonesPagoExpendedor(String texto, int valor_moneda) {
            super(texto);
            this.valor_moneda = valor_moneda;
            this.addActionListener(new EscuchadorBoton());
        }

        private class EscuchadorBoton implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                switch (valor_moneda) {
                    case 100:
                        if (comprador.cuantasMonedas(100) > 0) {
                            aux_moneda = comprador.getMoneda(100);
                            updateLabelMonedasText();
                        }
                        else aux_moneda = null;
                        break;
                    case 500:
                        if (comprador.cuantasMonedas(500) > 0) {
                            aux_moneda = comprador.getMoneda(500);
                            updateLabelMonedasText();
                        }
                        else aux_moneda = null;
                        break;
                    case 1000:
                        if (comprador.cuantasMonedas(1000) > 0) {
                            aux_moneda = comprador.getMoneda(1000);
                            updateLabelMonedasText();
                        }
                        else aux_moneda = null;
                        break;
                    default:
                        break;
                }

                expendedor.addMonedaPago(aux_moneda);
                if (aux_moneda != null) {
                    System.out.println("Moneda de " + aux_moneda.getValor() + " con serie: " + aux_moneda.getSerie() + " agregada al expendedor");
                }
                labelMonedasPagadas.setText("Monto ingresado: " + expendedor.getPago());
                aux_moneda = null;
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
