package com.ventana;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 894, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setToolTipText("");
		frame.setJMenuBar(menuBar_1);

		JMenu menu, subMenu;
		JMenuItem opcion1, opcion2, opcion3, rojo, verde;
		JMenuBar menuBar = new JMenuBar();
		
		menu = new JMenu("Menu");
		subMenu = new JMenu("SubMenu");
		opcion1 = new JMenuItem("Opcion 1");
		opcion2 = new JMenuItem("Opcion 2");
		opcion3 = new JMenuItem("Opcion 3");
		rojo = new JMenuItem("Color Rojo");
		verde = new JMenuItem("Color Verde");
		
		menu.add(opcion1);
		menu.add(opcion2);
		menu.add(opcion3);
		
		subMenu.add(rojo);
		subMenu.add(verde);
		menu.add(subMenu);
		
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		ActionListener colorAction = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				JMenuItem item = (JMenuItem)e.getSource();
				if (item.getText().equals("Color Rojo")) {
					
					System.out.println(item.getText());
					frame.getContentPane().setBackground(new Color(255,0,0));
				}
				
				if (item.getText()== "Color Verde") {
					
					frame.getContentPane().setBackground(new Color(0,255,0));
				}
			}
		};
		
		rojo.addActionListener(colorAction);
		verde.addActionListener(colorAction);
	}

}
