package postgresql;

import java.sql.SQLException;

public class Control {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no encontrado");
			e.printStackTrace();
		}
		Vista vista = new Vista();
		vista.menu();
	}
}
