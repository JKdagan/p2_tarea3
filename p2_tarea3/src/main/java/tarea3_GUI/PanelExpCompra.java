package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Monedas.*;
import Productos.Producto;
//Panel que estará en la tercera fila de PanelExpendedor
public class PanelExpCompra extends JPanel {
    //Label donde se verán imagenes
    public static JLabel labelImagen;
    //boton que retirara el producto comprado y se lo quedara el Comprador
    private BotonRetirarProducto boton_retirar_producto;
    //boton para ir retirando el vuelto de la maquina
    private BotonRetirarVuelto boton_retirar_vuelto;
    //un panel
    private JPanel panel;
    //boton para rellenar los depositos de los productos con la cantidad inicial
    private BotonRellenarDepositos boton_rellenar;
    //imagen que se verá en "donde cae el producto"
    private static ImageIcon imagenActual;
    //Constructor por defecto;
    /*@param color, es un Color que se le añadira al PanelExpCompra
     */
    public PanelExpCompra(Color color) {
        super();
        this.setBackground(color);
        //hacemos que la imagen de "donde cae el producto" sea una imagen en blanco inicialmente simulando que esta vacio y la añadimos al Label donde se ira cambiando la imagen
        imagenActual = new ImageIcon(getClass().getResource("/blanco.jpg"));
        labelImagen = new JLabel(imagenActual);
        //creamos los botones para retirar producto, vuelto y para rellenar los depositos y los añadimos al Panel
        boton_retirar_producto = new BotonRetirarProducto("Retirar producto");
        boton_retirar_vuelto = new BotonRetirarVuelto("Retirar vuelto de a 100");
        boton_rellenar=new BotonRellenarDepositos("Rellenar depositos");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        //hacemos que los botones de retirar se vean a los costados, el de rellenar este en la parte inferior y el label de las imagenes se vea en el centro
        panel.add(boton_retirar_producto,BorderLayout.EAST);
        panel.add(boton_retirar_vuelto,BorderLayout.WEST);
        panel.add(boton_rellenar,BorderLayout.SOUTH);
        panel.add(labelImagen,BorderLayout.CENTER);
        add(panel);

    }
    //Metodo que actualiza la imagen de "donde cae el producto", este se llama luego de una compra exitosa colocando en el Label la imagen del producto que se compró simulando que cayo y ya no está vacio
    /*@param imagen es la Imagen que debe actualizar
     */
    public static void actualizarImagen(ImageIcon imagen) {
        if (imagen != null) {
            Image img = imagen.getImage();
            int ancho = labelImagen.getWidth();
            int alto = labelImagen.getHeight();
            Image newImg = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            imagenActual = new ImageIcon(newImg);
        } else {
            imagenActual = new ImageIcon(PanelExpCompra.class.getResource("/blanco.jpg"));
        }
        labelImagen.setIcon(imagenActual);
    }
    //Boton con escuchador para retirar el producto
    private class BotonRetirarProducto extends JButton {
        public BotonRetirarProducto(String texto) {
            super(texto);
            this.addActionListener(new EscuchadorBoton());
        }

        private class EscuchadorBoton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                //obtenemos el Producto del Expendedor y se lo añadimos al Comprador ya que fue comprado, luego se actuliza el Label de las imagenes a que se vea nuevamente la imagen blanco.jpg para simular que nuevamente esta vacio en donde cae el producto pues se retiró el que habia
                Producto producto = PanelPrincipal.expendedor.getProducto();
                if (producto != null) {
                    PanelPrincipal.comprador.addProducto(producto);
                    actualizarImagen(new ImageIcon(getClass().getResource("/blanco.jpg")));
                }
            }
        }
    }
    //Boton con escuchador para retirar el vuelto de la maquina
    private class BotonRetirarVuelto extends JButton {
        public BotonRetirarVuelto(String texto) {
            super(texto);
            this.addActionListener(new EscuchadorBoton());
        }
        private class EscuchadorBoton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                //obtenemos una Moneda del vuelto, actualizamos el vuelto que queda en la maquina tambien actualizamos el label que muestra el vuelto que hay en la maquina y al mismo tiempo que quitamos una Moneda del deposito de vuelto el comprador recibe una Moneda100 asi que actualizamos tambien el Label que muestra las Monedas que tiene el Comprador
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
    //Boton con escuchador para rellenar los depositos de los productos en la maquina
    private class BotonRellenarDepositos extends JButton {
        public BotonRellenarDepositos(String texto) {
            super(texto);
            this.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //llamamos al metodo del Expendedor que agrega una cantidad dada de productos en cada deposito por igual, luego actualizamos el Label de la informacion que muestra la cantidad de Productos que nos quedan de cada tipo
                    PanelPrincipal.expendedor.llenarDepositos(5);
                    PanelExpProductos.updatePreciosyCantidad();
                }
            });
        }
    }
}
