package crea;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class creaArchivo {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		String nombreFichero;
		String dato;
		char centinela='s';
		System.out.println("Introduce el nombre del fichero");
		nombreFichero=teclado.next();
		try (FileWriter fichero=new FileWriter(nombreFichero+".txt",true)){//Permite concatenar el fichero sin machacarlo
			do{
				System.out.println("Introduce un dato");
				dato=teclado.next();
				fichero.write("\r\n"+dato);
				System.out.println("Introduce n para acabar de introducir datos");
				centinela=teclado.next().charAt(0);
			}while(centinela!='n');
			teclado.close();
		} catch (IOException e) {
			System.out.println("Fichero no creado");
		}
	}

}
