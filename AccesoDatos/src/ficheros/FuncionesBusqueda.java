package ficheros;

import java.io.File;
import java.io.FilenameFilter;

public class FuncionesBusqueda implements FilenameFilter {

    private String File;
    private String fichero;
    private int length;
    private String extension;
    private String path;

    public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getFile() {
        return File;
    }

    public void setFile(String file) {
        File = file;
    }

    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Método no recursivo
    public void listarDirectorio(String path) {

        File f = new File(path);

        if (f.exists() && f.isDirectory()) {
            File[] files = f.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.println("DIR " + file.getAbsolutePath());
                        // Si quisieras hacerlo recursivo aquí, descomenta la siguiente línea:
                        // listarDirectorio(file.getAbsolutePath());
                    } else {
                        System.out.println("FICH: " + file.getAbsolutePath() + " SIZE: " + file.length());
                    }
                }
            } else {
                System.out.println("No se puede acceder al contenido de " + f.getAbsolutePath());
            }
        } else {
            System.out.println("Directorio no encontrado");
        }
    }

    // Método recursivo
    public void listarDirectorioRecursivo(File path) {

        if (path.exists() && path.isDirectory()) {

            File[] files = path.listFiles();

            if (files != null) {
                for (File file : files) {

                    if (file.isDirectory()) {
                        System.out.println("DIR " + file.getAbsolutePath());
                        // Realiza recursivamente la búsqueda
                        listarDirectorioRecursivo(file);
                    }

                    if (file.isFile()) {
                        System.out.println("FICH " + file.getName() + " SIZE " + file.length());
                    }
                }
            } else {
                System.out.println("No se puede acceder al contenido de " + path.getAbsolutePath());
            }
        } else {
            System.out.println("Directorio no encontrado");
        }
    }

	@Override
	public boolean accept(File path, String extension) {
		return extension.startsWith(this.extension);
	}
	
	public void filtrarFicheroPorExtension(String ruta, String extension) {
		this.setPath(ruta);
		this.setExtension(extension);
		
		File f = new File(ruta);
		File[] files = f.listFiles(this);
		
		if(f.exists()) {
			for(File file : files) {
				System.out.println("Archivo encontrado: "+file.getAbsolutePath());
			}
		}
		else {
			System.out.println("No hay ningún archivo que empiece así");
		}
	}
}
