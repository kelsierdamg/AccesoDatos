package lecturaescritura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MenuInicio {

	public static void main(String[] args) {
		try(InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
			BufferedReader br = new BufferedReader(isr)) {
			
			String linea = " ";
			
			boolean continuar = true;
			while(continuar) {
				menu();
				linea = br.readLine();
				if(linea.equalsIgnoreCase("a")) {
					System.out.println("Escribe algo:");
					
					linea = br.readLine();
					System.out.println("Escribiste: "+linea);
				}
				else if(linea.equalsIgnoreCase("b")) {
					
				}
				else if(linea.equalsIgnoreCase("c")) {
					System.out.println("Saliendo del programa");
					continuar = false;
					break;
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void menu() {
		System.out.println("Escriba una opción: ");
		System.out.println("A: Imprime la linea ");
		System.out.println("B: Muestra el menú ");
		System.out.println("C: Salir ");
	}
}
