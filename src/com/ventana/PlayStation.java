package com.ventana;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PlayStation {

    private JFrame frame;
    private JTextField textField;
    private JLabel lblNewLabel;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PlayStation window = new PlayStation();
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
    public PlayStation() {
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

        lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(37, 68, 100, 13);
        frame.getContentPane().add(lblNewLabel);

        textArea = new JTextArea();
        textArea.setBounds(144, 45, 122, 113);
        frame.getContentPane().add(textArea);

        textField = new JTextField();
        textField.setBounds(304, 83, 96, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        // Upper buttons
        JButton btnAddToLabel = new JButton("Add to Label");
        btnAddToLabel.setBounds(20, 185, 120, 21);
        frame.getContentPane().add(btnAddToLabel);
        btnAddToLabel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String labelText = lblNewLabel.getText();
                lblNewLabel.setText("Hello, how are you?");
                textArea.append(labelText + "\n");
                textField.setText(labelText);
            }
        });

        // Lower buttons
        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(20, 216, 85, 21);
        frame.getContentPane().add(btnClear);
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblNewLabel.setText("");
                textArea.setText("");
                textField.setText("");
            }
        });
    }
}

