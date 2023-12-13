package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaSeguridad extends JFrame {
	protected JFrame vActual, vAnterior;
	protected JButton btnVolver;
	protected JPanel pSur;
	
	public VentanaSeguridad(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setTitle("Ventana de Seguridad");
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
	
	/*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaSeguridad();
            }
        });

}*/

}
