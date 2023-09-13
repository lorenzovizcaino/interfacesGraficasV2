package discoduroderoer;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class f_RutaFichero {
    public static void main(String[] args) {
        new VentanaRutaFichero();
    }
}
class VentanaRutaFichero extends JFrame {

    public VentanaRutaFichero(){
        setBounds(100,100,500,200);
        setTitle("Ruta Fichero");
        LaminaRutaFichero laminaRutaFichero=new LaminaRutaFichero();
        add(laminaRutaFichero);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class LaminaRutaFichero extends JPanel{
    private JLabel label;
    private JTextField texto;
    private JButton boton;
    GBCConstrains constrains;

    public LaminaRutaFichero(){
        setLayout(new GridBagLayout());
        constrains=new GBCConstrains();
        label=new JLabel("Pulsa en el boton y elige una ruta");
        texto=new JTextField(20);
        boton=new JButton(". . .");

        boton.addActionListener(e->{
            JFileChooser chooser=new JFileChooser();
            int opcion=chooser.showOpenDialog(this);
            if(opcion==JFileChooser.APPROVE_OPTION){
                File file=chooser.getSelectedFile();
                if(file.getAbsolutePath().endsWith("txt")){
                    texto.setText(file.toString());
                }else{
                    JOptionPane.showMessageDialog(this,"Solo valido para archivos TXT","ERROR",JOptionPane.ERROR_MESSAGE);
                }


            }
        });


        add(label, constrains.Constrains(0,0,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,5,10,5)));
        add(texto, constrains.Constrains(0,1,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,5,10,5)));
        add(boton, constrains.Constrains(1,1,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,5,10,5)));
    }
}