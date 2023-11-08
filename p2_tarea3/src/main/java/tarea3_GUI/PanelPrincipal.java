package tarea3_GUI;

import tarea3_logica.*;

import javax.swing.*;
import java.awt.*;


public class PanelPrincipal extends JPanel {
    private PanelComprador panel_comprador;
    private PanelExpendedor panel_expendedor;
    public static Comprador comprador;
    public static Expendedor expendedor;

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
