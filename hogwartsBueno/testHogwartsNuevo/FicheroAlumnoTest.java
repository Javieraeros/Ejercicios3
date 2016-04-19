package testHogwartsNuevo;

import static org.junit.Assert.*;

import org.junit.Test;

import hogwartsMalDiseñado.Alumno;
import hogwartsNuevo.FicheroAlumno;

public class FicheroAlumnoTest {
	FicheroAlumno utilidad=new FicheroAlumno();
	@Test
	public void leeTextoTest() {
		String esperada="1 Gellert Dumbledore 6.39";
		String actual=utilidad.leeTexto("hogwartsBueno\\hogwartsNuevo\\AlumnosCadenas.txt");
		assertEquals(esperada, actual);
	}
	@Test
	public void leeTextoTestLinea(){
		String esperada="7 Vincent Crabbe 8.68";
		String actual=utilidad.leeTexto("hogwartsBueno\\hogwartsNuevo\\AlumnosCadenas.txt",7);
		assertEquals(esperada, actual);
	}

	@Test
	public void leeTextoTestVariasLineas(){
		String[] esperada={"2 Hermione Black 7.83",
				"3 Oliver Potter 9.01",
				"4 Seamus Lupin 5.73",
				"5 Peeves Pettigrew 7.1",
				"6 Rubeus Goyle 6.55",
				"7 Vincent Crabbe 8.68",
				"8 Luna Granger 2.62",
				"9 Harry Filch 9.23"};
		String[] actual=utilidad.leeTexto("hogwartsBueno\\hogwartsNuevo\\AlumnosCadenas.txt",2,8);
		assertArrayEquals(esperada, actual);
	}
	@Test
	public void escribeTextoTest(){
		utilidad.escribeTexto("hogwartsBueno\\testHogwartsNuevo\\test.txt","Hola Mundo");
		String esperada="Hola Mundo";
		String actual=utilidad.leeTexto("hogwartsBueno\\testHogwartsNuevo\\test.txt");
		assertEquals(esperada, actual);
	}
	
	@Test
	public void escribeTextoBooleanTest(){
		utilidad.escribeTexto("hogwartsBueno\\testHogwartsNuevo\\testBoolean.txt","Hola Mundo",false);
		String esperada="Hola Mundo";
		String actual=utilidad.leeTexto("hogwartsBueno\\testHogwartsNuevo\\testBoolean.txt");
		assertEquals(esperada, actual);
	}
}
