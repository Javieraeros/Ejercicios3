package hogwartsNuevo;

import java.io.*;
import java.util.StringTokenizer;

public class FicheroAlumno {
	/*
	 * Interfaz
	 * Cabecera: String leeAlumno(String nombreFichero)
	 * Proceso:Lee el primer Alumno del archivo de texto correspondiente
	 * Precondiciones:Ninguna
	 * Entrada:La ruta del fichero
	 * Salida:Una cadena
	 * Entrada/Salida:Nada
	 * Postcondiciones:Cadena asociada al nombre
	 */
	public String leeAlumno(String nombreFichero) {
		String devuelve = null;
		try {
			File archivo = new File(nombreFichero);
			FileReader fichero = new FileReader(archivo);
			BufferedReader bw = new BufferedReader(fichero);
			devuelve = bw.readLine();
			bw.close();
			fichero.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return devuelve;
	}

	/*
	 * Interfaz
	 * Cabecera:void muestraAlumnos(String nombreFichero)
	 * Proceso:Lee el fichero deonde estén almacenados todos los Alumnos y los pinta en pantalla
	 * Precondiciones:Ninguna
	 * Entrada:La ruta del fichero
	 * Salida:nada, pinta en pantalla
	 * Entrada/Salida:Nada
	 * Postcondiciones:Cadena asociada al nombre
	 */
	public void muestraAlumnos(String nombreFichero) {
		try {
			File archivo = new File(nombreFichero);
			FileReader fichero = new FileReader(archivo);
			BufferedReader bw = new BufferedReader(fichero);
			
			//Lectura anticipada
			String linea=bw.readLine();
			StringTokenizer leeid;
			String id;
			while(linea!=null){
				leeid=new StringTokenizer(linea);
				id=leeid.nextToken();
				if(!id.equals("0")){
					System.out.println(linea);
				}
				linea=bw.readLine();
			}
			bw.close();
			fichero.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	
	/*
	 * Interfaz
	 * Cabecera: String leeAlumno(String nombreFichero,int linea)
	 * Proceso:Lee el alumno indicado por el parámetro del archivo de texto correspondiente
	 * Precondiciones:número de linea mayor que 0, y menor que fin de fichero
	 * Entrada:La ruta del fichero
	 * 			un entero para el Alumno
	 * Salida:Una cadena
	 * Entrada/Salida:Nada
	 * Postcondiciones:Cadena asociada al nombre
	 */
	public String leeAlumno(String nombreFichero, int linea) {
		String devuelve = null;
		if (linea > 0) {
			try {
				File archivo = new File(nombreFichero);
				FileReader fichero = new FileReader(archivo);
				BufferedReader bw = new BufferedReader(fichero);
				for(int i=1;i<linea;i++){   //Dejo el puntero apuntando a la linea que quiero leer
					bw.readLine();
				}
				devuelve = bw.readLine();
				bw.close();
				fichero.close();
			} catch (IOException e) {
				System.out.println("Error, la línea debe tiene que existir en el fichero");
			}
		}else{
			System.out.println("Error, la línea tiene que ser mayor que 0");
		}
		return devuelve;
	}
	/*
	 * Interfaz
	 * Cabecera: String[] leeAlumno(String nombreFichero,int lineaInicio,int numeroLeer)
	 * Proceso:Lee el conjunto de Alumnos igual a numeroLeer, empezando por lineaInicio
	 * Precondiciones:número de linea mayor que 0, y menor que fin de fichero,numeroLeer mayor que 0
	 * Entrada:La ruta del fichero
	 * 			un entero para el primer Alumno
	 * 			un entero para el número de lineas
	 * Salida:Un array de cadenas
	 * Entrada/Salida:Nada
	 * Postcondiciones:Array de cadenas asociada al nombre
	 */
	public String[] leeAlumno(String nombreFichero, int lineaInicio,int numeroLeer) {
		String[] devuelve = new String[numeroLeer];
		if (lineaInicio > 0 && numeroLeer>0) {
			try {
				File archivo = new File(nombreFichero);
				FileReader fichero = new FileReader(archivo);
				BufferedReader bw = new BufferedReader(fichero);
				for(int conta=1;conta<lineaInicio;conta++){   //Dejo el puntero apuntando a la linea que quiero leer
					bw.readLine();
				}
				for(int conta=0;conta<numeroLeer;conta++){
					devuelve[conta] = bw.readLine();
				}
				bw.close();
				fichero.close();
			} catch (IOException e) {
				System.out.println("Error, la línea debe tiene que existir en el fichero");
				System.out.println("Asegurate de que existen todas las líneas");
			}
		}else{
			System.out.println("Error, la línea tiene que ser mayor que 0");
		}
		return devuelve;
	}

	/* 
	 * Interfaz 
	 * Cabecera:void escribeTexto(String nombreFichero,String texto)
	 * Proceso:escribe una cadena de texto en el fichero indicado, añadiendo un salto de línea.
	 * 			Lo usaremos para crear un log
	 * Precondiciones:Ningna
	 * Entrada:Una cadena para el nombre(ruta) del fichero
	 * 			Una cadena con el Alumno que queramos escribir
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:El archivo quedará escrito y cerrado. Por defecto el archivo no se machaca a si mismo
	 * 					sino que escribe después de la última escritura
	 */
	public void escribeTexto(String nombreFichero, String texto) {
		try {
			File archivo = new File(nombreFichero);
			FileWriter fichero = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fichero);
			bw.write(texto + "\r\n");
			bw.close();
			fichero.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}
	
	/* 
	 * Interfaz 
	 * Cabecera:void escribeAlumno(String nombreFichero,Alumno a)
	 * Proceso:escribe un alumno (con el método cadena) en el fichero indicado, añadiendo un salto de línea
	 * Precondiciones:Ningna
	 * Entrada:Una cadena para el nombre(ruta) del fichero
	 * 			Un alumno que escribir
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:El archivo quedará escrito y cerrado. Por defecto el archivo no se machaca a si mismo
	 * 					sino que escribe después de la última escritura
	 */
	public void escribeAlumno(String nombreFichero, Alumno a) {
		try {
			File archivo = new File(nombreFichero);
			FileWriter fichero = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fichero);
			bw.write(a.cadena() + "\r\n");
			bw.close();
			fichero.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}
	
	
	/* 
	 * Interfaz 
	 * Cabecera: Alumno convierteLineaAlumno(String nombreFichero,int ID)
	 * Proceso:Devuelve un alumno a partir de la id de dicho alumno y del fichero especificado
	 * Precondiciones:ID mayor que 0
	 * Entrada:Un string como ruta del fichero
	 * 			El id del alumno que queremos leer
	 * Salida:Un alumno
	 * Entrada/Salida:Nada
	 * Postcondiciones:Alumno asociado al nombre, devolverá alumno null en caso de error
	 */
	public Alumno convierteAlumno(String nombreFichero,int ID){
		Alumno devuelve=null;
		try{
			File leer=new File(nombreFichero);
			FileReader fichero=new FileReader(leer);
			BufferedReader leeAlumno=new BufferedReader(fichero);
			String linea=leeAlumno.readLine();
			StringTokenizer alumnoTok=new StringTokenizer(linea);
			while(Integer.parseInt(alumnoTok.nextToken())!=ID && linea!=null){
				linea=leeAlumno.readLine();
				alumnoTok=new StringTokenizer(linea);
			}
			/*
			 * Al usar el StringTokenizer, el puntero de AlumnoTok apunta al nombre de la linea actual,
			 * por lo que para poner el id de ese alumno, usaremos el ID que nos pasan por parámetro
			 * ya que solo se lo pondremos si el alumno existe gracias a linea!=null
			 */
			//Creación de alumno a través de cadena
			if(linea!=null){ //nos aseguramos de que no ha llegado al final del fichero
				int id=ID;
				String nombre=alumnoTok.nextToken();
				String apellido=alumnoTok.nextToken();
				double nota=Double.parseDouble(alumnoTok.nextToken());
				devuelve=new Alumno(id,nombre,apellido,nota);
			}
			leeAlumno.close();
			fichero.close();
		}catch(IOException e){
			System.out.println(e);
		}
		return devuelve;
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: public void escribeAlumnoBinario(String ruta,Alumno a)
	 * Proceso:escribe un alumno de forma binaria con datos primitivos
	 * Precondiciones:ningura
	 * Entrada:1 cadena para la ruta
	 * 			1 alumno 
	 * Salida:Escribe en el fichero correspondiente
	 * Entrada/Salida:Nada
	 * Postcondiciones:El fichero pasado por la ruta qeudará escrito
	 */
	
	public void escribeAlumnoBinario(String ruta,Alumno a){
		try{
			File fichero=new File(ruta);
			FileOutputStream ficheroBin=new FileOutputStream(fichero,true);
			DataOutputStream escribeBin=new DataOutputStream(ficheroBin);
			escribeBin.writeInt(a.getID());
			escribeBin.writeInt(a.getNombre().length());
			escribeBin.writeChars(a.getNombre());
			escribeBin.writeInt(a.getApellidos().length());
			escribeBin.writeChars(a.getApellidos());
			escribeBin.writeDouble(a.getNota());
			escribeBin.close();
			ficheroBin.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}
	/* 
	 * Interfaz 
	 * Cabecera: public void muestraAlumnoBinario(String ruta)
	 * Proceso:muestra todos los alumnos del archivo seleccionado
	 * Precondiciones:ningura
	 * Entrada:1 cadena para la ruta
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:Muestra en pantalla todos los alumnos de dicho fichero
	 */
	public void muestraAlumnoBinario(String ruta){
		Alumno a; //creo aquí el alumno para ocupar menos espacio en memoria
		File fichero=new File(ruta);
		int id,tamanyoNombre,tamanyoApellido;
		String nombre,apellido;
		double nota;
		try {
			FileInputStream ficheroLeer = new FileInputStream(fichero);
			DataInputStream lee=new DataInputStream(ficheroLeer);
			do{
				//Inicio las variables en cada incio del bucle para evitar valores indebidos
				id=0;tamanyoNombre=0;tamanyoApellido=0;
				nombre="";apellido="";
				nota=0.0;
				
				//Leo el id
				id=lee.readInt();
				if(id!=0){  //para evitar mostrar los alumnos borrados por marca
					//Leo el nombre
					tamanyoNombre=lee.readInt();
					for(int i=0;i<tamanyoNombre;i++){
						nombre=nombre+lee.readChar();
					}
					
					//Leo el apellido
					tamanyoApellido=lee.readInt();
					for(int i=0;i<tamanyoApellido;i++){
						apellido=apellido+lee.readChar();
					}
					nota=lee.readDouble();
					a=new Alumno(id,nombre,apellido,nota);
					System.out.println(a.cadena());
				}
			}while(lee.available()>0);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	/*
	 * Crea un método que te guarde un array de Alumnos(cuestiones de rapidez) //opcional
	 * Crea un método que te de información de un alumno(binario) introduciendo el id de este
	 * Falta crear escribeObjetoBinario y leeObjetoBinario, con toda las funciones que hemos creado
	 * para archivos de texto y binarios primitivos. SERIALIZABLE
	 *
	 * Crear AccessRandom, para poder crear ficheros directos.
	 * 
	 * Ordernar ficheros de texto y binario (primitivos y objetos)
	 * 
	 * Cada vez que se cree un alumno (en un método o en hogwarts) usa el método correspondiente
	 * Cada vez que se modifique un alumno,guardalo en el fichero correspondiente
	 * Crea el principal Actualizar, de la forma que te dijo asun(do-while)
	 * Crea un principal que te muestre el fichero correspondiente con la funcionalidad correspondiente
	 * No uses rutas relativas y/o absolutas
	 */
}
