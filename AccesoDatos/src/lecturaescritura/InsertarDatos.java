package lecturaescritura;

public class InsertarDatos {
	private int id;
	private String log;
	private String fecha;
	
	public InsertarDatos(int id, String log, String fecha) {
		this.id = id;
		this.log = log;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "ID = " + id + ";Log = " + log + ";Fecha = " + fecha;
	}
	
}
