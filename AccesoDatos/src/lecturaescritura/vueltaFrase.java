package lecturaescritura;

import java.io.FileReader;
import java.io.IOException;

public class vueltaFrase {
	public static void main(String[] args) {
		if(args.length<1) {
			System.out.println("Número de argumentos incorrecto");
		}
		
		try(FileReader fr = new FileReader(args[0])) {
			int n;
			while((n=fr.read()) != -1) {
				System.out.print((char)n);
			}
			
			char arr2[] = new char[n];
			int longitud = arr2.length;
			char arr1[] = new char[longitud];
			
			for(int i=20; i>0; i--) {
				arr1[n]=arr2[i];
				n++;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
