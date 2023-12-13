package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaPrincipal {
	
	private JFrame ventana;
	
	public VentanaPrincipal() {
		
		// Crear una ventana principal
        ventana = new JFrame("Ventana Principal");
        ventana.setBounds(500, 300, 700, 250);
        
		// Crear una ventana principall
        ventana = new JFrame("Ventana Principal");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lblTitulo = new JLabel("ZOOYARZABAL");
        //Panel para los botones
        JPanel pnlBotones = new JPanel();
        // Panel imagen
        JPanel pnlImagen = new JPanel();
        JPanel pnlNorte = new JPanel();
        
        pnlNorte.add(lblTitulo);
        ventana.add(pnlNorte, BorderLayout.NORTH);
        
        /*
         * Apartado donde colocaremos la imagen del zoo, por ahora una provisonal en el centro
         * de la ventana que se abrirá al ejecutar el programa
         */
        
        ImageIcon icono = new ImageIcon("C:/Users/unaio/OneDrive/Imágenes/1197626.jpg"); // Después cambiaremos la ruta de acceso de la imagen cuando demos con la imagen final deseada
        Image imagen = icono.getImage();
        Image nuevaImagen = imagen.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon nuevoIcono = new ImageIcon(nuevaImagen);
        JLabel labelImagen = new JLabel(nuevoIcono);
        pnlImagen.add(labelImagen);
        ventana.add(pnlImagen, BorderLayout.CENTER);
        
        // Botones para seleccionar si eres trabajador o visitante
        JButton btnTrabajador = new JButton("Soy Trabajador");
        // ActionListener para el botón de trabajador
        btnTrabajador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose(); // Cerrar la ventana principal
                new VentanaTrabajador(ventana); // Abrir la ventana de trabajadores
            }
        });
        
        JButton btnVisitante = new JButton("Soy Visitante");
        // ActionListener para el botón de visitante
        btnVisitante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose(); // Cerrar la ventana principal
                new VentanaVisitante(ventana); // Abrir la ventana de visitantes
            }
        });
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener((e)->{
        	System.exit(0);
        });
        pnlBotones.add(btnTrabajador);
        pnlBotones.add(btnVisitante);
        pnlBotones.add(btnSalir);
        // Agregar botones a la ventana principal
        ventana.add(pnlBotones, BorderLayout.SOUTH);
        
        ventana.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if ((e.getKeyCode()== KeyEvent.VK_C && e.isControlDown())) {
					ventana.dispose();
				}
			}
		});
        
        ventana.setVisible(true);
        
       
		
	}
	
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new VentanaPrincipal();
	            }
	        });

	
}
}
