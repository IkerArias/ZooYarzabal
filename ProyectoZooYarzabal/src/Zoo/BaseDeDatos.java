package Zoo;

import java.lang.System.Logger;
import java.sql.*;
import java.util.logging.Level;

public class BaseDeDatos {
	
	private Logger logger = null;
	private static Exception ultimoError = null; 
	private Connection connection;
	
	public static void main(String[] args) {
		Connection connection = null;
		
		// Establecemos la conexión
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:ZOObd.db");
			
			// Empezamos a lanzar declaraciones
			Statement statement = connection.createStatement();
			
			// Creo una tabla para probar
			String crearTabla = "CREATE TABLE IF NOT EXISTS animal ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "nombre TEXT)";
			statement.execute(crearTabla);
			
			System.out.println( "Tabla creada exitosamente" );
			
		} catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Cerramos la conexión
				if ( connection != null ) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
