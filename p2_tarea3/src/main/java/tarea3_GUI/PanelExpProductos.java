package tarea3_GUI;

import Excepciones.*;
import Productos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Panel que estará en la segunda fila del PanelExpendedor
public class PanelExpProductos extends JPanel {
    //tendra imagenes de los productos que hay en la maquina
    private ImageIcon imagenCoca;
    private ImageIcon imagenSprite;
    private ImageIcon imagenFanta;
    private ImageIcon imagenSuper8;
    private ImageIcon imagenSnickers;
    //un Panel donde iran los Label de cada Producto, estos tendran las imagenes de cada Producto
    private JPanel imagenesPanel;
    private JLabel labelCoca;
    private JLabel labelSprite;
    private JLabel labelFanta;
    private JLabel labelSuper8;
    private JLabel labelSnickers;
    //Panel donde irán los Labels donde se verá la informacion de dicho producto
    private JPanel frasesPanel;
    private static JLabel fraseCocaCola;
    private static JLabel fraseSprite;
    private static JLabel fraseFanta;
    private static JLabel fraseSuper8;
    private static JLabel fraseSnickers;
    //Paneles para los botones
    private JPanel botonesPanel;
    private JPanel botones_centradosPanel;
    //Botones para seleccionar el Producto que se quiere comprar
    private BotonesProductos boton_CocaCola;
    private BotonesProductos boton_Sprite;
    private BotonesProductos boton_Fanta;
    private BotonesProductos boton_Super8;
    private BotonesProductos boton_Snickers;


    public PanelExpProductos(Color color) {
        this.setBackground(color);
        this.setLayout(new BorderLayout());

        //aparecen los botones en el panel
        this.inicializarBotonesProductos();

        //carga las imagenes en el panel
        this.mostrarImagenesProductos();

        //precios y cantidad
        this.mostrarPreciosyCantidad();

    }
    //Metodo que hace que se vean los botones
    private void inicializarBotonesProductos() {
        //un boton por cada producto, accediendo cada uno a un valor de la enumeracion que indica que producto es
        boton_CocaCola = new BotonesProductos("1. CocaCola", ProductEnum.COCA_COLA);
        boton_Sprite = new BotonesProductos("2. Sprite", ProductEnum.SPRITE);
        boton_Fanta = new BotonesProductos("3. Fanta", ProductEnum.FANTA);
        boton_Super8 = new BotonesProductos("4. Super8", ProductEnum.SUPER8);
        boton_Snickers = new BotonesProductos("5. Snickers", ProductEnum.SNICKERS);
        //Panel donde añadiremos los botones
        botonesPanel = new JPanel();
        botonesPanel.add(boton_CocaCola);
        botonesPanel.add(boton_Sprite);
        botonesPanel.add(boton_Fanta);
        botonesPanel.add(boton_Super8);
        botonesPanel.add(boton_Snickers);
        botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.LINE_AXIS));//alinearlos horizontalmente
        botonesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);//centrarlos
        botones_centradosPanel = new JPanel();//nuevo panel
        botones_centradosPanel.setLayout(new BoxLayout(botones_centradosPanel, BoxLayout.LINE_AXIS));//alinearlos horizontalmente
        botones_centradosPanel.add(Box.createHorizontalGlue());
        botones_centradosPanel.add(botonesPanel);
        botones_centradosPanel.add(Box.createHorizontalGlue());
        //hacemos que este panel donde están los botones para seleccionar que producto se vea en la parte superior
        add(botones_centradosPanel, BorderLayout.NORTH);
    }
    //Metodo que hace que se vean las imagenes
    private void mostrarImagenesProductos() {
        //A cada imagen le seleccionamos la imagen que queremos que se vea y le damos un tamaño especifico
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
        //añadimos cada imagen a su Label correspondiente
        labelCoca = new JLabel(imagenCoca);
        labelSprite = new JLabel(imagenSprite);
        labelFanta = new JLabel(imagenFanta);
        labelSuper8 = new JLabel(imagenSuper8);
        labelSnickers = new JLabel(imagenSnickers);
        //un Panel donde estaran todos los label de los productos
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
        //hacemos que este Panel donde estan las imagenes de los productos se vea en la parte inferior del panel
        add(imagenesPanel, BorderLayout.SOUTH);
    }
    //Metodo que hace que se vean las informaciones de los productos
    private void mostrarPreciosyCantidad() {
        //Labels que contendran los precios(fijos) de cada producto y las cantidad que quedan en el expendedor de este mismo
        fraseCocaCola = new JLabel("<html>Precio: $1200<br>Disponibles:" + PanelPrincipal.expendedor.dep_cocacola.cuantoHay() + "</html>");
        fraseSprite = new JLabel("<html>Precio:$1200<br>Disponibles:"+ PanelPrincipal.expendedor.dep_sprite.cuantoHay() + "</html>");
        fraseFanta = new JLabel("<html>Precio:$1000<br>Disponibles:"+ PanelPrincipal.expendedor.dep_fanta.cuantoHay() + "</html>");
        fraseSuper8 = new JLabel("<html>Precio:$300<br>Disponibles:"+ PanelPrincipal.expendedor.dep_super8.cuantoHay() + "</html>");
        fraseSnickers = new JLabel("<html>Precio:$400<br>Disponibles:"+ PanelPrincipal.expendedor.dep_snickers.cuantoHay() + "</html>");
        //Panel donde pondremos los Labels de informacion
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
        //hacemos que este panel donde se verán las infromaciones de los productos se vea en el centro
        add(frasesPanel, BorderLayout.CENTER);
    }
    //Metodo que actualiza la cantidad que quedan de los productos despues de una compra exitosa
    static void updatePreciosyCantidad() {
        fraseCocaCola.setText("<html>Precio: $1200<br>Disponibles:" + PanelPrincipal.expendedor.dep_cocacola.cuantoHay() + "</html>");
        fraseSprite.setText("<html>Precio:$1200<br>Disponibles:"+ PanelPrincipal.expendedor.dep_sprite.cuantoHay() + "</html>");
        fraseFanta.setText("<html>Precio:$1000<br>Disponibles:"+ PanelPrincipal.expendedor.dep_fanta.cuantoHay() + "</html>");
        fraseSuper8.setText("<html>Precio:$300<br>Disponibles:"+ PanelPrincipal.expendedor.dep_super8.cuantoHay() + "</html>");
        fraseSnickers.setText("<html>Precio:$400<br>Disponibles:"+ PanelPrincipal.expendedor.dep_snickers.cuantoHay() + "</html>");
    }
    //Botones con escuchadores que interactuan con la compra
    private class BotonesProductos extends JButton {
        //el Producto el cual queremos comprar
        ProductEnum producto;
        public BotonesProductos(String nombre, ProductEnum cualProducto) {
            super(nombre);
            producto = cualProducto;
            this.addActionListener(new EscuchadorBoton());
        }
        private class EscuchadorBoton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                try {
                    //Seleccionamos el producto
                    PanelPrincipal.expendedor.elegirProducto(producto);
                    //Mandamos a comprar el producto(compra existosa)
                    PanelPrincipal.expendedor.comprarProducto();
                    //Actualizamos las monedas que hay en el Expendedor luego de una compra exitosa a 0
                    PanelExpendedor.updateLabelMonedasPagadas();
                    //Siempre que la excepcion de que el deposito donde cae el producto comprado no este ocupada, se podrá comprar
                    if (PanelPrincipal.expendedor.flag_deposito_ocupado == false) {
                        //como la compra fue exitosa que se vea la imagen en PanelExpCompra simulando que cayó el Producto comprado
                        //switch para segun que producto es
                        switch (producto) {
                            case COCA_COLA -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/CocaCola.jpeg")));
                            case FANTA -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Fanta.jpeg")));
                            case SPRITE -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Sprite.jpeg")));
                            case SUPER8 -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Super8.jpeg")));
                            case SNICKERS -> PanelExpCompra.actualizarImagen(new ImageIcon(getClass().getResource("/Snickers.jpeg")));
                        }
                        //actualizamos la cantidad de productos que hay ahora ya que despues de una compra ya que deberia decrecer en uno los productos que hay en el deposito de dicho producto comprado
                        updatePreciosyCantidad();
                        //calculamos el vuelto correspondiente segun el dinero que ingresamos a la maquina y el precio de lo que compramos
                        int vuelto = PanelPrincipal.expendedor.calcularVuelto();
                        //actualizamos el Label del vuelto para que se vea lo correspondiente
                        PanelExpDinero.actualizarVuelto(vuelto);
                    }

                } //segun que excepcion ocurra se abrirá una ventana emergente con un texto que indique porque no se pudo realizar la compra
                catch (NoHayProductoException ex) {
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

