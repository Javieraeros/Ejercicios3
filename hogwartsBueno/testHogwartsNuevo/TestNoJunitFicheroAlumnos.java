package testHogwartsNuevo;

import hogwartsNuevo.Alumno;
import hogwartsNuevo.FicheroAlumno;

import java.util.Date;


public class TestNoJunitFicheroAlumnos {

	public static void main(String[] args) {
		FicheroAlumno util = new FicheroAlumno();
		Alumno yo,a;
		//util.muestraAlumnos("hogwartsBueno\\testHogwartsNuevo\\test.txt");
		Date fecha=new Date();
		System.out.println("fecha incio escritura en fichero texto: "+fecha);
		for(int i=0;i<5000;i++){
			yo=new Alumno("Javier","Ruiz",0);
			util.escribeAlumno("hogwartsBueno\\testHogwartsNuevo\\testAlumno.txt", yo);
		}
		fecha=new Date();
		System.out.println("fecha fin escritura en fichero texto: "+fecha);
		fecha=new Date();
		System.out.println("fecha incio escritura en fichero binario: "+fecha);
		for(int i=0;i<5000;i++){
			a=new Alumno("Javi","Ruiz",0);
			util.escribeAlumnoBinario("hogwartsBueno\\testHogwartsNuevo\\Alumnos.dat", a);
		}
		fecha=new Date();
		System.out.println("fecha fin escritura en fichero binario: "+fecha);
		//util.muestraAlumnoBinario("hogwartsBueno\\testHogwartsNuevo\\Alumnos.dat");
		/*Terminar de hacer pruebas!!*/
	}

}
