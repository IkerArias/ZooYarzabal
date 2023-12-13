package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Zoo.Trabajador;
import Zoo.ZOO;

public class VentanaTrabajador extends JFrame{
	private JLabel lblTitulo, lblDniR, lblnomR, lblConR, lblPuestoR, lblDniIS, lblconIS;
	private JButton btnVolver, btnInicio, btnRegistro;
	private JTextField txtDniR, txtnomR, txtDniIS;
	private JPasswordField txtconR, txtconIS;
	private JPanel pNorte, pSur, pCentro, pCentrodch, pCentroizq;
	private JFrame vActual, vAnterior;
	private JComboBox<String> txtPuestoR;
	
	public VentanaTrabajador (JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setBounds(500, 300, 700, 250);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		lblTitulo = new JLabel("INICIO DE SESIÓN TRABAJADOR");
		pNorte = new JPanel();
		getContentPane().add(pNorte, BorderLayout.NORTH);
		pNorte.add(lblTitulo);
		
		pCentro = new JPanel(new GridLayout(2,2));
		pCentrodch = new JPanel(new GridLayout(2,2));
		pCentroizq = new JPanel(new GridLayout(4, 4));
		
		//Registro
		lblPuestoR = new JLabel("Puesto de trabajo:");
		String[] opcionesArray = {"Elige una opcion", "LIMPIEZA", "MANTENIMIENTO", "CUIDADOR", "VETERINARIO", "GUIA", "ADMINISTRADOR", "DISEÑADOR DE EVENTOS", "TAQUILLERO", "GUARDIA DE SEGURIDAD"};
        txtPuestoR = new JComboBox<>(opcionesArray);
        lblnomR = new JLabel("Nombre:");
        txtnomR = new JTextField();
        lblDniR = new JLabel("DNI:");
        txtDniR = new JTextField();
        lblConR = new JLabel("Contraseña:");
        txtconR = new JPasswordField();
        pCentroizq.add(lblPuestoR);
        pCentroizq.add(txtPuestoR);
        pCentroizq.add(lblnomR);
        pCentroizq.add(txtnomR);
        pCentroizq.add(lblDniR);
        pCentroizq.add(txtDniR);
        pCentroizq.add(lblConR);
        pCentroizq.add(txtconR);
        getContentPane().add(pCentro, BorderLayout.CENTER);
        pCentro.add(pCentroizq);
        
        //Inicio sesion
        lblDniIS = new JLabel("DNI:");
        txtDniIS = new JTextField();
        lblconIS = new JLabel("Contraseña:");
        txtconIS = new JPasswordField();
        pCentrodch.add(lblDniIS);
        pCentrodch.add(txtDniIS);
        pCentrodch.add(lblconIS);
        pCentrodch.add(txtconIS);
        pCentro.add(pCentrodch);
        
        //Boton Registro
        btnRegistro = new JButton("REGISTRARSE");
        pCentro.add(btnRegistro);
        
        //Boton Inicio sesion
        btnInicio = new JButton("INICIAR SESIÓN");
        pCentro.add(btnInicio);
        
        //Boton volver
        btnVolver = new JButton("VOLVER");
        pSur = new JPanel();
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.add(btnVolver);
        
        Zoo.cargarFicheroTrabajadoresEnLista("Trabajadores.csv");
		
        btnVolver.addActionListener((e)->{
        	vAnterior.setVisible(true);
			vActual.dispose();
			Zoo.guardarListaTrabajadoresEnFichero("Trabajadores.csv");
        });
             
       
        //Boton Registrarse
        btnRegistro.addActionListener((e)->{
        	String p_tra = txtPuestoR.getActionCommand();
			String nom = txtnomR.getText();
			String dni = txtDniR.getText();
			String con = txtconR.getText();
			Trabajador t = new Trabajador(p_tra, nom, dni, con);
			if(Zoo.buscarTrabajador(dni) == null) {
				Zoo.aniadirTrabajador(t);
				JOptionPane.showMessageDialog(null, "Cliente registrado correctamente","REGISTRADO CORRECTAMENTE",JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese DNI", "ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
			}
			limpiarCampos();
		});
        
        //Boton Inicio Sesion
        btnInicio.addActionListener((e)->{
			String dni = txtDniIS.getText();
			String con = txtconIS.getText();
			String tipoTrabajador = (String) txtPuestoR.getSelectedItem();
			Trabajador t = Zoo.buscarTrabajador(dni);
			if(t == null) {
				JOptionPane.showMessageDialog(null, "El cliente no esta registrado", "Error en el inicio de sesion", JOptionPane.ERROR_MESSAGE);
			} else if(t.getCon().equals(con)) {
				JOptionPane.showMessageDialog(null, "Bienvenido "+t.getNombre(), "Inicio de sesion correcto", JOptionPane.INFORMATION_MESSAGE);
				abrirVentana(tipoTrabajador);
			} else {
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error en el inicio de sesion", JOptionPane.ERROR_MESSAGE);
			}
		});
        
        
        
        
        
		setVisible(true);
	}
	
	private void limpiarCampos() {
		txtDniIS.setText("");
		txtDniR.setText("");
		txtnomR.setText("");
		txtconR.setText("");
		txtconIS.setText("");
	}
	/*
    public VentanaTrabajador() {
    	
    //Paneles organizacion
    JPanel pnlComboBox = new JPanel();
    JPanel pnlUsuario = new JPanel();
    JPanel pnlContrasenia = new JPanel();
    	
    // Crear una ventana 
    ventana = new JFrame("Acceso de Trabajadores");
    ventana.setSize(800, 125);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLayout(new FlowLayout());
    
    // Crear ComboBox para elegir el tipo de trabajador
    tipoTrabajadorComboBox = new JComboBox<>();
    tipoTrabajadorComboBox.addItem("Limpieza");
    tipoTrabajadorComboBox.addItem("Mantenimiento");
    tipoTrabajadorComboBox.addItem("Cuidador");
    tipoTrabajadorComboBox.addItem("Veterinario");
    tipoTrabajadorComboBox.addItem("Guía");
    tipoTrabajadorComboBox.addItem("Administrador");
    tipoTrabajadorComboBox.addItem("Diseñador de Eventos");
    tipoTrabajadorComboBox.addItem("Taquillero");
    tipoTrabajadorComboBox.addItem("Guardia de Seguridad");
    	
    
    
    // Crear campos de usuario y contraseña
    usuarioTextField = new JTextField(15);
    contrasenaPasswordField = new JPasswordField(15);

    // Crear botón de inicio de sesión
    JButton btnIniciarSesion = new JButton("Iniciar Sesión");
    
    // Agregar componentes a la ventana
    pnlComboBox.add(new JLabel("Tipo de Trabajador:"));
    pnlComboBox.add(tipoTrabajadorComboBox);
    ventana.add(pnlComboBox, BorderLayout.NORTH);
    
    pnlUsuario.add(new JLabel("Usuario:"));
    pnlUsuario.add(usuarioTextField);
    ventana.add(pnlUsuario, BorderLayout.CENTER);
    
    pnlContrasenia.add(new JLabel("Contraseña:"));
    pnlContrasenia.add(contrasenaPasswordField);
    pnlContrasenia.add(btnIniciarSesion);
    ventana.add(pnlContrasenia, BorderLayout.SOUTH);
    
    
    
    // Agregar ActionListener al botón de inicio de sesión
    btnIniciarSesion.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usuario = usuarioTextField.getText();
            char[] contrasena = contrasenaPasswordField.getPassword();
            String tipoTrabajador = (String) tipoTrabajadorComboBox.getSelectedItem();

            if (verificarCredenciales(usuario, new String(contrasena))) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso como " + tipoTrabajador);
                abrirVentana(tipoTrabajador);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }

            contrasenaPasswordField.setText("");

		}
    });
    		//Mostrar la ventana
    		ventana.setVisible(true);
    
    }*/
    
	    protected void abrirVentana(String tipoTrabajador) {
		// TODO Auto-generated method stub
	        switch (tipoTrabajador) {
	            case "LIMPIEZA":
	                new VentanaLimpieza(vActual);
	                vActual.dispose();
	                break;
	            case "MANTENIMIENTO":
	                new VentanaMantenimiento(vActual);
	                vActual.dispose();
	                break;
	            case "CUIDADOR":
	                new VentanaCuidador(vActual);
	                vActual.dispose();
	                break;
	            case "VETERINARIO":
	                new VentanaVeterinario(vActual);
	                vActual.dispose();
	                break;
	            case "GUIA":
	                new VentanaGuia(vActual);
	                vActual.dispose();
	                break;
	            case "ADMINISTRADOR":
	                new VentanaAdministrador(vActual);
	                vActual.dispose();
	                break;
	            case "DISEÑADOR DE EVENTOS":
	                new VentanaDiseñadorEventos(vActual);
	                vActual.dispose();
	                break;
	            case "TAQUILLERO":
	                new VentanaTaquillero(vActual);
	                vActual.dispose();
	                break;
	            case "GUARDIA DE SEGURIDAD":
	                new VentanaSeguridad(vActual);
	                vActual.dispose();
	                break;
	            default:
	        }
		
	}
}