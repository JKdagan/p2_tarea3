package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Productos.*;
import tarea3_logica.*;
import javax.swing.border.EmptyBorder;

public class PanelExpCompra extends JPanel {
    private static JLabel labelImagen;
    private BotonRetirarProducto boton_retirar_producto;
    private JPanel panel;
    private Expendedor expendedor;

    public PanelExpCompra(Color color, Expendedor expendedor) {
        super();
        this.expendedor = expendedor;
        this.setBackground(color);

        labelImagen = new JLabel();
        add(labelImagen);

        boton_retirar_producto = new BotonRetirarProducto("Retirar producto");
        panel = new JPanel();
        panel.add(boton_retirar_producto);
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(panel, BorderLayout.EAST);

    }
    public static void actualizarImagen(ImageIcon imagen) {
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
                Producto producto = expendedor.getProducto();
                if (producto != null) {
                    PanelPrincipal.comprador.addProducto(producto);
                    actualizarImagen(null);
                }
                else {
                    actualizarImagen(null);
                }
            }
        }
    }
}
