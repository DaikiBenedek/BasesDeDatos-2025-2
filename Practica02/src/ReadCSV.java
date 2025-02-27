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

                // iteremos hasta que no encontremos lineas.
                while (aux != null){
                    arr = aux.split(";");
                    ArrayList<String> telefonos = new ArrayList<>();
                    ArrayList<String> correos = new ArrayList<>();
                    ArrayList<String> redesSociales = new ArrayList<>();

                    // Convertir los datos de telefonos a ArrayList<Long>
                    String[] telefonosStr = arr[1].split(",");
                    for (String telefono : telefonosStr) {
                        telefonos.add(telefono.trim());
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

                // iteremos hasta que no encontremos lineas.
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
     * @param dir direccion del csv.
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

                // iteremos hasta que no encontremos lineas.
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










    //MeTODOS PARA ELIMINAR
    /**
     * Metodo par eliminar un emprendedor
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
            System.out.println("No se encontro al emprendedor");
        } else {
            System.out.println("Emprendedor con RFC " + rfc + " eliminado correctamente.");
            try (FileWriter fileWriter = new FileWriter(new File("./Emprendedores.csv"))) {
                StringBuilder line = new StringBuilder();
                for (Emprendedor emprendedor : arrEm) {
                    line.append(emprendedor.serializa()); // Serializa cada emprendedor
                }
                fileWriter.write(line.toString()); // Escribe la lista actualizada en el archivo
                System.out.println("Archivo CSV actualizado correctamente.");
            } catch (Exception e) {
                System.out.println("Error al actualizar el archivo CSV: " + e.getMessage());
            }
        }
    }

    /**
     * Metodo para eliminar un cliente del arraylist.
     * @param id identificador unico.
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
            System.out.println("No se encontro el empleado");
        }else {
            System.out.println("Cliente con ID " + id + " eliminado correctamente.");
            try (FileWriter fileWriter = new FileWriter(new File("./Clientes.csv"))) {
                StringBuilder line = new StringBuilder();
                for (Cliente cliente : arrCl) {
                    line.append(cliente.serializa()); // Serializa cada emprendedor
                }
                fileWriter.write(line.toString()); // Escribe la lista actualizada en el archivo
                System.out.println("Archivo CSV actualizado correctamente.");
            } catch (Exception e) {
                System.out.println("Error al actualizar el archivo CSV: " + e.getMessage());
            }
        }
    }

    /**
     * Metodo para eliminar un negocio del Arraylist
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
            System.out.println("No se encontro el negocio");
        }else {
            System.out.println("Negocio con ID " + id + " eliminado correctamente.");
            try (FileWriter fileWriter = new FileWriter(new File("./Negocios.csv"))) {
                StringBuilder line = new StringBuilder();
                for (Negocio negocio : arrNeg) {
                    line.append(negocio.serializa()); // Serializa cada emprendedor
                }
                fileWriter.write(line.toString()); // Escribe la lista actualizada en el archivo
                System.out.println("Archivo CSV actualizado correctamente.");
            } catch (Exception e) {
                System.out.println("Error al actualizar el archivo CSV: " + e.getMessage());
            }
        }
    }













//Metodos para escribir en el CSV
    /** 
     * Metodo para agregar un emprendedor al csv
     * @param emprendedorNuevo
     * @param emprendedores
     */
    public static ArrayList<Emprendedor> agregaEmprendedores(String dir, Emprendedor emprendedorNuevo, ArrayList<Emprendedor> emprendedores){

        boolean z = false;

        for(Emprendedor emprendedor: emprendedores){
            if(emprendedor.getRfc().equals(emprendedorNuevo.getRfc())){
                System.out.println("Error, este emprendedor ya esta en el sistema");
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
    
    /**
     * Metodo para agregar un cliente al csv
     * @param emprendedorNuevo
     * @param emprendedores
     */
    public static ArrayList<Cliente> agregaClientes(String dir, Cliente clienteNuevo, ArrayList<Cliente> clientes){

        boolean z = false;

        for(Cliente negocio: clientes){
            if(negocio.getId() == clienteNuevo.getId()){
                System.out.println("Error, este emprendedor ya esta en el sistema");
                z = true;
                break;
            }
        }
        if(!z){
            clientes.add(clienteNuevo);
            try {
                FileWriter fileWriter = new FileWriter( new File(dir));
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < clientes.size(); i++){
                    line.append(clientes.get(i).serializa());
                }
                fileWriter.write(line.toString());
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error: "+e);
                // TODO: handle exception
            }
            System.out.println("Cliente agregado correctamente.");
            return clientes;
        }
        return clientes;
    }
    /**
     * Metodo para agregar un negocio al csv
     * @param emprendedorNuevo
     * @param emprendedores
     */
    public static ArrayList<Negocio> agregaNegocios(String dir, Negocio negocioNuevo, ArrayList<Negocio> negocios){

        boolean z = false;

        for(Negocio negocio: negocios){
            if(negocio.getId() == negocioNuevo.getId()){
                System.out.println("Error, este emprendedor ya esta en el sistema");
                z = true;
                break;
            }
        }
        if(!z){
            negocios.add(negocioNuevo);
            try {
                FileWriter fileWriter = new FileWriter( new File(dir));
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < negocios.size(); i++){
                    line.append(negocios.get(i).serializa());
                }
                fileWriter.write(line.toString());
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error: "+e);
                // TODO: handle exception
            }
            System.out.println("Negocio agregado correctamente.");
            return negocios;
        }
        return negocios;
    }
















    //MeTODOS PARA CONSULTAR
    /**
     * Metodo que consulta la informacion de un emprendedor.
     * @param rfc identificador unico.
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
            System.out.println("No se encontro al emprendedor");
        }
    }

    /**
     * Metodo que consulta la informacion de un cliente.
     * @param id identificador unico.
     * @param arrCl arrayList de empleados
     */
    public static void consultaCliente(int id , ArrayList<Cliente> arrCl){
        boolean encontrado = false;
        for( int i = 0; i< arrCl.size(); i++){
            Cliente cl = arrCl.get(i);
            if(cl.getId() == id){
                System.out.println(cl);
                encontrado = true;
                cl.toString();
            }
        }
        if(!encontrado){
            System.out.println("No se encontro al cliente");
        }
    }

    /**
     * Metodo que consulta la informacion de un negocio.
     * @param id identificador unico.
     * @param arrNe arrayList de empleados
     */
    public static void consultaNegocio(int id, ArrayList<Negocio> arrNe){
        boolean encontrado = false;
        for( int i = 0; i< arrNe.size(); i++){
            Negocio ne = arrNe.get(i);
            if(ne.getId() == id){
                System.out.println(ne);
                encontrado = true;
                ne.toString();
            }
        }
        if(!encontrado){
            System.out.println("No se encontro al negocio");
        }
    }
}
