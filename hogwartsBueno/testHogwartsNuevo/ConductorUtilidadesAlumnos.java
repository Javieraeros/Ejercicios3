package testHogwartsNuevo;
import java.util.Vector;

import hogwartsNuevo.Alumno;
import hogwartsNuevo.Alumnos;
import hogwartsNuevo.ApellidosEstudiantesHogwarts;
import hogwartsNuevo.NombresEstudiantesHogwarts;
import hogwartsNuevo.UtilidadesAlumnos;

import java.util.Random;
public class ConductorUtilidadesAlumnos
{
	public static void main(String[] args)
	{
		Random aleatorio = new Random();
		UtilidadesAlumnos uc = new UtilidadesAlumnos();
		int nombre=0,apellido=0;
		double nota = 0.0;
		NombresEstudiantesHogwarts en = NombresEstudiantesHogwarts.values()[0];
		ApellidosEstudiantesHogwarts ea = ApellidosEstudiantesHogwarts.values()[0];
		Vector <Alumno> alu = new Vector(3);
		for(int i = 0; i<alu.capacity(); i++, nota++)
		{
			nombre = aleatorio.nextInt(NombresEstudiantesHogwarts.values().length);
			apellido = aleatorio.nextInt(ApellidosEstudiantesHogwarts.values().length);
			nota = (double) aleatorio.nextInt(10)+1;
			alu.add(new Alumno(NombresEstudiantesHogwarts.values()[nombre].name(),ApellidosEstudiantesHogwarts.values()[apellido].name(),nota));//+(aleatorio.nextInt(11)/10.0)));
		}
		Alumnos desordenado = new Alumnos(alu);

		Alumnos ordenado = desordenado.clone();
		System.out.println("¿Son iguales?"+desordenado.equals(ordenado));

		uc.ordenarPlomada(ordenado);
		System.out.println(desordenado.toString());
		System.out.println(ordenado.toString());
		System.out.println("¿Son iguales?"+desordenado.equals(ordenado));

		System.out.println("Nota media: "+uc.calcularMedia(ordenado));

		System.out.println("Desviacion tipica: "+uc.calcularDesviacionTipica(ordenado));
	}
}
