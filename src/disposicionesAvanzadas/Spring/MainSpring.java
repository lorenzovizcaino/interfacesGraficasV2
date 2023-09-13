package disposicionesAvanzadas.Spring;

import javax.swing.*;

public class MainSpring {
    public static void main(String[] args) {
        VentanaSpring ventanaSpring =new VentanaSpring();

    }
}

class VentanaSpring extends JFrame {
    public VentanaSpring(){
        setBounds(100,100,1000,350);
        setTitle("VentanaSpring");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaSpring laminaSpring =new LaminaSpring();
        add(laminaSpring);


        setVisible(true);
    }
}

class LaminaSpring extends JPanel{


    public LaminaSpring(){
        SpringLayout miLayout=new SpringLayout();
        setLayout(miLayout);
        JButton boton1=new JButton("Boton 1");
        JButton boton2=new JButton("Boton 2");
        JButton boton3=new JButton("Boton 3");
        add(boton1);
        add(boton2);
        add(boton3);

        Spring miMuelle=Spring.constant(0,10,100);
        miLayout.putConstraint(SpringLayout.WEST,boton1,miMuelle,SpringLayout.WEST,this);
                //SpringLayout.WEST --> hace referencia al lado WEST del primer boton
                //boton1 -------------> hace referencia al componente que vamos a configurar
                //miMuelle -----------> es el muelle que configuramos en la linea anterior (comportamiento del muelle)
                //SpringLayout.WEST --> hace referencia al lado de la lamina a la cual vamos a anclar el boton
                //this ---------------> hace referencia al lugar al cual vamos a unir el boton1 con el muelle (this--> la propia lamina)
        miLayout.putConstraint(SpringLayout.WEST,boton2,miMuelle,SpringLayout.EAST,boton1);
        miLayout.putConstraint(SpringLayout.WEST,boton3,miMuelle,SpringLayout.EAST,boton2);
        miLayout.putConstraint(SpringLayout.EAST,this,miMuelle,SpringLayout.EAST,boton3);











    }


}