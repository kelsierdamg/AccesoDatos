package lecturaescritura;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class vueltaFrase {
	public static void main(String[] args) {
		if(args.length<1) {
			System.out.println("Número de argumentos incorrecto");
		}
		
		try(FileReader fr = new FileReader(args[0])) {
			ArrayList<Character> caracteres = new ArrayList<>();
			int n;
			while((n=fr.read()) != -1) {
				System.out.print((char)n);
				caracteres.add((char)n);
			}
			
			System.out.println();
			for(int i=caracteres.size()-1; i>=0; i--) {
				System.out.print(caracteres.get(i));
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
