package disposicionesAvanzadas.GridBagLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat {
    public static void main(String[] args) {
        VentanaChat ventanaChat=new VentanaChat();
    }
}

class VentanaChat extends JFrame {

    public VentanaChat(){
        setBounds(100,100,400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("VentanaChat");
        LaminaVentanaChat laminaVentanaChat=new LaminaVentanaChat();
        add(laminaVentanaChat);
        setVisible(true);


    }
}

class LaminaVentanaChat extends JPanel{

    private JTextArea area;
    private JScrollPane scroll;
    private JTextField texto;
    private JButton boton;
    public LaminaVentanaChat(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();

        area=new JTextArea();
        scroll=new JScrollPane(area);
        texto=new JTextField(20);
        boton=new JButton("Enviar");

        gbc.gridx=0;  //COLUMNA EN LA CUAL QUIERO QUE EMPIECE A POSICIONARSE MI COMPONENTE
        gbc.gridy=0;  //FILA    EN LA CUAL QUIERO QUE EMPIECE A POSICIONARSE MI COMPONENTE, ES DECIR COLUMNA 0, FILA 0
        gbc.gridwidth=2; //CANTIDAD DE COLUMNAS QUE QUIERO QUE OCUPE MI COMPONENTE
        gbc.gridheight=1; //CANTIDAD DE FILAS QUE QUIERO QUE OCUPE MI COMPONENTE
        gbc.weightx=1.0; //LO QUE VA A CRECER DE ANCHO EL COMPONENTE AL CRECER LA VENTANA 1.0--> NO CRECE NADA, 2.0 --> CRECE EL DOBLE
        gbc.weighty=1.0; //LO QUE VA A CRECER DE ALTO EL COMPONENTE AL CRECER LA VENTANA 1.0--> NO CRECE NADA, 2.0 --> CRECE EL DOBLE
        gbc.fill=GridBagConstraints.BOTH;  //MODO EN QUE VA A CRECER EL COMPONENTE HORIZONTAL, VERTICAL, AMBOS, ...
        add(scroll,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1.0;
        gbc.weighty=0.0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(texto,gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=0.0;
        gbc.weighty=0.0;
        gbc.fill=GridBagConstraints.NONE;
        add(boton,gbc);
        EventoChat eventoChat=new EventoChat();
        boton.addActionListener(eventoChat);






    }
    private class EventoChat implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==boton){
               // area.setText(area.getText()+"\n"+texto.getText());
                area.append(texto.getText()+"\n");  //metodo append mejor que setText, aunque ambos funcionan.
                texto.setText("");
            }
        }
    }

}


