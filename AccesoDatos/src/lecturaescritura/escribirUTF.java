package lecturaescritura;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class escribirUTF {
	public static void main(String[] args) {
		int pos = Integer.parseInt(args[1]);
		
		if(args.length<1) {
			System.out.println("Número de argumentos incorrecto");
			return;
		}
		
		try(RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
			escribirDatos(raf, 1, "Juan", "Perez", 80.2f);
			escribirDatos(raf, 2, "Ana", "Lopez", 65.5f);
			escribirDatos(raf, 3, "Luis", "Garcia", 75.3f);
			
			int numRegistro = (pos - 1) * 68;
			raf.seek(numRegistro);
			for(int i=1; i<=pos; i++) {
				int id = raf.readInt();
				String nombre = raf.readUTF();
				String apellido = raf.readUTF();
				float peso = raf.readFloat();
				
				switch(i) {
				case 1:
					System.out.println("ID: "+id);
				case 2:
					System.out.println("Nombre: "+nombre);
				case 3:
					System.out.println("Apellido: "+apellido);
				case 4:
					System.out.println("Peso: "+peso);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void escribirDatos(RandomAccessFile fich, int id, String nombre, String apellidos, float peso) throws IOException {
		fich.writeInt(id);
		fich.writeUTF(nombre);
		fich.writeUTF(apellidos);
		fich.writeFloat(peso);
		
		System.out.println("Posición en bytes: "+fich.getFilePointer());
	}

}
