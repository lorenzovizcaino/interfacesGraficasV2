package layouts.UsoGridBagLayout.ej1;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        VentanaGBL ventanaGBL=new VentanaGBL();
    }
}

class VentanaGBL extends JFrame{
    public VentanaGBL(){
        setBounds(100,100,300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GridBagLayoutDemo");
        LaminaGBL laminaGBL=new LaminaGBL();
        add(laminaGBL);
        setVisible(true);
    }
}


class LaminaGBL extends JPanel{

    private JButton boton1, boton2, boton3, boton4, boton5;
    private GridBagConstraints gbc;
    private ConfigConstrains configConstrains;
    public LaminaGBL(){
        setLayout(new GridBagLayout());
        gbc=new GridBagConstraints();
        configConstrains=new ConfigConstrains();


        boton1=new JButton("Boton 1");
        gbc=configConstrains.Constrains(0,0,1,1,0.5,0,GridBagConstraints.HORIZONTAL);
        add(boton1,gbc);

        boton2=new JButton("Boton 2");
        gbc=configConstrains.Constrains(1,0,1,1,0.5,0,GridBagConstraints.HORIZONTAL);
        add(boton2,gbc);

        boton3=new JButton("Boton 3");
        gbc=configConstrains.Constrains(2,0,1,1,0.5,0,GridBagConstraints.HORIZONTAL);
        add(boton3,gbc);

        boton4=new JButton("Boton 4");
        gbc=configConstrains.Constrains(0,1,3,2,0.5,0.5,GridBagConstraints.BOTH);
        add(boton4,gbc);

        boton5=new JButton("Boton 5");
        gbc=configConstrains.Constrains(1,3,2,1,0.5,0,GridBagConstraints.HORIZONTAL);
        gbc.insets=new Insets(10,0,0,0);
        add(boton5,gbc);


    }
}

class ConfigConstrains{

    private GridBagConstraints gbc=new GridBagConstraints();

    public GridBagConstraints Constrains(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int fill, int anchor, Insets insets){
        gbc.gridx=gridx;
        gbc.gridy=gridy;
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.weightx=weightx;
        gbc.weighty=weighty;
        gbc.fill=fill;
        gbc.anchor=anchor;
        gbc.insets=insets;
        return gbc;
    }

    public GridBagConstraints Constrains(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, Insets insets){
        gbc.gridx=gridx;
        gbc.gridy=gridy;
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.weightx=weightx;
        gbc.weighty=weighty;
        gbc.insets=insets;
        return gbc;
    }
    public GridBagConstraints Constrains(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int fill){
        gbc.gridx=gridx;
        gbc.gridy=gridy;
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.weightx=weightx;
        gbc.weighty=weighty;
        gbc.fill=fill;
        return gbc;
    }
    public GridBagConstraints Constrains(int gridx, int gridy, int gridwidth, int gridheight,int fill){
        gbc.gridx=gridx;
        gbc.gridy=gridy;
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.fill=fill;
        return gbc;
    }





}

