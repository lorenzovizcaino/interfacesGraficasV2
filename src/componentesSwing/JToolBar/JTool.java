package componentesSwing.JToolBar;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JTool {
    public static void main(String[] args) {
        MarcoVF marco=new MarcoVF();
        marco.setVisible(true);





    }
}

class MarcoVF extends JFrame {

    private JPanel miLamina;
    private JToolBar barra;
    public MarcoVF(){
        setBounds(100,100,600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        miLamina=new JPanel();

        add(miLamina);


        EventoColorFondo colorRojo=new EventoColorFondo("Rojo",Color.red,new ImageIcon("src/componentesSwing/JTool/bolaRoja.png"));
        EventoColorFondo colorAmarillo=new EventoColorFondo("Amarillo",Color.YELLOW,new ImageIcon("src\\componentesSwing\\JTool\\bolaAmarilla.png"));
        EventoColorFondo colorVerde=new EventoColorFondo("Verde",Color.GREEN,new ImageIcon("src\\componentesSwing\\JTool\\bolaVerde.png"));

        barra=new JToolBar();
        barra.add(colorRojo);
        barra.add(colorAmarillo);
        barra.add(colorVerde);
        add(barra, BorderLayout.NORTH);









    }
    private class EventoColorFondo extends AbstractAction{

        public EventoColorFondo(String nombre, Color colorFondo, Icon icono){
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON,icono);
            putValue(Action.SHORT_DESCRIPTION,"Pone la lamina o JPanel de color "+nombre);
            putValue("colorFondoJPanel", colorFondo);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c=(Color) getValue("colorFondoJPanel");
            miLamina.setBackground(c);
            System.out.println("Nombre: "+getValue(Action.NAME)+ " Descripcion:" +getValue(Action.SHORT_DESCRIPTION));
        }
    }



}




