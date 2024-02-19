package com.ventana;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class Resto {

    private JFrame frame;
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();
    private JLabel lblNewLabel_2;
    private JRadioButton rdbtnConCebolla;
    private JRadioButton rdbtnSinCebolla;
    private JCheckBox chckbxNewCheckBox;
    private JCheckBox chckbxNewCheckBox_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Resto window = new Resto();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Resto() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        ButtonGroup buttonGroup = new ButtonGroup();

        JOptionPane.showMessageDialog(frame, "¡Bienvenido al programa de selección de tortilla!", "Saludo", JOptionPane.WARNING_MESSAGE);

        JLabel lblNewLabel = new JLabel("Texto por defecto");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(232, 24, 154, 25);
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("Click Aqui");
        btnNewButton.setBounds(155, 202, 119, 21);
        frame.getContentPane().add(btnNewButton);

        rdbtnConCebolla = new JRadioButton("Con cebolla");
        buttonGroup.add(rdbtnConCebolla);
        rdbtnConCebolla.setHorizontalAlignment(SwingConstants.LEFT);
        rdbtnConCebolla.setBounds(253, 62, 103, 21);
        frame.getContentPane().add(rdbtnConCebolla);

        rdbtnSinCebolla = new JRadioButton("Sin cebolla");
        buttonGroup.add(rdbtnSinCebolla);
        rdbtnSinCebolla.setHorizontalAlignment(SwingConstants.LEFT);
        rdbtnSinCebolla.setBounds(253, 109, 103, 21);
        frame.getContentPane().add(rdbtnSinCebolla);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(47, 30, 175, 13);
        frame.getContentPane().add(lblNewLabel_1);

        chckbxNewCheckBox = new JCheckBox("Poco hecha");
        buttonGroup_1.add(chckbxNewCheckBox);
        chckbxNewCheckBox.setBounds(44, 62, 93, 21);
        frame.getContentPane().add(chckbxNewCheckBox);

        chckbxNewCheckBox_1 = new JCheckBox("Muy hecha");
        buttonGroup_1.add(chckbxNewCheckBox_1);
        chckbxNewCheckBox_1.setBounds(44, 109, 93, 21);
        frame.getContentPane().add(chckbxNewCheckBox_1);

        lblNewLabel_2 = new JLabel("Resultado Aqui:");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(82, 150, 271, 35);
        frame.getContentPane().add(lblNewLabel_2);

        // Agrega ActionListeners para actualizar el JLabel_2 en tiempo real
        rdbtnConCebolla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateResultLabel();
            }
        });

        rdbtnSinCebolla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateResultLabel();
            }
        });

        chckbxNewCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateResultLabel();
            }
        });

        chckbxNewCheckBox_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateResultLabel();
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Resto del código del botón...
                // ...
            }
        });
    }

    private void updateResultLabel() {
        String texto = "Tortilla: ";
        if (rdbtnConCebolla.isSelected()) {
            texto += rdbtnConCebolla.getText() + " ";
        }
        if (rdbtnSinCebolla.isSelected()) {
            texto += rdbtnSinCebolla.getText() + " ";
        }
        if (chckbxNewCheckBox.isSelected()) {
            texto += chckbxNewCheckBox.getText().toLowerCase() + " ";
        }
        if (chckbxNewCheckBox_1.isSelected()) {
            texto += chckbxNewCheckBox_1.getText().toLowerCase() + " ";
        }
        lblNewLabel_2.setText(texto);
    }
}
