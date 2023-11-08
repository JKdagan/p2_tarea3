package tarea3_GUI;

import Excepciones.*;
import Productos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelExpProductos extends JPanel {

    private ImageIcon imagenCoca;
    private ImageIcon imagenSprite;
    private ImageIcon imagenFanta;
    private ImageIcon imagenSuper8;
    private ImageIcon imagenSnickers;
    private JPanel imagenesPanel;
    private JLabel labelCoca;
    private JLabel labelSprite;
    private JLabel labelFanta;
    private JLabel labelSuper8;
    private JLabel labelSnickers;
    private JPanel botonesPanel;
    private JPanel botones_centradosPanel;
    private JPanel frasesPanel;
    private BotonesProductos boton_CocaCola;
    private BotonesProductos boton_Sprite;
    private BotonesProductos boton_Fanta;
    private BotonesProductos boton_Super8;
    private BotonesProductos boton_Snickers;
    private static JLabel fraseCocaCola;
    private static JLabel fraseSprite;
    private static JLabel fraseFanta;
    private static JLabel fraseSuper8;
    private static JLabel fraseSnickers;

    public PanelExpProductos(Color color) {
        this.setBackground(color);
        this.setLayout(new BorderLayout());

        //botones
        this.inicializarBotonesProductos();

        //cargar imagenes
        this.mostrarImagenesProductos();

        //precios y cantidad
        this.mostrarPreciosyCantidad();

    }
    private void inicializarBotonesProductos() {
        boton_CocaCola = new BotonesProductos("1. CocaCola", ProductEnum.COCA_COLA);
        boton_Sprite = new BotonesProductos("2. Sprite", ProductEnum.SPRITE);
        boton_Fanta = new BotonesProductos("3. Fanta", ProductEnum.FANTA);
        boton_Super8 = new BotonesProductos("4. Super8", ProductEnum.SUPER8);
        boton_Snickers = new BotonesProductos("5. Snickers", ProductEnum.SNICKERS);
        botonesPanel = new JPanel();
        botonesPanel.add(boton_CocaCola);
        botonesPanel.add(boton_Sprite);
        botonesPanel.add(boton_Fanta);
        botonesPanel.add(boton_Super8);
        botonesPanel.add(boton_Snickers);
        botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.LINE_AXIS));//alinear horizontal
        botonesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);//centrarlos
        botones_centradosPanel = new JPanel();
        botones_centradosPanel.setLayout(new BoxLayout(botones_centradosPanel, BoxLayout.LINE_AXIS));
        botones_centradosPanel.add(Box.createHorizontalGlue());
        botones_centradosPanel.add(botonesPanel);
        botones_centradosPanel.add(Box.createHorizontalGlue());
        add(botones_centradosPanel, BorderLayout.NORTH);//ponerlo en la parte superior
    }
    private void mostrarImagenesProductos() {
        imagenCoca = new ImageIcon(getClass().getResource("/CocaCola.jpeg"));
        imagenSprite = new ImageIcon(getClass().getResource("/Sprite.jpeg"));
        imagenFanta = new ImageIcon(getClass().getResource("/Fanta.jpeg"));
        imagenSuper8 = new ImageIcon(getClass().getResource("/Super8.jpeg"));
        imagenSnickers = new ImageIcon(getClass().getResource("/Snickers.jpeg"));
        imagenSprite.setImage(imagenSprite.getImage().getScaledInstance(60, 110, Image.SCALE_DEFAULT));
        imagenFanta.setImage(imagenFanta.getImage().getScaledInstance(60, 110, Image.SCALE_DEFAULT));
        imagenSuper8.setImage(imagenSuper8.getImage().getScaledInstance(130, 80, Image.SCALE_DEFAULT));
        imagenCoca.setImage(imagenCoca.getImage().getScaledInstance(60, 110, Image.SCALE_DEFAULT));
        imagenSnickers.setImage(imagenSnickers.getImage().getScaledInstance(130, 80, Image.SCALE_DEFAULT));
        labelCoca = new JLabel(imagenCoca);
        labelSprite = new JLabel(imagenSprite);
        labelFanta = new JLabel(imagenFanta);
        labelSuper8 = new JLabel(imagenSuper8);
        labelSnickers = new JLabel(imagenSnickers);
        imagenesPanel = new JPanel();
        imagenesPanel.setLayout(new BoxLayout(imagenesPanel, BoxLayout.LINE_AXIS));
        imagenesPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        imagenesPanel.add(labelCoca);
        imagenesPanel.add(Box.createRigidArea(new Dimension(70, 0)));
        imagenesPanel.add(labelSprite);
        imagenesPanel.add(Box.createRigidArea(new Dimension(70, 0)));
        imagenesPanel.add(labelFanta);
        imagenesPanel.add(Box.createRigidArea(new Dimension(70, 0)));
        imagenesPanel.add(labelSuper8);
        imagenesPanel.add(Box.createRigidArea(new Dimension(70, 0)));
        imagenesPanel.add(labelSnickers);
        add(imagenesPanel, BorderLayout.SOUTH);
    }
    private void mostrarPreciosyCantidad() {
        fraseCocaCola = new JLabel("<html>Precio: $1200<br>Disponibles:" + PanelPrincipal.expendedor.dep_cocacola.cuantoHay() + "</html>");
        fraseSprite = new JLabel("<html>Precio:$1200<br>Disponibles:"+ PanelPrincipal.expendedor.dep_sprite.cuantoHay() + "</html>");
        fraseFanta = new JLabel("<html>Precio:$1000<br>Disponibles:"+ PanelPrincipal.expendedor.dep_fanta.cuantoHay() + "</html>");
        fraseSuper8 = new JLabel("<html>Precio:$300<br>Disponibles:"+ PanelPrincipal.expendedor.dep_super8.cuantoHay() + "</html>");
        fraseSnickers = new JLabel("<html>Precio:$400<br>Disponibles:"+ PanelPrincipal.expendedor.dep_snickers.cuantoHay() + "</html>");
        frasesPanel = new JPanel();
        frasesPanel.setLayout(new BoxLayout(frasesPanel, BoxLayout.LINE_AXIS));
        fraseCocaCola.setHorizontalAlignment(SwingConstants.CENTER);
        fraseSprite.setHorizontalAlignment(SwingConstants.CENTER);
        fraseFanta.setHorizontalAlignment(SwingConstants.CENTER);
        fraseSuper8.setHorizontalAlignment(SwingConstants.CENTER);
        fraseSnickers.setHorizontalAlignment(SwingConstants.CENTER);
        frasesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        frasesPanel.add(fraseCocaCola);
        frasesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        frasesPanel.add(fraseSprite);
        frasesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        frasesPanel.add(fraseFanta);
        frasesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        frasesPanel.add(fraseSuper8);
        frasesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        frasesPanel.add(fraseSnickers);
        add(frasesPanel, BorderLayout.CENTER);
    }
    static void updatePreciosyCantidad() {
        fraseCocaCola.setText("<html>Precio: $1200<br>Disponibles:" + PanelPrincipal.expendedor.dep_cocacola.cuantoHay() + "</html>");
        fraseSprite.setText("<html>Precio:$1200<br>Disponibles:"+ PanelPrincipal.expendedor.dep_sprite.cuantoHay() + "</html>");
        fraseFanta.setText("<html>Precio:$1000<br>Disponibles:"+ PanelPrincipal.expendedor.dep_fanta.cuantoHay() + "</html>");
        fraseSuper8.setText("<html>Precio:$300<br>Disponibles:"+ PanelPrincipal.expendedor.dep_super8.cuantoHay() + "</html>");
        fraseSnickers.setText("<html>Precio:$400<br>Disponibles:"+ PanelPrincipal.expendedor.dep_snickers.cuantoHay() + "</html>");
    }
    private class BotonesProductos extends JButton {

        ProductEnum producto;

        public BotonesProductos(String nombre, ProductEnum cualProducto) {
            super(nombre);
            producto = cualProducto;
            this.addActionListener(new EscuchadorBoton());
        }

        private class EscuchadorBoton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                try {
                    PanelPrincipal.expendedor.elegirProducto(producto);
                    PanelPrincipal.expendedor.comprarProducto();
                    PanelExpendedor.updateLabelMonedasPagadas();

                    if (PanelPrincipal.expendedor.flag_deposito_ocupado == false) {
                        //como la compra fue exitosa que se vea la imagen en PanelExpCompra, luego hay que acomodar dimensiones y tamaño para que se vea dentro del rectangulo

                        switch (producto) {
                            case COCA_COLA -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/CocaCola.jpeg")));
                            case FANTA -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Fanta.jpeg")));
                            case SPRITE -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Sprite.jpeg")));
                            case SUPER8 -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Super8.jpeg")));
                            case SNICKERS -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Snickers.jpeg")));
                        }
                        updatePreciosyCantidad();

                        int vuelto = PanelPrincipal.expendedor.calcularVuelto();
                        PanelExpDinero.actualizarVuelto(vuelto);

                    }

                } catch (NoHayProductoException ex) {
                    JOptionPane.showMessageDialog(null, "No hay suficientes productos disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null, "El pago ingresado es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (PagoInsuficienteException ex) {
                    JOptionPane.showMessageDialog(null, "El pago es insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (DepositoOcupadoException ex) {
                    JOptionPane.showMessageDialog(null, "El depósito de salida está ocupado, retire el producto para seguir comprando", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
}

