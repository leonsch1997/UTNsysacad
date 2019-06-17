package Entidades;

public class Alumno extends Persona {	
	
	private String legajo;
	private double promedio;
	
	@Override
	public String toString() {
		/*return "legajo=" + legajo + ", Nombre=" + getNombre()
				+ ", Apelldo=" + getApellido() + ", Email=" + getEmail() + ", Contrase�a="
				+ getContrase�a() + ", Telefono=" + getTelefono() + ", Direccion, " + getDireccion().toString()+".";*/
		return "Alumno:"+ getNombre()+", "+getApellido()+".";
	}

	public Alumno()
	{
		
		
	}
	
	public Alumno(String nombre, String apellido, String email,String contrase�a,String telefono, String legajo, String calle,int numero)
	{
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setEmail(email);
		this.setContrase�a(contrase�a);
		this.setTelefono(telefono);
		this.setLegajo(legajo);
		Direccion dir = new Direccion(calle,numero);
		this.setDireccion(dir);
	}
	
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
}
