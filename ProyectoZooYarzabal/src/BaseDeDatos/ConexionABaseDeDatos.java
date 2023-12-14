package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionABaseDeDatos {

	public static Connection conectar() {
		Connection conexion = null;
		try {
			Class.forName("org.sqlite.JDBC");
			DriverManager.getConnection("jdbc:sqlite:/C:/Users/unaio/OneDrive/Escritorio/javaDataBaseTutorials.db/");
			System.out.println( "Conectado!" );
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( e + "" );
		}
		return conexion;
	}
}
