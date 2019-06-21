package UI;

import java.sql.*;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;
import Entidades.*;

public class Connection {

	public static void main(String[] args) {
		
		//driver
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//Connection
		java.sql.Connection conn = null;
		String url    = "jdbc:sqlserver://localhost;database=UTN";
		String user   = "UTN_user";
		String pass   = "hx2su9bb";
		
		try {
			
			//start Connection
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("Connection okey...");
			System.out.println("");

			
			/*Consulta Materias
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from Materias");
			
			while(rs.next()) {
				Materia M = new Materia();
				
				M.setIdMateria(rs.getInt("idMateria"));
				M.setNombre(rs.getString("nombre"));
				
				System.out.println(M);
				}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}*/
			

			
			//Nuevo alumno
			Scanner s= new Scanner(System.in);
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
			A2.setContraseña(s.nextLine());
			System.out.println("Ingrese Direccion");
			System.out.println("calle:");
			Direccion D = new Direccion();
			D.setCalle(s.nextLine());
			System.out.println("Numero:");
			D.setNumero(s.nextInt());
			
			//Crear nueva Direccion
			PreparedStatement pstmt=conn.prepareStatement("insert into Direcciones(calle,numero) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, D.getCalle());
			pstmt.setInt(2, D.getNumero());
	
			pstmt.executeUpdate();
			
			//id Direccion
			ResultSet keyResultSet=pstmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()) {
				int id=keyResultSet.getInt(1);
				D.setidDireccion(id);
			}		
			
			//agregar direccion al alumno
			A2.setDireccion(D);
			
			//crear nuevo alumno
			PreparedStatement pstmt2=conn.prepareStatement("insert into Alumnos(nombre,apellido,email,telefono,contraseña,legajo,idDireccion) values(?,?,?,?,?,?,?)");
			pstmt2.setString(1, A2.getNombre());
			pstmt2.setString(2, A2.getApellido());
			pstmt2.setString(3, A2.getEmail());
			pstmt2.setString(4, A2.getTelefono());
			pstmt2.setString(5, A2.getContraseña());
			pstmt2.setString(6, A2.getLegajo());
			pstmt2.setInt(7, A2.getDireccion().getidDireccion());
			
			pstmt2.executeUpdate();
			
			//cerrar conexion y scanner
			s.close();
			conn.close();
			System.out.println("");
			System.out.println("Connection cerrada...");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error con el Driver...");
			System.out.println("");
			e.printStackTrace();
			
		} catch(SQLException e) {
			System.out.println("Error en la connection...");
			System.out.println("");
			e.printStackTrace();
		}
	}

}
