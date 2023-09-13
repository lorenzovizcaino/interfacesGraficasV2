package eventos.eventosdefoco;


import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Main {
    public static void main(String[] args) {
        MarcoF marco=new MarcoF();





    }
}

class MarcoF extends JFrame {
    public MarcoF(){
        setBounds(100,100,600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        LaminaF laminaF=new LaminaF();
        add(laminaF);
        setVisible(true);
    }
}

class LaminaF extends JPanel{

    private JTextField campoTexto1;
    private JTextField campoTexto2;
    private JTextField campoTexto3;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JLabel etiqueta3;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        campoTexto1=new JTextField();
        campoTexto2=new JTextField();
        campoTexto3=new JTextField();
        etiqueta1=new JLabel("Usuario");
        etiqueta2=new JLabel("Contraseña");
        etiqueta3=new JLabel("Email");
        campoTexto1.setBounds(120,10,150,20);
        campoTexto2.setBounds(120,50,150,20);
        campoTexto3.setBounds(120,90,150,20);
        etiqueta1.setBounds(70,10,150,20);
        etiqueta2.setBounds(50,50,150,20);
        etiqueta3.setBounds(70,90,150,20);
        add(campoTexto1);
        add(campoTexto2);
        add(campoTexto3);
        add(etiqueta1);
        add(etiqueta2);
        add(etiqueta3);
        EventosDeFoco eventosDeFoco=new EventosDeFoco();
        campoTexto1.addFocusListener(eventosDeFoco);
        campoTexto2.addFocusListener(eventosDeFoco);
        campoTexto3.addFocusListener(eventosDeFoco);




    }
    private class EventosDeFoco implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {

        }

        @Override
        public void focusLost(FocusEvent e) {
            String usuario, pass;
            // System.out.println("El cuadro 1 ha perdido el foco");
            if(e.getSource()==campoTexto1){
                usuario=campoTexto1.getText();
                if(usuario.length()==0){
                    JOptionPane.showMessageDialog(null,"El usuario no puede quedar vacio");
                    campoTexto1.requestFocus();

                }

            }else if(e.getSource()==campoTexto2){
                pass=campoTexto2.getText();
                if(pass.length()==0){
                    JOptionPane.showMessageDialog(null,"La Contraseña no puede quedar vacia");
                    campoTexto2.requestFocus();
                }

            }else{
                System.out.println("El cuadro 3 ha perdido el foco");
            }
        }
    }
}


