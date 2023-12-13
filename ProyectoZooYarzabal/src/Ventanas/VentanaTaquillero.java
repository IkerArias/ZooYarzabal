package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Zoo.Visitante;
import Zoo.Visitante;
import Zoo.ZOO;

public class VentanaTaquillero extends JFrame {
	protected JFrame vActual, vAnterior;
	protected JButton btnVolver;
	protected JPanel pSur;

	private static final long serialVersionUID = 1L;
	
	public ZOO zoo;
	
	// Método obtener precio de la entrada del visitante
	public int precioEntrada() {
		int precio = (int) 19.99;
		Visitante v = new Visitante();
		int precioFinal = precio - v.obtenerDscuento()*precio;
		return precioFinal;
		
	}

	public VentanaTaquillero(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setTitle("Ventana del Taquillero");
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
                new VentanaTaquillero();
            }
        });
        
        }*/

}

