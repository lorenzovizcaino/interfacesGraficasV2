package discoduroderoer;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class g_RutaFichero {
    public static void main(String[] args) {
        new VentanaRutaFichero2();
    }
}
class VentanaRutaFichero2 extends JFrame {

    public VentanaRutaFichero2(){
        setBounds(100,100,500,200);
        setTitle("Ruta Fichero2");
        LaminaRutaFichero2 laminaRutaFichero=new LaminaRutaFichero2();
        add(laminaRutaFichero);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class LaminaRutaFichero2 extends JPanel{
    private JMenuBar barra;
    private JMenu fichero;
    private JMenuItem abrir, salir;
    private JLabel label;
    private JTextField texto;
    private JButton boton;
    GBCConstrains constrains;

    public LaminaRutaFichero2(){
        setLayout(new BorderLayout());
        JPanel norte=new JPanel();

        add(norte,BorderLayout.WEST);

        barra=new JMenuBar();
        fichero=new JMenu("File");
        abrir=new JMenuItem("Abrir...");
        salir=new JMenuItem("Salir...");
        abrir.addActionListener(e->{
            abrir();
        });
        salir.addActionListener(e->{
            System.exit(0);
        });

        barra.add(fichero);
        fichero.add(abrir);
        fichero.add(salir);

        norte.add(barra);

        JPanel centro=new JPanel();
        centro.setLayout(new GridBagLayout());
        add(centro,BorderLayout.CENTER);

        constrains=new GBCConstrains();
        label=new JLabel("Pulsa en el boton y elige una ruta");
        texto=new JTextField(20);
        boton=new JButton(". . .");

        boton.addActionListener(e->{
            abrir();
        });
        centro.add(label, constrains.Constrains(0,0,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,new Insets(10,5,10,5)));
        centro.add(texto, constrains.Constrains(0,1,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,5,10,5)));
        centro.add(boton, constrains.Constrains(1,1,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,5,10,5)));
    }

    private void abrir() {
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
    }
}