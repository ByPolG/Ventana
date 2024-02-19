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
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class Xbox {

    private JFrame frame;
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Xbox window = new Xbox();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Xbox() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        ButtonGroup buttonGroup = new ButtonGroup();

        // Mensaje de advertencia al iniciar
        JOptionPane.showMessageDialog(frame, "¡Bienvenido al programa de selección de tortilla!", "Saludo", JOptionPane.WARNING_MESSAGE);

        JLabel lblNewLabel = new JLabel("Texto por defecto");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(232, 24, 154, 25);
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("Click Aqui");
        btnNewButton.setBounds(155, 202, 119, 21);
        frame.getContentPane().add(btnNewButton);
        // Crear un button group

        JRadioButton rdbtnConCebolla = new JRadioButton("Con cebolla");
        buttonGroup.add(rdbtnConCebolla);
        rdbtnConCebolla.setHorizontalAlignment(SwingConstants.LEFT);
        rdbtnConCebolla.setBounds(253, 62, 103, 21);
        rdbtnConCebolla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblNewLabel.setText("Tortilla: " + rdbtnConCebolla.getText());
            }
        });
        frame.getContentPane().add(rdbtnConCebolla);

        JRadioButton rdbtnSinCebolla = new JRadioButton("Sin cebolla");
        buttonGroup.add(rdbtnSinCebolla);
        rdbtnSinCebolla.setHorizontalAlignment(SwingConstants.LEFT);
        rdbtnSinCebolla.setBounds(253, 109, 103, 21);
        rdbtnSinCebolla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblNewLabel.setText("Tortilla: " + rdbtnSinCebolla.getText());
            }
        });
        frame.getContentPane().add(rdbtnSinCebolla);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(47, 30, 175, 13);
        frame.getContentPane().add(lblNewLabel_1);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Poco hecha");
        buttonGroup_1.add(chckbxNewCheckBox);
        chckbxNewCheckBox.setBounds(44, 62, 93, 21);
        chckbxNewCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblNewLabel_1.setText("Tortilla: " + chckbxNewCheckBox.getText());
            }
        });
        frame.getContentPane().add(chckbxNewCheckBox);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Muy hecha");
        buttonGroup_1.add(chckbxNewCheckBox_1);
        chckbxNewCheckBox_1.setBounds(44, 109, 93, 21);
        chckbxNewCheckBox_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblNewLabel_1.setText("Tortilla: " + chckbxNewCheckBox_1.getText());
            }
        });
        frame.getContentPane().add(chckbxNewCheckBox_1);

        JLabel lblNewLabel_2 = new JLabel("Resultado Aqui:");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

        lblNewLabel_2.setBounds(82, 150, 271, 35);
        frame.getContentPane().add(lblNewLabel_2);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnSinCebolla.isSelected()) {
                    lblNewLabel.setText("Tortilla: " + rdbtnSinCebolla.getText());
                } else if (rdbtnConCebolla.isSelected()) {
                    lblNewLabel.setText("Tortilla: " + rdbtnConCebolla.getText());
                }

                String texto = "";
                if (rdbtnSinCebolla.isSelected()) {
                    texto += rdbtnSinCebolla.getText() + " y ";
                }
                if (rdbtnConCebolla.isSelected()) {
                    texto += rdbtnConCebolla.getText() + " y ";
                }
                if (chckbxNewCheckBox.isSelected()) {
                    texto += chckbxNewCheckBox.getText().toLowerCase() + " ";
                }
                if (chckbxNewCheckBox_1.isSelected()) {
                    texto += chckbxNewCheckBox_1.getText().toLowerCase() + " ";
                }
                lblNewLabel_2.setText(texto);
                JOptionPane.showMessageDialog(null, texto);
            }
        });        		
    }
}
