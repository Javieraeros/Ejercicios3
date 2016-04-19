package hogwartsNuevo;

import java.io.*;;

public class FicheroAlumno {
	/*
	 * Interfaz
	 * Cabecera: String leeTexto(String nombreFichero)
	 * Proceso:Lee la primera linea del archivo de texto correspondiente
	 * Precondiciones:Ninguna
	 * Entrada:La ruta del fichero
	 * Salida:Una cadena
	 * Entrada/Salida:Nada
	 * Postcondiciones:Cadena asociada al nombre
	 */
	public String leeTexto(String nombreFichero) {
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
	 * Cabecera: String leeTexto(String nombreFichero,int linea)
	 * Proceso:Lee la linea indicada por el parámetro del archivo de texto correspondiente
	 * Precondiciones:número de linea mayor que 0, y menor que fin de fichero
	 * Entrada:La ruta del fichero
	 * 			un entero para la linea
	 * Salida:Una cadena
	 * Entrada/Salida:Nada
	 * Postcondiciones:Cadena asociada al nombre
	 */
	public String leeTexto(String nombreFichero, int linea) {
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
	 * Cabecera: String[] leeTexto(String nombreFichero,int lineaInicio,int numeroLeer)
	 * Proceso:Lee el conjunto de lineas igual a numeroLeer, empezando por lineaInicio
	 * Precondiciones:número de linea mayor que 0, y menor que fin de fichero,numeroLeer mayor que 0
	 * Entrada:La ruta del fichero
	 * 			un entero para la linea
	 * 			un entero para el número de lineas
	 * Salida:Un array de cadenas
	 * Entrada/Salida:Nada
	 * Postcondiciones:Array de cadenas asociada al nombre
	 */
	public String[] leeTexto(String nombreFichero, int lineaInicio,int numeroLeer) {
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
	 * Cabecera:void escribeTexto(String nombreFichero,String info)
	 * Proceso:escribe una cadena de texto en el fichero indicado, añadiendo un salto de línea
	 * Precondiciones:Ningna
	 * Entrada:Una cadena para el nombre(ruta) del fichero
	 * 			Una cadena con lo que queremos escribir
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:El archivo quedará escrito y cerrado. Por defecto el archivo no se machaca a si mismo
	 * 					sino que escribe después de la última escritura
	 */
	public void escribeTexto(String nombreFichero, String info) {
		try {
			File archivo = new File(nombreFichero);
			FileWriter fichero = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fichero);
			bw.write(info + "\r\n");
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
	 * Cabecera:void escribeTexto(String nombreFichero,String info,boolean aniadir)
	 * Proceso:escribe una cadena de texto en el fichero indicado,sin añadir salto de linea
	 * Precondiciones:Ningna
	 * Entrada:Una cadena para el nombre(ruta) del fichero
	 * 			Una cadena con lo que queremos escribir
	 * 			Un booleano para indicar si queremos machacar el fichero(false) o si queremos escribir
	 * 			después de la última escritura(true)
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:El archivo quedará escrito y cerrado
	 */
	public void escribeTexto(String nombreFichero, String info,boolean aniadir) {
		try {
			File archivo = new File(nombreFichero);
			FileWriter fichero = new FileWriter(archivo, aniadir);
			BufferedWriter bw = new BufferedWriter(fichero);
			bw.write(info);
			bw.close();
			fichero.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	/* 
	 * Interfaz 
	 * Cabecera: Alumno convierteLineaAlumno(String nombreFichero,int Linea)
	 * Proceso:Devuelve un alumno a partir de la linea de un fichero
	 * Precondiciones:linea mayor que 0 y menor que la longitud del archivo
	 * Entrada:
	 * Salida:
	 * Entrada/Salida:
	 * Postcondiciones:
	 */
}
