package testHogwartsNuevo;

import hogwartsNuevo.Alumno;
import hogwartsNuevo.FicheroAlumno;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Date;


public class TestNoJunitFicheroAlumnos {

	public static void main(String[] args) {
		FicheroAlumno util = new FicheroAlumno();
		Alumno yo,a;
		//util.muestraAlumnos("hogwartsBueno//testHogwartsNuevo//testAlumno.txt");
		/*Date fecha=new Date();
		System.out.println("fecha incio escritura en fichero texto: "+fecha);
		for(int i=0;i<10000;i++){
			yo=new Alumno("Javi","Ruiz",9.235465112);
			util.escribeAlumno("hogwartsBueno//testHogwartsNuevo//testAlumno.txt", yo);
		}
		fecha=new Date();
		System.out.println("fecha fin escritura en fichero texto: "+fecha);
		fecha=new Date();
		System.out.println("fecha incio escritura en fichero binario: "+fecha);
		for(int i=0;i<10000;i++){
			a=new Alumno("Javi","Ruiz",9.235465112);
			util.escribeAlumnoBinario("hogwartsBueno//testHogwartsNuevo//Alumnos.dat", a);
		}
		fecha=new Date();
		System.out.println("fecha fin escritura en fichero binario: "+fecha);
		//util.muestraAlumnoBinario("hogwartsBueno//testHogwartsNuevo//Alumnos.dat");*/
		//System.out.println(util.convierteAlumno("hogwartsBueno//testHogwartsNuevo//testAlumno.txt", 275216).cadena());
		//util.muestraAlumnoBinario("hogwartsBueno//testHogwartsNuevo//Alumnos.dat");
		
		
		/*a=new Alumno("Mariano","Sánchez",8.20);
		try {
			FileOutputStream out=new FileOutputStream("hogwartsBueno//testHogwartsNuevo//AlumnoObjeto.dat",true);
			ObjectOutputStream fichero=new ObjectOutputStream(out);
			fichero.writeObject(a);
		} catch (IOException e) {
			System.out.println(e);
		}*/
		
		
		//a=new Alumno("Mariano","S�nchez",8.20);
		//util.escribeObjetoAlumno("hogwartsBueno//testHogwartsNuevo//AlumnoObjeto.dat", a);
		//util.muestraObjetosAlumno("hogwartsBueno//testHogwartsNuevo//AlumnoObjeto.dat");
		
		
		/*a=new Alumno(640,"Pedro","Rajoy",8.20);
		util.escribeAlumnoDirecto("hogwartsBueno//testHogwartsNuevo//AlumnoDirecto.dat", a);
		util.muestraAlumnoDirecto("hogwartsBueno//testHogwartsNuevo//AlumnoDirecto.dat");*/
		//a=util.buscaAlumnoDirecto("hogwartsBueno//testHogwartsNuevo//AlumnoDirecto.dat", 60);
		//System.out.println(a.cadena());
		
		
		//Creo el fichero 1 vez con OOS
		/*FileOutputStream ficheroPartir;
		ObjectOutputStream fichero;
		try {
			ficheroPartir = new FileOutputStream("hogwartsBueno//testHogwartsNuevo//pruebaPartir.dat");
			fichero=new ObjectOutputStream(ficheroPartir);
			ficheroPartir = new FileOutputStream("hogwartsBueno//testHogwartsNuevo//particion1.dat");
			fichero=new ObjectOutputStream(ficheroPartir);
			ficheroPartir = new FileOutputStream("hogwartsBueno//testHogwartsNuevo//particion2.dat");
			fichero=new ObjectOutputStream(ficheroPartir);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		for(int i=0;i<40;i++){
			a=new Alumno((int) (Math.random()*1000),"Antonio","Jimenez",5.32+i/13.00);
			util.escribeObjetoAlumno("hogwartsBueno//testHogwartsNuevo//pruebaPartir.dat", a);
		}
		util.parteFicheroSecuencias("hogwartsBueno//testHogwartsNuevo//pruebaPartir.dat", 
				"hogwartsBueno//testHogwartsNuevo//particion1.dat", 
				"hogwartsBueno//testHogwartsNuevo//particion2.dat", 4);
		util.muestraObjetosAlumno("hogwartsBueno//testHogwartsNuevo//pruebaPartir.dat");
		System.out.println("\r\n");
		System.out.println("\r\n");
		util.muestraObjetosAlumno("hogwartsBueno//testHogwartsNuevo//particion1.dat");
		System.out.println("\r\n");
		System.out.println("\r\n");
		util.muestraObjetosAlumno("hogwartsBueno//testHogwartsNuevo//particion2.dat");
		System.out.println(util.cuentaRegistroObjeto("hogwartsBueno//testHogwartsNuevo//particion1.dat")+" "+
				util.cuentaRegistroObjeto("hogwartsBueno//testHogwartsNuevo//particion1.dat"));*/
		
		
		/*FileOutputStream ficheroPartir;
		ObjectOutputStream fichero;
		//Creamos los ficheros
		try {
			ficheroPartir = new FileOutputStream("hogwartsBueno//testHogwartsNuevo//pruebaPartir.dat");
			fichero=new ObjectOutputStream(ficheroPartir);
			ficheroPartir = new FileOutputStream("hogwartsBueno//testHogwartsNuevo//particion1.dat");
			fichero=new ObjectOutputStream(ficheroPartir);
			ficheroPartir = new FileOutputStream("hogwartsBueno//testHogwartsNuevo//particion2.dat");
			fichero=new ObjectOutputStream(ficheroPartir);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		//Introducimos Alumnos
		for(int i=0;i<40;i++){
			a=new Alumno((int) (Math.random()*1000),"Antonio","Jimenez",5.32+i/13.00);
			util.escribeObjetoAlumno("hogwartsBueno//testHogwartsNuevo//pruebaPartir.dat", a);
		}
		
		util.muestraObjetosAlumno("hogwartsBueno//testHogwartsNuevo//pruebaPartir.dat");
		//ordenamos
		for(int i=1;i<40;i=i*2){
			util.parteFicheroSecuencias("hogwartsBueno//testHogwartsNuevo//pruebaPartir.dat", 
					"hogwartsBueno//testHogwartsNuevo//particion1.dat", 
					"hogwartsBueno//testHogwartsNuevo//particion2.dat", i);
			try {
				ficheroPartir = new FileOutputStream("hogwartsBueno//testHogwartsNuevo//pruebaPartir.dat");
				fichero=new ObjectOutputStream(ficheroPartir);
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
			util.mezclaFicheroSecuencia("hogwartsBueno//testHogwartsNuevo//pruebaPartir.dat", 
					"hogwartsBueno//testHogwartsNuevo//particion1.dat", 
				"hogwartsBueno//testHogwartsNuevo//particion2.dat", i);
			try {
				ficheroPartir = new FileOutputStream("hogwartsBueno//testHogwartsNuevo//particion1.dat");
				fichero=new ObjectOutputStream(ficheroPartir);
				ficheroPartir = new FileOutputStream("hogwartsBueno//testHogwartsNuevo//particion2.dat");
				fichero=new ObjectOutputStream(ficheroPartir);
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		System.out.println("");
		System.out.println("");
		util.muestraObjetosAlumno("hogwartsBueno//testHogwartsNuevo//pruebaPartir.dat");*/
		
		
		
		//Creo el fichero 1 vez con OOS
		FileOutputStream ficheroOrdenar=null;
		ObjectOutputStream fichero=null;
		try {
			ficheroOrdenar = new FileOutputStream("hogwartsBueno//testHogwartsNuevo//pruebaOrdenar.dat");
			fichero=new ObjectOutputStream(ficheroOrdenar);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			if(fichero!=null){
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(ficheroOrdenar!=null){
				try {
					ficheroOrdenar.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
				
				
		for(int i=0;i<40;i++){
			a=new Alumno((int) (Math.random()*1000),"Antonio","Jimenez",5.32+i/13.00);
			util.escribeObjetoAlumno("hogwartsBueno//testHogwartsNuevo//pruebaOrdenar.dat", a);
		}
		util.muestraObjetosAlumno("hogwartsBueno//testHogwartsNuevo//pruebaOrdenar.dat");
		System.out.println("Ordenando...");
		System.out.println("Ordenando...");
		System.out.println("Ordenando...");
		System.out.println("Ordenando...");
		util.ordenaFicheroObjeto("hogwartsBueno//testHogwartsNuevo//pruebaOrdenar.dat");
		//util.muestraObjetosAlumno("hogwartsBueno//testHogwartsNuevo//pruebaOrdenar.dat");
		
		
		
		
	}

}
