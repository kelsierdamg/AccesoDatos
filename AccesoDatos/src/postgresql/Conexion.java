package postgresql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;

public class Conexion {
	private String user;
	private String password;
	private String driver;
	private String url;
	private String database;
	private String path;
	private String server;
	private String port;
	private String urlConexion;
	private Connection conexion=null;
	
	public Connection newInstanceBD (String nameServerBD) {	
		Properties config = new Properties();
		try {
			config.load(new FileInputStream("fichero_configuracion.props"));
		} catch (IOException e) {
			System.out.println("Fichero de configuracion no encontrado");
			return null;
		}
		
		
		//Obtenemos datos de conexion
		user = config.getProperty(nameServerBD.toLowerCase() + ".user");
		password = config.getProperty(nameServerBD.toLowerCase() + ".password");
		driver = config.getProperty(nameServerBD.toLowerCase() + ".driver");
		url = config.getProperty(nameServerBD.toLowerCase() + ".url");
		database = config.getProperty(nameServerBD.toLowerCase() + ".database");
		path = config.getProperty(nameServerBD.toLowerCase() + ".path");
		server = config.getProperty(nameServerBD.toLowerCase() + ".server");
		port = config.getProperty(nameServerBD.toLowerCase() + ".port");
		
		//Creamos el string de conexion
		if (nameServerBD.equalsIgnoreCase("postgresql"))
			urlConexion = url + path;
		else
			urlConexion = url + "//" + server + ":" + port + "/" + database + "?createDatabaseIfNotExist=true";
		
			
		try {
			conexion = DriverManager.getConnection(urlConexion);
			
			if (conexion != null)
				System.out.println("Conexion con EXITO a la BD: " + database +
						            " String de conexion: " + urlConexion);
			
		} catch (SQLException e) {
			System.out.println("Error conexion a la BD: " + database);
		}
		
		return conexion;
	}
}
