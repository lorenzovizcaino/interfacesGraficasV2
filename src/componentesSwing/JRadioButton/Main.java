package componentesSwing.JRadioButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        VentanaJRadioButton ventanaJRadioButton=new VentanaJRadioButton();
    }
}

class VentanaJRadioButton extends JFrame {
    public VentanaJRadioButton(){
        setBounds(100,100,600,450);
        setTitle("VentanaJCheckBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaJRadioButton laminaJRadioButton=new LaminaJRadioButton();
        add(laminaJRadioButton);


        setVisible(true);
    }
}

class LaminaJRadioButton extends JPanel{
    private JRadioButton boton1, boton2, boton3;


    public LaminaJRadioButton(){

        ButtonGroup grupo=new ButtonGroup();
        boton1=new JRadioButton("Masculino");
        boton2=new JRadioButton("Femenino");
        boton3=new JRadioButton("Neutro");
        boton1.addActionListener(new ManejaRadioButton());
        grupo.add(boton1);
        grupo.add(boton2);
        grupo.add(boton3);

        add(boton1);
        add(boton2);
        add(boton3);





    }

    private class ManejaRadioButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            //MANERA 1:
            //if(boton1.isSelected()) System.out.println("Has selecionado masculino");

            //MANERA 2: (el metodo getSource() nos devuelve el objeto en el cual se ha disparado el evento)
            if (e.getSource()==boton1){
                System.out.println("Has selecionado masculino");
            }
        }
    }


}
