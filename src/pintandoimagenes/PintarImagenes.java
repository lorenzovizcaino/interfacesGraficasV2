package pintandoimagenes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PintarImagenes {
    public static void main(String[] args) {
        Marco marco=new Marco();

    }
}

class Marco extends JFrame{

    public Marco(){
        setBounds(100,100,800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Lamina lamina=new Lamina();
        add(lamina);
        setVisible(true);
    }


}

class Lamina extends JPanel{
    private Image imagen;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        File file=new File("img_2.png");
        try {
            imagen= ImageIO.read(file);


        } catch (IOException e) {
            System.out.println("Lo siento, la imagen no se ha encontrado");
        }
        int anchuraImagen=imagen.getWidth(this);
        int altoImagen=imagen.getHeight(this);
        g.drawImage(imagen,0,0,null);
        for (int i = 0; i < 800; i++) {

            for (int j = 0; j < 500; j++) {
                g.copyArea(0,0,anchuraImagen,altoImagen,anchuraImagen*i,altoImagen*j);
            }
        }

//        g.drawImage(imagen,50,50,null);
//        g.copyArea(50,50,256,256,350,150);
//        g.copyArea(180,50,50,50,350,50);


    }
}
