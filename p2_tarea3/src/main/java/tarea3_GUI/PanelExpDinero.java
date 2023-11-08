package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

//Panel que estará en la primera fila de PanelExpendedor
public class PanelExpDinero extends JPanel {
    //Tendrá 2 paneles, uno para mostrar las Monedas que se van ingresando al Expendedor y uno para mostrar el vuelto que suelta la maquina luego de una compra exitosa
    public static JLabel labelMonedasPagadas;
    public static JLabel labelVuelto;
    //Constructor por defecto; dibujamos 2 rectangulos de diferentes colores para simular que esta dividido por la mitad, añadimos un Label en cada orilla con una frase inicial
    /*@param color, es un Color que se le añadira al PanelExpendedor
     */
    public PanelExpDinero(Color color) {
        super(new BorderLayout());
        this.setBackground(color);

        JPanel labelsPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int rectWidth = getWidth() / 2;
                int rectHeight = getHeight();

                g.setColor(color1);
                g.fillRect(0, 0, rectWidth, rectHeight);

                g.setColor(color2);
                g.fillRect(rectWidth, 0, rectWidth, rectHeight);
            }
        };

        labelMonedasPagadas = new JLabel("Monto ingresado: 0");//inicialmente 0 porque aun no se ingresan monedas a la maquina
        labelVuelto = new JLabel("Vuelto: 0");//inicialmente 0 porque mientras no se compre algo no habra vuelto

        labelsPanel.setLayout(new BorderLayout());
        labelsPanel.add(labelMonedasPagadas, BorderLayout.WEST);
        labelsPanel.add(labelVuelto, BorderLayout.EAST);

        add(labelsPanel, BorderLayout.CENTER);
    }
    //Colores para colocar en los fondos se los rectangulos
    Color color1=new Color(216, 246, 18);
    Color color2=new Color(35, 243, 70);
    //Metodo que actualiza el texto del Label que muestra el vuelto
    public static void actualizarVuelto(int vuelto) {
        labelVuelto.setText("Vuelto: " + vuelto);
    }
}


