package disposicionesAvanzadas.libre;

import javax.swing.*;
import java.awt.*;

public class MainLibreAvanzado {
    public static void main(String[] args) {
        VentanaDisposicionLibreAvanzado ventanaDisposicionLibreAvanzado =new VentanaDisposicionLibreAvanzado();

    }
}

class VentanaDisposicionLibreAvanzado extends JFrame {
    public VentanaDisposicionLibreAvanzado(){
        setBounds(450,350,1350,400);
        setTitle("VentanaJComboBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaDisposicionLibreAvanzado laminaDisposicionLibreAvanzado =new LaminaDisposicionLibreAvanzado();
        add(laminaDisposicionLibreAvanzado);


        setVisible(true);
    }
}

class LaminaDisposicionLibreAvanzado extends JPanel{


    public LaminaDisposicionLibreAvanzado(){
        setLayout(new EnColumnas());  //Indicamos con esta orden que queremos trabajar con nuestra disposicion
        JLabel nombre=new JLabel("Nombre:");
        JLabel apellido=new JLabel("Apellido:");
        JLabel dni=new JLabel("DNI:");
        JLabel curso=new JLabel("Curso:");


        JTextField c_nombre=new JTextField();
        JTextField c_apellido=new JTextField();
        JTextField c_dni=new JTextField();
        JTextField c_curso=new JTextField();





        add(nombre);
        add(c_nombre);
        add(apellido);
        add(c_apellido);
        add(dni);
        add(c_dni);
        add(curso);
        add(c_curso);







    }


}

class EnColumnas implements LayoutManager{

    private int x;
    private int y;

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container miContenedor) {
        int anchoLamina=miContenedor.getWidth();  //anchoLamina=ancho de la ventana

        x=anchoLamina/2;  //x= centro de la ventana
        y=20;
        int n=miContenedor.getComponentCount();
        for (int i = 0; i < n; i++) {
            Component c=miContenedor.getComponent(i);
            c.setBounds(x-100,y,100,20);  //colocas x en el centro de la ventana - ancho del componente
            if(i%2==0){
               x+=80;

            }else{
                x=anchoLamina/2;
                y+=40;
            }



        }


    }
}
