package Zoo;

import java.sql.Date;

public class Visitante {
	
	String id_visitante, nombre;
	int edad;
	Date fecha_visita;
	@Override
	public String toString() {
		return "Visitante [id_visitante=" + id_visitante + ", nombre=" + nombre + ", edad=" + edad + ", fecha_visita="
				+ fecha_visita + "]";
	}
	public String getId_visitante() {
		return id_visitante;
	}
	public void setId_visitante(String id_visitante) {
		this.id_visitante = id_visitante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Date getFecha_visita() {
		return fecha_visita;
	}
	public void setFecha_visita(Date fecha_visita) {
		this.fecha_visita = fecha_visita;
	}

}
