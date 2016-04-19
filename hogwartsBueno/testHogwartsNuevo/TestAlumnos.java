package testHogwartsNuevo;
import java.util.Vector;

import hogwartsNuevo.Alumno;
import hogwartsNuevo.Alumnos;
import hogwartsNuevo.ApellidosEstudiantesHogwarts;
import hogwartsNuevo.NombresEstudiantesHogwarts;

import java.util.Random;
public class TestAlumnos
{
	public static void main(String[] args)
	{
		Random aleatorio = new Random();
		int nombre=0,apellido=0;
		double nota = 5.0;
		NombresEstudiantesHogwarts en = NombresEstudiantesHogwarts.values()[0];
		ApellidosEstudiantesHogwarts ea = ApellidosEstudiantesHogwarts.values()[0];
		//Alumnos Alumnos1 = new Alumnos();
		//System.out.print(Alumnos1.toString());
		Vector <Alumno> alu = new Vector(8);
		for(int i = 0; i<alu.capacity(); i++)
		{
			nombre = aleatorio.nextInt(NombresEstudiantesHogwarts.values().length);
			apellido = aleatorio.nextInt(ApellidosEstudiantesHogwarts.values().length);
			alu.add(new Alumno(NombresEstudiantesHogwarts.values()[nombre].name(),ApellidosEstudiantesHogwarts.values()[apellido].name(),nota));
		}
		Alumnos Alumnos2 = new Alumnos(4);
		Alumnos2.getAlumnos().add(new Alumno(NombresEstudiantesHogwarts.values()[0].name(),ApellidosEstudiantesHogwarts.values()[5].name(),nota));
		Alumnos2.getAlumnos().add(new Alumno(NombresEstudiantesHogwarts.values()[1].name(),ApellidosEstudiantesHogwarts.values()[12].name(),nota));
		Alumnos2.getAlumnos().add(new Alumno(NombresEstudiantesHogwarts.values()[2].name(),ApellidosEstudiantesHogwarts.values()[2].name(),nota));
		Alumnos2.getAlumnos().add(new Alumno(NombresEstudiantesHogwarts.values()[3].name(),ApellidosEstudiantesHogwarts.values()[3].name(),nota));
		System.out.print(Alumnos2.toString());
		Alumnos Alumnos3 = new Alumnos(alu);
		System.out.print(Alumnos3.toString());
		Alumnos Alumnos4 = new Alumnos(Alumnos2);
		System.out.print(Alumnos4.toString());

		System.out.println(Alumnos4.getNumAlumnos());
		System.out.println(Alumnos4.equals(Alumnos3));
		Alumnos4.setAlumnos(alu);
		System.out.println(Alumnos4.getNumAlumnos());
		System.out.println(Alumnos4.toString());
		System.out.println(Alumnos4.equals(Alumnos3));

		System.out.println(Alumnos2.hashCode());
		System.out.println(Alumnos3.hashCode());
		System.out.println(Alumnos4.hashCode());

		Alumnos Alumnos5 = Alumnos4.clone();
		System.out.println(Alumnos4.equals(Alumnos5));

		System.out.println(Alumnos4.compareTo(Alumnos3));
		System.out.println(Alumnos4.compareTo(Alumnos2));
		System.out.println(Alumnos2.compareTo(Alumnos4));
		Alumnos3.getAlumnos().elementAt(1).setNombre("Lloyd");
		Alumnos3.getAlumnos().elementAt(1).setApellidos("Irving");
		System.out.println(Alumnos4.compareTo(Alumnos3));
		System.out.println(Alumnos3.compareTo(Alumnos4));
	}
}
