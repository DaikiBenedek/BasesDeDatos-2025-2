import java.util.ArrayList;

/**
 * Representa un emprendedor con su información personal y de contacto.
 */
public class Emprendedor {
    private String rfc;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String domicilio;
    private ArrayList<Long> telefonos;
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
     * @param telefonos   Lista de números de teléfono del emprendedor.
     * @param correos     Lista de correos electrónicos del emprendedor.
     * @param fechaNac    Fecha de nacimiento del emprendedor.
     * @param genero      Género del emprendedor.
     */
    public Emprendedor(String rfc, String nombre, String apellidoPat, String apellidoMat, String domicilio,
                       ArrayList<Long> telefonos, ArrayList<String> correos, String fechaNac, String genero) {
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
     * Obtiene la lista de teléfonos del emprendedor.
     * @return Lista de números de teléfono.
     */
    public ArrayList<Long> getTelefonos() { 
        return telefonos;
     }

    /**
     * Establece la lista de teléfonos del emprendedor.
     * @param telefonos Lista de números de teléfono.
     */
    public void setTelefonos(ArrayList<Long> telefonos) { 
        this.telefonos = telefonos; 
    }

    /**
     * Obtiene la lista de correos electrónicos del emprendedor.
     * @return Lista de correos electrónicos.
     */
    public ArrayList<String> getCorreos() { 
        return correos; 
    }

    /**
     * Establece la lista de correos electrónicos del emprendedor.
     * @param correos Lista de correos electrónicos.
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
     * Obtiene el género del emprendedor.
     * @return Género del emprendedor.
     */
    public String getGenero() { 
        return genero; 
    }

    /**
     * Establece el género del emprendedor.
     * @param genero Género del emprendedor.
     */
    public void setGenero(String genero) { 
        this.genero = genero; 
    }
}

