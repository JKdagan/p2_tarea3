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

    public PanelExpCompra(Color color) {
        super();
        this.setBackground(color);

        labelImagen = new JLabel();
        add(labelImagen);

        boton_retirar_producto = new BotonRetirarProducto("Retirar producto");
        boton_retirar_vuelto = new BotonRetirarVuelto("Retirar vuelto de a 100");
        panel = new JPanel();
        panel.add(boton_retirar_producto);
        panel.add(boton_retirar_vuelto);
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(panel);

    }
    public static void actualizarImagen(ImageIcon imagen) {
        if (imagen != null) {
            Image img = imagen.getImage();
            Image newImg = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
            imagen = new ImageIcon(newImg);
        }
        labelImagen.setIcon(imagen);
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
}
