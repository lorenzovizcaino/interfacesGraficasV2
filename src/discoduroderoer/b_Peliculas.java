package discoduroderoer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class b_Peliculas {
    public static void main(String[] args) {
        new VentanaPeliculas();
    }
}

class VentanaPeliculas extends JFrame{

    public VentanaPeliculas(){
        super("Peliculas");
        setBounds(100,100,400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaPeliculas laminaPeliculas=new LaminaPeliculas();
        add(laminaPeliculas);
        setVisible(true);


    }
}

class LaminaPeliculas extends JPanel{
    private JLabel labelTitulo, labelPeliculas;
    private JTextField pelicula;
    private JComboBox<String> combo;
    private JButton anhadir;
    private String[] peliculas= {"Avatar","Lo que el viento se llevo"};
    private GridBagConstraints gbc;

    public LaminaPeliculas(){
        setLayout(new GridBagLayout());
        gbc=new GridBagConstraints();
        GBCConstrains constrains=new GBCConstrains();
        labelTitulo=new JLabel("Escribe el título de una película");
        labelPeliculas=new JLabel("Películas");
        pelicula=new JTextField(10);
        combo=new JComboBox<>(peliculas);
        anhadir=new JButton("Añadir");
        anhadir.addActionListener(e->{
            combo.addItem(pelicula.getText());
        });


        add(labelTitulo,constrains.Constrains(0,0,1,1,1.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.CENTER,new Insets(10,5,10,5)));
        add(labelPeliculas,constrains.Constrains(1,0,1,1,1.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.CENTER,new Insets(10,5,10,5)));
        add(pelicula,constrains.Constrains(0,1,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,25,10,5)));
        add(combo,constrains.Constrains(1,1,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,5,10,5)));
        add(anhadir,constrains.Constrains(0,2,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,35,10,100)));





    }
}

