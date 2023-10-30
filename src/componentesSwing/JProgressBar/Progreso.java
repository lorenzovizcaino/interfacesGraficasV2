package componentesSwing.JProgressBar;

import javax.swing.*;
import java.awt.event.*;

public class Progreso {
    static JFrame marco = new JFrame("Barra de progreso");
    static JPanel panel = new JPanel();
    static JButton pulsame = new JButton("Pulsame!");
    static JButton salir = new JButton("Cerrar");
    static JProgressBar barra = new JProgressBar(0, 100);//indicamos valor minimo y maximo

    public static void main (String[] args){

        marco.setSize(300, 100);
        marco.setResizable(false); //no permite cambiar el tamaño de la ventana
        marco.setLocationRelativeTo(null); //aparece en el centro de la pantalla
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        barra.setBounds(5, 10, 280, 25); //configura posicion x, posicion y
        pulsame.setBounds(5, 40, 140, 25); // ancho y alto
        salir.setBounds(150, 40, 140, 25);

        barra.setStringPainted(true); //Agrega el porcentaje en la barra
        pulsame.addActionListener(new Pulsar());
        salir.addActionListener(new Salir());

        panel.setLayout(null); //no aplicamos un gestor de diseño, los componentes tienen su propio lugar determinado, por defecto es flowlayout
        panel.add(barra);
        panel.add(pulsame);
        panel.add(salir);
        marco.add(panel);

        marco.setVisible(true);
    }

    public static class Pulsar implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            new Thread(new Hilo()).start();
            pulsame.setEnabled(false);
        }
    }
    public static class Salir implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            System.exit(0);
        }
    }

    public static class Hilo implements Runnable{
        @Override
        public void run(){
            for (int i=0; i<=100; i++){
                barra.setValue(i); //cambia el estado de la barra en i unidades
                barra.repaint(); //"repinta" el estado de la barra a el actual
                try{
                    Thread.sleep(50); //relentiza el hilo 50 milisegundos
                } catch (InterruptedException e){}
            }
        }
    }
}
