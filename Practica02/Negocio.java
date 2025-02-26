import java.util.ArrayList;

public class Negocio {
    private int id;
    private String nombreNegocio;
    private ArrayList<Long> telefonos = new ArrayList<>();
    private ArrayList<String> correos = new ArrayList<>();
    private ArrayList<String> redesSociales = new ArrayList<>();
    private String rangoPrecios;
    private String descripcion;

    /**
     * Constructor que inicializa un negocio con los valores proporcionados.
     * 
     * @param id  ID del negocio
     * @param nombreNegocio  Nombre del negocio
     * @param telefonos      Lista de números de teléfono
     * @param correos        Lista de correos electrónicos
     * @param redesSociales  Lista de redes sociales
     * @param rangoPrecios   Rango de precios del negocio
     * @param descripcion    Descripción del negocio
     */
    public Negocio(int id, String nombreNegocio, ArrayList<Long> telefonos, ArrayList<String> correos, ArrayList<String> redesSociales, String rangoPrecios, String descripcion) {
        this.id = id;
        this.nombreNegocio = nombreNegocio;
        this.telefonos = telefonos;
        this.correos = correos;
        this.redesSociales = redesSociales;
        this.rangoPrecios = rangoPrecios;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el ID del negocio.
     * @return ID del negocio.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del negocio.
     * @return Nombre del negocio.
     */
    public String getNombreNegocio() {
        return nombreNegocio;
    }

    /**
     * Establece el nombre del negocio.
     * @param nombreNegocio Nombre del negocio.
     */
    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    /**
     * Obtiene la lista de teléfonos del negocio.
     * @return Lista de números de teléfono.
     */
    public ArrayList<Long> getTelefonos() {
        return telefonos;
    }

    /**
     * Establece la lista de teléfonos del negocio.
     * @param telefonos Lista de números de teléfono.
     */
    public void setTelefonos(ArrayList<Long> telefonos) {
        this.telefonos = telefonos;
    }

    /**
     * Obtiene la lista de correos electrónicos del negocio.
     * @return Lista de correos electrónicos.
     */
    public ArrayList<String> getCorreos() {
        return correos;
    }

    /**
     * Establece la lista de correos electrónicos del negocio.
     * @param correos Lista de correos electrónicos.
     */
    public void setCorreos(ArrayList<String> correos) {
        this.correos = correos;
    }

    /**
     * Obtiene la lista de redes sociales del negocio.
     * @return Lista de redes sociales.
     */
    public ArrayList<String> getRedesSociales() {
        return redesSociales;
    }

    /**
     * Establece la lista de redes sociales del negocio.
     * @param redesSociales Lista de redes sociales.
     */
    public void setRedesSociales(ArrayList<String> redesSociales) {
        this.redesSociales = redesSociales;
    }

    /**
     * Obtiene el rango de precios del negocio.
     * @return Rango de precios.
     */
    public String getRangoPrecios() {
        return rangoPrecios;
    }

    /**
     * Establece el rango de precios del negocio.
     * @param rangoPrecios Rango de precios.
     */
    public void setRangoPrecios(String rangoPrecios) {
        this.rangoPrecios = rangoPrecios;
    }

    /**
     * Obtiene la descripción del negocio.
     * @return Descripción del negocio.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del negocio.
     * @param descripcion Descripción del negocio.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
