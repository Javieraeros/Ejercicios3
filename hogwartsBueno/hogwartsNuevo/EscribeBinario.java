/* ***********
 * Propiedades
 * ***********
 * Basicas:
 * Archivo tipo file consultable y modificable
 * Fichero tipo FileOutputStream
 * out tipo DataOutputStream
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
 * 
 * Añadidos:
 * void escribe();
 * coid cierra();
 */
 
package hogwartsNuevo;

import java.io.*;

public class EscribeBinario {
	//Atributos
	File archivo;
	FileOutputStream fichero;
	DataOutputStream out;
	
	//Constructores
	public EscribeBinario(){
		try{
			archivo=new File("defecto.txt");
			fichero=new FileOutputStream(archivo,true);
			out=new DataOutputStream(fichero);
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public EscribeBinario(String nombre,boolean sobreescritura){
		try{
			archivo=new File(nombre);
			fichero=new FileOutputStream(archivo, sobreescritura);
			out=new DataOutputStream(fichero);
		}catch(IOException e){
			System.out.println(e);
		}
	}
	//Consultores
	public File getArchivo(){
		return archivo.getAbsoluteFile();
	}
	
	//Modificadores
	public void setArchivo(File nuevo) throws FileNotFoundException{
		this.archivo=nuevo;
		this.fichero=new FileOutputStream(archivo);
		out=new DataOutputStream(fichero);
	}

	//Añadidos
	public void escribe(Alumno a){
		try {
			out.writeInt(a.getID());
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
