/* ***********
* Propiedades
* ***********
* Basicas: 
* 1 fichero consultable y modificable
* 
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
* FileWriter getFichero();
* 
* 
* Modificadores:
* void setFichero(FileWriter fichero);
* 
* M�todos a�adidos:
* void escribe(String info);
* void cierraFichero();
* 
* M�todos Sobreescritos:
* boolean equals(Object o);
* XXXXX clone();
* String toString();
* int hashCode();
* int compareTo(XXXX comparada);
*/

package hogwartsMalDiseñado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribeFichero {
	//atributos
	private FileWriter fichero;
	private BufferedWriter BW;
	
	//Constructores
	public EscribeFichero(){
		try {
			this.fichero=new FileWriter("defecto.log",true);
			BW=new BufferedWriter(fichero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EscribeFichero(String nombre,boolean sobreescribe){
		try {
			this.fichero=new FileWriter(nombre,sobreescribe);
			BW=new BufferedWriter(fichero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Consultores
	public FileWriter getFichero(){
		return this.fichero;
	}
	
	//Modificadores
	public void setFichero(FileWriter nombre){
		this.fichero=nombre;
		BW=new BufferedWriter(fichero);
	}
	//M�todos a�adidos
	public void escribe(String info){
		try {
			BW.write(info+"\r\n");
			BW.flush();   //Uso flush para asegurarme que se escribe le fichero aunque no se cierre
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cierraFichero(){
		try {
			BW.close();
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
