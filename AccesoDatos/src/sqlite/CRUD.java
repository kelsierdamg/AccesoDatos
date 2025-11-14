package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {
	private Connection conexion; // Objeto conexion

	public CRUD() {
	    try {
	        conexion = DriverManager.getConnection("jdbc:sqlite:personas.db");
	        System.out.println("Conexión establecida correctamente.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
		public void crearTabla() throws SQLException {
		    String sql = "CREATE TABLE IF NOT EXISTS persona (" +
		                 "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
		                 "nombre TEXT NOT NULL, " +
		                 "apellidos TEXT NOT NULL, " +
		                 "edad INTEGER NOT NULL" +
		                 ");";
		    
		    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
		        stmt.executeUpdate();
		    }
		}
		
		
		public void crear(Persona p) throws SQLException {
			
		    String sentenciaSql = "INSERT INTO persona (nombre, apellidos, edad) VALUES (?, ?, ?)";
		    PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
		    
		    try {
		        sentencia.setString(1, p.getNombre());
		        sentencia.setString(2, p.getApellidos());
		        sentencia.setInt(3, p.getEdad());
		        sentencia.executeUpdate();
		        System.out.println("Persona insertada correctamente.");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

		
		public void leer() throws SQLException {
			
			String sentenciaSql = "SELECT id, nombre, apellidos, edad FROM persona ";
			PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
			ResultSet resultado = sentencia.executeQuery();
			
			
			try {
				System.out.println("Lista de personas: ");
				
				while (resultado.next()) {
					System.out.println("ID: " + resultado.getInt("id"));
					System.out.println("NOMBRE: " + resultado.getString("nombre"));
					System.out.println("APELLIDOS: " + resultado.getString("apellidos"));
					System.out.println("EDAD: " + resultado.getInt("edad"));
					System.out.println("----------------------------");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void actualizar(int id, String nuevoNombre, String nuevoApellidos, int nuevaEdad) throws SQLException {
		
			String sentenciaSql = "UPDATE nombre = ?, apellidos = ?, edad = ? WHERE id = ?";
			PreparedStatement sentencia = null;
			
			try {
				sentencia = conexion.prepareStatement(sentenciaSql);
				
				sentencia.setString(1, nuevoNombre);
				sentencia.setString(2, nuevoApellidos);
				sentencia.setInt(3, nuevaEdad);
				sentencia.setInt(4, id);
				
				int filas = sentencia.executeUpdate(); // Devuelve el numero de filas afectadas
				
				if(filas > 0) {
					System.out.println("Actualizado correctamente");
				} else {
					System.out.println("No se ha actualizado correctamente");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void eliminar(int id) {
			String sentenciaSql = "DELETE persona WHERE id = ?";
			PreparedStatement sentencia = null;
			 
			try {
			  sentencia = conexion.prepareStatement(sentenciaSql);
			  
			  sentencia.setInt(1, id);
			  
			  int filas = sentencia.executeUpdate();
			  if (filas > 0 ) {
				  System.out.println("Se ha borrado correctaemente");
			  } else {
				  System.out.println("Error");
			  }
			  
			  
			} catch (SQLException sqle) {
			  sqle.printStackTrace();
			
			} finally {
			  if (sentencia != null)
			    try {
			      sentencia.close();
			    } catch (SQLException sqle) {
			      sqle.printStackTrace();
			    
			    }
			  
			}
		}
		
		
	    public void cerrarConexion() {
	        try {
	            if (conexion != null && !conexion.isClosed()) {
	                conexion.close();
	                System.out.println("Conexión cerrada correctamente.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
