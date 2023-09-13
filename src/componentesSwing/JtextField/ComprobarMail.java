package componentesSwing.JtextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComprobarMail {
    public static void main(String[] args) {
        Ventana2 ventana2=new Ventana2();
    }
}

class Ventana2 extends JFrame{
    public Ventana2(){
        setBounds(100,100,400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Comprobar Mail");
        Lamina2 lamina2=new Lamina2();
        add(lamina2);

        setVisible(true);
    }
}

class Lamina2 extends JPanel{
    private JTextField campoTexto;
    private JButton boton;
    private JLabel etiqueta;
    public Lamina2(){
        setLayout(new GridLayout(3,0));
        campoTexto=new JTextField(20);

        boton=new JButton("Comprueba");

        etiqueta=new JLabel("");
        ComprobarMail comprobarMail=new ComprobarMail();
        boton.addActionListener(comprobarMail);

        add(campoTexto);
        add(boton);
        add(etiqueta);


    }
    private class ComprobarMail implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int longitudMail=campoTexto.getText().length();
            String cadena=campoTexto.getText();
            int contadorArrobas=0;
            for (int i = 0; i < longitudMail; i++) {
                if(cadena.charAt(i)=='@') contadorArrobas++;
            }
            if(contadorArrobas==1){
                etiqueta.setText("Email Correcto");
            }else{
                etiqueta.setText("Email INCORRECTO");
            }
        }
    }
}