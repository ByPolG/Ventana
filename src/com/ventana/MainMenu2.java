package com.ventana;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.BorderLayout;
import java.awt.Color;

public class MainMenu2 {

    private JFrame frame;
    private JTextArea textArea; // Declarar el JTextArea como un campo de clase

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenu2 window = new MainMenu2();
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
    public MainMenu2() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 894, 395);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu file, edit, help;
        JMenuItem open, cut, copy, paste, selectAll, text;

        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");

        open = new JMenuItem("Open File");

        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        
        text = new JMenuItem("Text");

        file.add(open);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        
        help.add(text);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        frame.getContentPane().setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(0, 0, 0, 0);
        frame.getContentPane().add(textArea);

        
        
        ActionListener abrirFichero = new ActionListener() {
            @Override
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
                        StringBuilder texto = new StringBuilder();

                        while ((line = br.readLine()) != null) {
                            texto.append(line).append("\n");
                        }

                        textArea.setText(texto.toString());

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
        };
        
        ActionListener editorAction = new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    		
    			JMenuItem item = (JMenuItem)e.getSource();
    			if (item.getText().equals("Cut"))
    				textArea.cut();
    			
    			else if (item.getText().equals("Paste"))
    				textArea.paste();
    			
    			else if (item.getText().equals("Copy"))
    				textArea.copy();
    			
    			else if (item.getText().equals("Select All"))
    				textArea.selectAll();
    				
    		}
    	};

        open.addActionListener(abrirFichero);
    	
    	cut.addActionListener(editorAction);
        copy.addActionListener(editorAction);
        paste.addActionListener(editorAction);
        selectAll.addActionListener(editorAction);
        
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
        slider.setBounds(10, 73, 379, 180);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        frame.getContentPane().add(slider);
        
        JButton btnnewButton = new JButton("Valor slider");
        btnnewButton.setBounds(285, 69, 53, 42);
        
        SpinnerModel model = new SpinnerNumberModel(10, 0, 100, 2);
        
        JSpinner spinner = new  JSpinner(model);
        
        spinner.setEditor(new JSpinner.DefaultEditor(spinner));
        
        spinner.setBounds(404, 117, 84, 42);
        frame.getContentPane().add(spinner);
        
        
        String datos[][] = { {"Ensalada", "15$"},
        					 {"Hamburguesa", "20$"},
        					 {"Patatas", "7$"},
        					 {"Agua", "2$"}
        };
        
    	String columnas[]= {"CARTA", "PRECIO"};
    	JTable table = new JTable(datos,columnas);
    	table.setBounds(589,38,202,215);    	
    	frame.getContentPane().add(table);
    	
    	table.setCellSelectionEnabled(true);
    	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	ListSelectionModel selecion = table.getSelectionModel();
    	
    	selecion.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				if(!e.getValueIsAdjusting()) {
					
					int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					String valor = (String) table.getValueAt(row, column);
					System.out.println("El valor seleccionado es: " + valor);
				}
				
			}
		});
    	
    	JButton colorButton = new JButton("Cambiar Color de Fondo");
    	colorButton.setBounds(10, 10, 200, 30);
    	frame.getContentPane().add(colorButton);
    	
    	colorButton.addActionListener(new ActionListener() {
    		
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        
    	        Color selectedColor = JColorChooser.showDialog(frame, "Selecciona un Color de Fondo", frame.getBackground());

    	        if (selectedColor != null) {
    	            
    	            frame.getContentPane().setBackground(selectedColor);
    	        }
    	    }
    	});


    	
        }
    	

}
