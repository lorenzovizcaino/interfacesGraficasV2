import javax.swing.*;
import java.awt.*;


public class PrimerJFrame {
    public static void main(String[] args) {
        /*JFrame miVentana=new JFrame();
        miVentana.setSize(600,350);

        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //EXIT_ON_CLOSE ---> Cierra la aplicacion
        //HIDE_ON_CLOSE ---> Cierra la ventana, pero no termina la aplicación, util cuando queremos cerrar una ventana que no es la principal
        miVentana.setLocation(600,350);
        miVentana.setVisible(true);*/
        MiJFrame miVentana=new MiJFrame();



    }
}


class MiJFrame extends JFrame{
    public MiJFrame(){

        //setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocation(600,350);
        setBounds(600,350,450,450);//setSize y setLocation en un solo comando
        //setLocationRelativeTo(null); //con este comando siempre colocas la ventana en el centro de la pantalla sea cual sea el monitor del usuario
        //setResizable(false);//con false impide redimensionar la ventana
        //setExtendedState(Frame.MAXIMIZED_BOTH);//pantalla maximizada a pantalla completa
        setTitle("Mi primera Ventana");

        //cambiar icono (3 siguientes lineas)
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Image image= toolkit.getImage("bolaRoja.png");
        setIconImage(image);

        setVisible(true);
    }
}
