/* ***********
 * Propiedades
 * ***********
 * Basicas:
 * Nombre cadena, consultable y modificable
 * Apellidos cadena,consultable y modificable
 * Nota real,consulotable y modificable

 * Derivadas:
 * 
 * 
 * Compartidas:

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
 * 
 * Modificadores:
 * void setNombre(String nombre)
 * void setApellidos(String apellidos)
 * void setNota(double Nota)
 * 
 * Métodos añadidos:
 * 
 * 
 * 
 * *********************
 * Métodos Sobreescritos
 * *********************
 * boolean equals(Object o);
 * Alumno clone();
 * String toString();
 * int hashCode();
 * int compareTo(Alumno comparado);
 */
package hogwartsFichero;
import java.io.*;
import java.lang.annotation.*;
public class Alumno implements Cloneable,Comparable<Alumno>{
	//Atributos
	private String nombre;
	private String apellidos;
	private double nota;
	
	//Constructores
	public Alumno(){
		nombre="Harry";
		apellidos="Potter";
		nota=5;
		EscribeBinario listado=new EscribeBinario("Alumnos",true);
		listado.escribe(this);
		listado.cierra();
		try {
			FileWriter fichero = new FileWriter("src\\hogwartsFichero\\AlumnosCadenas.txt",true);
			BufferedWriter out=new BufferedWriter(fichero);
			out.write(this.cadena()+"\r\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Alumno(String nombre,String apellidos,double nota)throws IllegalArgumentException{
		if (nota<0){
			throw new IllegalArgumentException("Error, la nota no puede ser menor que 0. Alumno no creado");
		}else{
			this.nombre=nombre;
			this.apellidos=apellidos;
			this.nota=nota;
			EscribeBinario listado=new EscribeBinario("Alumnos",true);
			listado.escribe(this);
			listado.cierra();
			try {
				FileWriter fichero = new FileWriter("src\\hogwartsFichero\\AlumnosCadenas.txt",true);
				BufferedWriter out=new BufferedWriter(fichero);
				out.write(this.cadena()+"\r\n");
				out.close();
				fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Consultores
	public String getNombre(){
		return this.nombre;
	}
	
	public String getApellidos(){
		return this.apellidos;
	}
	
	public double getNota(){
		return this.nota;
	}
	
	
	//Modificadores
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
	}
	
	public void setNota(double nota)throws IllegalArgumentException{
		if (nota<0){
			throw new IllegalArgumentException("Error, la nota no puede ser menor que 0. Alumno no creado");
		}else{
			this.nota=nota;
		}
	}
	public String cadena(){
		return (this.hashCode()+" "+nombre+" "+apellidos+" "+nota);
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: boolean equals(Object o)
	 * Proceso: Método que devuelve si un objeto es IGUAL a otro
	 * Precondiciones:Ninguna
	 * Entrada:1 objeto
	 * Salida: 1 booleano
	 * Entrada/Salida:Nada
	 * Postcondiciones:Booleano asociado al nombre, true si los objetos son iguales, false en caso contrario
	 */
	 
	@Override
	public boolean equals(Object o){
		boolean resul=false;
		if (o!=null && o instanceof Alumno){
			Alumno a=(Alumno) o;
			resul=(a.getNombre()==this.nombre && a.getApellidos()==this.apellidos && a.getNota()==this.nota);
		}
		return resul;
	}
	
	@Override
	public Alumno clone(){
		Alumno clonado=null;
		try{
			clonado=(Alumno) super.clone();
		}catch(CloneNotSupportedException error){
			System.out.println("Error,Alumno no clonado");
		}
		return clonado;
	}
	
	@Override
	public String toString(){
		return ("Nombre: "+nombre+" Apellidos: "+apellidos+" Nota: "+nota);
	}
	
	@Override
	public int hashCode(){
		return ((int) (nombre.hashCode()+apellidos.hashCode()+100*nota));
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: int compareTo(Alumno comparado)
	 * Proceso Método que compara si un dos Alumnos son IGUALES
	 * Precondiciones:Nada
	 * Entrada:1 Alumno
	 * Salida:1 Entero
	 * Entrada/Salida:Nada
	 * Postcondiciones:Devuelve 1 si el Alumno que usa el método es mayor que el Alumno que paso por parametro
	 * 0 si son iguales, -1 en caso contrario. Un Alumno es mayor que otro si la primera, segunda o sucesivas letras de su apellido
	 * son anteriores a las letras de otro Alumno. En caso de que tengan el mismo apellido,se comparan por nombre
	 */
	 
	 
	@Override
	public int compareTo(Alumno comparado){
		int resul=0;
		int tamanyo;
		if (this.apellidos.length()<comparado.getApellidos().length()){
			tamanyo=this.apellidos.length();							//No es necesario el -1 porque en el for pongo < y NO <=
		}else{
			tamanyo=comparado.getApellidos().length();               
		}
		//for(int i=0;i<tamanyo || resul!=0;i++){}
		//Muuuuuuuuuy maaaaaaaaaaaaal Javié!
		for(int i=0;i<tamanyo && resul==0;i++){
			char n=apellidos.charAt(i);
			char c=comparado.getApellidos().charAt(i);
			if(n>c){
				resul=-1;
			}else{
				if(n<c){
					resul=1;
				}
			}
		}
		
		if(resul==0){
			if (this.nombre.length()<comparado.getNombre().length()){
				tamanyo=this.nombre.length();							
			}else{
				tamanyo=comparado.getNombre().length();               
			}
			for(int i=0;i<tamanyo && resul==0;i++){
				char n=nombre.charAt(i);
				char c=comparado.getNombre().charAt(i);
				if(n>c){
					resul=-1;
				}else{
					if(n<c){
						resul=1;
					}
				}
			}
		}
		return resul;
	}
}

