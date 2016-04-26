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
 * 
 * A�adidos:
 * void escribe();
 * coid cierra();
 */
 
package hogwartsMalDise;

import java.io.*;

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

	//A�adidos
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
	
	public void actualiza(Alumno a)throws IllegalArgumentException{
		int idAlumno,nombre,apellido;
		cierra();
		try{
			FileInputStream ficheroLeer=new FileInputStream("src\\hogwartsFichero\\Alumnos.dat");
			DataInputStream in=new DataInputStream(ficheroLeer);
			fichero=new FileOutputStream("src\\hogwartsFichero\\Alumnos_act.dat");
			out=new DataOutputStream(fichero);
			while(ficheroLeer.available() > 0){
				idAlumno=in.readInt();
				if(idAlumno!=a.hashCode()){
					out.writeInt(idAlumno);
					nombre=in.readInt();
					out.writeInt(nombre);
					for(int i=0;i<nombre;i++){
						out.writeChar(in.readChar());
					}
					apellido=in.readInt();
					out.writeInt(apellido);
					for(int i=0;i<apellido;i++){
						out.writeChar(in.readChar());
					}
					out.writeDouble(in.readDouble());
				}else{
					escribe(a);
				}
			}
			in.close();
			ficheroLeer.close();
			out.close();
			fichero.close();
			
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
}
