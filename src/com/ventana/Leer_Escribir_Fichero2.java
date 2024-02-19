package com.ventana;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Leer_Escribir_Fichero2 {

    private JFrame frame;
    private JTextField readFilePathTextField;
    private JTextField writeFilePathTextField;
    private JTextArea textArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Leer_Escribir_Fichero2 window = new Leer_Escribir_Fichero2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Leer_Escribir_Fichero2() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        readFilePathTextField = new JTextField();
        readFilePathTextField.setBounds(213, 10, 201, 25);
        frame.getContentPane().add(readFilePathTextField);

        writeFilePathTextField = new JTextField();
        writeFilePathTextField.setBounds(213, 220, 201, 25);
        frame.getContentPane().add(writeFilePathTextField);

        JButton btnLeer = new JButton("Leer Fichero");
        btnLeer.setBounds(35, 45, 98, 54);
        frame.getContentPane().add(btnLeer);

        JButton btnEscribir = new JButton("Escribir Fichero");
        btnEscribir.setBounds(35, 162, 98, 54);
        frame.getContentPane().add(btnEscribir);

        textArea = new JTextArea();
        textArea.setBounds(213, 45, 201, 171);
        frame.getContentPane().add(textArea);

        btnLeer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filePath = readFilePathTextField.getText();

                if (!filePath.isEmpty()) {
                    BufferedReader br = null;
                    try {
                        File file = new File(filePath);
                        br = new BufferedReader(new FileReader(file));
                        String line;
                        String texto = "";
                        while ((line = br.readLine()) != null) {
                            texto += line + "\n";
                        }
                        textArea.setText(texto);
                    } catch (FileNotFoundException ex) {
                        System.out.println("El archivo no existe");
                    } catch (IOException ex) {
                        System.out.println("Imposible acceder al archivo");
                    } finally {
                        try {
                            if (br != null) {
                                br.close();
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        btnEscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = writeFilePathTextField.getText();
                if (!filePath.isEmpty()) {
                    String content = textArea.getText();
                    try {
                        FileWriter fw = new FileWriter(filePath, false);
                        fw.write(content);
                        fw.close();
                    } catch (IOException ex) {
                        System.out.println("Error al escribir en el archivo");
                    }
                }
            }
        });
    }
}