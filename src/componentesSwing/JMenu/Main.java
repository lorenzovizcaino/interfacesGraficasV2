package componentesSwing.JMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        VentanaJMenu ventanaJMenu =new VentanaJMenu();

    }
}

class VentanaJMenu extends JFrame {
    public VentanaJMenu(){
        setBounds(100,100,600,450);
        setTitle("VentanaJMenu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaJMenu laminaJMenu =new LaminaJMenu();
        add(laminaJMenu);


        setVisible(true);
    }
}

class LaminaJMenu extends JPanel{

    private JMenuBar miBarra;
    private JMenu archivo;
    private JMenu edicion;
    private JMenu herramientas;
    private JMenuItem guardar;
    private JMenuItem guardarComo;
    private JMenuItem cortar;
    private JMenuItem copiar;
    private JMenuItem pegar;

    private JMenuItem opciones;
    private JMenu preferencias;
    private JMenuItem generales;
    private JMenuItem ayuda;





    public LaminaJMenu(){
        HacerAlgo hacerAlgo=new HacerAlgo();

        miBarra=new JMenuBar();

        archivo=new JMenu("Archivo");
        edicion=new JMenu("Edicion");
        herramientas=new JMenu("Herramientas");

        miBarra.add(archivo);
        miBarra.add(edicion);
        miBarra.add(herramientas);

        //AQUI VAN LOS ELEMENTOS DE ARCHIVO
        guardar=new JMenuItem("Guardar");
        guardarComo=new JMenuItem("Guardar Como");
        guardarComo.addActionListener(hacerAlgo);
        archivo.add(guardar);
        archivo.add(guardarComo);

        //AQUI VAN LOS ELEMENTOS DE EDICION
        cortar=new JMenuItem("Cortar");
        copiar=new JMenuItem("Copiar");
        pegar=new JMenuItem("Pegar");
        edicion.add(cortar);
        edicion.add(copiar);
        edicion.add(pegar);

        //AQUI VAN LOS ELEMENTOS DE HERRAMIENTAS
        opciones=new JMenuItem("Opciones");
        preferencias=new JMenu("Preferencias");
        herramientas.add(opciones);
        herramientas.addSeparator();
        herramientas.add(preferencias);


        //AQUI VAN LOS ELEMENTOS DE PREFERENCIAS
        generales=new JMenuItem("Generales");
        ayuda=new JMenuItem("Ayuda");
        preferencias.add(generales);
        preferencias.add(ayuda);

        add(miBarra);









    }
    private class HacerAlgo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==guardarComo){
                System.out.println("Guardando Como...");
            }
        }
    }


}
