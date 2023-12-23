package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Zoo.BordeadoTexto;
import Zoo.ImagePanel;

public class VentanaPrincipal {
	
	private JFrame ventana;
	private static VentanaPrincipal instancia;
	
	public VentanaPrincipal() {
        instancia = this;
		// Crear una ventana principal
        ventana = new JFrame("Ventana Principal");
        ventana.setBackground(Color.DARK_GRAY);
		ventana.setBounds(500, 50, 600, 700);
		ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImagePanel pnlTitulo = new ImagePanel("fondoJunglaParaPaneles.jpg");
        pnlTitulo.setLayout(new FlowLayout());
        BordeadoTexto lblTitulo = new BordeadoTexto( "ZOOYARZABAL" );
        Font fuente = new Font(lblTitulo.getFont().getName(), Font.BOLD, 24);
        lblTitulo.setFont(fuente);
        lblTitulo.setForeground(Color.YELLOW);
        pnlTitulo.add(lblTitulo);
        pnlTitulo.setPreferredSize(new Dimension(pnlTitulo.getPreferredSize().width, 40));
        ventana.add(pnlTitulo, BorderLayout.NORTH);
        //Panel para los botones
        ImagePanel pnlBotones = new ImagePanel("fondoJunglaParaPaneles.jpg");
        // Panel imagen
        JPanel pnlImagen = new JPanel();
        pnlImagen.setBackground(Color.DARK_GRAY);
        
       
        
        /*
         * Apartado donde colocaremos la imagen del zoo, por ahora una provisonal en el centro
         * de la ventana que se abrirá al ejecutar el programa
         */
        
        ImageIcon icono = new ImageIcon("iconoApp.jpg/"); // Después cambiaremos la ruta de acceso de la imagen cuando demos con la imagen final deseada
        Image imagen = icono.getImage();
        Image nuevaImagen = imagen.getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon nuevoIcono = new ImageIcon(nuevaImagen);
        JLabel labelImagen = new JLabel(nuevoIcono);
        pnlImagen.add(labelImagen);
        ventana.add(pnlImagen, BorderLayout.CENTER);
        
        // Botones para seleccionar si eres trabajador o visitante
        JButton btnTrabajador = new JButton("Soy Trabajador");
        btnTrabajador.setBackground(Color.DARK_GRAY);
        btnTrabajador.setForeground(Color.YELLOW);
        // ActionListener para el botón de trabajador
        btnTrabajador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose(); // Cerrar la ventana principal
                new VentanaTrabajador(ventana); // Abrir la ventana de trabajadores
            }
        });
        
        JButton btnVisitante = new JButton("Soy Visitante");
        btnVisitante.setBackground(Color.DARK_GRAY);
        btnVisitante.setForeground(Color.YELLOW);
        // ActionListener para el botón de visitante
        btnVisitante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose(); // Cerrar la ventana principal
                VentanaPrincipal.getInstancia().ventana.dispose();
                SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						new VentanaVisitante(ventana);
					}
				});
                // new VentanaVisitante(ventana); // Abrir la ventana de visitantes
            }
        });
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBackground(Color.DARK_GRAY);
        btnSalir.setForeground(Color.YELLOW);
        btnSalir.addActionListener((e)->{
        	System.exit(0);
        });
        pnlBotones.add(btnTrabajador);
        pnlBotones.add(btnVisitante);
        pnlBotones.add(btnSalir);
        // Agregar botones a la ventana principal
        ventana.add(pnlBotones, BorderLayout.SOUTH);
        
        
        
        ventana.setVisible(true);
        ventana.setResizable(false);
        
       
		
	}
	
	 public static VentanaPrincipal getInstancia() {
		return instancia;
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
