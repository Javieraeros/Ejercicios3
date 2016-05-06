/* Clase gestionadora para el ejercicio de Hogwarts
 * 
 */
package hogwartsMalDise;
import java.util.Vector;
import java.util.Scanner;
public class EstudiosMuggles {
	/* 
	 * Interfaz 
	 * Cabecera: void cargaAlumnos (Alumnos cargar)
	 * Proceso: Método que carga una clase Alumnos con Alumno y notas aleatorias de 0 a 10
	 * Precondiciones:Ninguna, aunque hay que tener en cuenta que se borrará todo lo que contenga dicha clase
	 * Entrada:1 entero
	 * Salida:Nada
	 * Entrada/Salida:Una objeto tipo Alumnos
	 * Postcondiciones:Se devuelve Clase por referencia.
	 */
	
	//Resguardo
	/*public static void cargaAlumnos (Alumnos cargar){
		System.out.println("En construcción :D");
	}*/
	
	public static void cargaAlumnos (Alumnos cargar){
		int capacidad,i,indiceNombre,indiceApellido;
		double nota;
		capacidad=cargar.getAlumnos().capacity();
		Vector<Alumno> cargado=new Vector<Alumno>();
		for(i=0;i<capacidad;i++){
			indiceNombre=(int) (Math.random()*NombresEstudiantesHogwarts.values().length); //Muy importante los parentesis recogiendo todo!!
			indiceApellido=(int) (Math.random()*ApellidosEstudiantesHogwarts.values().length);
			NombresEstudiantesHogwarts nombre=NombresEstudiantesHogwarts.values()[indiceNombre];
			ApellidosEstudiantesHogwarts apellido=ApellidosEstudiantesHogwarts.values()[indiceApellido];
			nota=Math.floor(Math.random()*1000)/100.0;
			Alumno alumnoAleatorio=new Alumno(nombre.name(),apellido.name(),nota);
			cargado.add(i,alumnoAleatorio);
		}
		cargar.setAlumnos(cargado);
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: void pintarNotasRelativas(Alumnos c)throws IllegalArgumentException
	 * Proceso:Método que pinta en pantalla
	 * Precondiciones:objeto Alumnos con al menos 1 alumno
	 * Entrada:un objeto Alumnos
	 * Salida:Nada, pinta en pantalla
	 * Entrada/Salida:No
	 * Postcondiciones:Pintará en pantalla tantos * como alumnos haya con las diferentes calificaciones escritas, a saber:
	 * 						-Sobresaliente
	 * 						-Notable
	 * 						-Aprobado
	 * 						-Insuficiente
	 * 						-Muy deficiente
	 * Soltará una excepción en caso de que la clase no tenga al menos 1 alumno o la media o desviación sea menor que 0
	 */
	
	//Resguardo
	/*public static void pintarNotasRelativas(Alumnos c)throws IllegalArgumentException{
		System.out.println("En construcción,peicha");
	}*/
	
	
	/* MUY IMPORTANTE PONER LOS NUMEROS.00 PORQUE SINO JAVA HACE LA DIVISIÓN ENTERA!!!!!!!!
	 * 
	 * 
	 */
	public static void pintarNotasRelativas(Alumnos c)throws IllegalArgumentException{
		if (c.getNumAlumnos()>=1){
			int SS=0,NT=0,AP=0,IS=0,MD=0;
			int i;
			double nota=0,media,desviacion;
			UtilidadesAlumnos uc=new UtilidadesAlumnos();
			media=uc.calcularMedia(c);
			desviacion=uc.calcularDesviacionTipica(c);
			if (media>=0 && desviacion>=0){
				for(i=0;i<c.getNumAlumnos();i++){
					nota=c.getAlumnos().elementAt(i).getNota();
					if(nota<media-3.00/2.00*desviacion){
						MD++;
					}else{
						if(nota<media-desviacion/2.00){
							IS++;
						}else{
							if(nota<media+desviacion/2.00){
								AP++;
							}else{
								if(nota<media+3.00/2.00*desviacion){
									NT++;
								}else{
									SS++;
								}
							}
						}
					}
				}//Fin para
				
				//Pintamos los sobresalientes
				System.out.print("SS");
				pintaNota(SS);
				//Pintamos los notables
				System.out.print("NT");
				pintaNota(NT);
				//Pintamos los aprobados
				System.out.print("AP");
				pintaNota(AP);
				//Pintamos los insuficientes
				System.out.print("IS");
				pintaNota(IS);
				//Pintamos los muy deficientes
				System.out.print("MD");
				pintaNota(MD);
			}else{
				throw new IllegalArgumentException ("Error, la media o la desviación no puede ser menor que 0");
			}
		}else{
			throw new IllegalArgumentException ("Error, la clase debe contener al menos un alumno");
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: void pintaNota(int pintar) throws IllegalArgumentException
	 * Proceso:pinta tantos asteriscos como pintar diga
	 * Precondiciones:pintar>=0
	 * Entrada:1 entero
	 * Salida:nada, pinta en pantalla
	 * Entrada/Salida:Nada
	 * Postcondiciones:Pinta en pantalla, soltará una excepcion si pintar es menor que 0
	 */
	
	public static void pintaNota(int pintar)throws IllegalArgumentException{
		if(pintar>=0){
			for(int i=0;i<pintar;i++){
				System.out.print("*");
			}
			System.out.println();
		}else{
			throw new IllegalArgumentException("Error, el número de * a pintarn o peude ser menor que 0");
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: void aniadeAlumno(Alumnos c,Alumno a)
	 * Proceso:
	 * Precondiciones:Niguna
	 * Entrada:Un tipo Alumno
	 * Salida:Nada
	 * Entrada/Salida:Objeto tipo Alumnos
	 * Postcondiciones:Alumnos c por referencia
	 */
	
	//Resguardo
	/*public static void aniadeAlumno(Alumnos c){
		System.out.println("Trabajando...");
	}*/
	
	public static void aniadeAlumno(Alumnos c,Alumno a){
		/*Scanner teclado=new Scanner(System.in);
		String nombre,apellido;
		double nota;
		boolean nombreValido,apellidoValido;
		do{
			System.out.println("Introduce el nombre");
			nombre=teclado.next();
			nombreValido=cadenaLetras(nombre);
		}
		while(nombreValido==false);
		do{
			System.out.println("Introduce el apellido");
			apellido=teclado.next();
			apellidoValido=cadenaLetras(apellido);
		}
		while(apellidoValido==false);
		do{
			System.out.println("Introduce la nota");
			nota=teclado.nextDouble();
		}
		while(nota<0);
		Alumno nuevo=new Alumno(nombre,apellido,nota);*/
		//c.getAlumnos().addElement(nuevo);     //No es lo correcto para la metodología orientada a objetos!!!
		Vector<Alumno> aniadido=(Vector <Alumno>) c.getAlumnos().clone();
		aniadido.addElement(a);
		c.setAlumnos(aniadido);
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: boolean cadenaLetras(String cadena);	 
	 * Proceso: método que comrpueba si una cadena está compuesta únicamente por letras
	 * Precondiciones:Ninguna
	 * Entrada:1 cadena
	 * Salida:1 booleano
	 * Entrada/Salida:nada
	 * Postcondiciones:booleano asociado al nombre
	 */
	//resguardo
	/*public static boolean cadenaLetras(String cadena){
		return true;
	}*/
	
	
	public static boolean cadenaLetras(String cadena){
		char[] comprueba;
		comprueba=cadena.toCharArray();
		boolean resul=true;
		for(int i=0;i<comprueba.length;i++){
			if(!Character.isLetter(comprueba[i])){
				resul=false;
			}
		}
		return resul;
	}
	/* 
	 * Interfaz 
	 * Cabecera: void muestraNotaRelativaAlumno(int indice,Alumnos c)throws IllegalArgumentException
	 * Proceso:pinta en pantalla al Alumno y su nota relativa con respecto a la clase de Alumnos
	 * Precondiciones:indice mayor que 0 y menor que el tamño del vecetor Alumno
	 * Entrada:1 entero y un objeto de tipo Alumnos
	 * Salida:Nada,pinta en pantalla
	 * Entrada/Salida:Nada
	 * Postcondiciones:Nada,pinta en pantalla
	 */
	 
	//Resguardo
	/*public static void mustraNotaRelativaAlumno(int indice,Alumnos c)throws IllegalArgumentException{
		System.out.println("En construccion");
	}*/
	
	public static void muestraNotaRelativaAlumno(int indice,Alumnos c)throws IllegalArgumentException{
		if (indice<0 || indice>c.getNumAlumnos()){
			throw new IllegalArgumentException("El alumno no existe");
		}else{
			double media,desviacion,nota;
			UtilidadesAlumnos ua=new UtilidadesAlumnos();
			media=ua.calcularMedia(c);
			desviacion=ua.calcularDesviacionTipica(c);
			nota=c.getAlumnos().get(indice).getNota();
			System.out.println(c.getAlumnos().get(indice));
			if(nota<media-3.00/2.00*desviacion){
				System.out.println("Muy deficiente");
			}else{
				if(nota<media-desviacion/2.00){
					System.out.println("Insuficiente");
				}else{
					if(nota<media+desviacion/2.00){
						System.out.println("Aprobado");
					}else{
						if(nota<media+3.00/2.00*desviacion){
							System.out.println("Notable");
						}else{
							System.out.println("Sobresaliente");
						}
					}
				}
			}
		}
	}

	/* 
	 * cabecera: nada eliminarAlumno(Alumnos c, Alumno a)
	 * comentario: el método elimina un Alumnos de Alumnos
	 * precondiciones: nada
	 * entrada: nada
	 * salida: nada
	 * entrada/salida: un Alumnos
	 * postcondiciones: Alumnos por referencia
	 */
	public static void eliminarAlumno(Alumnos c, Alumno a)
	{
		UtilidadesAlumnos ua = new UtilidadesAlumnos();
		Vector<Alumno> resultante=(Vector <Alumno>) c.getAlumnos().clone();
		if(ua.buscarAlumno(c,a)!=-1){
			resultante.removeElementAt(ua.buscarAlumno(c,a));
		}else {
			System.out.println("El alumno no ha sido eliminado");
		}
		c.setAlumnos(resultante);
	}
}
