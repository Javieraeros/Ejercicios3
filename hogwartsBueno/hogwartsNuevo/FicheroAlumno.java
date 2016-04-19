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
	 * Cabecera: String leeTexto(String nombreFichero,int linea)
	 * Proceso:Lee la linea indicada por el parámetro del archivo de texto correspondiente
	 * Precondiciones:número de linea mayor que 0, y menor que fin de fichero
	 * Entrada:La ruta del fichero
	 * 			un entero para la linea
	 * Salida:Una cadena
	 * Entrada/Salida:Nada
	 * Postcondiciones:Cadena asociada al nombre
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
}
