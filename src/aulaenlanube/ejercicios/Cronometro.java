/**
 * EJERCICIOS FINALES REPASO JAVA SWING
 * 
 * Crear un cronómetro con segundos y centésimas. Deberá tener 2 JButton, para iniciar y reiniciar el tiempo. 
 * Al pulsar el botón de iniciar, dicho botón permitirá pausar el tiempo, mientras que al pulsar en reiniciar, el contador pasará a estar a cero y se detendrá. 
 * Ampliar la aplicación para que si pausamos con el contador de centésimas en 00, nos muestre un mensaje de diálogo.
 * 
 * Esta solución es poco precisa ya que NO hace uso de la hora del sistema. 
 * 
 */

package aulaenlanube.ejercicios;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;

public class Cronometro extends JFrame {

    private int centesimas;
    private boolean corriendo;
    private JLabel label;
    private Timer timer;
    private JButton iniciarPausar;
    private JButton reiniciar;

    public Cronometro() {

        centesimas = 0;
        corriendo = false;

        // configuración del JFrame
        setTitle("Cronómetro");
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // etiqueta del cronómetro
        label = new JLabel("00:00");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        add(label);

        // botón iniciar-pausar
        iniciarPausar = new JButton("Iniciar");
        add(iniciarPausar);

        // botón reiniciar
        reiniciar = new JButton("Reiniciar");
        add(reiniciar);

        // evento del contador cada 10ms
        timer = new Timer(10, e -> {
            if (corriendo) {
                centesimas++;

                DecimalFormat df = new DecimalFormat("00");
                int segundos = (centesimas / 100) % 60;
                int restantesCentesimas = centesimas % 100;

                label.setText(df.format(segundos) + ":" + df.format(restantesCentesimas));
            }
        });

        // evento iniciar-pausar
        iniciarPausar.addActionListener(e -> {
            if (corriendo) {
                corriendo = false;
                iniciarPausar.setText("Iniciar");

                if (centesimas % 100 == 0) {
                    JOptionPane.showMessageDialog(null, "Has parado el cronómetro en 0 centésimas", "Enhorabuena",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                corriendo = true;
                iniciarPausar.setText("Pausar");
                timer.start();
            }
        });

        // evento reiniciar
        reiniciar.addActionListener(e -> {
            centesimas = 0;
            corriendo = false;
            iniciarPausar.setText("Iniciar");
            label.setText("00:00");
        });
    }

    public static void main(String[] args) {
        new Cronometro().setVisible(true);
    }
}