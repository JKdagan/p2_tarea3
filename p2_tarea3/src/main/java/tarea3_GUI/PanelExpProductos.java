package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class PanelExpProductos extends JPanel {
    private ImageIcon imagenCoca;
    private ImageIcon imagenSprite;
    private ImageIcon imagenFanta;
    private ImageIcon imagenSuper8;
    private ImageIcon imagenSnickers;

    public PanelExpProductos(Color color) {
        this.setBackground(color);
        //botones
        JPanel botonesPanel = new JPanel();
        setLayout(new BorderLayout());

        JButton boton1 = new JButton("1. CocaCola");
        JButton boton2 = new JButton("2. Sprite");
        JButton boton3 = new JButton("3. Fanta");
        JButton boton4 = new JButton("4. Super8");
        JButton boton5 = new JButton("5. Snickers");

        botonesPanel.add(boton1);
        botonesPanel.add(boton2);
        botonesPanel.add(boton3);
        botonesPanel.add(boton4);
        botonesPanel.add(boton5);

        botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.LINE_AXIS));//alinear horizontal
        botonesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);//centrarlos
        JPanel botonesCentradosPanel = new JPanel();
        botonesCentradosPanel.setLayout(new BoxLayout(botonesCentradosPanel, BoxLayout.LINE_AXIS));
        botonesCentradosPanel.add(Box.createHorizontalGlue());
        botonesCentradosPanel.add(botonesPanel);
        botonesCentradosPanel.add(Box.createHorizontalGlue());
        add(botonesCentradosPanel, BorderLayout.NORTH);//ponerlo en la parte superior


        //imagenes
        imagenCoca = new ImageIcon(getClass().getResource("/imagenes/CocaCola.jpeg"));
        imagenSprite = new ImageIcon(getClass().getResource("/imagenes/Sprite.jpeg"));
        imagenFanta = new ImageIcon(getClass().getResource("/imagenes/Fanta.jpeg"));
        imagenSuper8 = new ImageIcon(getClass().getResource("/imagenes/Super8.jpeg"));
        imagenSnickers = new ImageIcon(getClass().getResource("/imagenes/Snickers.jpeg"));

        imagenCoca.setImage(imagenCoca.getImage().getScaledInstance(60, 110, Image.SCALE_DEFAULT));
        imagenSprite.setImage(imagenSprite.getImage().getScaledInstance(60, 110, Image.SCALE_DEFAULT));
        imagenFanta.setImage(imagenFanta.getImage().getScaledInstance(60, 110, Image.SCALE_DEFAULT));
        imagenSuper8.setImage(imagenSuper8.getImage().getScaledInstance(130, 80, Image.SCALE_DEFAULT));
        imagenSnickers.setImage(imagenSnickers.getImage().getScaledInstance(130, 80, Image.SCALE_DEFAULT));

        JLabel labelCoca = new JLabel(imagenCoca);
        JLabel labelSprite = new JLabel(imagenSprite);
        JLabel labelFanta = new JLabel(imagenFanta);
        JLabel labelSuper8 = new JLabel(imagenSuper8);
        JLabel labelSnickers = new JLabel(imagenSnickers);

        JPanel imagenesPanel = new JPanel();
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


}
