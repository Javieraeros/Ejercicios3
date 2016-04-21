package hogwartsNuevo;

import java.io.*;;

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
			String linea=bw.readLine();
			while(linea!=null){
				System.out.println(linea);
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
	 * Proceso:escribe una cadena de texto en el fichero indicado, añadiendo un salto de línea
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
	 * Proceso:Devuelve un alumno a partir de la linea de un fichero
	 * Precondiciones:linea mayor que 0 y menor que la longitud del archivo
	 * Entrada:Un string como ruta del fichero
	 * 			El id/linea del alumno que queremos leer
	 * Salida:Un alumno
	 * Entrada/Salida:Nada
	 * Postcondiciones:Alumno asociado al nombre, devolverá alumno null en caso de error
	 */
	public Alumno convierteLineaAlumno(String nombreFichero,int ID){
		Alumno devuelve=null;
		try{
			File leer=new File(nombreFichero);
			FileReader fichero=new FileReader(leer);
			BufferedReader leeAlumno=new BufferedReader(fichero);
			for(int i=0;i<ID;i++){
				leeAlumno.readLine();
			}
			/*no acabada*/
		}catch(IOException e){
			System.out.println(e);
		}
		return devuelve;
	}
	
	/*
	 * Falta crear escribeObjetoBinario y leeObjetoBinario
	 * Recuerda crear la clase miObjectOutputStream
	 * Cada vez que se cree un alumno (en un método o en hogwarts) usa el método correspondiente
	 * Cada vez que se modifique un alumno,guardalo en el fichero correspondiente
	 * Añade las funcionalidades correspondientes para crear el log
	 * Crea el principal Actualizar, de la forma que te dijo asun(do-while)
	 * Crea un principal que te muestre el fichero correspondiente con la funcionalidad correspondiente
	 * No uses rutas relaticas y/o absolutas
	 */
}
