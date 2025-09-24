package lecturaescritura;

import java.io.FileWriter;
import java.io.IOException;

public class escribirFicheros {

	public static void main(String[] args) throws IOException {
		if(args.length<5) {
			System.out.println("Indica la ruta del fichero a escribir");
			return;
		}
		
		try(FileWriter fw = new FileWriter(args[0], true)) {
			for(int i=1; i<args.length; i++) {
				fw.write(args[i]+ " ");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
