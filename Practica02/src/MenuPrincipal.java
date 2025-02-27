import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
  	static ArrayList<Negocio> negocios = ReadCSV.leeNegociosCSV("./Negocios.csv");
  	static ArrayList<Cliente> clientes =  ReadCSV.leeClientesCSV("./Clientes.csv");
  	static ArrayList<Emprendedor> emprendedores =  ReadCSV.leeEmprendedoresCSV("./Emprendedores.csv");
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion; // Guardaremos la opcion del usuario
    
        while (!salir) {
          System.out.println(" \n .oPYo.  o                                   o      8        ");
          System.out.println(" 8   `8                                             8        ");
          System.out.println("o8YooP' o8 .oPYo. odYo. o    o .oPYo. odYo. o8 .oPYo8 .oPYo. ");
          System.out.println(" 8   `b  8 8oooo8 8' `8 Y.  .P 8oooo8 8' `8  8 8    8 8    8 ");
          System.out.println(" 8    8  8 8.     8   8 `b..d' 8.     8   8  8 8    8 8    8 ");
          System.out.println(" 8oooP'  8 `Yooo' 8   8  `YP'  `Yooo' 8   8  8 `YooP' `YooP' ");
          System.out.println(":......::..:.....:..::..::...:::.....:..::..:..:.....::.....:");
          System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
          System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    
          System.out.println("\n" + "\n");
          System.out.println("          Elije el numero de la opcion que se adapte a tus necesidades    ");
          System.out.println("\n");
          System.out.println("          1  -- GESTIONAR Clientes");
          System.out.println("          2  -- GESTIONAR Emprendedores");
          System.out.println("          3  -- GESTIONAR Negocios");
          System.out.println("\n");
          System.out.println("          OPRIME 4 PARA SALIR");
    
          System.out.println("Escribe una de las opciones");
          opcion = sc.nextInt();
          try{
            switch (opcion){
              case 1:
                System.out.println("Has seleccionado la opcion 1 Gestion de Clientes");
				menuCliente();
                break;
              case 2:
                System.out.println("Has seleccionado la opcion 2 Gestion de Emprendedores");
                menuEmprendedor();
				break;
              case 3:
                System.out.println("Has seleccionado la opcion 3 Gestion de Negocios");
                menuNegocio();
				break;
              case 4:
                salir = true;
                break;
              default:
                System.out.println("Solo numeros entre 1 y 4");
            }
          }
            catch (IllegalArgumentException e) {
            System.out.println("Argumento invalido, favor de introducir solo numeros");
          }
        }
    }

    public static void menuCliente(){

		int a = getInt(4,"¿Que deseas realizar? \n Escribe 0 para agregar un nuevo Cliente \n Escribe 1 para consultar un Cliente \n Escribe 2 para editar un Cliente \n Escribe 3 para eliminar un Cliente", "Error, eso no es una opcion");
    	switch (a){

      	case (0): //Agregar
			boolean flag;
			int id;
			String nombre;
			String apellidoPat;
			String apellidoMat;
			boolean metodoPago = false;
			String domicilio;
			String numeroTarjeta;
			String vencimiento;
			int cvv;

			do{
				flag = false;
				id = getInt(10000000, "¿Cual es el ID del cliente?: " , "Error, eso no es un numero");
				//Verifica que es un entero
				if(id % 1 == 0){
				  flag = true;
				}
			}while(flag == false);
			nombre = getOnlyLettersSpace("¿Cual es el nombre?: ");
			apellidoPat =  getOnlyLetters("¿Cual es el apellido paterno?: ");
			apellidoMat =  getOnlyLetters("¿Cual es el apellido materno?: ");
			boolean b = false;
			do {
				try {
					System.out.println("¿Cual es tu metodo de pago? ('true' si es tarjeta, 'false' si es efectivo)");
					Scanner n = new Scanner(System.in);
					boolean bn = n.nextBoolean();
					metodoPago = bn;
					b = true;
				} catch (InputMismatchException e) {
					System.out.println("Escribe un booleano");
				}
			} while (!b);
			domicilio =  getOnlyLettersSpaceNumber("¿Cual es el domicilio?: ");
			numeroTarjeta = getOnlyNumber("¿Cual es el numero de la tarjeta?: ");
			vencimiento = getOnlyLettersSpaceNumber("¿Cual es el vencimiento de la tarjeta?: ");
			do{
				flag = false;
				cvv = getInt(1000, "¿Cual es el CVV de la tarjeta?: " , "Error, eso no es un numero");
				//Verifica que es un entero
				if(cvv % 1 == 0){
				  flag = true;
				}
			}while(flag == false);

			// Crear el objeto Cliente
			Cliente clienteNuevo = new Cliente(id, nombre, apellidoPat, apellidoMat, metodoPago, domicilio, numeroTarjeta, vencimiento, cvv);
			ReadCSV.agregaClientes("./Clientes.csv", clienteNuevo,clientes);
			break;
		case (1): //Consultar
			Scanner scCliente2 = new Scanner(System.in);
			System.out.println("¿Cual es el ID del cliente que deseas consultar?");
			id = scCliente2.nextInt();
			ReadCSV.consultaCliente(id, clientes);
		break;

		case (2):
		//Editar
		break;

		case (3):
			Scanner scCliente3 = new Scanner(System.in);
			System.out.println("¿Cual es el ID del cliente que deseas eliminar?");
			id = scCliente3.nextInt();
			ReadCSV.eliminaCliente(id, clientes);
		break;
	  
		default:
			System.out.println("Elige una opcion valida");
		break;
		}
		
    }

    public static void menuEmprendedor(){
		int a = getInt(4,"¿Que deseas realizar? \n Escribe 0 para agregar un nuevo Emprendedor \n Escribe 1 para consultar un Emprendedor \n Escribe 2 para editar un Emprendedor \n Escribe 3 para eliminar un Emprendedor", "Error, eso no es una opcion");
    	switch (a){

      	case (0): //Agregar
			String rfc;
			String nombre;
			String apellidoPat;
			String apellidoMat;
			String domicilio;
			ArrayList<String> telefonos = new ArrayList<>();
			ArrayList<String> correos = new ArrayList<>();
			String fechaNac;
			String genero;

			rfc = getOnlyLettersSpaceNumber("¿Cual es el RFC?: ");
			nombre = getOnlyLettersSpace("¿Cual es el nombre?: ");
			apellidoPat =  getOnlyLetters("¿Cual es el apellido paterno?: ");
			apellidoMat =  getOnlyLetters("¿Cual es el apellido materno?: ");
			domicilio =  getOnlyLettersSpaceNumber("¿Cual es el domicilio?: ");
			// Solicitar telefonos

			System.out.println("Ingrese los telefonos (ingrese '0' para terminar):");
			while (true) {
				String telefono = getOnlyNumber("Ingrese un telefono: ");
				if (telefono.equalsIgnoreCase("0")) {
					break;
				}
				try {
					telefonos.add(telefono); // Convertir a Long y agregar a la lista
				} catch (NumberFormatException e) {
					System.out.println("Error: Ingrese un numero valido.");
				}
			}

			// Solicitar correos
			System.out.println("Ingrese los correos (ingrese 'fin@hotmail.com' para terminar):");
			while (true) {
				String correo = getEmail("Ingrese un correo: ");
				if (correo.equalsIgnoreCase("fin@hotmail.com")) {
					break;
				}
				correos.add(correo); // Agregar a la lista
			}

			fechaNac = getFechaDeNacimiento("¿Cual es la fecha de Nacimiento? (en formato DD/MM/YYYY): ");
			genero = getOnlyLettersSpace("¿Cual es el genero?: ");

			// Crear el objeto Emprendedor
			Emprendedor emprendedorNuevo = new Emprendedor(rfc, nombre, apellidoPat, apellidoMat, domicilio, telefonos, correos, fechaNac, genero);
			ReadCSV.agregaEmprendedores("./Emprendedores.csv", emprendedorNuevo,emprendedores);
			break;
		case (1): //Consultar
			Scanner scEmprendedor2 = new Scanner(System.in);
			System.out.println("¿Cual es el rfc del emprendedor que deseas consultar?");
			rfc = scEmprendedor2.nextLine();
			ReadCSV.consultaEmprendedor(rfc, emprendedores);
		break;

		case (2):
		//Editar
		break;

		case (3):
			Scanner scEmprendedor3 = new Scanner(System.in);
			System.out.println("¿Cual es el rfc del emprendedor que deseas eliminar?");
			rfc = scEmprendedor3.nextLine();
			ReadCSV.eliminaEmprendedor(rfc, emprendedores);
		break;
	  
		default:
			System.out.println("Elige una opcion valida");
		break;
		}

    }

    public static void menuNegocio(){

		int a = getInt(4,"¿Que deseas realizar? \n Escribe 0 para agregar un nuevo Negocio \n Escribe 1 para consultar un Negocio \n Escribe 2 para editar un Negocio \n Escribe 3 para eliminar un Negocio", "Error, eso no es una opcion");
    	switch (a){

      	case (0): //Agregar
			boolean flag;
			int id;
			String nombreNegocio;
			ArrayList<String> telefonos = new ArrayList<>();
			ArrayList<String> correos = new ArrayList<>();
			ArrayList<String> redesSociales = new ArrayList<>();
			String rangoPrecios;
			String descripcion;

			do{
				flag = false;
				id = getInt(10000000, "¿Cual es el ID del Negocio? (Solo numeros): " , "Error, eso no es un numero");
				//Verifica que es un entero
				if(id % 1 == 0){
				  flag = true;
				}
			}while(flag == false);

			nombreNegocio = getOnlyLettersSpaceNumber("¿Cual es el nombre?: ");
			
			// Solicitar telefonos

			System.out.println("Ingrese los telefonos (ingrese '0' para terminar):");
			while (true) {
				String telefono = getOnlyNumber("Ingrese un telefono: ");
				if (telefono.equalsIgnoreCase("0")) {
					break;
				}
				try {
					telefonos.add(telefono);
				} catch (NumberFormatException e) {
					System.out.println("Error: Ingrese un numero valido.");
				}
			}

			// Solicitar correos
			System.out.println("Ingrese los correos (ingrese 'fin@hotmail.com' para terminar):");
			while (true) {
				String correo = getEmail("Ingrese un correo: ");
				if (correo.equalsIgnoreCase("fin@hotmail.com")) {
					break;
				}
				correos.add(correo); // Agregar a la lista
			}

			// Solicitar redes sociales
			System.out.println("Ingrese las redes sociales en formato 'redSocial : nombre' (ingrese 'fin' para terminar):");
			while (true) {
				String redSocial = getOnlyLettersSpaceNumber("Ingrese una red social: ");
				if (redSocial.equalsIgnoreCase("fin")) {
					break;
				}
				redesSociales.add(redSocial); // Agregar a la lista
			}

			rangoPrecios =  getOnlyLettersSpaceNumber("¿Cual es el rango de precios? (en formato '000 a 000'): ");
			descripcion =  getOnlyLettersSpaceNumber("¿Cual es la descripcion?: ");
			// Crear el objeto Emprendedor
			Negocio negocioNuevo = new Negocio(id, nombreNegocio, telefonos, correos, redesSociales, rangoPrecios, descripcion);
			ReadCSV.agregaNegocios("./Negocios.csv", negocioNuevo,negocios);
			break;
		case (1): //Consultar
			Scanner scNegocio2 = new Scanner(System.in);
			System.out.println("¿Cual es el ID del negocio que deseas consultar?");
			id = scNegocio2.nextInt();
			ReadCSV.consultaNegocio(id, negocios);
		break;

		case (2):
		//Editar
		break;

		case (3):
			Scanner scNegocio3 = new Scanner(System.in);
			System.out.println("¿Cual es el ID del negocio que deseas eliminar?");
			id = scNegocio3.nextInt();
			ReadCSV.eliminaNegocio(id, negocios);
		break;
	  
		default:
			System.out.println("Elige una opcion valida");
		break;
		}
		
    }
    /**
    *getInt recibe un entero, dos cadenas y devuelve un entero, si lo que el usuario ponga no es un entero, devolvera error
    * hasta que se le pase un entero, es para verificar si es un entero o no. La primera cadena es el mensaje
    * que queremos que el usuario vea y la segunda es el error. el entero que recibe es la cota superior.
    *@param d cota superior
    *@param b mensaje normal
    *@param c mensaje de error
    *@return el entero
  */
  public static int getInt(int d, String b,String c){
    Scanner sc = new Scanner(System.in);
    int a=0;
    boolean z=false;
    do{
    System.out.println(b);
      if(sc.hasNextInt()){
        z = true;
        a = sc.nextInt();
      }
      else {
        sc.next();
        System.out.println(c);
      }
    }while(z == false);
    return a;
  }

  /**
	 * @param lineMessage
	 * @return String
	 */
	// Metodo que verifica si la entrada del usuario es solo numeros
	// numeros
	// muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: numeros)
	public static String getOnlyNumber(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificara si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condicion que atraviesa el tamaño de las letras y cambia el valor a false

			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57)))/* 0 - 9 */

					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada invalida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificacion == falsa
		} while (check == false);
		return letters;
	}

  /**
	 * @param lineMessage
	 * @return String
	 */
	// Metodo que verifica si la entrada del usuario es solo letras y muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: numeros)
	public static String getOnlyLetters(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificara si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condicion que atraviesa el tamaño de las letras y cambia el valor a false

			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90))
						&& (((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122)))
					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada invalida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificacion == falsa
		} while (check == false);
		return letters;
	}

  /**
	 * @param lineMessage
	 * @return String
	 */
	// Metodo que verifica si la entrada del usuario es solo letras y espacios y
	// muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: numeros)
	public static String getOnlyLettersSpace(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificara si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condicion que atraviesa el tamaño de las letras y cambia el valor a false

			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90))
						&& (((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122))
						&& ((int) letters.charAt(l) != 32)) /* SPACE */

					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada invalida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificacion == falsa
		} while (check == false);
		return letters;
	}


	/**
	 * @param lineMessage
	 * @return String
	 */
	// Metodo que verifica si el correo electronico es valido, muestra un mensaje de
	// error en caso de el formato sea incorrecto
	public static String getEmail(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que comprobara el formato del correo electronico
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException e) {
				System.out.println("Error al recibir el email");
			}
			// ASCII
			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90)) && /* A - Z */
						(((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122)) && /* a - z */
						(((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57)) && /*
																																									 * 0 - // 9
																																									 */
						((int) letters.charAt(l) != 46) && /* . */
						((int) letters.charAt(l) != 95) && /* _ */
						((int) letters.charAt(l) != 64)) /* @ */
					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada invalida! ¡Intentar otra vez!");
			else {
				if (!letters.contains("@")) {
					System.out.println("Formato no valido, ingrese correo electronico valido");
					check = false;
				} else if (!letters.contains(".")) {
					System.out.println("Formato no valido, ingrese correo electronico valido");
					check = false;
				} else if (letters.indexOf("@") > letters.indexOf(".")) {
					System.out.println("Formato no valido, ingrese correo electronico valido");
				}
			}
			// El bucle se ejecuta mientras la verificacion == falsa
		} while (check == false);
		return letters;
	}

  /**
	 * @param lineMessage
	 * @return String
	 */
	// Metodo que verifica si la entrada del usuario es solo letras y espacios y
	// muestra
	// mensajes de error
	// en caso de que la entrada sea otra cosa (por ejemplo: numeros)
	public static String getOnlyLettersSpaceNumber(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que verificara si la entrada del usuario son letras
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException | StringIndexOutOfBoundsException e) {
				System.out.println("Error al recibir letras");
			}
			// condicion que atraviesa el tamaño de las letras y cambia el valor a false
			// ASCII
			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 65) || ((int) letters.charAt(l) > 90))
						&& (((int) letters.charAt(l) < 97) || ((int) letters.charAt(l) > 122))
						&& (((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57)) /* 0 - 9 */
						&& ((int) letters.charAt(l) != 32) /* SPACE */
						&& ((int) letters.charAt(l) != 35) /* # */
						&& ((int) letters.charAt(l) != 46) /* . */
						&& ((int) letters.charAt(l) != 44) /* , */
						&& ((int) letters.charAt(l) != 47)) /* / */

					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada invalida! ¡Intentar otra vez!");
			// El bucle se ejecuta mientras la verificacion == falsa
		} while (check == false);
		return letters;
	}

  /**
	 * @param lineMessage
	 * @return String
	 */
	// Metodo que verifica si la fecha de nacimiento es valido, muestra un mensaje
	// de
	// error en caso de el formato sea incorrecto
	public static String getFechaDeNacimiento(String lineMessage) {
		boolean check = true;
		String letters = "";
		// bucle que comprobara el formato del correo electronico
		do {
			check = true;
			System.out.print(lineMessage);
			try {
				letters = br.readLine();
			} catch (IOException e) {
				System.out.println("Error al recibir la fecha de nacimiento");
			}
			// ASCII
			for (int l = 0; l < letters.length(); l++) {
				if ((((int) letters.charAt(l) < 48) || ((int) letters.charAt(l) > 57)) && /* 0 - 9 */
						((int) letters.charAt(l) != 47)) /* / */
					check = false;
			}
			if (check == false)
				System.out.println("¡Entrada invalida! ¡Intentar otra vez!");
			else {
				if (!letters.contains("/")) {
					System.out.println("Formato no valido, ingrese la fecha de nacimiento del siguiente ejemplo: 12/03/99");
					check = false;
				}

			}
			// El bucle se ejecuta mientras la verificacion == falsa
		} while (check == false);
		return letters;
	}
}
