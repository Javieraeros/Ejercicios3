/* 
 * Con este programa, actualizaremos todos los calores del archivo Alumnos.dat, mediante Alumnos_act.dat
 * Necesitaremos de ambos archivos anteriormente citados
 * Devolveremos el archivo Alumnos.dat ya actualizado con los valores de Alumnos_act (de ahora en adelante
 * "actualizador")
 * 
 * En el archivo: Alumnos_act tenemos todos lso alumnos a los que le hemso hecho alg�n tipo de modificaci�n
 * las cuales pasaran al archivo Alumnos.dat, manteniendo su ID y cambiando lo que sea necesario
 * 
 * No tenemos ning�n tipo de restricci�n a la hora de actualizar, es decir, en el archivo actualizador podremos
 * tener tantas veces el mismo alumno como queramos, sin embargo, el �nico con el que actualizaremos ser� con
 * el �ltimo alumno, ya que este es el que tiene todo los cambios v�lidos.
 * 
 Pseudoc�digo generalizado
 Inicio
 	abrirAlumnosLeer           (Alumnos)
 	abrirAlumnos_actLeer       (Actualizado)
 	abrirAlumnos_tempEscribir (Temporal)
 	Leer registro Actualizado
	Leer registro Alumnos
 	mientras (no FF de Actualizado y no FF de Alumnos)
 		leer fin de ficheros (alumnos y actualizado
 		Si(ID_Alumnos == ID_Actualizado)
			Escribir registro actualizado en Temporal
			Leer registro Actualizado
			Leer registro Alumnos
		En otro caso /*puesto que solo contemplamos el caso de actualizaciones, damos por hecho de que 
						lo que se est� realizando es una copia del maestro al maestro actualizado*/
/*
			Mientras (ID_Actualizado >ID_Alumnos)
				Escribir registro de Alumnos en Actualizado
				Leer registro de Alumnos
			fin_Mientras
		Fin_si
	fin_mientras
	Mientras(no FF de Alumnos)
		leer fin de fichero Alumno
		Leer registro de Alumnos
		Escribir registro de Alumnos en Temporal
	Fin mientras
fin
*/
package hogwartsMalDise;

import java.io.*;

public class ActualizaFichero {
	/* 
	 * Interfaz 
	 * Cabecera: Alumno leeAlumno(DataInputStream leer) throws IOException
	 * Proceso:m�todo que lee un alumno de un fichero, y lo devuelve como tal
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
			a = new Alumno(id,nombre, apellido, nota);
		} catch (IOException e) {
			
		}
		return a;
	}
	public static void main(String[] args) {
		// Declaraci�n de objetos y otras variables de inter�s
		Alumno viejo,actual;
		int eofAlumno=1,eofActualizado=1;
		File Maestro = new File("src\\hogwartsFichero\\Alumnos.dat");
		FileInputStream alumno;
		DataInputStream alumnoIn = null;
		BufferedInputStream bufferAlumno,bufferActualizado;
		File Movimiento = new File("src\\hogwartsFichero\\Alumnos_act.dat");
		FileInputStream actualizado;
		DataInputStream actualizadoIn = null;
		EscribeBinario temporal = null;
		try {
			// abrirAlumnosLeer (Alumnos)
			alumno = new FileInputStream(Maestro);
			bufferAlumno=new BufferedInputStream(alumno);
			alumnoIn = new DataInputStream(bufferAlumno);
			
			// abrirAlumnos_actLeer (Actualizado)
			actualizado = new FileInputStream(Movimiento);
			bufferActualizado=new BufferedInputStream(actualizado);
			actualizadoIn = new DataInputStream(bufferActualizado);

			// abrirAlumnos_tempEscribir (Temporal)
			temporal=new EscribeBinario("Alumnos_temp",true);
			
			// leer registro Alumnos
			viejo=leeAlumno(alumnoIn);
			
			// leer registro Actualizado
			actual=leeAlumno(actualizadoIn);
			
			// mientras (no FF de Actualizado y no FF de Alumnos)
			while (eofAlumno!=-1 && eofActualizado!=-1 ){
				//leer fin de fichero Alumnos
				bufferAlumno.mark(10);
				eofAlumno=alumnoIn.read();
				bufferAlumno.reset();
				
				//leer fin de fichero Actualizado
				bufferActualizado.mark(10);
				eofActualizado=actualizadoIn.read();
				bufferActualizado.reset();
				
				
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
			while(eofAlumno!=-1){
				//leer fin de fichero Alumnos
				bufferAlumno.mark(10);
				eofAlumno=alumnoIn.read();
				bufferAlumno.reset();
				
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
			temporal.cierra();
			File maestroActualizado=new File("src\\hogwartsFichero\\Alumnos_temp.dat");
			Maestro.delete();
			boolean renombrado=maestroActualizado.renameTo(Maestro);
			Movimiento.delete();
			System.out.println(renombrado);
		}
	}
}
