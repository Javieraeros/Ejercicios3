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
		//util.muestraAlumnos("hogwartsBueno\\testHogwartsNuevo\\testAlumno.txt");
		/*Date fecha=new Date();
		System.out.println("fecha incio escritura en fichero texto: "+fecha);
		for(int i=0;i<10000;i++){
			yo=new Alumno("Javi","Ruiz",9.235465112);
			util.escribeAlumno("hogwartsBueno\\testHogwartsNuevo\\testAlumno.txt", yo);
		}
		fecha=new Date();
		System.out.println("fecha fin escritura en fichero texto: "+fecha);
		fecha=new Date();
		System.out.println("fecha incio escritura en fichero binario: "+fecha);
		for(int i=0;i<10000;i++){
			a=new Alumno("Javi","Ruiz",9.235465112);
			util.escribeAlumnoBinario("hogwartsBueno\\testHogwartsNuevo\\Alumnos.dat", a);
		}
		fecha=new Date();
		System.out.println("fecha fin escritura en fichero binario: "+fecha);
		//util.muestraAlumnoBinario("hogwartsBueno\\testHogwartsNuevo\\Alumnos.dat");*/
		//System.out.println(util.convierteAlumno("hogwartsBueno\\testHogwartsNuevo\\testAlumno.txt", 275216).cadena());
		//util.muestraAlumnoBinario("hogwartsBueno\\testHogwartsNuevo\\Alumnos.dat");
		
		
		/*a=new Alumno("Mariano","Sánchez",8.20);
		try {
			FileOutputStream out=new FileOutputStream("hogwartsBueno\\testHogwartsNuevo\\AlumnoObjeto.dat",true);
			ObjectOutputStream fichero=new ObjectOutputStream(out);
			fichero.writeObject(a);
		} catch (IOException e) {
			System.out.println(e);
		}*/
		
		
		//a=new Alumno("Mariano","S�nchez",8.20);
		//util.escribeObjetoAlumno("hogwartsBueno\\testHogwartsNuevo\\AlumnoObjeto.dat", a);
		//util.muestraObjetosAlumno("hogwartsBueno\\testHogwartsNuevo\\AlumnoObjeto.dat");
		
		
		/*a=new Alumno("Pedro","Rajoy",8.20);
		util.escribeAlumnoDirecto("hogwartsBueno\\testHogwartsNuevo\\AlumnoDirecto.dat", a);
		util.muestraAlumnoDirecto("hogwartsBueno\\testHogwartsNuevo\\AlumnoDirecto.dat");*/
		//a=util.buscaAlumnoDirecto("hogwartsBueno\\testHogwartsNuevo\\AlumnoDirecto.dat", 60);
		//System.out.println(a.cadena());
	}

}
