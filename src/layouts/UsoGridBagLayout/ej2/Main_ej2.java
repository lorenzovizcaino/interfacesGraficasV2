package layouts.UsoGridBagLayout.ej2;


import javax.swing.*;
import java.awt.*;

public class Main_ej2 {
    public static void main(String[] args) {
        VentanaGBL_ej2 ventanaGBL_ej2=new VentanaGBL_ej2();
    }
}

class VentanaGBL_ej2 extends JFrame {
    public VentanaGBL_ej2(){
        setBounds(100,100,400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GridBagLayoutDemo");
        LaminaGBL_ej2 laminaGBL=new LaminaGBL_ej2();
        add(laminaGBL);
        setVisible(true);
    }
}

class LaminaGBL_ej2 extends JPanel{
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    private GridBagConstraints gbc;
    private ConfigConstrains configConstrains=new ConfigConstrains();

    public LaminaGBL_ej2(){
        setLayout(new GridBagLayout());
        gbc=new GridBagConstraints();

        b1=new JButton("Botón 1");
        gbc=configConstrains.Constrains(0,0,1,1,GridBagConstraints.HORIZONTAL);
        add(b1,gbc);

        b2=new JButton("Botón 2");
        gbc=configConstrains.Constrains(1,0,1,1,GridBagConstraints.HORIZONTAL);
        add(b2,gbc);

        b3=new JButton("Botón 3");
        gbc=configConstrains.Constrains(2,0,1,1,GridBagConstraints.HORIZONTAL);
        add(b3,gbc);

        b4=new JButton("Botón 4");
        gbc=configConstrains.Constrains(3,0,1,1,GridBagConstraints.HORIZONTAL);
        add(b4,gbc);

        b5=new JButton("Botón 5");
        gbc=configConstrains.Constrains(0,1,4,1,GridBagConstraints.HORIZONTAL);
        add(b5,gbc);

        b6=new JButton("Botón 6");
        gbc=configConstrains.Constrains(0,2,3,1,GridBagConstraints.HORIZONTAL);
        add(b6,gbc);

        b7=new JButton("Botón 7");
        gbc=configConstrains.Constrains(3,2,1,1,GridBagConstraints.HORIZONTAL);
        add(b7,gbc);

        b8=new JButton("Botón 8");
        gbc=configConstrains.Constrains(0,3,1,2,GridBagConstraints.BOTH);
        add(b8,gbc);

        b9=new JButton("Botón 9");
        gbc=configConstrains.Constrains(1,3,3,1,GridBagConstraints.HORIZONTAL);
        add(b9,gbc);

        b10=new JButton("Botón 10");
        gbc=configConstrains.Constrains(1,4,3,1,GridBagConstraints.HORIZONTAL);
        add(b10,gbc);


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

    public GridBagConstraints Constrains(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty){
        gbc.gridx=gridx;
        gbc.gridy=gridy;
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.weightx=weightx;
        gbc.weighty=weighty;
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



    public GridBagConstraints Constrains(int gridx, int gridy, int gridwidth, int gridheight){
        gbc.gridx=gridx;
        gbc.gridy=gridy;
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        return gbc;
    }





}
