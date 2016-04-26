/*En este programa mostraremos los datos almacenados en el fichero Alumnos.dat
 * Necesitaremos el fichero Alumnos.dat (suponemos que el nombre no cambiar�
 * El programa escribir� en pantalla los datos de dicho fichero
 * 
 * Pseudoc�digo generalizado
 * 	Inicio 
 * 		abreFicheroAlumnosLeer
 * 		repertir
 * 			muestra ID
 * 			muestra nombre
 * 			muestra apellido
 * 			muestra nota
 * 		mientras no Fin de Fichero
 * 		cierraFichero
 * 	Fin
 */
package hogwartsMalDise;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class muestraDatHogwarts {

	public static void main(String[] args) {
		int tamanyoNombre, tamanyoApellido;
		//abreFicheroAlumnosLeer
		DataInputStream fichero;
		try {
			fichero = new DataInputStream(new FileInputStream("src\\hogwartsFichero\\Alumnos.dat"));
			do {
				//muestraID
				System.out.println("ID: "+fichero.readInt());
				//muestraNombre
				tamanyoNombre = fichero.readInt();
				System.out.print("Nombre: ");
				for (int i = 0; i < tamanyoNombre; i++) {
					System.out.print(fichero.readChar());
				}
				System.out.println();
				//muestraApellido
				System.out.print("Apellido: ");
				tamanyoApellido = fichero.readInt();
				for (int i = 0; i < tamanyoApellido; i++) {
					System.out.print(fichero.readChar());
				}
				System.out.println();
				//muestraNota
				System.out.println("Nota: "+fichero.readDouble());
			} while (fichero.available() > 0); // �nica forma que se me ha
												// ocurrido de leer :/
			//cierraFichero
			fichero.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Lo siguiente es para crear un archivo de actualizaci�n de alumnos, y comprobar si lo actualiza
		/*Alumno javi=new Alumno("Javi","Ruiz",10);
		javi.setNombre("pene25");*/
	}

}
