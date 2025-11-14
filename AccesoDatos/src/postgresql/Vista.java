package postgresql;

import java.sql.SQLException;
import java.util.Scanner;

public class Vista {
private static CRUD crud = new CRUD();
	
	public void menu() throws SQLException {	
		Scanner entrada = new Scanner(System.in);		
		crud.crearTabla();
		int opcion;
		int id;
		String nombre;
		String apellidos;
		int edad;
		
		do {
			mostrarMenu();
			opcion = entrada.nextInt();
			entrada.nextLine();
			
			switch (opcion) {
			case 1:
				System.out.println("Crear persona");
				System.out.println("Introduzca el id: ");
				id = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Introduzca el nombre: ");
				nombre = entrada.nextLine();
				System.out.println("Introduzca los apellidos: ");
				apellidos = entrada.nextLine();
				System.out.println("Introduzca la edad: ");
				edad = entrada.nextInt();
				entrada.nextLine();
				
				crud.crear(new Modelo (id, nombre, apellidos, edad));
				
				break;
			case 2:
				System.out.println("Leer persona");
				crud.leer();
				break;
			case 3:
				System.out.println("Actualizar persona");
				System.out.println("Introduzca ID de: PERSONA");
				id = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Introduzca NOMBRE de: PERSONA");
				nombre = entrada.nextLine();
				System.out.println("Introduzca APELLIDOS de: PERSONA");
				apellidos = entrada.nextLine();
				System.out.println("Introduzca EDAD de: PERSONA");
				edad = entrada.nextInt();
				entrada.nextLine();
				
				crud.actualizar(id, nombre, apellidos, edad);
				
				break;
			case 4:
				System.out.println("Eliminar persona");
				System.out.println("Seleccione el id para eliminar a: PERSONA");
				id = entrada.nextInt();
				entrada.nextLine();
				crud.eliminar(id);
				break;
			case 5:
				System.out.println("Saliendo...");
				crud.cerrarConexion();
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (opcion != 5);
	}
	
	public void mostrarMenu() {
		System.out.println("-----MENU-----");
		System.out.println("1. Crear persona");
		System.out.println("2. Leer persona");
		System.out.println("3. Actualizar persona");
		System.out.println("4. Eliminar persona");
		System.out.println("5. Salir");
		System.out.print("Seleccione una opcion: ");
	}
}
