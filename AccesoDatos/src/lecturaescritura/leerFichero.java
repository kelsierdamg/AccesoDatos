package lecturaescritura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class leerFichero {
	public static void main(String[] args) {
		if(args.length<1) {
			System.out.println("Número de argumentos incorrecto");
			return;
		}
		
		try(FileReader fr = new FileReader(args[0])) {
			int n;
			char[] c = new char[42];
			int i = 0;
			
			//lee por caracteres
			while((n=fr.read()) != -1) {
				System.out.print((char) n);
			}
			
			//lee por lineas
			/*
			while((n=fr.read(c, 0, 40)) != -1) {
				c[i]=(char)n;
				i++;
			}
			
			for(char c1 : c) {
				System.out.print(c1);
			}*/
		}
		catch(FileNotFoundException e) {
			System.out.println("Fichero no encontrado: "+e.getMessage());
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("Error I/O: "+e.getMessage());
			e.printStackTrace();
		}
	}
}
