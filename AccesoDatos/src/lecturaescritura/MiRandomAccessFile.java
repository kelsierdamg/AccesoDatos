package lecturaescritura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.RandomAccessFile;

public class MiRandomAccessFile { 

	public static void main(String[] args) {
		try(FileReader fr = new FileReader("C:\\Users\\alumnoTarde\\Downloads\\empleados.csv"); 
			RandomAccessFile raf = new RandomAccessFile("C:\\Users\\alumnoTarde\\Downloads\\empleados.dat", "rw")) {
			int r = fr.read();
			String cadena = "";
			
			ArrayList<String> lineas = new ArrayList<String>();
			
			while(r != -1) {
				cadena = cadena + (char)r;
				
				if(r == '\n') {
					lineas.add(cadena.trim()); // trim para quitar saltos de línea
					cadena = "";
				}
				r = fr.read();
			}
			if (!cadena.isEmpty()) {
				lineas.add(cadena.trim()); // Añade la última línea si no termina en salto
			}
			
			for(String linea : lineas) {
				System.out.println("Linea: "+linea); // Imprime solo la línea actual
				String[] campos = linea.split(";");
			
				for(int i = 0; i < campos.length; i++) {
					String campo = campos[i];
					
					switch(i) {
						case 0:
							raf.writeInt(Integer.parseInt(campo));
							System.out.println("ID: " + campo);
							break;
						case 1:
							raf.writeUTF(campo);
							System.out.println("Nombre: " + campo);
							break;
						case 2:
							raf.writeUTF(campo);
							System.out.println("Apellido: " + campo);
							break;
						case 3:
							raf.writeInt(Integer.parseInt(campo));
							System.out.println("Teléfono: " + campo);
							break;
						case 4:
							raf.writeFloat(Float.parseFloat(campo));
							System.out.println("Salario: " + campo);
							break;
					}
				}	
			}
			System.out.println("Contenido escrito en empleados.dat: " + raf.length() + " bytes");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}