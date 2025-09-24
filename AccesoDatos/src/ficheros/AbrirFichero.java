package ficheros;

public class AbrirFichero {
	public static void main(String[] args) {
		System.out.println("Numero de argumentos: " + args.length);
		
		for(String arg : args) {
			System.out.println("Argumentos recibidos: " + arg);
		}
		
		FuncionesBusqueda ff = new FuncionesBusqueda();
		ff.filtrarFicheroPorExtension(args[0], args[1]);
	}
}
