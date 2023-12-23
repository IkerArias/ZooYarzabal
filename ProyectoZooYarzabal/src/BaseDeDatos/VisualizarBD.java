package BaseDeDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import Zoo.Animal;
import Zoo.Empleado;
import Zoo.Exhibicion;
import Zoo.Habitat;
import Zoo.Visitante;

public class VisualizarBD {
	
	private static Connection conexion;
	
	public static ArrayList<Empleado> visualizarEmpleados() {
		ArrayList<Empleado> empleados = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:ZOOYARZABALBD.db");
			
			try {
				Statement statement = conexion.createStatement();
				String sent = "SELECT * FROM Empleados";
				ResultSet rs = statement.executeQuery( sent );
				while ( rs.next() ) { 
					String DNI = rs.getString( "id_empleado" );
					String NombreEmpleado = rs.getString( "nombre" );
					String PuestoEmpleado = rs.getString( "puesto" );
					float SalarioEmpleado = rs.getFloat( "salario" );
					
					// String FechaContratacion = rs.getString( "fecha_contratacion" );
					// SimpleDateFormat formatoFecha = new SimpleDateFormat( "yyyy-MM-dd" );
					// Date fechaContratacion = (Date) formatoFecha.parse(FechaContratacion);
					
					// java.util.Date fechaUtil = rs.getDate( "fecha_contratacion" );
					// java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());
					
					String fechaString = rs.getString( "fecha_contratacion" );
					SimpleDateFormat formatoFecha = new SimpleDateFormat( "yyyy-MM-dd" );
					java.util.Date fechaContratacion = formatoFecha.parse(fechaString);
					java.sql.Date fechaSQL = new java.sql.Date(fechaContratacion.getTime());
					
					Empleado empleado = new Empleado();
					empleado.setDNI(DNI);
					empleado.setNombreEmpleado(NombreEmpleado);
					empleado.setPuestoEmpleado(PuestoEmpleado);
					empleado.setSalarioEmpleado(SalarioEmpleado);
					
					// empleado.setFechaContratacion(fechaSQL);
					// empleado.setFechaContratacion(fechaContratacion);
					empleado.setFechaContratacion(fechaSQL);
					
//					empleados.add(empleado);
//					for ( Empleado emp : empleados ) {
//						System.out.println( emp + "\n" );
//					}
				}
				rs.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return empleados;
	}
	
	public static ArrayList<Habitat> visualizarHabitats() {
		ArrayList<Habitat> habitats = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:ZOOYARZABALBD.db");
			
			try {
				Statement statement = conexion.createStatement();
				String sent = "SELECT * FROM Habitats";
				ResultSet rs = statement.executeQuery( sent );
				while ( rs.next() ) {
					String id_habitat = rs.getString( "id_habitat" );
					String nombre = rs.getString( "nombre" );
					String tipo = rs.getString( "tipo" );
					
					Habitat habitat = new Habitat();
					habitat.setId_habitat(id_habitat);
					habitat.setNombre(nombre);
					habitat.setTipo(tipo);
					
					habitats.add(habitat);
					for ( Habitat h : habitats ) {
						System.out.println( h + "\n" );
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return habitats;
	}
	
	public static ArrayList<Animal> visualizarAnimales() {
		ArrayList<Animal> animales = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:ZOOYARZABALBD.db");
			
			try {
				Statement statement = conexion.createStatement();
				String sent = "SELECT * FROM Animales";
				ResultSet rs = statement.executeQuery( sent );
				while (rs.next()) {
					String id_animal = rs.getString( "id_animal" );
					String nombre = rs.getString( "nombre" );
					String especie = rs.getString( "especie" );
					String habitat = rs.getString( "habitat" );
					
					String fechaString = rs.getString( "fecha_nacimiento" );
					SimpleDateFormat formatoFecha = new SimpleDateFormat( "yyyy-MM-dd" );
					java.util.Date fechaNacimiento = formatoFecha.parse(fechaString);
					java.sql.Date fechaSQL = new java.sql.Date(fechaNacimiento.getTime());
					
					Animal animal = new Animal();
					animal.setId_animal(id_animal);
					animal.setNombre(nombre);
					animal.setEspecie(especie);
					animal.setFecha_nacimiento(fechaSQL);
					animal.setHabitat(habitat);
					
					animales.add(animal);
					
					for ( Animal a : animales ) {
						System.out.println( a + "\n" );
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return animales;
		
	}
	
	public static ArrayList<Visitante> visualizarVisitantes() {
		ArrayList<Visitante> visitantes = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:ZOOYARZABALBD.db");
			
			try {
				Statement statement = conexion.createStatement();
				String sent = "SELECT * FROM Visitantes";
				ResultSet rs = statement.executeQuery( sent );
				while (rs.next()) {
					String id_visitante = rs.getString( "id_visitante" );
					String nombre = rs.getString( "nombre" );
					int edad = rs.getInt( "edad" );
					String fechaString = rs.getString( "fecha_visita" );
					SimpleDateFormat formatoFecha = new SimpleDateFormat( "yyyy-MM-dd" );
					java.util.Date fechaVisita = formatoFecha.parse(fechaString);
					java.sql.Date fechaSQL = new java.sql.Date(fechaVisita.getTime());
					
					Visitante visitante = new Visitante();
					visitante.setId_visitante(id_visitante);
					visitante.setNombre(nombre);
					visitante.setEdad(edad);
					visitante.setFecha_visita(fechaSQL);
					visitantes.add(visitante);
					
					for ( Visitante a : visitantes ) {
						System.out.println( a + "\n" );
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return visitantes;
		
	}
	
	public static ArrayList<Exhibicion> visualizarExhibiciones() {
		ArrayList<Exhibicion> exhibiciones = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:ZOOYARZABALBD.db");
			
			try {
				Statement statement = conexion.createStatement();
				String sent = "SELECT * FROM Exhibiciones";
				ResultSet rs = statement.executeQuery( sent );
				while (rs.next()) {
					String id_exhibicion = rs.getString( "id_exhibicion" );
					String nombre = rs.getString( "nombre" );
					String descripcion = rs.getString( "descripcion" );
					String id_animal = rs.getString( "id_animal" );
					
					Exhibicion exhibicion = new Exhibicion();
					exhibicion.setId_exhibicion(id_exhibicion);
					exhibicion.setNombre(nombre);
					exhibicion.setDescripcion(descripcion);
					exhibicion.setId_animal(id_animal);
					
					exhibiciones.add(exhibicion);
					
					for ( Exhibicion a : exhibiciones ) {
						System.out.println( a + "\n" );
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return exhibiciones;
		
	}
	

}
