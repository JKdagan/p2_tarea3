package tarea3_GUI;

import tarea3_logica.*;

import javax.swing.*;
import java.awt.*;

//Panel general que luego separaremos en 2 paneles más
public class PanelPrincipal extends JPanel {
    //Estos PanelComprador y PanelExpendedor son los paneles que estarán dentro de PanelPrincipal
    private PanelComprador panel_comprador;
    private PanelExpendedor panel_expendedor;
    //Objetos que tendrá nuestro PanelPrincipal
    public static Comprador comprador;
    public static Expendedor expendedor;
    //Constructor por defecto; le añadimos un Comprador que empiece con 5 monedas de cada tipo, un Expendedor que empiece con 5 productos de cada tipo, separamos el PanelPrincipal en 2 columnas y añadimos en orden PanelExpendedor a una y PanelComprador a otra
    /* @param color, es un Color que se le añadirá al PanelPrincipal
    */
    public PanelPrincipal(Color color) {
        super();
        this.comprador = new Comprador(5);
        this.expendedor = new Expendedor(5);
        this.panel_expendedor = new PanelExpendedor(Color.green);
        this.panel_comprador = new PanelComprador(Color.white);
        this.add(panel_expendedor);
        this.add(panel_comprador);

        this.setBackground(color);
        this.setLayout(new GridLayout(1, 2));
    }

    public void paint(Graphics g) {
        //todo se dibuja a partir de este método
        //llama al método paint al que hace override en la super
        super.paint(g);
        //el de la super clase solo pinta el fondo (background)
        //llama al metodo paint definido en el PanelComprador
        panel_comprador.paint(g);
        //llama al metodo paint definido en el PanelExpendedor
        panel_expendedor.paint(g);
    }


}
