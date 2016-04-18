/* 
 * Con este programa, actualizaremos todos los calores del archivo Alumnos.dat, mediante Alumnos_act.dat
 * Necesitaremos de ambos archivos anteriormente citados
 * Devolveremos el archivo Alumnos.dat ya actualizado con los valores de Alumnos_act (de ahora en adelante
 * "actualizador")
 * 
 * En el archivo: Alumnos_act tenemos todos lso alumnos a los que le hemso hecho algún tipo de modificación
 * las cuales pasaran al archivo Alumnos.dat, manteniendo su ID y cambiando lo que sea necesario
 * 
 * No tenemos ningún tipo de restricción a la hora de actualizar, es decir, en el archivo actualizador podremos
 * tener tantas veces el mismo alumno como queramos, sin embargo, el único con el que actualizaremos será con
 * el último alumno, ya que este es el que tiene todo los cambios válidos.
 * 
 Pseudocódigo generalizado
 Inicio
 	abrirAlumnosLeer           (Alumnos)
 	abrirAlumnos_actLeer       (Actualizado)
 	abrirAlumnos_tempEscribir (Temporal)
 	Leer registro Actualizado
	Leer registro Alumnos
 	mientras (no FF de Actualizado y no FF de Alumnos)
 		Si(ID_Alumnos == ID_Actualizado)
			Escribir registro actualizado en Temporal
			Leer registro Actualizado
			Leer registro Alumnos
		En otro caso /*puesto que solo contemplamos el caso de actualizaciones, damos por hecho de que 
						lo que se está realizando es una copia del maestro al maestro actualizado*/
/*
			Mientras (ID_Actualizado >ID_Alumnos)
				Escribir registro de Alumnos en Actualizado
				Leer registro de Alumnos
			fin_Mientras
		Fin_si
	fin_mientras
	Mientras(no FF de Alumnos)
		Leer registro de Alumnos
		Escribir registro de Alumnos en Temporal
	Fin mientras
fin
*/
package hogwartsFichero;

import java.io.*;

public class ActualizaFichero {
	/* 
	 * Interfaz 
	 * Cabecera: Alumno leeAlumno(DataInputStream leer) throws IOException
	 * Proceso:método que lee un alumno de un fichero, y lo devuelve como tal
	 * Precondiciones:ninguna
	 * Entrada:1 fichero
	 * Salida:1 alumno
	 * Entrada/Salida:Nada
	 * Postcondiciones:Alumno asociado al nombre
	 */
	public static Alumno leeAlumno(DataInputStream leer){
		int id,letrasNombre,letrasApellido,i;
		double nota;
		Alumno a=null;
		String nombre="";
		String apellido="";
		try {
			id=leer.readInt();
			letrasNombre = leer.readInt();
			for (i = 0; i < letrasNombre; i++) {
				nombre = nombre + leer.readChar();
			}
			letrasApellido = leer.readInt();
			for (i = 0; i < letrasApellido; i++) {
				apellido = apellido + leer.readChar();
			}
			nota = leer.readDouble();
			a = new Alumno(nombre, apellido, nota,id);
		} catch (IOException e) {
			
		}
		return a;
	}
	public static void main(String[] args) {
		// Declaración de objetos y otras variables de interés
		Alumno viejo,actual;

		File Maestro = new File("src\\hogwartsFichero\\Alumnos.dat");
		FileInputStream alumno;
		DataInputStream alumnoIn = null;
		File Movimiento = new File("src\\hogwartsFichero\\Alumnos_act.dat");
		FileInputStream actualizado;
		DataInputStream actualizadoIn = null;
		EscribeBinario temporal = null;
		try {
			// abrirAlumnosLeer (Alumnos)
			alumno = new FileInputStream(Maestro);
			alumnoIn = new DataInputStream(alumno);

			// abrirAlumnos_actLeer (Actualizado)
			actualizado = new FileInputStream(Movimiento);
			actualizadoIn = new DataInputStream(actualizado);

			// abrirAlumnos_tempEscribir (Temporal)
			temporal=new EscribeBinario("Alumnos_temp",true);
			
			// leer registro Alumnos
			viejo=leeAlumno(alumnoIn);
			
			// leer registro Actualizado
			actual=leeAlumno(actualizadoIn);
			
			
			// mientras (no FF de Actualizado y no FF de Alumnos)
			while (alumnoIn.read()!=-1 && actualizadoIn.read()!=-1 ){
				
				// Si(ID_Alumnos == ID_Actualizado)
				if (viejo.getID() == actual.getID()) {
					// Escribir registro actualizado en Temporal
					temporal.escribe(actual);
					// leer registro Alumnos
					viejo=leeAlumno(alumnoIn);
					
					// leer registro Actualizado
					actual=leeAlumno(actualizadoIn);
				}else{// En otro caso
					// Mientras (ID_Actualizado >ID_Alumnos)//no es necesario controlar el fin de ficheros
															//de Alumnos, puesto que sabemos que en actualizado
															//solo puede haber alumnos ya existentes
					while(actual.getID()>viejo.getID()){
						// Escribir registro de Alumnos en Temporal
						temporal.escribe(viejo);
						
						// Leer registro de Alumnos
						viejo=leeAlumno(alumnoIn);
					}// fin_Mientras
				}// Fin_si
			}// fin_mientras
			// Mientras(no FF de Alumnos)
			while(alumnoIn.read()!=-1){
				// Leer registro de Alumnos
				viejo=leeAlumno(alumnoIn);
				// Escribir registro de Alumnos en Temporal
				temporal.escribe(viejo);
			}// Fin mientras
			alumno.close();
			actualizado.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			/*temporal.cierra();
			File maestroActualizado=new File("src\\hogwartsFichero\\Alumnos_final.dat");
			Maestro.delete();
			boolean renombrado=maestroActualizado.renameTo(Maestro);
			Movimiento.delete();
			System.out.println(renombrado);*/
		}
	}
}
