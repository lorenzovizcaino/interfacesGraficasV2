package disposicionesAvanzadas.libre;

import javax.swing.*;

public class MainLibre {

    public static void main(String[] args) {
        VentanaDisposicionLibre ventanaDisposicionLibre =new VentanaDisposicionLibre();

    }
}

class VentanaDisposicionLibre extends JFrame {
    public VentanaDisposicionLibre(){
        setBounds(450,350,350,400);
        setTitle("VentanaJComboBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaDisposicionLibreAvanzado laminaDisposicionLibre =new LaminaDisposicionLibreAvanzado();
        add(laminaDisposicionLibre);


        setVisible(true);
    }
}

class LaminaDisposicionLibre extends JPanel{


    public LaminaDisposicionLibre(){
        setLayout(null);  //para trabajar con disposición libre tenemos que iniciar el Layout a null
        JLabel nombre=new JLabel("Nombre:");
        JLabel apellido=new JLabel("Apellido:");

        JTextField c_nombre=new JTextField();
        JTextField c_apellido=new JTextField();


        nombre.setBounds(20,20,80,10);
        c_nombre.setBounds(100,15,100,20);
        apellido.setBounds(20,60,80,10);
        c_apellido.setBounds(100,55,100,20);

        add(nombre);
        add(c_nombre);
        add(apellido);
        add(c_apellido);







    }


}
