package lecturaescritura;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class escribirBuffered {
	public static void main(String[] args) {
		if(args.length<1) {
			System.out.println("Argumentos insuficientes");
			return;
		}
		
		ArrayList<InsertarDatos> registros = new ArrayList<>();
		
		try(FileWriter fr = new FileWriter(args[0]);
			BufferedWriter bw = new BufferedWriter(fr)) {
			escribirDatos(bw, registros);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void escribirDatos(BufferedWriter bw, ArrayList<InsertarDatos> registros) throws IOException {
		LocalDateTime now = LocalDateTime.now();
		registros.add(new InsertarDatos(1, "error", now.toString()));
		registros.add(new InsertarDatos(2, "error2", now.toString()));
		registros.add(new InsertarDatos(3, "error3", now.toString()));
		registros.add(new InsertarDatos(4, "error4", now.toString()));
		
		for(int i=0; i<registros.size(); i++) {
			bw.write(registros.get(i).toString());
			bw.newLine();
		}
		
		System.out.println("Registro añadido");
	}

}
