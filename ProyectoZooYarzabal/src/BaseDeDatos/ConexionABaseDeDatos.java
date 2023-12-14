package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionABaseDeDatos {

	private static Connection conexion;
	
	public static Connection abrirConexion() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:/C:/Users/unaio/OneDrive/Escritorio/javaDataBaseTutorials.db/");
			System.out.println( "Conectado a la base de datos!" );
			
			// Vamos a crear la base de datos desde 0
			System.out.println( "Creando base de datos... " );
			Statement statement = conexion.createStatement();
			String sent = "CREATE TABLE IF NOT EXISTS Animales (id_animal INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, especie TEXT NOT NULL, fecha_nacimiento DATE, genero TEXT, habitat TEXT, CONSTRAINT fk_habitat FOREIGN KEY (habitat) REFERENCES Habitats(nombre));";
			System.out.println( sent );
			statement.executeUpdate( sent );
			sent = "CREATE TABLE IF NOT EXISTS Habitats (id_habitat INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, tipo TEXT);";
			System.out.println( sent );
			statement.executeUpdate( sent );
			sent = "CREATE TABLE IF NOT EXISTS Empleados (id_empleado INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, puesto TEXT, salario REAL, fecha_contratacion DATE);";
			System.out.println( sent );
			statement.executeUpdate( sent );
			sent = "CREATE TABLE IF NOT EXISTS Visitantes (id_visitante INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, edad INTEGER, fecha_visita DATE);";
			System.out.println( sent );
			statement.executeUpdate( sent );
			sent = "CREATE TABLE IF NOT EXISTS Exhibiciones (id_exhibicion INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, descripcion TEXT, id_animal INTEGER, CONSTRAINT fk_animal FOREIGN KEY (id_animal) REFERENCES Animales(id_animal));";
			System.out.println( sent );
			statement.executeUpdate( sent );
			System.out.println( "Tablas creadas correcatamente" );
			// Tablas ya creadas
			
			// Ahora meteremos datos a las tablas
			sent = "INSERT INTO Habitats (id_habitat, nombre, tipo) VALUES\r\n"
					+ "(99, 'Selva', 'Tropical'),\r\n"
					+ "(98, 'Savannah', 'Árido'),\r\n"
					+ "(97, 'Acuario', 'Acuático'),\r\n"
					+ "(96, 'Bosque', 'Templado'),\r\n"
					+ "(95, 'Desierto', 'Árido'),\r\n"
					+ "(94, 'Jungla', 'Tropical'),\r\n"
					+ "(93, 'Polar', 'Frío'),\r\n"
					+ "(92, 'Sabana', 'Árido'),\r\n"
					+ "(91, 'Océano', 'Acuático'),\r\n"
					+ "(90, 'Montaña', 'Frío');";
			System.out.println( "Habitats creados" );
			statement.execute( sent );
			
			// CURIOSAMENTE FUNCIONA HASTA AQUÍ LUEGO SALTA EL ERROR DE SQLITE_BUSY
			
			sent = "INSERT INTO Animales (id_animal, nombre, especie, fecha_nacimiento, genero, habitat) VALUES\r\n"
					+ "(1, 'León', 'Panthera leo', '2010-05-15', 'Macho', 'Savannah'),\r\n"
					+ "(2, 'Tigre', 'Panthera tigris', '2012-02-28', 'Hembra', 'Selva'),\r\n"
					+ "(3, 'Delfín', 'Delphinidae', '2015-08-10', 'Macho', 'Acuario'),\r\n"
					+ "(4, 'Oso Polar', 'Ursus maritimus', '2013-12-20', 'Hembra', 'Polar'),\r\n"
					+ "(5, 'Elefante', 'Loxodonta africana', '2008-07-03', 'Macho', 'Sabana'),\r\n"
					+ "(6, 'Pingüino', 'Spheniscidae', '2016-04-05', 'Hembra', 'Polar'),\r\n"
					+ "(7, 'Jirafa', 'Giraffa camelopardalis', '2011-11-12', 'Macho', 'Savannah'),\r\n"
					+ "(8, 'Tortuga Marina', 'Cheloniidae', '2014-09-18', 'Hembra', 'Océano'),\r\n"
					+ "(9, 'Mono', 'Cercopithecidae', '2017-06-25', 'Macho', 'Jungla'),\r\n"
					+ "(10, 'Lince Ibérico', 'Lynx pardinus', '2019-03-08', 'Hembra', 'Bosque');\r\n"
					+ "";
			System.out.println( "Animales insertados" );
			statement.executeUpdate( sent );
			
			sent = "INSERT INTO Empleados (id_empleado, nombre, puesto, salario, fecha_contratacion) VALUES\r\n"
					+ "(1, 'Juan Pérez', 'Guardián', 30000.00, '2010-03-15'),\r\n"
					+ "(2, 'María López', 'Biologo', 45000.00, '2012-08-22'),\r\n"
					+ "(3, 'Carlos Rodriguez', 'Veterinario', 50000.00, '2014-05-10'),\r\n"
					+ "(4, 'Ana Gómez', 'Cuidador', 28000.00, '2015-11-28'),\r\n"
					+ "(5, 'Pedro Martinez', 'Guía Turístico', 35000.00, '2018-02-14'),\r\n"
					+ "(6, 'Laura Sanchez', 'Cocinero', 32000.00, '2019-09-30'),\r\n"
					+ "(7, 'Roberto Castro', 'Limpiador', 25000.00, '2011-07-17'),\r\n"
					+ "(8, 'Elena Ramírez', 'Administrador', 55000.00, '2013-04-12'),\r\n"
					+ "(9, 'Javier González', 'Entrenador', 40000.00, '2016-06-08'),\r\n"
					+ "(10, 'Sofía Herrera', 'Contador', 48000.00, '2020-01-25');\r\n"
					+ "";
			System.out.println( "Empleado registrados" );
			statement.executeUpdate( sent );
			
			sent = "INSERT INTO Visitantes (id_visitante, nombre, edad, fecha_visita) VALUES\r\n"
					+ "(1, 'Familia López', 35, '2023-01-05'),\r\n"
					+ "(2, 'Juan Martínez', 25, '2023-02-12'),\r\n"
					+ "(3, 'María Sánchez', 28, '2023-03-20'),\r\n"
					+ "(4, 'Pedro Ramírez', 40, '2023-04-08'),\r\n"
					+ "(5, 'Laura Hernández', 22, '2023-05-15'),\r\n"
					+ "(6, 'Carlos Rodríguez', 50, '2023-06-23'),\r\n"
					+ "(7, 'Ana Gómez', 30, '2023-07-10'),\r\n"
					+ "(8, 'Roberto Castro', 45, '2023-08-18'),\r\n"
					+ "(9, 'Elena Ramírez', 55, '2023-09-25'),\r\n"
					+ "(10, 'Javier González', 38, '2023-10-30');\r\n"
					+ "";
			System.out.println( "Visitantes registrados" );
			statement.executeUpdate( sent );
			
			sent = "INSERT INTO Exhibiciones (id_exhibicion, nombre, descripcion, id_animal) VALUES\r\n"
					+ "(1, 'Show de Leones', 'Increíble espectáculo de leones en acción.', 1),\r\n"
					+ "(2, 'Hábitat del Tigre', 'Observa a los tigres en su entorno natural.', 2),\r\n"
					+ "(3, 'Delfinario', 'Disfruta de acrobacias y saltos de delfines.', 3),\r\n"
					+ "(4, 'Encuentro Polar', 'Observa a los osos polares nadar y jugar.', 4),\r\n"
					+ "(5, 'Safari de Elefantes', 'Recorre la sabana y conoce a los elefantes.', 5),\r\n"
					+ "(6, 'Mundo Marino', 'Explora la vida marina y conoce a los pingüinos.', 6),\r\n"
					+ "(7, 'Cuello de Jirafa', 'Aprende sobre las jirafas y su cuello largo.', 7),\r\n"
					+ "(8, 'Tortugas en Acción', 'Descubre la vida de las tortugas marinas.', 8),\r\n"
					+ "(9, 'Selva de Monos', 'Observa a los monos jugando y interactuando.', 9),\r\n"
					+ "(10, 'Rincon del Lince', 'Conoce al lince ibérico en su hábitat natural.', 10);\r\n"
					+ "";
			System.out.println( "Exhibiciones organizadas" );
			statement.executeUpdate( sent );
			
			System.out.println( "Datos introducidos correctamente" );
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( e + "" );
		}
		return conexion;
	}
	
	// Ya una vez que hayamos realizado las operaciones cerramos la conexión
	public static void cerramosConexion() {
		try {
			conexion.close();
			System.out.println( "Conexión cerrada con éxito! ");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
