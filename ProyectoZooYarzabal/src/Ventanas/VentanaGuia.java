package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaGuia extends JFrame{
	protected JFrame vActual, vAnterior;
	protected JButton btnVolver;
	protected JPanel pSur;
	
	public VentanaGuia(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setTitle("Ventana del Guia");
		setBounds(500, 300, 700, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener((e)->{
        	vAnterior.setVisible(true);
        	vActual.dispose();
        });
        pSur = new JPanel();
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.add(btnVolver);
        
        setVisible(true);
	}

}
