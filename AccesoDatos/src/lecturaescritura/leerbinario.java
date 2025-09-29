package lecturaescritura;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.EOFException;

public class leerbinario {
	public static void main(String[] args) {
		String archivo = null;
		if(args.length<1) {
			System.out.println("Número de argumentos incorrecto");
			return;
		}
		else {
			archivo = args[0];
			System.out.println("Fichero: " +archivo);
		}
		
		try(FileInputStream fi = new FileInputStream(archivo);
			DataInputStream di = new DataInputStream(fi)) {
			
			while(true) {
				try {
					int id = di.readInt();
					String nombre = di.readUTF();
					String apellido = di.readUTF();
					double sueldo = di.readFloat();
					
					System.out.println("ID: "+id);
					System.out.println("Nombre: "+nombre);
					System.out.println("Apellido: "+apellido);
					System.out.println("Salario: "+sueldo);
				} catch(EOFException e) {
					System.out.println("Final del fichero");
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
