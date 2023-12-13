package Zoo;

import java.io.Serializable;
import java.util.Date;

public class AsignacionVet_Ani implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos
	protected Animal animal;
	protected Trabajador trabajador;
	protected Date fecha;
	
	// Getters y Setters
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	// Constructores
	public AsignacionVet_Ani(Animal animal, Trabajador trabajador, Date fecha) {
		super();
		this.animal = animal;
		this.trabajador = trabajador;
		this.fecha = fecha;
	}
	public AsignacionVet_Ani() {
		super();
		this.animal = new Animal();
		this.trabajador = new Trabajador();
		this.fecha = new Date();
	}
	
	// Método toString()
	@Override
	public String toString() {
		return "El animal " + animal.getID() + "ha sido emparejado al veterinario/a " + trabajador.getDNI() + "el día" + fecha + "]";
	}
	
	
}
