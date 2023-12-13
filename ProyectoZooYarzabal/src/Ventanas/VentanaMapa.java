package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaMapa extends JFrame{
	private JFrame vActual, vAnterior;
	private JButton btnVolver;
	private JPanel pSur;
	
	public VentanaMapa (JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setBounds(500, 300, 700, 250);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		btnVolver = new JButton("VOLVER");
		pSur = new JPanel();
		getContentPane().add(pSur, BorderLayout.SOUTH);
		pSur.add(btnVolver);
		
		btnVolver.addActionListener((e)->{
			vAnterior.setVisible(true);
			vActual.dispose();
		});		
		
		setVisible(true);
	}

	
	//Aqui ira una imagen del mapa
	
	
}
