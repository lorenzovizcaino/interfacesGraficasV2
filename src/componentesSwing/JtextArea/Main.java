package componentesSwing.JtextArea;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        VentanaJTextArea ventanaJTextArea=new VentanaJTextArea();
    }
}

class VentanaJTextArea extends JFrame {
    public VentanaJTextArea(){
        setBounds(100,100,600,450);
        setTitle("VentanaJTextArea");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaJTextArea laminaJTextArea=new LaminaJTextArea();
        add(laminaJTextArea);

        setVisible(true);
    }
}

class LaminaJTextArea extends JPanel{
    private JTextArea miAreaTexto;
    private JButton boton;

    public LaminaJTextArea(){
        miAreaTexto=new JTextArea(7,25);
        //SE UTILIZA LA CLASE JScrollPane PARA PODER TENER UN AREA DE TEXTO QUE SOPORTE UN CAJA DE TEXTO CON SCROLL
        JScrollPane laminaScroll=new JScrollPane(miAreaTexto);
        miAreaTexto.setLineWrap(true);

        boton=new JButton("Copiar");
        CopiarAreaTexto copiarAreaTexto=new CopiarAreaTexto();
        boton.addActionListener(copiarAreaTexto);


        add(laminaScroll);
        add(boton);




    }
    private class CopiarAreaTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(miAreaTexto.getText());
        }
    }

}

