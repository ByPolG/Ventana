package com.ventana;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComboBox {

    private JFrame frame;
    private JComboBox<String> comboBox;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ComboBox window = new ComboBox();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ComboBox() {
        initialize();
        añadirComida();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);

        JButton btnAgregar = new JButton("Agregar");
        panel.add(btnAgregar);

        comboBox = new JComboBox<String>();
        comboBox.setModel(new DefaultComboBoxModel<String>(
                new String[] { "Hamburguesa", "Kebap", "Pizza", "Ensalada", "Durum", "Patatas" }));
        frame.getContentPane().add(comboBox, BorderLayout.CENTER);

        JLabel elLabel = new JLabel("New label");
        frame.getContentPane().add(elLabel, BorderLayout.SOUTH);

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nuevoAlimento = textField.getText().trim();

                if (!nuevoAlimento.isEmpty()) {
                    if (contieneNumeros(nuevoAlimento)) {
                        JOptionPane.showMessageDialog(frame, "El nombre del alimento no puede contener números.",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                    } else if (contieneCaracteresEspeciales(nuevoAlimento)) {
                        JOptionPane.showMessageDialog(frame,
                                "El nombre del alimento no puede contener caracteres especiales.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboBox.getModel();
                        model.addElement(nuevoAlimento);
                        textField.setText(""); // Limpiar el campo de texto después de agregar.
                    }
                }
            }
        });

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elLabel.setText((String) comboBox.getSelectedItem());
            }
        });
        
        String imagePath = "C:\\Users\\ALUMNOS_FP\\Desktop\\pacman.png";
        ImageIcon icon = new ImageIcon(imagePath);
        
        Object[] opciones = {"Si oh", "Calla oh"};
        
        int opcion = JOptionPane.showOptionDialog(null, 
        		"¿Quieres una ensalada?", 
        		"Duda existencial", 
        		JOptionPane.DEFAULT_OPTION,
        		JOptionPane.WARNING_MESSAGE, 
        		icon, 
        		opciones, 
        		opciones[1]);
    }

    private void añadirComida() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres agregar un alimento?", "Pregunta",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            String nuevoAlimento = JOptionPane.showInputDialog("Introduce el nombre del nuevo alimento:");

            if (nuevoAlimento != null && !nuevoAlimento.isEmpty()) {
                DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboBox.getModel();
                model.addElement(nuevoAlimento);
            }
        }
    }

    private boolean contieneNumeros(String cadena) {
        return cadena.matches(".*\\d+.*");
    }

    private boolean contieneCaracteresEspeciales(String cadena) {
        return !cadena.matches("[a-zA-Z\\s]+");
    }
}
