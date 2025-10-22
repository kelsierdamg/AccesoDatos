package lecturaescritura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class PersistenciaDatos {
	public static final String FICHERO = "C:\\Users\\alumnoTarde\\Downloads\\usuarios.txt";
	public static void main(String[] args) {
		try(InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
		    BufferedReader br = new BufferedReader(isr)) {
			ArrayList<Usuario> usuarios = new ArrayList<>();
			String linea = " ";
			
			boolean continuar = true;
			while(continuar) {
				menu();
				linea = br.readLine();
				if(linea.equalsIgnoreCase("a")) {
					System.out.println("Escribe el nombre del usuario:");
					String nombre = br.readLine();
					System.out.println("Escribe los apellidos: ");
					String apellidos = br.readLine();
					System.out.println("Escribe el DNI: ");
					String dni = br.readLine();
					
					usuarios.add(new Usuario(nombre, apellidos, dni));
					añadirFichero(usuarios.get(0));
				}
				if(linea.equalsIgnoreCase("b")) {
					try(FileReader fr = new FileReader(FICHERO);
						BufferedReader br2 = new BufferedReader(fr)) {
						String linea2;
						while((linea2 = br2.readLine()) != null) {
							String partes[] = linea2.split(",");
							
							String nombre = partes[0];
							String apellidos = partes[1];
							String dni = partes[2];
							
							Usuario u = new Usuario(nombre, apellidos, dni);
							usuarios.add(u);
						}
						for(Usuario u : usuarios) {
							System.out.println(u);
						}
					}
				}
				if(linea.equalsIgnoreCase("c")) {
					System.out.println("Saliendo del programa...");
					continuar = false;
					break;
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void menu() {
		System.out.println("Escriba una opción: ");
		System.out.println("A: Introduce un nuevo usuario: ");
		System.out.println("B: Lista todos los usuarios ");
		System.out.println("C: Salir ");
	}
	
	public static void añadirFichero(Usuario u) throws IOException {
		try(FileWriter fw = new FileWriter(FICHERO, true);
			BufferedWriter bw = new BufferedWriter(fw)) {
			
			bw.write("Nombre: " +u.getNombre()+ " Apellidos: " +u.getApellido()+ " DNI: "+u.getDni());
			bw.newLine();
		}
	}
}
