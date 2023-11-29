package componentesSwing.JDialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class DialogExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Frame");
        JButton button = new JButton("Open Dialog");

        button.addActionListener(e -> {
            // Crear un cuadro de diálogo
            JDialog dialog = new JDialog(frame, "Dialog", true); // El tercer parámetro indica que es modal

            // Agregar componentes al cuadro de diálogo
            JLabel label = new JLabel("Este es un cuadro de diálogo");
            JButton closeButton = new JButton("Cerrar");

            closeButton.addActionListener(closeEvent -> {
                dialog.dispose(); // Cerrar el cuadro de diálogo al hacer clic en el botón "Cerrar"
            });

            dialog.add(label);
            dialog.add(closeButton);

            // Configurar el diseño del cuadro de diálogo
            dialog.setLayout(new FlowLayout());
            dialog.setSize(300, 150);
            dialog.setLocationRelativeTo(frame);

            // Hacer visible el cuadro de diálogo
            dialog.setVisible(true);
        });

        // Configurar el diseño del marco principal
        frame.setLayout(new java.awt.FlowLayout());
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar el botón al marco principal
        frame.add(button);

        // Hacer visible el marco principal
        frame.setVisible(true);
    }
}

