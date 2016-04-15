/* ***********
 * Propiedades
 * ***********
 * Basicas:
 * 1 FileOutputStream consultable y modificable
 * 1 DataOutputStream
 * 
 * Derivadas:
 * 
 * 
 * Compartidas:
 *  
 * 
 * 
 * Restricciones:
 * 
 * 
 * 
 * ********
 * Interfaz
 * ********
 * Consultores:
 * FileOutputStream getFichero();
 * 
 * Modificadores:
 * void setFichero(FileOutputStream fichero);
 * void cambiaNombre(String nombre);
 * 
 * Añadidos:
 * escribe();
 * cierra();
 */
 
package hogwartsFichero;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribeBinario {
	//Atributos
	FileOutputStream fichero;
	DataOutputStream out;
	
	//Constructores
	public EscribeBinario(){
		try{
			fichero=new FileOutputStream("\\src\\hogwartsFichero\\defecto.dat",true);
			out=new DataOutputStream(fichero);
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public EscribeBinario(String nombre,boolean sobreescritura){
		try{
			fichero=new FileOutputStream("src\\hogwartsFichero\\"+nombre+".dat", sobreescritura);
			out=new DataOutputStream(fichero);
		}catch(IOException e){
			System.out.println(e);
		}
	}
	//Consultores
	public FileOutputStream getFichero(){
		return fichero;
	}
	
	//Modificadores
	public void setFichero(FileOutputStream fichero){
		this.fichero=fichero;
		out=new DataOutputStream(fichero);
	}
	public void cambiaNombre(String nombre){
		//Recuerda modificarlo para que vuelque los datos de un fichero en el otro
		try {
			fichero=new FileOutputStream(nombre+".dat");
			out=new DataOutputStream(fichero);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	//Añadidos
	public void escribe(Alumno a){
		try {
			out.writeInt(a.hashCode());
			out.writeInt(a.getNombre().length());
			out.writeChars(a.getNombre());
			out.writeInt(a.getApellidos().length());
			out.writeChars(a.getApellidos());
			out.writeDouble(a.getNota());
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	public void cierra(){
		try {
			out.close();
			fichero.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
}
