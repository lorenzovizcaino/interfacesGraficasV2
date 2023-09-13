package discoduroderoer;

import javax.swing.*;
import java.awt.*;

public class a_Saludador {
    public static void main(String[] args) {
        new VentanaSaludador();
    }
}

class VentanaSaludador extends JFrame{

    public VentanaSaludador(){
        setBounds(100,100,300,200);
        setTitle("Saludador");
        LaminaSaludador laminaSaludador=new LaminaSaludador();
        add(laminaSaludador);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class LaminaSaludador extends JPanel{
    JLabel etiqueta;
    JTextField campoTexto;
    JButton saludar;

    public LaminaSaludador(){
        setLayout(new FlowLayout());
        etiqueta=new JLabel("Escribe un nombre para saludar");
        campoTexto=new JTextField(20);
        saludar=new JButton("¡Saludar!");
        saludar.addActionListener(e->{
            JOptionPane.showMessageDialog(null,"¡Hola "+campoTexto.getText()+" !");
        });
        add(etiqueta);
        add(campoTexto);
        add(saludar);

    }
}
