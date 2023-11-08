package tarea3_GUI;

import Monedas.*;
import Productos.Producto;
import tarea3_logica.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//Panel que asignamos para mostrar al Comprador(sus Productos y sus Monedas), en este interactua para añadirle Monedas al Expendedor
public class PanelComprador extends JPanel {
    //Imagen en representación de un Comprador
    private ImageIcon imagenComprador;
    //Labels que muestran la cantidad de monedas 100,500 y 100, tambien uno para mostrar las monedas ingresadas al Expendedor
    private static JLabel labelMonedas100;
    private static JLabel labelMonedas500;
    private static JLabel labelMonedas1000;
    private static JLabel labelMonedasPagadas;
    //Labels en donde abran botones para interactuar con la maquina y con el cliente
    private JPanel botones_superior;
    private JPanel botones_inferior;
    private JPanel monedas_panel;
    //Respectivos botones dichos arriba
    private BotonesMonedaComprador boton_add100;
    private BotonesMonedaComprador boton_add500;
    private BotonesMonedaComprador boton_add1000;
    private BotonesPagoExpendedor boton_pagar100;
    private BotonesPagoExpendedor boton_pagar500;
    private BotonesPagoExpendedor boton_pagar1000;
    //Botones especiales que abren ventanas con informacion del Comprador
    private JButton botonAbrirVentana;
    private BotonBolsillo botonBolsillo;
    //Constructor por defecto; le añadimos un color de fondo y un Layout, luego llamamos a los metodos explicados abajo
    /*@param color, es un Color que se le añadirá a PanelComprador
     */
    public PanelComprador(Color color) {
        super();
        this.labelMonedasPagadas = labelMonedasPagadas;
        this.setBackground(color);
        this.setLayout(new BorderLayout());
        //Mostrar imagen del comprador
        this.mostrarFotoComprador();
        //Botones para darle monedas al comprador y pagar en expendedor
        this.inicializarBotones();
        //Mostrar dinero del comprador
        this.mostrarMonedasComprador();
    }
    //Muestra una ventana emergente en la que queremos mostrar la informacion de Productos que posee el Comprador
    public class CustomOptionPane extends JOptionPane {
        public static void showCustomDialog(String message) {
            JOptionPane inventario = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            JDialog dialog = inventario.createDialog("Inventario del comprador");
            dialog.setVisible(true);
        }
    }



    //Metodo que actualiza el texto de los Labels que muestran las Monedas que posee el Comprador(accediendo a metodo "cuantasMonedas" de este), además le añadimos un color para diferenciar cada tipo de Moneda
    public static void updateLabelMonedasText() {
        labelMonedas100.setText("<html><font color='blue'>Monedas de 100:</font> " + PanelPrincipal.comprador.cuantasMonedas(100) + "</html>");
        labelMonedas500.setText("<html><font color='red'>Monedas de 500:</font> " + PanelPrincipal.comprador.cuantasMonedas(500) + "</html>");
        labelMonedas1000.setText("<html><font color='green'>Monedas de 1000:</font> " + PanelPrincipal.comprador.cuantasMonedas(1000) + "</html>");
    }

    //Boton con escuchador, hace que se abra la VentanaBolsillo
    private class BotonBolsillo extends JButton {
        public BotonBolsillo(String texto) {
            super(texto);
            this.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    VentanaBolsillo ventana = new VentanaBolsillo();
                    ventana.setVisible(true);
                }
            });
        }
    }

    //Metodo para que inicializar todos los botones que hay en el panel, los botones para interactuar con la maquina están arriba y los botones interactuar con el comprador están abajo
    private void inicializarBotones() {
        //botones para pagar
        botones_superior = new JPanel();
        botones_superior.setLayout(new FlowLayout(FlowLayout.RIGHT));
        boton_pagar100 = new BotonesPagoExpendedor("Pagar en maquina con 100", 100);
        boton_pagar500 = new BotonesPagoExpendedor("Pagar en maquina con 500", 500);
        boton_pagar1000 = new BotonesPagoExpendedor("Pagar en maquina con 1000", 1000);
        botones_superior.add(boton_pagar100);
        botones_superior.add(boton_pagar500);
        botones_superior.add(boton_pagar1000);
        add(botones_superior, BorderLayout.NORTH);

        //botones para darle mas dinero al comprador
        botones_inferior = new JPanel();
        botones_inferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
        boton_add100 = new BotonesMonedaComprador("Añadirme una Moneda de 100",100);
        boton_add500 = new BotonesMonedaComprador("Añadirme una Moneda de 500",500);
        boton_add1000 = new BotonesMonedaComprador("Añadirme una Moneda de 1000",1000);
        botones_inferior.add(boton_add100);
        botones_inferior.add(boton_add500);
        botones_inferior.add(boton_add1000);
        add(botones_inferior, BorderLayout.SOUTH);

        //boton del inventario
        botonAbrirVentana = new JButton("Inventario");
        botonAbrirVentana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarProductosComprador();
            }
        });
        botones_superior.add(botonAbrirVentana);

        //boton del bolsillo
        botonBolsillo = new BotonBolsillo("Bolsillo");
        botones_superior.add(botonBolsillo);
    }

    //Metodo que los Productos que posee el Comprador en su ArrayList de Productos; si no se ha realizado ninguna compra aún dirá que no se ha comprado nada, y cada vez que se compre algo se añadira el nombre del Producto a la Ventana acumulandose hacia abajo
    private void mostrarProductosComprador() {
        if (PanelPrincipal.comprador != null) {
            ArrayList<Producto> productos = PanelPrincipal.comprador.getProductos();
            if (!productos.isEmpty()) {
                StringBuilder mensaje = new StringBuilder("Inventario:\n");
                for (Producto producto : productos) {
                    mensaje.append(producto.getNombre() + ":" + producto.getSerie()).append("\n");
                }
                JOptionPane.showMessageDialog(this, mensaje.toString(), "Productos del Comprador", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "El comprador no ha comprado nada aún.", "Productos del Comprador", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    //Metodo que muestra las Monedas que posee el Comprador en ese momento
    private void mostrarMonedasComprador() {
        labelMonedas100 = new JLabel("Monedas de 100: " + PanelPrincipal.comprador.cuantasMonedas(100));
        labelMonedas500 = new JLabel("Monedas de 500: " + PanelPrincipal.comprador.cuantasMonedas(500));
        labelMonedas1000 = new JLabel("Monedas de 1000: " + PanelPrincipal.comprador.cuantasMonedas(1000));
        monedas_panel = new JPanel();
        monedas_panel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Utiliza FlowLayout alineado a la izquierda
        monedas_panel.add(labelMonedas100);
        monedas_panel.add(labelMonedas500);
        monedas_panel.add(labelMonedas1000);
        add(monedas_panel, BorderLayout.WEST);
    }

    //Metodo que muestra simplemente una imagen de una persona simulando un cliente
    private void mostrarFotoComprador() {
        imagenComprador = new ImageIcon(getClass().getResource("/Comprador.jpg"));
        if (imagenComprador != null) {
            imagenComprador.setImage(imagenComprador.getImage().getScaledInstance(300, 690, Image.SCALE_DEFAULT));
            JLabel label = new JLabel(imagenComprador);
            add(label, BorderLayout.CENTER);
        }
    }

    //Botones con escuchadores que interactuan con el Comprador
    private class BotonesMonedaComprador extends JButton {
        public Moneda aux_moneda;
        public int valor_moneda;
        BotonesMonedaComprador(String texto, int valor_moneda) {
            super(texto);
            this.valor_moneda = valor_moneda;
            this.addActionListener(new EscuchadorBoton());
        }
        //switch para separar en casos de que Moneda sea, se crea una nueva Moneda del tipo elegido y se le añade al Comprador y se actualiza el labelMonedas correspondiente
        private class EscuchadorBoton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                switch (valor_moneda) {
                    case 100:
                        aux_moneda = new Moneda100(Moneda100.serie_100);
                        PanelPrincipal.comprador.addMoneda(aux_moneda);
                        labelMonedas100.setText("Monedas de 100: " + PanelPrincipal.comprador.cuantasMonedas(100));
                        break;
                    case 500:
                        aux_moneda = new Moneda500(Moneda500.serie_500);
                        PanelPrincipal.comprador.addMoneda(aux_moneda);
                        labelMonedas500.setText("Monedas de 500: " + PanelPrincipal.comprador.cuantasMonedas(500));
                        break;
                    case 1000:
                        aux_moneda = new Moneda1000(Moneda1000.serie_1000);
                        PanelPrincipal.comprador.addMoneda(aux_moneda);
                        labelMonedas1000.setText("Monedas de 1000: " + PanelPrincipal.comprador.cuantasMonedas(1000));
                        break;
                    default:
                        break;
                }
                Moneda.incrementarSerie();
            }
        }
    }

    //Botones con escuchadores que interactuan con el Expendedor
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
                //switch para separar los casos de que Moneda sea; si el Comprador tiene de las  Monedas seleccionadas se le quita la moneda al Comprador y se actualiza el label de esa Moneda, luego se añade esa Moneda al Expendedor y se actualiza el label de MonedasPagadas
                switch (valor_moneda) {
                    case 100:
                        if (PanelPrincipal.comprador.cuantasMonedas(100) > 0) {
                            aux_moneda = PanelPrincipal.comprador.getMoneda(100);
                            updateLabelMonedasText();
                        }
                        else aux_moneda = null;
                        break;
                    case 500:
                        if (PanelPrincipal.comprador.cuantasMonedas(500) > 0) {
                            aux_moneda = PanelPrincipal.comprador.getMoneda(500);
                            updateLabelMonedasText();
                        }
                        else aux_moneda = null;
                        break;
                    case 1000:
                        if (PanelPrincipal.comprador.cuantasMonedas(1000) > 0) {
                            aux_moneda = PanelPrincipal.comprador.getMoneda(1000);
                            updateLabelMonedasText();
                        }
                        else aux_moneda = null;
                        break;
                    default:
                        break;
                }
                PanelPrincipal.expendedor.addMonedaPago(aux_moneda);
                if (aux_moneda != null) {
                    System.out.println("Moneda de " + aux_moneda.getValor() + " con serie: " + aux_moneda.getSerie() + " agregada al expendedor");
                }
                PanelExpendedor.updateLabelMonedasPagadas();
                aux_moneda = null;
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}