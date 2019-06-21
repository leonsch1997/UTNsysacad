package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Data.*;
import Entidades.*;


public class UIdesktop {

	public static void main(String[] args) {
		
		DataAlumno DA = new DataAlumno();
		
		
		//System.out.println(DA.getOne("43904").toString()); 
		//DA.addAlumno("Agustin","Gonzales","44539","4569987","agozanles@gmail.com","asd4568","Mexico",1456);
		//DA.addAlumno("test","tes","1","455557","test@gmail.com","test123","test",123);
		//DA.delete("1");
		
		ArrayList<Alumno> alumnos =DA.getAll(); 
		for (Alumno A:alumnos) 
		{
			System.out.println(A.toString());
			System.out.println("");
		}
		
		
		
		DataDireccion DD = new DataDireccion();
		ArrayList<Direccion> direcciones =DD.getAll(); 
		for (Direccion D:direcciones) 
		{
			System.out.println(D.toString());
		}
		
		/*Scanner s= new Scanner(System.in);
		Alumno A2 = new Alumno();
		System.out.println("Ingrese nombre:");
		A2.setNombre(s.nextLine());
		System.out.println("Ingrese Apellido:");
		A2.setApellido(s.nextLine());
		System.out.println("Ingrese Legajo:");
		A2.setLegajo(s.nextLine());
		System.out.println("Ingrese Telefono:");
		A2.setTelefono(s.nextLine());
		System.out.println("Ingrese email:");
		A2.setEmail(s.nextLine());
		System.out.println("Ingrese Contraseña:");
		A2.setContraseña(s.nextLine());*/
	}	
}
