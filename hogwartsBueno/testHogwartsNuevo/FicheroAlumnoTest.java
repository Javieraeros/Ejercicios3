package testHogwartsNuevo;

import static org.junit.Assert.*;

import org.junit.Test;

import hogwartsNuevo.Alumno;
import hogwartsNuevo.FicheroAlumno;

public class FicheroAlumnoTest {
	FicheroAlumno utilidad=new FicheroAlumno();
	
	@Test
	public void leeAlumnoTestID(){
		String esperada="7 Vincent Crabbe 8.68";
		String actual=utilidad.leeAlumno("hogwartsBueno\\hogwartsNuevo\\AlumnosCadenas.txt",7);
		assertEquals(esperada, actual);
	}
	@Test
	public void leeAlumnoTestVariasLineas(){
		String[] esperada={"2 Hermione Black 7.83",
				"3 Oliver Potter 9.01",
				"4 Seamus Lupin 5.73",
				"5 Peeves Pettigrew 7.1",
				"6 Rubeus Goyle 6.55",
				"7 Vincent Crabbe 8.68",
				"8 Luna Granger 2.62",
				"9 Harry Filch 9.23"};
		String[] actual=utilidad.leeAlumno("hogwartsBueno\\hogwartsNuevo\\AlumnosCadenas.txt",2,8);
		assertArrayEquals(esperada, actual);
	}
	
	
	@Test
	public void escribeTextoTest(){
		utilidad.escribeTexto("hogwartsBueno\\testHogwartsNuevo\\test.txt","Hola Mundo");
		String esperada="Hola Mundo";
		String actual=utilidad.leeAlumno("hogwartsBueno\\testHogwartsNuevo\\test.txt",1);
		assertEquals(esperada, actual);
	}
	
	@Test
	public void escribeAlumnoTest(){
		Alumno a=new Alumno("Javi","Ruiz",3.26);
		utilidad.escribeAlumno("hogwartsBueno\\testHogwartsNuevo\\testAlumno.txt", a);
	}
	
	@Test
	public void convierteLineaAlumnoTest(){
		Alumno a=new Alumno(1,"Javi","Ruiz",3.26);
		utilidad.escribeAlumno("hogwartsBueno\\testHogwartsNuevo\\testAlumnoConvierte.txt", a);
		Alumno b=utilidad.convierteAlumno("hogwartsBueno\\testHogwartsNuevo\\testAlumnoConvierte.txt", 1);
		assertEquals(a,b);
	}
	@Test
	public void escribeAlumnoBinario(){
		Alumno a=new Alumno("Pepe","Botella",6.89);
		utilidad.escribeAlumnoBinario("hogwartsBueno\\testHogwartsNuevo\\Alumnos.dat", a);
	}
	@Test
	public void devuelveAlumnoBinario(){
		Alumno a=new Alumno(1,"Pepe","Botella",6.89);
		Alumno copia =utilidad.devuelveAlumnoBinario("hogwartsBueno\\testHogwartsNuevo\\Alumnos.dat",2);
		assertEquals(a,copia);
	}
	@Test
	public void buscaObjetoAlumnoTest(){
		Alumno a=new Alumno("Mariano","Sánchez",8.20);
		Alumno copia =utilidad.buscaObjetoAlumno("hogwartsBueno\\testHogwartsNuevo\\AlumnoObjeto.dat",9);
		assertEquals(a,copia);
	} 
}
