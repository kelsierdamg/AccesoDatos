package lecturaescritura;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class escribirChar {
	public static final char ESPACIO = ' ';
	public static final int LENGTH_CADENA = 15;

	public static void main(String[] args) {
		 /*
		 * id nombre apellido peso
		 * 4bytes 30bytes 30bytes(15char) float(4bytes)
		 * tamaño del registro en bytes: 68 bytes
		 */

		 if(args.length<2) {
			 System.out.println("Error: Faltan parametros, necesitamos fichero y posicion");
			 return;
		 }

		 int posicion = Integer.parseInt(args[1]);
		 String fichero = args[0];
		 
		 try {
			 RandomAccessFile raf = new RandomAccessFile(fichero, "rw");
			 //Escritura de datos
			 //escribirDatos(raf, 0, "Juan", "Perez", 80.2f);
			 //escribirDatos(raf, 1, "Ana", "Lopez", 65.5f);
			 //escribirDatos(raf, 2, "Luis", "Garcia", 75.3f);

			 //Lectura aleatoria
			 int numRegistro = (posicion -1) * 68; //Posicion empieza en 1, no en 0
			 raf.seek(numRegistro); //Nos situamos al principio del fichero
			 
			 System.out.println("Id: " + raf.readInt());
			 String nombre = "";

			 for(int i=0; i<LENGTH_CADENA; i++) {
				 nombre = nombre + raf.readChar();
			 }

			 System.out.println("Nombre: " + nombre.trim());

			 String apellidos = "";
			 
			 for(int i=0; i<LENGTH_CADENA; i++) {
				 apellidos = apellidos + raf.readChar();
			 }

			 System.out.println("Nombre: " + apellidos.trim());
			 System.out.println("Peso: " + raf.readFloat());

			 raf.close();


		 } catch (FileNotFoundException e) {
			 System.out.println(e.getMessage());
			 e.printStackTrace();
		 } catch (IOException e) {
			 System.out.println("IOException " + e.getMessage());
			 e.printStackTrace();
		 }

	}

	public static void escribirDatos(RandomAccessFile fich, int id, String nombre, String apellidos, float peso) {
		try {
			fich.writeInt(id);
			//Escribir char
			//char[] n1 = new char[15];
			char[] n1 = nombre.toCharArray();

			for(int i=0; i<LENGTH_CADENA; i++) {
				if (i < n1.length) {
					System.out.println("Nombre: " + n1[i]);
					fich.writeChar(n1[i]);
				} else {
					fich.writeChar(ESPACIO); // Rellenar con espacios si el nombre es más corto que 15 caracteres
				}
			}

			//char[] n2 = new char[15];
			char[] n2 = apellidos.toCharArray();

			for(int i=0; i<LENGTH_CADENA; i++) {
				if (i < n2.length) {
					System.out.println("Apellidos: " + n2[i]);
					fich.writeChar(n2[i]);
				} else {
					fich.writeChar(ESPACIO); // Rellenar con espacios si el apellido es más corto que 15 caracteres
				}
			}

			fich.writeFloat(peso);
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}