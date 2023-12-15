package BaseDeDatos;

public class MainBD {

	public static void main(String[] args) {
		ConexionABaseDeDatos.abrirConexion();
		VisualizarBD.visualizarEmpleados();
		ConexionABaseDeDatos.cerramosConexion();
	}
}