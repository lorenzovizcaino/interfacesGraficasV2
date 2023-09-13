package layouts.UsoGridBagLayout.ejVentanasCursoPasado;

import javax.swing.*;
import java.awt.*;

public class MiVentana {
    public static void main(String[] args) {
        PanelMiVentana panelMiVentana=new PanelMiVentana();
    }
}

class PanelMiVentana extends JFrame {

    public PanelMiVentana(){
        setBounds(100,100,300,200);
        setTitle("Mi Ventana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaMiVentana laminaMiVentana=new LaminaMiVentana();
        add(laminaMiVentana);
        setVisible(true);
    }

}

class LaminaMiVentana extends JPanel{
    private JTextArea areaTexto;
    private JButton boton1, boton2,boton3, boton4;
    private JTextField campoTexto;
    private GridBagConstraints gbc=new GridBagConstraints();

    public LaminaMiVentana(){
        setLayout(new GridBagLayout());

        areaTexto=new JTextArea("Area texto");
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=3;
        gbc.gridheight=4;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill=GridBagConstraints.BOTH;
        add(areaTexto,gbc);

        boton1=new JButton("Botón 1");
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.gridx=3;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(boton1,gbc);

        boton2=new JButton("Botón 2");
        gbc.gridx=3;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(boton2,gbc);

        boton3=new JButton("Botón 3");
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(boton3,gbc);

        campoTexto=new JTextField("Campo texto");
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(campoTexto,gbc);

        boton4=new JButton("Botón 4");
        gbc.weightx=0;
        gbc.gridx=3;
        gbc.gridy=4;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(boton4,gbc);
    }
}
