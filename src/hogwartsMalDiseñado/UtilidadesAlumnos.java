package hogwartsMalDise�ado;
import java.util.Vector;
import java.lang.Math;
public class UtilidadesAlumnos
{
	/*
	 * cabecera: nada ordernarPlomada(Alumnos c)
	 * comentario: el método ordena un array de cualquier tipo mediante el método de la Plomada
	 * precondiciones: nada
	 * entrada: nada
	 * salida: nada
	 * entrada/salida: un array
	 * postcondiciones: array ordernado, por referencia
	 */
	public void ordenarPlomada(Alumnos c)
	{
		for(int i=c.getAlumnos().size()-1; i>0; i--)
		{
			for(int j=0; j<i; j++)
			{
				if(c.getAlumnos().get(i).compareTo(c.getAlumnos().get(j))==1)
				{
					Alumno aux = c.getAlumnos().get(i).clone();
					c.getAlumnos().set(i, c.getAlumnos().get(j).clone());
					c.getAlumnos().set(j, aux.clone());
				}
			}
		}
	}

	/*
	 * cabecera: real calcularMedia(Alumnos c)
	 * comentario: el método calcula la media de las notas de los alumnos de la Alumnos
	 * precondiciones: nada
	 * entrada: una Alumnos
	 * salida: un real
	 * entrada/salida: nada
	 * postcondiciones: real asociado al nombre
	 */
	public double calcularMedia(Alumnos c)
	{
		double media = 0;
		for(int i = 0; i<c.getAlumnos().size(); i++)
		{
			media = media + c.getAlumnos().get(i).getNota();
		}
		media = media/c.getAlumnos().size();
		return media;
	}

	/*
	 * cabecera: real calcularDesviacionTipica(Alumnos c)
	 * comentario: el método calcula la desviacion tipica de la Alumnos
	 * precondiciones: nada
	 * entrada: una Alumnos
	 * salida: un real
	 * entrada/salida: nada
	 * postcondiciones: real asociado al nombre
	 */
	 public double calcularDesviacionTipica(Alumnos c)
	{
		double desvTip = 0;
		double media = calcularMedia(c);
		for(int i = 0; i<c.getAlumnos().size(); i++)
		{
			desvTip = desvTip + Math.pow(c.getAlumnos().get(i).getNota()-media,2);
		}
		desvTip = Math.sqrt(desvTip/c.getAlumnos().size());
		return desvTip;
	}
	
	/*
	 * cabecera: entero buscarAlumno(Alumnos c, Alumno a)
	 * comentario: el método busca un Alumno en un Alumnos
	 * precondiciones: nada
	 * entrada: un Alumno y un Alumnos
	 * salida: un entero
	 * entrada/salida: nada
	 * postcondiciones: entero asociado al nombre, devuleve -1 en caso de que el Alumno no esté en Alumnos o el indice en caso de que se encuentre al Alumno
	 */
	public int buscarAlumno(Alumnos c, Alumno a)
	{
		int inicio =0, fin = c.getAlumnos().size(), mitad = 0, encontrado = -1;
		while(inicio <= fin && encontrado == -1)
		{
			mitad = (inicio+fin)/2;
			if(c.getAlumnos().get(mitad).compareTo(a)==0)
				encontrado = mitad;
			else
				if(c.getAlumnos().get(mitad).compareTo(a)==-1)
					fin = mitad-1;
				else
					inicio = mitad+1;
		}
		return encontrado;
	}
}
