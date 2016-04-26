/*
 * Propiedades:
 * ****************
 * 	Básicas:
 * 	*********
 *			alumnos: Alumno[], consultable, modificable
 * 		numAlumnos: entero, consultable
 * 		
 * 	Derivadas:
 * 	*************
 *
 * 	Compartidas:
 * 	****************
 *
 * Restricciones:
 * *****************
 *
 * Métodos sobrescritos:
 * **************************
 * 	equals()
 * 	toString()
 * 	hashCode()
 * 	clone()
 * 	compareTo()
 *
 * Interfaz:
 * **********
 * 	Alumno[] getAlumnos()
 * 	entero getNumAlumnos()
 * 	nada setAlumnos(Alumno[] alumnos)
 */
package hogwartsMalDise;
import java.util.Vector;
public class Alumnos implements Cloneable,Comparable<Alumnos>
{
	//Atributos
	private Vector <Alumno> alumnos;
	private int numAlumnos;

	//Constructor por defecto
	public Alumnos()
	{
		numAlumnos = 1;
		alumnos = new Vector(numAlumnos,1);
	}

	//Constructores ordinarios
	public Alumnos(int numAlumnos)
	{
		this.numAlumnos = numAlumnos;
		alumnos = new Vector(numAlumnos,1);
	}

	public Alumnos(Vector<Alumno> a)
	{
		alumnos = a;
		numAlumnos = a.size();           //Aquí lo mismo!!
	}

	//Constructor de copia
	public Alumnos(Alumnos c)
	{
		this.numAlumnos = c.numAlumnos;
		alumnos = c.alumnos;
	}

	//Consultores
	public Vector <Alumno> getAlumnos()
	{
		return alumnos;
	}

	public int getNumAlumnos()
	{
		return numAlumnos;
	}
	
	//Modificadores
	public void setAlumnos(Vector <Alumno> a)
	{
		alumnos = (Vector <Alumno>) a.clone();
		numAlumnos = a.size();              //Utilizo size para saber cuantos alumnos hay, y no cual es la capacidad del vector
	}

	//Métodos sobrescritos
	/*
	 * Criterio de igualdad:
	 * 	Se considerarán iguales dos objetos del tipo Alumnos que posean la misma cantidad de alumnos y los mismos alumnos.
	 */
	@Override
	public boolean equals(Object o)
	{
		boolean igual = false;
		if (o!=null && o instanceof Alumnos){
			Alumnos c=(Alumnos) o;
			if(alumnos.size()==c.alumnos.size())
			{
				boolean alumnoIgual = true;
				for(int i = 0; i<alumnos.size() && alumnoIgual == true; i++)
				{
						alumnoIgual = alumnos.get(i).equals(c.alumnos.get(i));
				}
				igual = alumnoIgual;
			}
		}
		return igual;
	}

	@Override
	public String toString()
	{
		String s = "";
		for(int i = 0; i<alumnos.size(); i++)
		{
			s = s+"\n"+(i+1)+"\n"+alumnos.get(i).toString()+"\n";
		}
		return s;
	}

	@Override
	public int hashCode()
	{
		int code = 0;
		for(int i = 0; i<alumnos.size(); i++)
		{
			code = code+alumnos.get(i).hashCode();
		}
		code = code/alumnos.size();
		return code;
	}

	@Override
	public Alumnos clone()
	{
		Alumnos copia=null;
		try{
			copia=(Alumnos) super.clone();
			copia.setAlumnos(getAlumnos());
			/*copia.getAlumnos().clear();
			for(int i = 0; i<alumnos.size(); i++)
			{
				copia.getAlumnos().add(alumnos.get(i).clone()) ;
			}
			* */
		}catch(CloneNotSupportedException error){
			System.out.println("Error,Alumnos no clonada");
		}
		return copia;
	}

	/*
	 * Criterio de comparación:
	 * 	Se considerarán iguales dos objetos del tipo Alumnos que posean la misma cantidad de alumnos y los mismos alumnos,
	 * 	se considerará menor la Alumnos que tenga menos alumnos que la otra o, en caso de igualdad, que sus alumnos sean menores
	 * 	y se considerará mayor la Alumnos que tenga más alumnos que la otra o, en caso de igualdad, que sus alumnos sean mayores
	 */
	public int compareTo(Alumnos c)
	{
		int compara = -1;
		if(equals(c))
			compara = 0;
		else
			if(numAlumnos>c.numAlumnos || (numAlumnos==c.numAlumnos && toString().compareTo(c.toString())>0))
				compara = 1;
		return compara;
	}
}
