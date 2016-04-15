package hogwartsFichero;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class muestraDatHogwarts {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		String nombreFichero;
		int tamanyoNombre,tamanyoApellido;
		System.out.println("Introduce el nombre del fichero: ");
		nombreFichero=teclado.nextLine();
		DataInputStream fichero;
		try {
			fichero = new DataInputStream(new FileInputStream("src\\ejercicios3\\"+nombreFichero+".dat"));
			do{
			tamanyoNombre=fichero.readInt();
			for(int i=0;i<tamanyoNombre;i++){
				System.out.print(fichero.readChar());
			}
			System.out.println();
			tamanyoApellido=fichero.readInt();
			for(int i=0;i<tamanyoApellido;i++){
				System.out.print(fichero.readChar());
			}
			System.out.println();
			System.out.println(fichero.readDouble());
			}while(fichero.available()>0); //Única forma que se me ha ocurrido de leer :/
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
