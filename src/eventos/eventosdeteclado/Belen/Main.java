package eventos.eventosdeteclado.Belen;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Ventana extends JFrame {

    Ventana(){
        Panel panel = new Panel();
        add(panel);


    }

    public static void main(String[] args) {
       Ventana ventana = new Ventana();
       ventana.setTitle("Ventana");
       ventana.setBounds(100,100,1000,800);
       ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
       ventana.setVisible(true);

        }
    }
