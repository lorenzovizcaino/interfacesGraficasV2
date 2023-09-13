package segundaLamina;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Main {
    public static void main(String[] args) {
        MarcoDibujos marcoDibujos=new MarcoDibujos();

    }
}

class MarcoDibujos extends JFrame{
    public MarcoDibujos()  {
        setBounds(300,300,800,450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LaminaDibujos laminaDibujos=new LaminaDibujos();
        add(laminaDibujos);
        setVisible(true);
    }
}


class LaminaDibujos extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawRect(20,20,100,100);
//        g.drawLine(20,20,120,120);
//        g.fillRect(20,200,100,100);

        Graphics2D g2=(Graphics2D) g;
        Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
        BasicStroke stroke=new BasicStroke(4);
        g2.setStroke(stroke);
        g2.draw(rectangulo);

    }
}
