package lecturaescritura;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class binarios {
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
		
		try(FileOutputStream fo = new FileOutputStream(archivo, true); 
			DataOutputStream d_o = new DataOutputStream(fo)) {
			
			d_o.writeInt(1234);
			d_o.writeUTF("Angel");
			d_o.writeUTF("Martin");
			d_o.writeFloat(1500.40f);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
