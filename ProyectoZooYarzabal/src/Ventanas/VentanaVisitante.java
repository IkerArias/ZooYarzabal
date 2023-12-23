package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Zoo.BordeadoTexto;
import Zoo.ImagePanel;
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class VentanaVisitante extends JFrame{
	private static JFrame vActual;
	private JFrame vAnterior;
	private JButton btnEventos, btnMapa, btnInfoAnimales, btnVolver;
	private JPanel pnlNorte, pnlBotones, pnlSur;
	private JLabel lblTitulo;
	private EmbeddedMediaPlayerComponent component;
	
//	public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//    		System.setProperty("jna.library.path", "C:/Program Files/VideoLAN/VLC");
//            JFrame frame = new VentanaVisitante(null); // Para el JFrame anterior, pasa null
//        });
//    }
	
	public static void main(String[] args) {
		System.out.println("a");
		// boolean found = (new NativeDiscovery()).discover();
		System.setProperty("jna.library.path", "C:/Program Files/VideoLAN/VLC");
		miVentana = new VentanaVisitante(vActual);
		System.out.println("b");
		miVentana.lanzarVideo("Go!azen 10_ _Zoriontasuna_.mp4");
		System.out.println((new NativeDiscovery()).discoveredPath());

	}
	
	private static VentanaVisitante miVentana;
	
	public VentanaVisitante(JFrame va) {
		super();
		setResizable(false);
		setTitle( "INFORMACIÓN PARA LOS VISITANTES" );
		vActual = this;
		vAnterior = va;
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setBounds(500, 150, 1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		ImagePanel pnlTitulo = new ImagePanel("fondoJunglaParaPaneles.jpg");
		pnlTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        BordeadoTexto lblTitulo = new BordeadoTexto( "BIENVENIDO AL ZOO" );
        Font fuente = new Font(lblTitulo.getFont().getName(), Font.BOLD, 30);
        lblTitulo.setFont(fuente);
        lblTitulo.setForeground(Color.YELLOW);
        pnlTitulo.add(lblTitulo);
        pnlTitulo.setPreferredSize(new Dimension(pnlTitulo.getPreferredSize().width, 50));
        add(pnlTitulo, BorderLayout.NORTH);
        
        /*
         * Vamos a meter el video dentro de un panel y toda la ventana será controlada
         * por un JScrollPane, el video será sacado de Youtube, ya que no contamos con
         * los recursos para hacer uno nosotros mismos.
         */
        
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        
        JPanel panelVideoyBotones = new JPanel(new BorderLayout());
        
        
        component = new EmbeddedMediaPlayerComponent();    
        panelVideoyBotones.add(component, BorderLayout.CENTER);
        panelPrincipal.add(panelVideoyBotones, BorderLayout.CENTER);
        
        JPanel panelBotonesVideo = new JPanel(new FlowLayout());
        JButton botonPausa = new JButton( "Pausar" );
        botonPausa.setBackground(Color.DARK_GRAY);
        botonPausa.setForeground(Color.YELLOW);
        panelBotonesVideo.add(botonPausa);
        JButton botonReiniciar = new JButton( "Reiniciar" );
        botonReiniciar.setBackground(Color.DARK_GRAY);
        botonReiniciar.setForeground(Color.YELLOW);
        panelBotonesVideo.add(botonReiniciar);
        
        botonPausa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (component.mediaPlayer().status().isPlaying()) {
					component.mediaPlayer().controls().pause();
				}else {
					component.mediaPlayer().controls().play();
				}
			}
		});
        
        botonReiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				component.mediaPlayer().controls().pause();
				component.mediaPlayer().controls().setTime(0);
				component.mediaPlayer().controls().play();
			}
		});
        
        panelVideoyBotones.add(panelBotonesVideo, BorderLayout.SOUTH);
        
        
        /*
         * JTextArea con el texto de bienvenida
         */
		
        JPanel pnlTexto = new JPanel(new GridBagLayout());
        // Agregaremos algunas condiciones para que luego el JTextArea se vea mejor
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1; 
        gbc.weightx = 1.0; 
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        
        
        JTextArea areaTexto = new JTextArea();
        areaTexto.setOpaque(false);
        areaTexto.setBackground(new Color(0, 0, 0, 0));
        areaTexto.setRows(10);
        areaTexto.setColumns(30);
        areaTexto.setText(
                "¡Bienvenidos al Zoológico Zooyarzabal!\n\n" +
                "Estamos emocionados de presentarles nuestro zoológico, donde podrán experimentar " +
                "la diversidad y belleza de la vida animal. Algunas de las atracciones destacadas incluyen:\n\n" +
                "- **Safari Africano**: Observa a majestuosos leones, elefantes, jirafas y rinocerontes en su hábitat natural.\n" +
                "- **Acuario Marino**: Sumérgete en las profundidades del océano y descubre una variedad de peces tropicales, tiburones y corales vibrantes.\n" +
                "- **Selva Amazónica**: Explora la rica biodiversidad de la selva amazónica, desde coloridos loros hasta intrigantes jaguares y perezosos.\n" +
                "- **Habitat Polar**: Experimenta el frío ártico mientras observas a osos polares, pingüinos y otras criaturas adaptadas a las condiciones extremas.\n\n" +
                "Además de nuestras atracciones principales, ofrecemos espectáculos diarios, charlas educativas y actividades interactivas para toda la familia. " +
                "Esperamos que disfruten de esta aventura única y se lleven recuerdos inolvidables de su visita a Zooyarzabal."
        );
        areaTexto.setEditable(false);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setLineWrap(true);
        Font fuenteLetra = new Font("Arial", Font.BOLD, 16);
        areaTexto.setFont(fuenteLetra);
        areaTexto.setForeground(Color.YELLOW);
        
        ImagePanel imagePanel = new ImagePanel("fondoMarino.jpg");
        imagePanel.setLayout(new BorderLayout());
        imagePanel.add(areaTexto, BorderLayout.CENTER);
        
        
        panelPrincipal.add(imagePanel, BorderLayout.SOUTH);
        add(panelPrincipal);
        
        
        ImagePanel pnlBotones = new ImagePanel("fondoJunglaParaPaneles.jpg");
        btnEventos = new JButton("EVENTOS");
        btnEventos.setBackground(Color.DARK_GRAY);
        btnEventos.setForeground(Color.YELLOW);
		btnMapa = new JButton("MAPA");
		btnMapa.setBackground(Color.DARK_GRAY);
        btnMapa.setForeground(Color.YELLOW);
		btnInfoAnimales = new JButton("INFORMACIÓN DE ANIMALES");
		btnInfoAnimales.setBackground(Color.DARK_GRAY);
		btnInfoAnimales.setForeground(Color.YELLOW);
		btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(Color.DARK_GRAY);
		btnVolver.setForeground(Color.YELLOW);
		pnlBotones.add(btnEventos);
		pnlBotones.add(btnMapa);
		pnlBotones.add(btnInfoAnimales);
		pnlBotones.add(btnVolver);
		add(pnlBotones, BorderLayout.SOUTH);
		
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
		
		btnVolver.addActionListener((e)->{
	        vAnterior.setVisible(true);
			vActual.dispose();
	    });
	
//		JScrollPane jScrollPane = new JScrollPane(vActual);
//		add(jScrollPane);
		
		setVisible(true);
		
		

	
}
	private void lanzarVideo(String urlVideo) {
		component.mediaPlayer().audio().setVolume(75); // para que no salga a tope el volúmen
		component.mediaPlayer().media().play(urlVideo);
	}
}
	
	
