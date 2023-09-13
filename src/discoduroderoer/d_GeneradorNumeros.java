package discoduroderoer;

import javax.swing.*;
import java.awt.*;

public class d_GeneradorNumeros {
    public static void main(String[] args) {
        new VentanaGeneradorNumeros();
    }
}

class VentanaGeneradorNumeros extends JFrame{

    public VentanaGeneradorNumeros(){
        setBounds(100,100,300,400);
        setTitle("Generador de Numeros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaGeneradorNumeros laminaGeneradorNumeros=new LaminaGeneradorNumeros();
        add(laminaGeneradorNumeros);
        setVisible(true);
    }
}

class LaminaGeneradorNumeros extends JPanel{
    private JLabel numero1, numero2, numeroGenerado;
    private JSpinner jSNumero1, jSNumero2;
    private JTextField jTNumeroGenerado;
    private JButton generar;
    private GridBagConstraints gbc;
    private GBCConstrains constrains;
    public LaminaGeneradorNumeros(){
        setLayout(new GridBagLayout());
        constrains=new GBCConstrains();
        numero1=new JLabel("Número 1");
        jSNumero1=new JSpinner(new SpinnerNumberModel(0,0,10,1));

        numero2=new JLabel("Número 2");
        jSNumero2=new JSpinner(new SpinnerNumberModel(10,0,10,1));
        numeroGenerado=new JLabel("Numero generado");
        jTNumeroGenerado=new JTextField(2);
        generar=new JButton("Generar");

        generar.addActionListener(e->{
            int numGenerado=-1;

            while (numGenerado < (int)jSNumero1.getValue() || numGenerado > (int)jSNumero2.getValue()){
                numGenerado=(int)(Math.random()*10);
                System.out.println(numGenerado);
            }

            jTNumeroGenerado.setText(String.valueOf(numGenerado));
        });



        add(numero1,constrains.Constrains(0,0,1,1,1.0,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,30,5,10)));
        add(jSNumero1,constrains.Constrains(1,0,1,1,1.0,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,50)));
        add(numero2,constrains.Constrains(0,1,1,1,1.0,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,30,5,10)));
        add(jSNumero2,constrains.Constrains(1,1,1,1,1.0,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,50)));
        add(numeroGenerado,constrains.Constrains(0,2,1,1,1.0,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,30,5,10)));
        add(jTNumeroGenerado,constrains.Constrains(1,2,1,1,1.0,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,50)));
        add(generar,constrains.Constrains(1,3,1,1,1.0,1.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,50)));



    }
}