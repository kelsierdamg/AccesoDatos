package lecturaescritura;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileRead {
	public static void main(String[] args) {
		String nombre_fich = "";
		
		if(args.length != 0) {
			nombre_fich = args[0];
		}
		
		try(FileReader fr = new FileReader(args[0])) {
			int r = fr.read();
			String cadena = "";
			
			ArrayList<String> lineas = new ArrayList<String>();
			
			while(r != -1) {
				cadena = cadena + (char)r;
				
				if(r == 10) {
					lineas.add(cadena);
					cadena = "";
				}
				
				r = fr.read();
			}
			
			for(String linea : lineas) {
				System.out.println("Linea: "+lineas);
				String[] campos = linea.split(";");
				
				for(String campo : campos) {
					System.out.println("Campo: "+campo);
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
