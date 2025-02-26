import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
public class ReadCSV {

/**
     * Lee el CSV de los negocios.
     * @param dir
     * @return Arrayslist<Negocio>
     */
    public static ArrayList<Negocio> leeNegociosCSV(String dir){
        ArrayList<Negocio> negocios = new ArrayList<Negocio>();
        
        if(dir.contains("egocio")){
            try {
                // creamos el buffer que lee de nuestro archivo 'dir'.
                BufferedReader lector = new BufferedReader ( new FileReader( dir ) );
                String aux = "";
                String [] arr;
                aux = lector.readLine();

                // iteremos hasta que no encontremos líneas.
                while (aux != null){
                    arr = aux.split(";");
                    ArrayList<Long> telefonos = new ArrayList<>();
                    ArrayList<String> correos = new ArrayList<>();
                    ArrayList<String> redesSociales = new ArrayList<>();

                    // Convertir los datos de telefonos a ArrayList<Long>
                    String[] telefonosStr = arr[1].split(",");
                    for (String telefono : telefonosStr) {
                        telefonos.add(Long.parseLong(telefono.trim()));
                    }

                    // Convertir los datos de correos a ArrayList<String>
                    String[] correosStr = arr[2].split(",");
                    for (String correo : correosStr) {
                        correos.add(correo.trim());
                    }

                    // Convertir los datos de redes sociales a ArrayList<String>
                    String[] redesSocialesStr = arr[3].split(",");
                    for (String redSocial : redesSocialesStr) {
                        redesSociales.add(redSocial.trim());
                    }
                    Negocio negocioAux = new Negocio(Integer.parseInt(arr[0]), arr[1], telefonos, correos, redesSociales, arr[5], arr[6]);
                    negocios.add(negocioAux);
                    aux = lector.readLine();
                }
            // error en caso de no haber encontrado el archivo.
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error en 'Negocio.csv'");
            // error en entrada o salida.
            } catch (IOException es) {
                es.printStackTrace();
            }
        }
        return negocios;
    }

    /**
     * Lee el CSV de los clientes
     * @param dir
     * @return Arrayslist<Cliente>
     */
    public static ArrayList<Cliente> leeClientesCSV(String dir){

        ArrayList <Cliente> clientes = new ArrayList<Cliente>();
        if(dir.contains("lientes")){
            try {
                // creamos el buffer que lee de nuestro archivo 'dir'.
                BufferedReader lector = new BufferedReader ( new FileReader( dir ) );
                String aux = "";
                String [] arr;
                aux = lector.readLine();

                // iteremos hasta que no encontremos líneas.
                while (aux != null){
                    arr = aux.split(";");
                    Cliente clientesAux = new Cliente(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], Boolean.parseBoolean(arr[4]), arr[5], arr[6], arr[7] ,Integer.parseInt(arr[8]));
                    clientes.add(clientesAux);
                    aux = lector.readLine();
                }

            // error en caso de no haber encontrado el archivo.
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            // error en entrada o salida.
            } catch (IOException es) {
                es.printStackTrace();
            }
        }
        return clientes;
    }

    /**
     * Lee el CSV de los emprendedores
     * @param dir dirección del csv.
     * @return Arrayslist<Emprendedor>
     */
    public static ArrayList<Emprendedor> leeEmprendedoresCSV (String dir){
        ArrayList<Emprendedor> emprendedores = new ArrayList<Emprendedor>();

        if(dir.contains("mprendedor")){
            try {
                // creamos el buffer que lee de nuestro archivo 'dir'.
                BufferedReader lector = new BufferedReader ( new FileReader( dir ) );
                String aux = "";
                String [] arr;
                aux = lector.readLine();

                // iteremos hasta que no encontremos líneas.
                while (aux != null){
                    arr = aux.split(";");
                    ArrayList<String> telefonos = new ArrayList<>();
                    ArrayList<String> correos = new ArrayList<>();

                    // Convertir los datos de telefonos a ArrayList<Long>
                    String[] telefonosStr = arr[5].split(",");
                    for (String telefono : telefonosStr) {
                        telefonos.add(telefono.trim());
                    }

                    // Convertir los datos de correos a ArrayList<String>
                    String[] correosStr = arr[6].split(",");
                    for (String correo : correosStr) {
                        correos.add(correo.trim());
                    }

                    try {
                        Emprendedor emprendedorAux = new Emprendedor(arr[0], arr[1], arr[2], arr[3], arr[4], telefonos, correos, arr[7], arr[8]);
                        emprendedores.add(emprendedorAux);
                    } catch (NumberFormatException e) {
                        // TODO: handle exception
                    }
                    aux = lector.readLine();
                }
            // error en caso de no haber encontrado el archivo.
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            // error en entrada o salida.
            } catch (IOException es) {
                es.printStackTrace();
            }
        }
        return emprendedores;
    }










    //MÉTODOS PARA ELIMINAR
    /**
     * Método par eliminar un emprendedor
     * @param id
     * @param arrEm
     */
    public static void eliminaEmprendedor(String rfc, ArrayList<Emprendedor> arrEm){
        boolean encontrado = false;
        for(Emprendedor em : arrEm){
            if (em.getRfc().equals(rfc)) { 
                arrEm.remove(em);
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("No se encontró al emprendedor");
        } else {
            System.out.println("Emprendedor con RFC " + rfc + " eliminado correctamente.");
        }
    }

    /**
     * Método para eliminar un cliente del arraylist.
     * @param id identificador único.
     * @param arrCl
     */
    public static void eliminaCliente(int id, ArrayList<Cliente> arrCl){
        boolean encontrado = false;
        for( int i = 0; i< arrCl.size(); i++){
            Cliente cl = arrCl.get(i);
            if(cl.getId() == id){
                arrCl.remove(i);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se encontró el empleado");
        }else {
            System.out.println("Cliente con ID " + id + " eliminado correctamente.");
        }
    }

    /**
     * Método para eliminar un negocio del Arraylist
     * @param id
     * @param arrNeg
     */
    public static void eliminaNegocio(int id, ArrayList<Negocio> arrNeg){
        boolean encontrado = false;
        for( int i = 0; i< arrNeg.size(); i++){
            Negocio ng = arrNeg.get(i);
            if(ng.getId() == id){
                arrNeg.remove(i);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se encontró el negocio");
        }else {
            System.out.println("Negocio con ID " + id + " eliminado correctamente.");
        }
    }













//Métodos para escribir en el CSV
    /**
     * @param emprendedorNuevo
     * @param emprendedores
     */
    public static ArrayList<Emprendedor> agregaEmprendedores(String dir, Emprendedor emprendedorNuevo, ArrayList<Emprendedor> emprendedores){

        boolean z = false;

        for(Emprendedor emprendedor: emprendedores){
            if(emprendedor.getRfc().equals(emprendedorNuevo.getRfc())){
                System.out.println("Error, este emprendedor ya está en el sistema");
                z = true;
                break;
            }
        }
        if(!z){
            emprendedores.add(emprendedorNuevo);
            try {
                FileWriter fileWriter = new FileWriter( new File(dir));
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < emprendedores.size(); i++){
                    line.append(emprendedores.get(i).serializa());
                }
                fileWriter.write(line.toString());
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error: "+e);
                // TODO: handle exception
            }
            System.out.println("Emprendedor agregado correctamente.");
            return emprendedores;
        }
        return emprendedores;
    }
    
















    //MÉTODOS PARA CONSULTAR
    /**
     * Método que consulta la información de un emprendedor.
     * @param id identificador único.
     * @param arrEmp arrayList de empleados
     */
    public static void consultaEmprendedor(String rfc, ArrayList<Emprendedor> arrEmp){
        boolean encontrado = false;
        for( int i = 0; i< arrEmp.size(); i++){
            Emprendedor emp = arrEmp.get(i);
            if(emp.getRfc().equals(rfc)){
                System.out.println(emp);
                encontrado = true;
                emp.toString();
            }
        }
        if(!encontrado){
            System.out.println("No se encontró al emprendedor");
        }
    }
}
