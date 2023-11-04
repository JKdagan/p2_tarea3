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
    private JPanel botones_superior;
    private JPanel botones_inferior;
    private JPanel monedas_panel;
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
        imagenComprador = new ImageIcon(getClass().getResource("/Comprador.jpeg"));
        if (imagenComprador != null) {
            imagenComprador.setImage(imagenComprador.getImage().getScaledInstance(200, 500, Image.SCALE_DEFAULT));
            JLabel label = new JLabel(imagenComprador);
            add(label, BorderLayout.CENTER);
        }

        //Botones para darle monedas al comprador y pagar en expendedor
        this.inicializarBotones();

        //Mostrar dinero del comprador
        this.mostrarMonedasComprador();

    }

    public void updateLabelMonedasText() {
        labelMonedas100.setText("Monedas de 100: " + comprador.cuantasMonedas(100));
        labelMonedas500.setText("Monedas de 500: " + comprador.cuantasMonedas(500));
        labelMonedas1000.setText("Monedas de 1000: " + comprador.cuantasMonedas(1000));
    }
    private void inicializarBotones() {
        //botones para pagar
        this.botones_superior = new JPanel();
        this.botones_superior.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.boton_pagar100 = new BotonesPagoExpendedor("Pagar en maquina con 100", 100);
        this.boton_pagar500 = new BotonesPagoExpendedor("Pagar en maquina con 500", 500);
        this.boton_pagar1000 = new BotonesPagoExpendedor("Pagar en maquina con 1000", 1000);
        this.botones_superior.add(boton_pagar100);
        this.botones_superior.add(boton_pagar500);
        this.botones_superior.add(boton_pagar1000);
        add(botones_superior, BorderLayout.NORTH);

        //botones para darle mas dinero al comprador
        this.botones_inferior = new JPanel();
        this.botones_inferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.boton_add100 = new BotonesMonedaComprador("Añadirme una Moneda de 100",100);
        this.boton_add500 = new BotonesMonedaComprador("Añadirme una Moneda de 500",500);
        this.boton_add1000 = new BotonesMonedaComprador("Añadirme una Moneda de 1000",1000);
        this.botones_inferior.add(boton_add100);
        this.botones_inferior.add(boton_add500);
        this.botones_inferior.add(boton_add1000);
        add(botones_inferior, BorderLayout.SOUTH);
    }
    private void mostrarMonedasComprador() {
        this.labelMonedas100 = new JLabel("Monedas de 100: " + comprador.cuantasMonedas(100));
        this.labelMonedas500 = new JLabel("Monedas de 500: " + comprador.cuantasMonedas(500));
        this.labelMonedas1000 = new JLabel("Monedas de 1000: " + comprador.cuantasMonedas(1000));
        this.monedas_panel = new JPanel();
        this.monedas_panel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Utilizar FlowLayout alineado a la izquierda
        this.monedas_panel.add(labelMonedas100);
        this.monedas_panel.add(labelMonedas500);
        this.monedas_panel.add(labelMonedas1000);
        add(monedas_panel, BorderLayout.WEST);
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
