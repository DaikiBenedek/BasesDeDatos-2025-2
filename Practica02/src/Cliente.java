/**
 * Representa un cliente con su informacion personal y de pago.
 */
public class Cliente {
    private int id;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private boolean metodoPago;
    private String domicilio;
    private String numeroTarjeta;
    private String vencimiento;
    private int cvv;

    /**
     * Constructor que inicializa un cliente con los valores proporcionados.
     *
     * @param id  ID del cliente
     * @param nombre       Nombre del cliente.
     * @param apellidoPat  Apellido paterno del cliente.
     * @param apellidoMat  Apellido materno del cliente.
     * @param metodoPago   Metodo de pago (true si es tarjeta, false si es efectivo).
     * @param domicilio    Domicilio del cliente.
     * @param numeroTarjeta Numero de tarjeta del cliente.
     * @param vencimiento  Fecha de vencimiento de la tarjeta.
     * @param cvv          Codigo de seguridad de la tarjeta.
     */
    public Cliente(int id, String nombre, String apellidoPat, String apellidoMat, boolean metodoPago, String domicilio, String numeroTarjeta, String vencimiento, int cvv) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.metodoPago = metodoPago;
        this.domicilio = domicilio;
        this.numeroTarjeta = numeroTarjeta;
        this.vencimiento = vencimiento;
        this.cvv = cvv;
    }


    /**
     * Obtiene el ID del cliente.
     * @return ID del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return Nombre del cliente.
     */
    public String getNombre() { 
        return nombre; 
    }

    /**
     * Establece el nombre del cliente.
     * @param nombre Nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     * @return Apellido paterno del cliente.
     */
    public String getApellidoPat() { 
        return apellidoPat;
     }

    /**
     * Establece el apellido paterno del cliente.
     * @param apellidoPat Apellido paterno del cliente.
     */
    public void setApellidoPat(String apellidoPat) { 
        this.apellidoPat = apellidoPat;
     }

    /**
     * Obtiene el apellido materno del cliente.
     * @return Apellido materno del cliente.
     */
    public String getApellidoMat() { 
        return apellidoMat; 
    }

    /**
     * Establece el apellido materno del cliente.
     * @param apellidoMat Apellido materno del cliente.
     */
    public void setApellidoMat(String apellidoMat) {
         this.apellidoMat = apellidoMat; 
    }

    /**
     * Obtiene el metodo de pago del cliente.
     * @return true si es tarjeta, false si es efectivo.
     */
    public boolean isMetodoPago() {
        return metodoPago;
     }

    /**
     * Establece el metodo de pago del cliente.
     * @param metodoPago true si es tarjeta, false si es efectivo.
     */
    public void setMetodoPago(boolean metodoPago) { 
        this.metodoPago = metodoPago;
     }

    /**
     * Obtiene el domicilio del cliente.
     * @return Domicilio del cliente.
     */
    public String getDomicilio() { 
        return domicilio;
     }

    /**
     * Establece el domicilio del cliente.
     * @param domicilio Domicilio del cliente.
     */
    public void setDomicilio(String domicilio) { 
        this.domicilio = domicilio; 
    }

    /**
     * Obtiene el numero de tarjeta del cliente.
     * @return Numero de tarjeta del cliente.
     */
    public String getNumeroTarjeta() { 
        return numeroTarjeta;
    }

    /**
     * Establece el numero de tarjeta del cliente.
     * @param numeroTarjeta Numero de tarjeta del cliente.
     */
    public void setNumeroTarjeta(String numeroTarjeta) { 
        this.numeroTarjeta = numeroTarjeta; 
    }

    /**
     * Obtiene la fecha de vencimiento de la tarjeta.
     * @return Fecha de vencimiento de la tarjeta.
     */
    public String getVencimiento() {
        return vencimiento; 
    }

    /**
     * Establece la fecha de vencimiento de la tarjeta.
     * @param vencimiento Fecha de vencimiento de la tarjeta.
     */
    public void setVencimiento(String vencimiento) { 
        this.vencimiento = vencimiento; 
    }

    /**
     * Obtiene el codigo de seguridad de la tarjeta.
     * @return Codigo de seguridad de la tarjeta.
     */
    public int getCvv() { 
        return cvv;
     }

    /**
     * Establece el codigo de seguridad de la tarjeta.
     * @param cvv Codigo de seguridad de la tarjeta.
     */
    public void setCvv(int cvv) {
         this.cvv = cvv; 
    }

    /**
     * Metodo para imprimir un emprendedor
	 * @return String
	 */
    @Override
	public String toString() {

		String s = "\nID Cliente: " + this.id + "\n" + "Nombre: " + this.nombre + "\n" + "Apellido Paterno: "
				+ this.apellidoPat + "\n" + "Apellido Materno: " + this.apellidoMat + "\n" + "Metodo de Pago: " + this.metodoPago + "\n"
				+ "Domicilio: " + this.domicilio + "\n" + "Numero de Tarjeta: " + this.numeroTarjeta + "\n" 
                + "Vencimiento: " + this.vencimiento + "\n" + "CVV: " + this.cvv + "\n"  ;
		return s;
    }   

    /**
     * Metodo para serializar un emprendedor
	 * @return String
	 */
    public String serializa(){
        String cadena = id +";"+ nombre + ";"+ apellidoPat+";"+ apellidoMat+";"+ metodoPago+";"+ domicilio +";"+
        numeroTarjeta +";"+ vencimiento+";"+ cvv + "\n";
        return cadena;
    }
}
