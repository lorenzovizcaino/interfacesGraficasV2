package componentesSwing.JComboBox;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox Example");
        JPanel panel = new JPanel();

        String[] options = {"Option 1", "Option 2", "Option 3"};

        JComboBox<String> comboBox = new JComboBox<>(options);
        JLabel label = new JLabel("Selected option: ");

        // Agregar un ItemListener al JComboBox
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Obtener el elemento seleccionado y mostrarlo en la etiqueta
                    String selectedOption = comboBox.getSelectedItem().toString();
                    label.setText("Selected option: " + selectedOption);
                }
            }
        });

        panel.add(comboBox);
        panel.add(label);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
