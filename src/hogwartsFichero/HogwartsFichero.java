/*
 *                                                           ANALISIS
 * En el siguiente programa, crearemos una clase de Alumnos con un nombre y apellidos, y una nota mayor que 0, la cual podremos generar de 
 * forma aleatoria, dado un número de alumnos mayor que 0, o crear una nostros introduciendo alumnos hasta que queramos parar.
 * Una ve creada la clase con alumnos,se nos ofrecerá la opción de mostrar todos los alumnos de la clse, añadir o quitar alumno, 
 * mostrar la media y/o la desviación, mostrar notas relativas, mostrar la nota relativa de un alumno,volver a crear una nueva clase de alumnos
 * o salir del programa.
 * 
 * 
 * ENTRADAS:
 * 		-2 enteros para las opciones de los menús
 * 		-1 entero para indicar el número de alumnos de una clase generada aleatoriamente
 * 		-1 alumno
 * 		-1 número para eliminar un alumno
 * 		-Variables controladoras de bucle
 * SALIDAS:
 * 		-Nada, pintará en pantalla:
 * 			-El menú cuando sea necesario
 * 			-La media
 * 			-La desviación
 * 			-Notas relativas
 * 			-Clase Alumnos
 */

/*Pseudocódigo generaliado
 * Inicio
 * mostrarMenuInicialLeerValidarOpcion
 * segun opcion
 * 	caso 1:
 * 		crearClaseAleatoria
 * 	caso 2:
 * 		repetir
 * 			IntroducirAlumno
 * 		mientras usuario quiera
 * fin_segun
 * mostarMenuSecundarioLeerValidarOpcion
 * repetir
 * 	segun opcion_2
 * 		caso 1:
 * 			mostrarAlumnos
 * 		caso 2:
 * 			AñadirAlumno
 * 		caso 3:
 * 			QuitarAlumno
 * 		caso 4:
 * 			MostrarMedia
 * 		caso 5:
 * 			MostrarDesviación
 * 		caso 6:
 * 			MostrarNotasRelativas
 * 		caso 7:
 * 			MostrarNotaRelativaAlumno
 * 		caso 8:                          //Crear nueva clase de Alumnos
 * 			mostrarMenuInicialLeerValidarOpcion
 * 			segun opcion
 * 				caso 1:
 * 					crearClaseAleatoria
 * 				caso 2:
 * 					repetir
 * 						IntroducirAlumno
 * 						preguntarsiseguir
 * 					mientras usuario quiera
 * 			fin_segun
 * mientras opcion diferente de 0
 * Fin
 */
package hogwartsFichero;

import java.util.Date;
import java.util.Scanner;

public class HogwartsFichero {
	public static void menuInicial() {
		System.out.println("Introduce el número de la opción:");
		System.out.println("1.Crear una clase de Alumnos aleatoria");
		System.out.println("2.Introducir Alumnos 1 a 1");
		System.out.println("0.Salir");
	}

	public static void menuSecundario() {
		System.out.println("Introduce el número de la opción:");
		System.out.println("1.Mostrar la información de todos los Alumnos");
		System.out.println("2.Añadir Alumno a la Clase");
		System.out.println("3.Quitar Alumno de la Clase");
		System.out.println("4.Mostrar la media de la clase");
		System.out.println("5.Mostrar la Desviación media de la clase");
		System.out.println("6.Mostrar notas relativas de la clase");
		System.out.println("7.Mostrar nota relativa de un alumno");
		System.out.println("8.Crear una nueva clase de Alumnos");
		System.out.println("0.Salir");
	}

	public static void main(String args[]) {
		int opcionMenu = 0, opcionSubMenu = 1, numAlumnos = 1;
		char seguir = 'n';
		boolean nombreValido = false, apellidoValido = false;
		EscribeFichero fichero = new EscribeFichero("src\\hogwartsFichero\\Hogwarts.log",true);
		Scanner teclado = new Scanner(System.in);
		Alumnos alumnos = null;
		Alumno a = null;
		String nombre, apellido;
		double nota = 0.0;
		UtilidadesAlumnos ua = new UtilidadesAlumnos();
		Date fecha = new Date();
		fichero.escribe("Fecha de apertura " + fecha);
		fichero.escribe("********************************************************************");
		// fichero.cierraFichero();//De esta forma me aseguro, que pase lo que
		// pase, siempre se crea un log en el fichero
		// fichero=new EscribeFichero("Hogwarts"); elimino esto porque he
		// añadido el método flush al fichero

		// mostrarMenuInicialLeerValidarOpcion
		do {
			menuInicial();
			System.out.println("Elija una opcion del menu, por favor.");
			opcionMenu = teclado.nextInt();
			fichero.escribe("Opción de menú " + opcionMenu);
		} while (opcionMenu < 0 || opcionMenu > 2);

		switch (opcionMenu) {
		case 1:
			// crearClaseAleatoria
			do {
				System.out.println("¿Cuantos alumnos debe tener la clase?");
				numAlumnos = teclado.nextInt();
				if (numAlumnos < 0) {
					fichero.escribe("El usuario ha introducido un número inválido de alumnos: " + numAlumnos);
				}
			} while (numAlumnos <= 0);
			fichero.escribe("Se ha creado una clase aleatoria con " + numAlumnos + " alumnos");
			alumnos = new Alumnos(numAlumnos);
			EstudiosMuggles.cargaAlumnos(alumnos);
			break;
		case 2:
			alumnos = new Alumnos();
			do {
				// IntroducirAlumno
				System.out.println("Introduzca un nuevo Alumno:");
				do {
					// teclado.nextLine(); //para poder usar nextLine
					System.out.println("Introduce el nombre");
					nombre = teclado.next();
					nombreValido = EstudiosMuggles.cadenaLetras(nombre);
					if (!nombreValido) {
						fichero.escribe("El usuario ha intentado introducir el siguiente nombre inválido: " + nombre);
					}
				} while (!nombreValido);
				do {
					System.out.println("Introduce el apellido");
					apellido = teclado.next();
					apellidoValido = EstudiosMuggles.cadenaLetras(apellido);
					if (!apellidoValido) {
						fichero.escribe("El usuario ha intentado introducir el siguiente nombre inválido: " + apellido);
					}
				} while (apellidoValido == false);
				do {
					System.out.println("Introduce la nota");
					nota = teclado.nextDouble();
					if (nota < 0) {
						fichero.escribe("El usuario ha intentado introducir la siguiente nota no válida: " + nota);
					}
				} while (nota < 0);
				Alumno nuevo = new Alumno(nombre, apellido, nota);
				EstudiosMuggles.aniadeAlumno(alumnos, nuevo);
				fichero.escribe("Se ha introducido el siguiente alumno: " + nombre + " " + apellido + " " + nota);
				System.out.println("¿Desea introducir otro alumno?");
				seguir = teclado.next().charAt(0);
				fichero.escribe(
						"El usuario ha introducido " + seguir + " como respuesta a la pregunta si desea seguir");
			} while (seguir == 's');
			break;
		}
		while (opcionMenu != 0 && opcionSubMenu != 0) {
			ua.ordenarPlomada(alumnos);
			// mostarMenuSecundarioLeerValidarOpcion
			do {
				menuSecundario();
				opcionSubMenu = teclado.nextInt();
				if (opcionSubMenu < 0 || opcionSubMenu > 8)
					fichero.escribe("El usuario ha introducido la opción inválida: " + opcionSubMenu);
			} while (opcionSubMenu < 0 || opcionSubMenu > 8);
			fichero.escribe("El usuario ha introducido la opción válida: " + opcionSubMenu);
			switch (opcionSubMenu) {
			case 1:
				// mostrarAlumnos
				System.out.println(alumnos.toString());
				fichero.escribe("Se ha pintado la clase alumnos");
				break;
			case 2:
				// AñadirAlumno
				do {
					// teclado.nextLine(); //para poder usar nextLine
					System.out.println("Introduce el nombre");
					nombre = teclado.next();
					nombreValido = EstudiosMuggles.cadenaLetras(nombre);
					if (!nombreValido) {
						fichero.escribe("El usuario ha intentado introducir el siguiente nombre inválido: " + nombre);
					}
				} while (!nombreValido);
				do {
					System.out.println("Introduce el apellido");
					apellido = teclado.next();
					apellidoValido = EstudiosMuggles.cadenaLetras(apellido);
					if (!apellidoValido) {
						fichero.escribe("El usuario ha intentado introducir el siguiente nombre inválido: " + apellido);
					}
				} while (apellidoValido == false);
				do {
					System.out.println("Introduce la nota");
					nota = teclado.nextDouble();
					if (nota < 0) {
						fichero.escribe("El usuario ha intentado introducir la siguiente nota no válida: " + nota);
					}
				} while (nota < 0);
				Alumno nuevo = new Alumno(nombre, apellido, nota);
				EstudiosMuggles.aniadeAlumno(alumnos, nuevo);
				fichero.escribe("Se ha introducido el siguiente alumno: " + nombre + " " + apellido + " " + nota);
				break;
			case 3:
				// QuitarAlumno
				System.out.println("¿Que alumno desea eliminar?");
				do {
					// teclado.nextLine(); //para poder usar nextLine
					System.out.println("Introduce el nombre");
					nombre = teclado.next();
					nombreValido = EstudiosMuggles.cadenaLetras(nombre);
					if (!nombreValido) {
						fichero.escribe("El usuario ha intentado introducir el siguiente nombre inválido: " + nombre);
					}
				} while (!nombreValido);
				do {
					System.out.println("Introduce el apellido");
					apellido = teclado.next();
					apellidoValido = EstudiosMuggles.cadenaLetras(apellido);
					if (!apellidoValido) {
						fichero.escribe("El usuario ha intentado introducir el siguiente nombre inválido: " + apellido);
					}
				} while (apellidoValido == false);

				a = new Alumno(nombre, apellido, nota);
				if (ua.buscarAlumno(alumnos, a) == -1) {
					fichero.escribe("No se ha eliminado ningún alumno");
				}else{
					EstudiosMuggles.eliminarAlumno(alumnos, a);
					fichero.escribe("Se ha eliminado el alumno: "+a.toString());
				}
				break;
			case 4:
				// MostrarMedia
				System.out.println("La nota media es: " + ua.calcularMedia(alumnos));
				break;
			case 5:
				// MostrarDesviación
				System.out.println("La desviacion tipica es: " + ua.calcularDesviacionTipica(alumnos));
				break;
			case 6:
				// MostrarNotasRelativas
				EstudiosMuggles.pintarNotasRelativas(alumnos);
				break;
			case 7:
				// MostrarNotaRelativaAlumno
				System.out.println("¿De qué alumno desea ver la nota relativa?");
				do {
					System.out.println("Introduzca el nombre.");
					nombre = teclado.next();
				} while (EstudiosMuggles.cadenaLetras(nombre) == false);
				do {
					System.out.println("Introduzca el apellido.");
					apellido = teclado.next();
				} while (EstudiosMuggles.cadenaLetras(apellido) == false);
				do {
					System.out.println("Introduzca la nota.");
					nota = teclado.nextDouble();
				} while (EstudiosMuggles.cadenaLetras(nombre) == false);
				a = new Alumno(nombre, apellido, nota);
				EstudiosMuggles.muestraNotaRelativaAlumno(ua.buscarAlumno(alumnos, a), alumnos);
				break;
			case 8:
				// mostrarMenuInicialLeerValidarOpcion
				do {
					menuInicial();
					opcionMenu = teclado.nextInt();
				} while (opcionMenu < 0 || opcionMenu > 2);

				switch (opcionMenu) {
				case 1:
					// crearClaseAleatoria
					do {
						System.out.println("¿Cuantos alumnos debe tener la clase?");
						numAlumnos = teclado.nextInt();
					} while (numAlumnos <= 0);

					alumnos = new Alumnos(numAlumnos);
					EstudiosMuggles.cargaAlumnos(alumnos);
					break;
				case 2:
					alumnos = new Alumnos();
					do {
						// IntroducirAlumno
						System.out.println("Introduzca un nuevo Alumno:");
						do {
							System.out.println("Introduce el nombre");
							nombre = teclado.next();
							nombreValido = EstudiosMuggles.cadenaLetras(nombre);
						} while (nombreValido == false);
						do {
							System.out.println("Introduce el apellido");
							apellido = teclado.next();
							apellidoValido = EstudiosMuggles.cadenaLetras(apellido);
						} while (apellidoValido == false);
						do {
							System.out.println("Introduce la nota");
							nota = teclado.nextDouble();
						} while (nota < 0);
						nuevo = new Alumno(nombre, apellido, nota);
						EstudiosMuggles.aniadeAlumno(alumnos, nuevo);
						// preguntarsiseguir
						System.out.println("¿Desea introducir otro alumno?");
						seguir = teclado.next().charAt(0);
					} while (seguir == 's');
					break;
				}
				break;
			}
		}
		fichero.cierraFichero();
	}
}
