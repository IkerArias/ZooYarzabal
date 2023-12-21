package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class VentanaVisitante extends JFrame{
	private JFrame vActual, vAnterior;
	private JButton btnEventos, btnMapa, btnInfoAnimales, btnVolver;
	private JPanel pnlNorte, pnlBotones, pnlSur;
	private JLabel lblTitulo;
	
	public VentanaVisitante(JFrame va) {
		super();
		setTitle( "INFORMACIÓN PARA LOS VISITANTES" );
		vActual = this;
		vAnterior = va;
		setBounds(500, 300, 700, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImagePanel pnlTitulo = new ImagePanel("C:/ProgIII/a.jpg/");
        pnlTitulo.setLayout(new FlowLayout());
        BordeadoTexto lblTitulo = new BordeadoTexto( "BIENVENIDO AL ZOO" );
        Font fuente = new Font(lblTitulo.getFont().getName(), Font.BOLD, 24);
        lblTitulo.setFont(fuente);
        lblTitulo.setForeground(Color.YELLOW);
        pnlTitulo.add(lblTitulo);
        pnlTitulo.setPreferredSize(new Dimension(pnlTitulo.getPreferredSize().width, 40));
        add(pnlTitulo, BorderLayout.NORTH);
        
        /*
         * Vamos a meter el video dentro de un panel y toda la ventana será controlada
         * por un JScrollPane, el video será sacado de Youtube, ya que no contamos con
         * los recursos para hacer uno nosotros mismos.
         */
        
        JPanel pnlVideo = new JPanel();
 
        EmbeddedMediaPlayerComponent component = new EmbeddedMediaPlayerComponent();
        component.mediaPlayer().media().play("C:/Users/unaio/Downloads/Go!azen 10_ _Zoriontasuna_.mp4");
        getContentPane.add(pnlVideo, BorderLayout.CENTER);
		
		
//		lblTitulo = new JLabel("INORMACION PARA VISITANTES");
//		pnlNorte = new JPanel();
//		getContentPane().add(pnlNorte, BorderLayout.NORTH);
//		pnlNorte.add(lblTitulo);
		
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
	
	
