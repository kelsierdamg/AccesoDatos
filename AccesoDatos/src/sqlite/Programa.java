package sqlite;

import java.sql.SQLException;

public class Programa {
	public static void main(String[] args) throws SQLException {		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no encontrado");
			e.printStackTrace();
			
		}
		
		Vista vista = new Vista();
		vista.menu();
	}
}
