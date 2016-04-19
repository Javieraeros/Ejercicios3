package testHogwartsBueno;

import static org.junit.Assert.*;

import org.junit.Test;

import hogwartsMalDiseñado.Alumno;
import hogwartsNuevo.FicheroAlumno;

public class FicheroAlumnoTest {

	@Test
	public void leeTextoTest() {
		FicheroAlumno utilidad=new FicheroAlumno();
		String esperada="1 Gellert Dumbledore 6.39";
		String actual=utilidad.leeTexto("hogwartsBueno\\hogwartsNuevo\\AlumnosCadenas.txt");
		assertEquals(esperada, actual);
	}

}
