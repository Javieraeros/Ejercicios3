/* ***********
 * Propiedades
 * ***********
 * Basicas:
 * Nombre cadena, consultable y modificable
 * Apellidos cadena,consultable y modificable
 * Nota real,consultable y modificable
 * ID entero. Se usará para identificar de forma unívoca a un alumno, se tomará del fichero correspondiente,
 * 			el id+1 del último alumno
 * 
 * Derivadas:
 * 
 * 
 * Compartidas:
 * 
 * *************
 * Restricciones
 * *************
 * Nota mayor que 0
 * 
 * ********
 * Interfaz
 * ********
 * Constructores:
 * Alumno()
 * Alumno(String nombre,String apellidos,double nota)
 * 
 * Consultores:
 * String getNombre()
 * String getApellidos()
 * double getNota()
 * int getID()
 * 
 * Modificadores:
 * void setNombre(String nombre)
 * void setApellidos(String apellidos)
 * void setNota(double Nota)
 * 
 * MÃ©todos aÃ±adidos:
 * void tomaID();
 * String cadena()
 * 
 * *********************
 * MÃ©todos Sobreescritos
 * *********************
 * boolean equals(Object o);
 * Alumno clone();
 * String toString();
 * int hashCode();
 * int compareTo(Alumno comparado);
 */
package hogwartsNuevo;

import java.io.*;
import java.lang.annotation.*;

public class Alumno implements Cloneable, Comparable<Alumno>,Serializable {
	
	private static final long serialVersionUID = 1L;
	// Atributos
	private String nombre;
	private String apellidos;
	private double nota;
	private int ID;
	private static int IDTodos = 0;

	// Constructores
	public Alumno() {
		nombre = "Harry";
		apellidos = "Potter";
		nota = 5;
		ID = tomaID();

	}

	public Alumno(String nombre, String apellidos, double nota) throws IllegalArgumentException {
		if (nota < 0) {
			throw new IllegalArgumentException("Error, la nota no puede ser menor que 0. Alumno no creado");
		} else {
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.nota = nota;
			this.ID = tomaID();
		}
	}

	/*Este constructor solo se usará para crear un alumno con un ID fijo,en métodos de lectura
	  de la clase gestionadora de ficheros de Alumnos 
	  */ 
	public Alumno(int ID,String nombre,String apellidos,double nota)throws IllegalArgumentException {
		if (nota < 0) {
			throw new IllegalArgumentException("Error, la nota no puede ser menor que 0. Alumno no creado");
		} else {
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.nota = nota;
			this.ID = ID;
			System.out.println("Se desaconseja el uso de este constructor para crear alumnos");
			System.out.println("si queremos mantener id únicos");
		}
	}
	
	
	// Consultores
	public int getID() {
		return this.ID;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public double getNota() {
		return this.nota;
	}

	// Modificadores
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setNota(double nota) throws IllegalArgumentException {
		if (nota < 0) {
			throw new IllegalArgumentException("Error, la nota no puede ser menor que 0. Alumno no creado");
		} else {
			this.nota = nota;
		}
	}

	// Métodos Añadidos
	public String cadena() {
		return (ID + " " + nombre + " " + apellidos + " " + nota);
	}

	/*
	 * Necesito un ID único e invariable, por eso creo este método
	 * Si usase hashCode, el "ID" cambiaría cada vez qeu cambia cualquiera de
	 * los atributos que use
	 * para gener el hashCode
	 */
	public int tomaID() {
		int id = 1;
		if (IDTodos == 0) {
			try {
				FileInputStream leerID = new FileInputStream("hogwartsBueno\\hogwartsNuevo\\ID.dat");
				DataInputStream in = new DataInputStream(leerID);
				/*
				 * Puesto que sabesmos que, si el fichero existe,solo tiene
				 * escrito un entero,
				 * no hace falta saber si hay algo que leer,ni cuanto hay
				 * puesto que solo habrá un entero.
				 */
				// Leo el ID del archivo y se lo asigno a IDTodos
				id = in.readInt();
				id = id + 1;
				IDTodos = id;

				// Cerramos y escribimos el nuevo ID
				in.close();
				leerID.close();
			} catch (FileNotFoundException e1) {
				System.out.println("Que has hecho que no encuentro el fichero Alumnos.dat??");
				System.out.println("Bueno, no pasa nada, lo vuelvo a crear... PERO QUE NO VUELVA A OCURRIR");
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			id = IDTodos + 1;
			IDTodos++;
		}
		try {
			FileOutputStream escribeID = new FileOutputStream("hogwartsBueno\\hogwartsNuevo\\ID.dat");
			DataOutputStream out = new DataOutputStream(escribeID);
			out.writeInt(id);
			escribeID.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

		return id;
	}
	
	public int tomaIDVieja() {
		int id=1;
		try {
			FileInputStream leerID = new FileInputStream("hogwartsBueno\\hogwartsNuevo\\ID.dat");
			DataInputStream in = new DataInputStream(leerID);
			id=in.readInt();
			id=id+1;
			in.close();
			leerID.close();
		} catch (FileNotFoundException e1) {
			System.out.println("Que has hecho que no encuentro el fichero Alumnos.dat??");
			System.out.println("Bueno, no pasa nada, lo vuelvo a crear... PERO QUE NO VUELVA A OCURRIR");
		} catch (IOException e) {
			System.out.println(e);
		}
		try{
		FileOutputStream escribeID=new FileOutputStream("hogwartsBueno\\hogwartsNuevo\\ID.dat");
		DataOutputStream out=new DataOutputStream(escribeID);
		out.writeInt(id);
		escribeID.close();
		}catch(FileNotFoundException e){
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	
	/*
	 * Interfaz Cabecera: boolean equals(Object o) Proceso: MÃ©todo que devuelve
	 * si un objeto es IGUAL a otro Precondiciones:Ninguna Entrada:1 objeto
	 * Salida: 1 booleano Entrada/Salida:Nada Postcondiciones:Booleano asociado
	 * al nombre, true si los objetos son iguales, false en caso contrario
	 */

	@Override
	public boolean equals(Object o) {
		boolean resul = false;
		if (o != null && o instanceof Alumno) {
			Alumno a = (Alumno) o;
			resul = (a.getNombre().equals(this.nombre)  && a.getApellidos().equals(this.apellidos) && a.getNota() == this.nota);
		}
		return resul;
	}

	@Override
	public Alumno clone() {
		Alumno clonado = null;
		try {
			clonado = (Alumno) super.clone();
		} catch (CloneNotSupportedException error) {
			System.out.println("Error,Alumno no clonado");
		}
		return clonado;
	}

	@Override
	public String toString() {
		return ("Nombre: " + nombre + " Apellidos: " + apellidos + " Nota: " + nota);
	}

	@Override
	public int hashCode() {
		return ((int) (nombre.hashCode() + apellidos.hashCode() + 100 * nota));
	}

	/*
	 * Interfaz Cabecera: int compareTo(Alumno comparado) 
	 * Proceso Metodo que
	 * compara si un dos Alumnos son IGUALES 
	 * Precondiciones:Nada 
	 * Entrada:1 Alumno 
	 * Salida:1 Entero 
	 * Entrada/Salida:Nada 
	 * Postcondiciones:Devuelve 1 si el Alumno que usa el mÃ©todo es mayor que el Alumno que paso por
	 * parametro 0 si son iguales, -1 en caso contrario. Un Alumno es mayor que otro si la primera, segunda o 
	 * sucesivas letras de su apellido son anteriores a las letras de otro Alumno. 
	 * En caso de que tengan el mismo apellido,se comparan por nombre
	 */

	@Override
	public int compareTo(Alumno comparado) {
		int resul = 0;
		int tamanyo;
		if (this.apellidos.length() < comparado.getApellidos().length()) {
			tamanyo = this.apellidos.length(); // No es necesario el -1 porque
												// en el for pongo < y NO <=
		} else {
			tamanyo = comparado.getApellidos().length();
		}
		// for(int i=0;i<tamanyo || resul!=0;i++){}
		// Muuuuuuuuuy maaaaaaaaaaaaal JaviÃ©!
		for (int i = 0; i < tamanyo && resul == 0; i++) {
			char n = apellidos.charAt(i);
			char c = comparado.getApellidos().charAt(i);
			if (n > c) {
				resul = -1;
			} else {
				if (n < c) {
					resul = 1;
				}
			}
		}

		if (resul == 0) {
			if (this.nombre.length() < comparado.getNombre().length()) {
				tamanyo = this.nombre.length();
			} else {
				tamanyo = comparado.getNombre().length();
			}
			for (int i = 0; i < tamanyo && resul == 0; i++) {
				char n = nombre.charAt(i);
				char c = comparado.getNombre().charAt(i);
				if (n > c) {
					resul = -1;
				} else {
					if (n < c) {
						resul = 1;
					}
				}
			}
		}
		return resul;
	}
}
