package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        exp = new PanelExpendedor();
        com = new PanelComprador();
        this.setBackground(Color.white);
    }
    public PanelPrincipal(Color color){
        exp = new PanelExpendedor(Color.green);
        com = new PanelComprador(Color.red);
        this.setBackground(color);
        this.add(exp);
        this.add(com);

        this.setLayout(new GridLayout(1,2));


    }

    public void paint(Graphics g) { //todo se dibuja a partir de este método
        super.paint(g); //llama al método paint al que hace override en la super
        //el de la super clase solo pinta el fondo (background)
        com.paint(g); //llama al metodo paint definido en el PanelComprador
        exp.paint(g); //llama al metodo paint definido en el PanelExpendedor
    }
}
