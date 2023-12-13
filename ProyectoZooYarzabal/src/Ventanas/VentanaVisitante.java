package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaVisitante extends JFrame{
	private JFrame vActual, vAnterior;
	private JButton btnEventos, btnMapa, btnInfoAnimales, btnVolver;
	private JPanel pnlNorte, pnlBotones, pnlSur;
	private JLabel lblTitulo;
	
	public VentanaVisitante(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setBounds(500, 300, 700, 250);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		lblTitulo = new JLabel("INORMACION PARA VISITANTES");
		pnlNorte = new JPanel();
		getContentPane().add(pnlNorte, BorderLayout.NORTH);
		pnlNorte.add(lblTitulo);
		
		pnlBotones = new JPanel();
		getContentPane().add(pnlBotones, BorderLayout.CENTER);
		btnEventos = new JButton("EVENTOS");
		btnMapa = new JButton("MAPA");
		btnInfoAnimales = new JButton("INFORMACIÓN DE ANIMALES");
		btnVolver = new JButton("VOLVER");
		
		btnEventos.addActionListener((e)->{
			JOptionPane.showMessageDialog(null, "Has seleccionado la opción de Eventos", "EVENTOS", JOptionPane.INFORMATION_MESSAGE);
			new VentanaEventos(vActual);
			vActual.dispose();
		});
		
		btnMapa.addActionListener((e)->{
			JOptionPane.showMessageDialog(null, "Has seleccionado la opción de Mapa", "MAPA", JOptionPane.INFORMATION_MESSAGE);
			new VentanaMapa(vActual);
			vActual.dispose();
		});
		
		btnInfoAnimales.addActionListener((e)->{
			JOptionPane.showMessageDialog(null, "Has seleccionado la opción de informacion sobre Animales", "ANIMALES", JOptionPane.INFORMATION_MESSAGE);
			new VentanaAnimales(vActual);
			vActual.dispose();
		});
				
		pnlBotones.add(btnInfoAnimales);
	    pnlBotones.add(btnMapa);
	    pnlBotones.add(btnEventos);
	    
	    pnlSur = new JPanel();
	    getContentPane().add(pnlSur, BorderLayout.SOUTH);
	    
	    btnVolver.addActionListener((e)->{
			vAnterior.setVisible(true);
			vActual.dispose();
		});
	    
	    pnlSur.add(btnVolver);
		
		
		setVisible(true);

	
}
}
	
	
