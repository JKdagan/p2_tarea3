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
        JPanel panelbotonesRetirar=new JPanel();
        panelbotonesRetirar.add(boton_retirar_producto);
        panelbotonesRetirar.add(boton_retirar_vuelto);


        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(panelbotonesRetirar,BorderLayout.NORTH);
        panel.add(boton_rellenar,BorderLayout.SOUTH);
        panel.add(labelImagen,BorderLayout.CENTER);

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
        labelImagen.setBounds(x-65,y-35,280,140);
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
