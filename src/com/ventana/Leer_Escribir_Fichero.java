package com.ventana;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.dnd.DnDConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.FileChooserUI;

import org.w3c.dom.Text;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class Leer_Escribir_Fichero { 

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leer_Escribir_Fichero window = new Leer_Escribir_Fichero();
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
	public Leer_Escribir_Fichero() {
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
		
		JButton btnLeer = new JButton("Leer Fichero");
		btnLeer.setBounds(35, 45, 98, 54);
		frame.getContentPane().add(btnLeer);
		
		JButton btnEscribir = new JButton("Escribir Fichero");
		btnEscribir.setBounds(35, 162, 98, 54);
		frame.getContentPane().add(btnEscribir);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(213, 45, 201, 171);
		frame.getContentPane().add(textArea);
		
		btnLeer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
				fc.addChoosableFileFilter(filter);
				fc.setAcceptAllFileFilterUsed(false);				
				int result = fc.showOpenDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					
					BufferedReader br = null;
					
					try {
						
						File file = fc.getSelectedFile();
						
						br = new BufferedReader(new FileReader(file));
						
						String line;
						String texto = "";
						
						while ((line = br.readLine()) !=null) {
							
							texto += line + "\n";
						}
						
						textArea.setText(texto);
						
					} catch (FileNotFoundException ex) {
						
						System.out.println("El archivo no existe");
						
					} catch (IOException ex) {

						System.out.println("Imposible acceder al archivo");
					}
				}
				
			}
		});
		
		btnEscribir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				fc.setAcceptAllFileFilterUsed(false);
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
				fc.addChoosableFileFilter(filter);
				
				int result = fc.showSaveDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					
					File file = fc.getSelectedFile();
					
					String content = textArea.getText();
					
					try {
						
						FileWriter fw = new FileWriter(file, false);
						fw.write(content);
						fw.close();
						
					} catch (FileNotFoundException ex) {
						
						System.out.println("El archivo no existe");
						
					} catch (IOException ex) {

						System.out.println("Imposible acceder al archivo");
					}
				}
			}
		});
	}
}
