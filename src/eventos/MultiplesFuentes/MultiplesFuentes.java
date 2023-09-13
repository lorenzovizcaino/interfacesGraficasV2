package eventos.MultiplesFuentes;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MultiplesFuentes {
    public static void main(String[] args) {
        MarcoVF marco=new MarcoVF();





    }
}

class MarcoVF extends JFrame {
    public MarcoVF(){
        setBounds(100,100,600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        LaminaVF laminaVF=new LaminaVF();
        add(laminaVF);
        setVisible(true);
    }
}

class LaminaVF extends JPanel  {
    private JButton botonRojo, botonAmarillo, botonVerde;

    public LaminaVF(){


        EventoColorFondo colorRojo=new EventoColorFondo("Rojo",Color.red);
        EventoColorFondo colorAmarillo=new EventoColorFondo("Amarillo",Color.YELLOW);
        EventoColorFondo colorVerde=new EventoColorFondo("Verde",Color.GREEN);
        //SE CREAN LOS JButton UTILIZANDO UN CONSTRUCTOR AL CUAL LE PONEMOS COMO PARAMETRO UN evento.
        botonRojo=new JButton(colorRojo);
        botonAmarillo=new JButton(colorAmarillo);
        botonVerde=new JButton(colorVerde);
        add(botonRojo);
        add(botonAmarillo);
        add(botonVerde);

        InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke teclaRoja=KeyStroke.getKeyStroke("ctrl R");
        KeyStroke teclaAmarilla=KeyStroke.getKeyStroke("ctrl A");
        KeyStroke teclaVerde=KeyStroke.getKeyStroke("ctrl V");
        mapaEntrada.put(teclaRoja,"Fondo rojo");
        mapaEntrada.put(teclaAmarilla,"Fondo amarillo");
        mapaEntrada.put(teclaVerde,"Fondo verde");
        ActionMap mapaAccion=getActionMap();
        mapaAccion.put("Fondo rojo",colorRojo);
        mapaAccion.put("Fondo amarillo",colorAmarillo);
        mapaAccion.put("Fondo verde",colorVerde);





    }
    private class EventoColorFondo extends AbstractAction{

        public EventoColorFondo(String nombre, Color colorFondo){
            putValue(Action.NAME, nombre);
            putValue(Action.SHORT_DESCRIPTION,"Pone la lamina o JPanel de color "+nombre);
            putValue("colorFondoJPanel", colorFondo);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c=(Color) getValue("colorFondoJPanel");
            setBackground(c);
            System.out.println("Nombre: "+getValue(Action.NAME)+ " Descripcion:" +getValue(Action.SHORT_DESCRIPTION));
        }
    }



}




