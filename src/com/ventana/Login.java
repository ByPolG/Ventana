package com.ventana;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login {

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
					Login window = new Login();
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
	public Login() {
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
				
				String data = "Usuario " + textField.getText();
				lblUsuario.getText(); data += ", Password: " + new String(passwordField.getPassword());
				lblInformation.setText(data);
				
				String usuario = textField.getText();
				String password = new String(passwordField.getPassword());
				
				if(usuario.equals("admin") && password.equals("1234")) {
					
					JOptionPane.showMessageDialog(null, "Autenticado");
				
				} else {
					
					JOptionPane.showMessageDialog(null, "Error");
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
}
