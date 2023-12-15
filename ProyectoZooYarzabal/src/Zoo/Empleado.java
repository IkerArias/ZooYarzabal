package Zoo;

import java.sql.Date;

import javax.xml.crypto.Data;

public class Empleado {
	String DNI, NombreEmpleado, PuestoEmpleado;
	float SalarioEmpleado;
	Date FechaContratacion;
	@Override
	public String toString() {
		return "Empleado [DNI=" + DNI + ", NombreEmpleado=" + NombreEmpleado + ", PuestoEmpleado=" + PuestoEmpleado
				+ ", SalarioEmpleado=" + SalarioEmpleado + ", FechaContratacion=" + FechaContratacion + "]";
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombreEmpleado() {
		return NombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		NombreEmpleado = nombreEmpleado;
	}
	public String getPuestoEmpleado() {
		return PuestoEmpleado;
	}
	public void setPuestoEmpleado(String puestoEmpleado) {
		PuestoEmpleado = puestoEmpleado;
	}
	public float getSalarioEmpleado() {
		return SalarioEmpleado;
	}
	public void setSalarioEmpleado(float salarioEmpleado) {
		SalarioEmpleado = salarioEmpleado;
	}
	public Date getFechaContratacion() {
		return FechaContratacion;
	}
	public void setFechaContratacion(Date fechaContratacion2) {
		FechaContratacion = fechaContratacion2;
	}
}
