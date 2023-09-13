package disposicionesAvanzadas.box;

import javax.swing.*;

public class MainBox {
    public static void main(String[] args) {
        VentanaBox ventanaBox =new VentanaBox();

    }
}

class VentanaBox extends JFrame {
    public VentanaBox(){
        setBounds(700,400,200,200);
        setTitle("DisposicionBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaBox laminaBox =new LaminaBox();
        add(laminaBox);


        setVisible(true);
    }
}

class LaminaBox extends JPanel{


    public LaminaBox(){


        //--------------   primer box  --------------
        JLabel nUsuario=new JLabel("Nombre");
        JTextField cUsuario=new JTextField(10);
        cUsuario.setMaximumSize(cUsuario.getPreferredSize());
        //DAR UN MAXIMO DE TAMAÑO AL JtextField AL REDIMENSIONAR, EN ESTE CASO SE LE DA EL VALOR INICIAL CON El METODO getPreferedSize()
        Box cajaUsuario=Box.createHorizontalBox();
        cajaUsuario.add(nUsuario);
        cajaUsuario.add(Box.createHorizontalStrut(10));
        cajaUsuario.add(cUsuario);
        //-----------  segundo Box  ------------------
        JLabel nPass=new JLabel("Contraseña");
        JTextField cPass=new JTextField(10);
        cPass.setMaximumSize(cPass.getPreferredSize());
        //DAR UN MAXIMO DE TAMAÑO AL JtextField AL REDIMENSIONAR, EN ESTE CASO SE LE DA EL VALOR INICIAL CON LE METODO getPreferedSize()
        Box cajaPassword=Box.createHorizontalBox();
        cajaPassword.add(nPass);
        cajaPassword.add(Box.createHorizontalStrut(10));
        cajaPassword.add(cPass);

        //---------------tercer box  ------------------
        JButton boton1=new JButton("OK");
        JButton boton2=new JButton("Cancelar");
        Box cajaBotones=Box.createHorizontalBox();
        cajaBotones.add(boton1);
        cajaBotones.add(Box.createGlue());

        cajaBotones.add(boton2);

        //--------------vertical Box  --------------
        Box cajaVertical=Box.createVerticalBox();
        cajaVertical.add(cajaUsuario);
        cajaVertical.add(cajaPassword);
        cajaVertical.add(cajaBotones);

        add(cajaVertical);






    }


}
