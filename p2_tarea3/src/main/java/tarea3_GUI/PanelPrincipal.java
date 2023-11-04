package tarea3_GUI;

import tarea3_logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public static Comprador comprador;
    public static Expendedor expendedor;

    public PanelPrincipal(Color color){
        super();
        comprador = new Comprador(5);
        expendedor = new Expendedor(5);
        exp = new PanelExpendedor(Color.green, expendedor);
        com = new PanelComprador(Color.white, comprador, expendedor, PanelExpDinero.labelMonedasPagadas);
        this.setBackground(color);
        this.add(exp);
        this.add(com);
        this.setLayout(new GridLayout(1,2));
    }

    public void paint(Graphics g) { //todo se dibuja a partir de este método
        //llama al método paint al que hace override en la super
        super.paint(g);
        //el de la super clase solo pinta el fondo (background)

        //llama al metodo paint definido en el PanelComprador
        com.paint(g);

        //llama al metodo paint definido en el PanelExpendedor
        exp.paint(g);
    }
}
