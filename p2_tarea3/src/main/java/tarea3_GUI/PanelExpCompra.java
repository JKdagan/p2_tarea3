package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Monedas.*;
import Productos.Producto;

public class PanelExpCompra extends JPanel {
    public static JLabel labelImagen;
    private BotonRetirarProducto boton_retirar_producto;
    private BotonRetirarVuelto boton_retirar_vuelto;
    private JPanel panel;
    private BotonRellenarDepositos boton_rellenar;

    public PanelExpCompra(Color color) {
        super();
        this.setBackground(color);

        labelImagen = new JLabel();


        boton_retirar_producto = new BotonRetirarProducto("Retirar producto");
        boton_retirar_vuelto = new BotonRetirarVuelto("Retirar vuelto de a 100");
        boton_rellenar=new BotonRellenarDepositos("Rellenar depositos");



        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(boton_retirar_producto,BorderLayout.EAST);
        panel.add(boton_retirar_vuelto,BorderLayout.WEST);
        panel.add(boton_rellenar,BorderLayout.SOUTH);
        panel.add(labelImagen,BorderLayout.CENTER);

        add(panel);

    }
    public static void actualizarImagen(ImageIcon imagen) {
        if (imagen != null) {
            Image img = imagen.getImage();
            Image newImg = img.getScaledInstance(280, 130, Image.SCALE_SMOOTH);
            imagen = new ImageIcon(newImg);
        }
        labelImagen.setIcon(imagen);
    }

    private class BotonRetirarProducto extends JButton {
        public BotonRetirarProducto(String texto) {
            super(texto);
            this.addActionListener(new EscuchadorBoton());
        }

        private class EscuchadorBoton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Producto producto = PanelPrincipal.expendedor.getProducto();
                if (producto != null) {
                    PanelPrincipal.comprador.addProducto(producto);
                    actualizarImagen(null);
                }
                else {
                    actualizarImagen(null);
                }
            }
        }
    }//PanelExpCompra
    private class BotonRetirarVuelto extends JButton {
        public BotonRetirarVuelto(String texto) {
            super(texto);
            this.addActionListener(new EscuchadorBoton());
        }

        private class EscuchadorBoton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Moneda aux = PanelPrincipal.expendedor.getMonedaVuelto();
                if (aux != null) {
                    PanelExpDinero.actualizarVuelto(PanelPrincipal.expendedor.calcularVuelto());
                    PanelPrincipal.comprador.addMoneda(aux);
                    PanelExpendedor.updateLabelMonedasPagadas();
                    PanelComprador.updateLabelMonedasText();
                }
            }
        }
    }
    private class BotonRellenarDepositos extends JButton {
        public BotonRellenarDepositos(String texto) {
            super(texto);
            this.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    PanelPrincipal.expendedor.llenarDepositos(5);
                    PanelExpProductos.updatePreciosyCantidad();
                }
            });
        }
    }
}
