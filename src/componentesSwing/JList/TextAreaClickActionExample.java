package componentesSwing.JList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TextAreaClickActionExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JTextArea con clic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> lineList = new JList<>(listModel);
        JTextArea textArea = new JTextArea();

        JButton button = new JButton("Agregar Línea");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String line = textArea.getText();
                listModel.addElement(line);
                textArea.setText("");
            }
        });

        lineList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = lineList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        // Realizar la acción en la línea seleccionada
                        String selectedLine = listModel.getElementAt(selectedIndex);
                        System.out.println("Línea seleccionada: " + selectedLine);
                        // Puedes reemplazar esta impresión con la acción que desees realizar en la línea.
                    }
                }
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(textArea), BorderLayout.NORTH);
        frame.add(lineList, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

