package aulaenlanube.ejemplos;

import javax.swing.*;
import java.awt.*;

public class EjemploFigurasBordesComplejos extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // dibuja una línea en rojo con un ancho de 20, con terminaciones redondeadas
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(20, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));               
        g2d.drawLine(50, 30, 350, 30);

        // dibuja el rectángulo con degradado
        GradientPaint gradient = new GradientPaint(0, 0, Color.RED, getWidth(), getHeight(), Color.BLUE);
        g2d.setPaint(gradient);
        g2d.fillRect(50, 80, 300, 300);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(50, 80, 300, 300);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Figuras con bordes complejos");
        frame.add(new EjemploFigurasBordesComplejos());
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}