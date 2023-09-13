package componentesSwing.JtextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Ventana ventana=new Ventana();
    }
}

class Ventana extends JFrame{
    public Ventana(){
        setBounds(100,100,600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Lamina lamina=new Lamina();
        add(lamina);
        setVisible(true);
    }

}

class Lamina extends JPanel{
    JTextField cuadroTexto;
    JTextField cuadroTexto2;
    public Lamina(){
        cuadroTexto=new JTextField(20);
        cuadroTexto2=new JTextField(20);

        add(cuadroTexto);

        JButton boton=new JButton("Escribir");

        ObtenerTexto obtenerTexto=new ObtenerTexto();
        boton.addActionListener(obtenerTexto);

        add(boton);
        add(cuadroTexto2);

    }
    private class ObtenerTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(cuadroTexto.getText());
            cuadroTexto2.setText(cuadroTexto.getText());
        }
    }
}


