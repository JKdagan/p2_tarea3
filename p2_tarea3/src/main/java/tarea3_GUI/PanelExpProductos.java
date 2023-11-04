package tarea3_GUI;

import Excepciones.*;
import Productos.*;
import tarea3_logica.Expendedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

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
    private JLabel fraseCocaCola;
    private JLabel fraseSprite;
    private JLabel fraseFanta;
    private JLabel fraseSuper8;
    private JLabel fraseSnickers;

    private Expendedor expendedor;

    public PanelExpProductos(Color color, Expendedor expendedor) {
        this.expendedor = expendedor;
        this.setBackground(color);
        this.setLayout(new BorderLayout());

        //botones
        this.inicializarBotonesProductos();

        //cargar imagenes
        this.inicializarImagenesProductos();

        //poner imagenes
        this.ajustarImagenesProductos();

        //precios y cantidad
        this.mostrarPreciosyCantidad();

    }

    private void inicializarImagenesProductos() {
        imagenCoca = new ImageIcon(getClass().getResource("/CocaCola.jpeg"));
        imagenSprite = new ImageIcon(getClass().getResource("/Sprite.jpeg"));
        imagenFanta = new ImageIcon(getClass().getResource("/Fanta.jpeg"));
        imagenSuper8 = new ImageIcon(getClass().getResource("/Super8.jpeg"));
        imagenSnickers = new ImageIcon(getClass().getResource("/Snickers.jpeg"));
        imagenCoca.setImage(imagenCoca.getImage().getScaledInstance(60, 110, Image.SCALE_DEFAULT));
        imagenSprite.setImage(imagenSprite.getImage().getScaledInstance(60, 110, Image.SCALE_DEFAULT));
        imagenFanta.setImage(imagenFanta.getImage().getScaledInstance(60, 110, Image.SCALE_DEFAULT));
        imagenSuper8.setImage(imagenSuper8.getImage().getScaledInstance(130, 80, Image.SCALE_DEFAULT));
        imagenSnickers.setImage(imagenSnickers.getImage().getScaledInstance(130, 80, Image.SCALE_DEFAULT));
    }
    private void ajustarImagenesProductos() {
        this.labelCoca = new JLabel(imagenCoca);
        this.labelSprite = new JLabel(imagenSprite);
        this.labelFanta = new JLabel(imagenFanta);
        this.labelSuper8 = new JLabel(imagenSuper8);
        this.labelSnickers = new JLabel(imagenSnickers);
        this.imagenesPanel = new JPanel();
        this.imagenesPanel.setLayout(new BoxLayout(imagenesPanel, BoxLayout.LINE_AXIS));
        this.imagenesPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        this.imagenesPanel.add(labelCoca);
        this.imagenesPanel.add(Box.createRigidArea(new Dimension(70, 0)));
        this.imagenesPanel.add(labelSprite);
        this.imagenesPanel.add(Box.createRigidArea(new Dimension(70, 0)));
        this.imagenesPanel.add(labelFanta);
        this.imagenesPanel.add(Box.createRigidArea(new Dimension(70, 0)));
        this.imagenesPanel.add(labelSuper8);
        this.imagenesPanel.add(Box.createRigidArea(new Dimension(70, 0)));
        this.imagenesPanel.add(labelSnickers);
        add(imagenesPanel, BorderLayout.SOUTH);
    }
    private void inicializarBotonesProductos() {
        this.boton_CocaCola = new BotonesProductos("1. CocaCola", ProductEnum.COCA_COLA);
        this.boton_Sprite = new BotonesProductos("2. Sprite", ProductEnum.SPRITE);
        this.boton_Fanta = new BotonesProductos("3. Fanta", ProductEnum.FANTA);
        this.boton_Super8 = new BotonesProductos("4. Super8", ProductEnum.SUPER8);
        this.boton_Snickers = new BotonesProductos("5. Snickers", ProductEnum.SNICKERS);
        this.botonesPanel = new JPanel();
        this.botonesPanel.add(boton_CocaCola);
        this.botonesPanel.add(boton_Sprite);
        this.botonesPanel.add(boton_Fanta);
        this.botonesPanel.add(boton_Super8);
        this.botonesPanel.add(boton_Snickers);
        this.botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.LINE_AXIS));//alinear horizontal
        this.botonesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);//centrarlos
        this.botones_centradosPanel = new JPanel();
        this.botones_centradosPanel.setLayout(new BoxLayout(botones_centradosPanel, BoxLayout.LINE_AXIS));
        this.botones_centradosPanel.add(Box.createHorizontalGlue());
        this.botones_centradosPanel.add(botonesPanel);
        this.botones_centradosPanel.add(Box.createHorizontalGlue());
        add(botones_centradosPanel, BorderLayout.NORTH);//ponerlo en la parte superior
    }
    private void mostrarPreciosyCantidad() {
        this.fraseCocaCola = new JLabel("<html>Precio: $1200<br>Disponibles:" + PanelPrincipal.expendedor.dep_cocacola.cuantoHay() + "</html>");
        this.fraseSprite = new JLabel("<html>Precio:$1200<br>Disponibles:"+ PanelPrincipal.expendedor.dep_sprite.cuantoHay() + "</html>");
        this.fraseFanta = new JLabel("<html>Precio:$1000<br>Disponibles:"+ PanelPrincipal.expendedor.dep_fanta.cuantoHay() + "</html>");
        this.fraseSuper8 = new JLabel("<html>Precio:$300<br>Disponibles:"+ PanelPrincipal.expendedor.dep_super8.cuantoHay() + "</html>");
        this.fraseSnickers = new JLabel("<html>Precio:$400<br>Disponibles:"+ PanelPrincipal.expendedor.dep_snickers.cuantoHay() + "</html>");
        this.frasesPanel = new JPanel();
        this.frasesPanel.setLayout(new BoxLayout(frasesPanel, BoxLayout.LINE_AXIS));
        this.fraseCocaCola.setHorizontalAlignment(SwingConstants.CENTER);
        this.fraseSprite.setHorizontalAlignment(SwingConstants.CENTER);
        this.fraseFanta.setHorizontalAlignment(SwingConstants.CENTER);
        this.fraseSuper8.setHorizontalAlignment(SwingConstants.CENTER);
        this.fraseSnickers.setHorizontalAlignment(SwingConstants.CENTER);
        this.frasesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        this.frasesPanel.add(fraseCocaCola);
        this.frasesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        this.frasesPanel.add(fraseSprite);
        this.frasesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        this.frasesPanel.add(fraseFanta);
        this.frasesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        this.frasesPanel.add(fraseSuper8);
        this.frasesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        this.frasesPanel.add(fraseSnickers);
        add(frasesPanel, BorderLayout.CENTER);
    }
    private class BotonesProductos extends JButton {

    ProductEnum producto;
    public BotonesProductos(String nombre, ProductEnum cualProducto) {
        super(nombre);
        this.producto = cualProducto;
        this.addActionListener(new EscuchadorBoton());
    }
    private class EscuchadorBoton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                expendedor.elegirProducto(producto);
                expendedor.comprarProducto();
                PanelExpDinero.updateLabelMonedasPagadas();

                if (expendedor.flag_deposito_ocupado == false) {
                    //como la compra fue exitosa que se vea la imagen en PanelExpCompra, luego hay que acomodar dimensiones y tamaño para que se vea dentro del rectangulo

                    switch(producto){
                        case COCA_COLA -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/CocaCola.jpeg")));
                        case FANTA -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Fanta.jpeg")));
                        case SPRITE -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Sprite.jpeg")));
                        case SUPER8 -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Super8.jpeg")));
                        case SNICKERS -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Snickers.jpeg")));
                    }
                }


            }
            catch (NoHayProductoException ex) {
                // "NoHayProductoException"
            } catch (PagoIncorrectoException ex) {
                // "PagoIncorrectoException"
            } catch (PagoInsuficienteException ex) {
                // "PagoInsuficienteException"
            } catch (DepositoOcupadoException ex) {
                System.out.println("El deposito de salida esta ocupado, retire el producto antes de la siguiente compra");
                System.out.println(PanelPrincipal.expendedor.getPago());
                //"DepositoOcupadoException"
            }// EN LAS EXECPCIONES TENEMOS QUE PONER LAS VENTANAS EMERGENTES
        }
    }

    }
}
