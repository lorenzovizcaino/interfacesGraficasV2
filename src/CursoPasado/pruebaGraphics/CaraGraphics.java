/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CursoPasado.pruebaGraphics;

/**
 *
 * @author usuario
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author rodri
 */
class BotonCara extends JButton {
    BotonCara() {
        super();
    }

    BotonCara(String titulo) {
        super(titulo);
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        System.out.println("Estoy en el método paint del botón");
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        System.out.println("Estoy en el método paintComponent del botón");
    }
}

public class CaraGraphics extends JFrame implements ActionListener {

    BotonCara botonCara;
    PanelCara panel;
    Container c;

    CaraGraphics() {
        panel = new PanelCara();
        botonCara = new BotonCara("Sonrie");

        // Poner el botón a la escucha
        botonCara.addActionListener(this);
        c = this.getContentPane();
        c.add(panel);
        c.add(botonCara, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        System.out.println("Estoy en el método paint del JFrame");
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("sonrie :" + panel.isSonrie());
        panel.setSonrie(!panel.isSonrie());
        repaint();
    }

}
