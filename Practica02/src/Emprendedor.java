import java.util.ArrayList;

/**
 * Representa un emprendedor con su informacion personal y de contacto.
 */
public class Emprendedor {
    private String rfc;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String domicilio;
    private ArrayList<String> telefonos;
    private ArrayList<String> correos;
    private String fechaNac;
    private String genero;

    /**
     * Constructor que inicializa un emprendedor con los valores proporcionados.
     *
     * @param rfc         RFC del emprendedor.
     * @param nombre      Nombre del emprendedor.
     * @param apellidoPat Apellido paterno del emprendedor.
     * @param apellidoMat Apellido materno del emprendedor.
     * @param domicilio   Domicilio del emprendedor.
     * @param telefonos   Lista de numeros de telefono del emprendedor.
     * @param correos     Lista de correos electronicos del emprendedor.
     * @param fechaNac    Fecha de nacimiento del emprendedor.
     * @param genero      Genero del emprendedor.
     */
    public Emprendedor(String rfc, String nombre, String apellidoPat, String apellidoMat, String domicilio,
                       ArrayList<String> telefonos, ArrayList<String> correos, String fechaNac, String genero) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.domicilio = domicilio;
        this.telefonos = telefonos;
        this.correos = correos;
        this.fechaNac = fechaNac;
        this.genero = genero;
    }

    
    /**
     * Obtiene el RFC del emprendedor.
     * @return RFC del emprendedor.
     */
    public String getRfc() { 
        return rfc; 
    }

    /**
     * Establece el RFC del emprendedor.
     * @param rfc RFC del emprendedor.
     */
    public void setRfc(String rfc) { 
        this.rfc = rfc; 
    }

    /**
     * Obtiene el nombre del emprendedor.
     * @return Nombre del emprendedor.
     */
    public String getNombre() { 
        return nombre; 
    }

    /**
     * Establece el nombre del emprendedor.
     * @param nombre Nombre del emprendedor.
     */
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    /**
     * Obtiene el apellido paterno del emprendedor.
     * @return Apellido paterno del emprendedor.
     */
    public String getApellidoPat() { 
        return apellidoPat; 
    }

    /**
     * Establece el apellido paterno del emprendedor.
     * @param apellidoPat Apellido paterno del emprendedor.
     */
    public void setApellidoPat(String apellidoPat) { 
        this.apellidoPat = apellidoPat; 
    }

    /**
     * Obtiene el apellido materno del emprendedor.
     * @return Apellido materno del emprendedor.
     */
    public String getApellidoMat() {
         return apellidoMat; 
    }

    /**
     * Establece el apellido materno del emprendedor.
     * @param apellidoMat Apellido materno del emprendedor.
     */
    public void setApellidoMat(String apellidoMat) {
         this.apellidoMat = apellidoMat;
     }

    /**
     * Obtiene el domicilio del emprendedor.
     * @return Domicilio del emprendedor.
     */
    public String getDomicilio() { 
        return domicilio; 
    }

    /**
     * Establece el domicilio del emprendedor.
     * @param domicilio Domicilio del emprendedor.
     */
    public void setDomicilio(String domicilio) { 
        this.domicilio = domicilio; 
    }

    /**
     * Obtiene la lista de telefonos del emprendedor.
     * @return Lista de numeros de telefono.
     */
    public ArrayList<String> getTelefonos() { 
        return telefonos;
     }

    /**
     * Establece la lista de telefonos del emprendedor.
     * @param telefonos Lista de numeros de telefono.
     */
    public void setTelefonos(ArrayList<String> telefonos) { 
        this.telefonos = telefonos; 
    }

    /**
     * Obtiene la lista de correos electronicos del emprendedor.
     * @return Lista de correos electronicos.
     */
    public ArrayList<String> getCorreos() { 
        return correos; 
    }

    /**
     * Establece la lista de correos electronicos del emprendedor.
     * @param correos Lista de correos electronicos.
     */
    public void setCorreos(ArrayList<String> correos) { 
        this.correos = correos;
     }

    /**
     * Obtiene la fecha de nacimiento del emprendedor.
     * @return Fecha de nacimiento del emprendedor.
     */
    public String getFechaNac() { 
        return fechaNac; 
    }

    /**
     * Establece la fecha de nacimiento del emprendedor.
     * @param fechaNac Fecha de nacimiento del emprendedor.
     */
    public void setFechaNac(String fechaNac) { 
        this.fechaNac = fechaNac; 
    }

    /**
     * Obtiene el genero del emprendedor.
     * @return Genero del emprendedor.
     */
    public String getGenero() { 
        return genero; 
    }

    /**
     * Establece el genero del emprendedor.
     * @param genero Genero del emprendedor.
     */
    public void setGenero(String genero) { 
        this.genero = genero; 
    }

    /**
     * Metodo para imprimir un emprendedor
	 * @return String
	 */
    @Override
	public String toString() {

		String s = "\nRFC Emprendedor: " + this.rfc + "\n" + "Nombre: " + this.nombre + "\n" + "Apellido Paterno: "
				+ this.apellidoPat + "\n" + "Apellido Materno: " + this.apellidoMat + "\n"
				+ "Domicilio: " + this.domicilio + "\n" + "Telefonos: " + this.telefonos + "\n" + "correos: " + this.correos + "\n"
                + "Fecha de Nacimiento: " + this.fechaNac + "\n" + "Genero: " + this.genero + "\n" ;
		return s;
    }   

    /**
     * Metodo para serializar un emprendedor
	 * @return String
	 */
    public String serializa(){
        String cadena = rfc+";"+ nombre + ";"+ apellidoPat+";"+ apellidoMat+";"+ domicilio+";"+ telefonos.toString() +";"+
        correos.toString() +";"+ fechaNac+";"+ genero + "\n";
        return cadena;
    }
}

