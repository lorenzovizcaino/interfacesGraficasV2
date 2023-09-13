package componentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioVideo108 {

        public static void main(String[] args) {
            VentanaVideo108 ventanaVideo108=new VentanaVideo108();
        }
    }

    class VentanaVideo108 extends JFrame {
        public VentanaVideo108(){
            setBounds(100,100,600,450);
            setTitle("EjercicioVideo108");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            LaminaVideo108 laminaVideo108=new LaminaVideo108();
            add(laminaVideo108);
            setVisible(true);
        }
    }

    class LaminaVideo108 extends JPanel{

        private JLabel labelNombre, LabelApellido;
        private JTextField nombre, apellido;
        private JTextArea texto;
        private JButton boton1, boton2;
        private JCheckBox casilla1, casilla2;
        private JRadioButton radio1, radio2;
        private String bloqueTexto="";
        private String nom, ape;
        private  int contador=-1;

        public LaminaVideo108(){
            labelNombre =new JLabel("Nombre: ");
            LabelApellido=new JLabel("Apellido: ");
            nombre=new JTextField(10);
            apellido=new JTextField(10);
            texto=new JTextArea(20,30);
            boton1=new JButton("Boton 1");
            boton2=new JButton("Boton 2");
            casilla1=new JCheckBox("Casilla 1");
            casilla2=new JCheckBox("Casilla 2");
            ButtonGroup grupo=new ButtonGroup();
            radio1=new JRadioButton("Radio 1");
            radio2=new JRadioButton("Radio 2");
            FuncionVideo108 funcionVideo108=new FuncionVideo108();
            boton1.addActionListener(funcionVideo108);
            boton2.addActionListener(funcionVideo108);
            casilla1.addActionListener(funcionVideo108);
            casilla2.addActionListener(funcionVideo108);
            radio1.addActionListener(funcionVideo108);
            radio2.addActionListener(funcionVideo108);

            grupo.add(radio1);
            grupo.add(radio2);
            setLayout(new BorderLayout());

            JPanel norte=new JPanel();
            add(norte,BorderLayout.NORTH);
            norte.add(labelNombre);
            norte.add(nombre);
            norte.add(LabelApellido);
            norte.add(apellido);

            JPanel centro=new JPanel();
            JScrollPane jScrollPane=new JScrollPane(texto);
            texto.setLineWrap(true);
            add(centro,BorderLayout.CENTER);
            centro.add(jScrollPane);

            JPanel sur=new JPanel();
            add(sur,BorderLayout.SOUTH);
            sur.add(boton1);
            sur.add(boton2);
            sur.add(casilla1);
            sur.add(casilla2);
            sur.add(radio1);
            sur.add(radio2);

        }
        private class FuncionVideo108 implements ActionListener{


            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(nombre.getText().equals(nom) && apellido.getText().equals(ape))){
                    texto.setText(texto.getText()+"\n"+nombre.getText()+" "+apellido.getText()+" realiza las siguientes acciones");
                    nom=nombre.getText();
                    ape=apellido.getText();
                }

                if(e.getSource()==boton1){
                    texto.setText(texto.getText()+"\nBotón 1 pulsado");
                }
                if(e.getSource()==boton2){
                    texto.setText(texto.getText()+"\nBotón 2 pulsado");
                }
                if(e.getSource()==casilla1){
                    if (casilla1.isSelected()) {
                        texto.setText(texto.getText()+"\nCasilla 1 activada");
                    }else {
                        texto.setText(texto.getText() + "\nCasilla 1 desactivada");
                    }
                }
                if(e.getSource()==casilla2){
                    if (casilla2.isSelected()) {
                        texto.setText(texto.getText()+"\nCasilla 2 activada");
                    }else {
                        texto.setText(texto.getText() + "\nCasilla 2 desactivada");
                    }
                }
                if(e.getSource()==radio1 || e.getSource()==radio2){
                    contador++;

                    if (radio1.isSelected()) {

                        texto.setText(texto.getText()+"\nRadio 1 activada");
                    }else {
                        if(contador>0){
                            texto.setText(texto.getText() + "\nRadio 1 desactivada");

                        }

                    }
                    if (radio2.isSelected()) {

                        texto.setText(texto.getText()+"\nRadio 2 activada");
                    }else {
                        if(contador>0){
                            texto.setText(texto.getText() + "\nRadio 2 desactivada");

                        }

                    }
                }
            }
        }
    }

