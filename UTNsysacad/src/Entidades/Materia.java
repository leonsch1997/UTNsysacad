package Entidades;

public class Materia {
	
	@Override
	public String toString() {
		return "Materia: " + idMateria + " - " + nombre + ".";
	}
	int idMateria;
	String nombre;
	String descripcion;
	
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getdescripcion() {
		return descripcion;
	}
	public void setdescripcion(String descp) {
		this.descripcion = descp;
	}
	
}
