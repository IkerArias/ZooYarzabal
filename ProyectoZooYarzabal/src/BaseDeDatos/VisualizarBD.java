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

import Zoo.Empleado;

public class VisualizarBD {
	
	private static Connection conexion;
	
	public static Connection visualizarEmpleados() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:Zooyarzabal.db");
			
			try {
				Statement statement = conexion.createStatement();
				ArrayList<Empleado> empleados = new ArrayList<>();
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
					
					empleados.add(empleado);
					for ( Empleado emp : empleados ) {
						System.out.println( emp + "\n" );
					}
				}
				rs.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conexion;
	}

}
