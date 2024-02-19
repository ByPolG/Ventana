package com.ventana;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Contraseñas {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Contraseñas window = new Contraseñas();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Contraseñas() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(60, 47, 49, 13);
        frame.getContentPane().add(lblUsuario);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(60, 87, 49, 13);
        frame.getContentPane().add(lblPassword);

        textField = new JTextField();
        textField.setBounds(140, 44, 86, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 84, 86, 19);
        frame.getContentPane().add(passwordField);

        JButton btnLogin = new JButton("Loggin");
        btnLogin.setBounds(60, 169, 85, 21);
        frame.getContentPane().add(btnLogin);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(168, 169, 85, 21);
        frame.getContentPane().add(btnCancel);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(275, 169, 85, 21);
        frame.getContentPane().add(btnClear);

        JLabel lblInformation = new JLabel("");
        lblInformation.setBounds(246, 10, 180, 149);
        frame.getContentPane().add(lblInformation);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textField.getText();
                String password = new String(passwordField.getPassword());

                if (usuario.equals("pablofb") && password.equals("Psjmtoad5630")) {
                    JOptionPane.showMessageDialog(null, "Autenticado como pablofb");
                } else if (usuario.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Autenticado como admin");
                } else if (usuario.equals("cualquiera")) {
                    // Verificar requisitos de contraseña para "cualquiera"
                    if (verificarRequisitosContraseña(password)) {
                        JOptionPane.showMessageDialog(null, "Autenticado como cualquiera");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: La contraseña no cumple con los requisitos.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error de autenticación");
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                passwordField.setText("");
            }
        });
    }

    // Método para verificar los requisitos de contraseña
    private boolean verificarRequisitosContraseña(String contraseña) {
        // Utilizamos expresiones regulares para verificar los requisitos
        // al menos una letra mayúscula, un número, un carácter especial y al menos 8 caracteres
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
        Matcher matcher = pattern.matcher(contraseña);
        return matcher.matches();
    }
}
