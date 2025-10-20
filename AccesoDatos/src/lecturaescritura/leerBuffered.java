package lecturaescritura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class leerBuffered {

	public static void main(String[] args) {
		if(args.length<1) {
			System.out.println("Argumentos insuficientes");
			return;
		}
		
		try(FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr)) {
			leerDatos(br);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void leerDatos(BufferedReader br) throws IOException {
		String linea;
		while((linea = br.readLine()) != null) {
			System.out.println(linea);
		}
	}

}
