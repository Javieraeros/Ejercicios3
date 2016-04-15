package hogwartsFichero;

public class testAlumno {
	
	public static void main (String args[]) {
		Alumno Harry=new Alumno();
		Alumno yo=new Alumno("Javierí","Ruiz",0);
		//Paco.pinta(yo.getNombre()+yo.getNota());
		//yo.setNombre("Pues me cambio de nombre");
		//yo.setNota(10.0);
		//Paco.pinta(yo.getNombre()+"\n"+yo.getNota());
		//Paco.pinta(yo.equals(Harry));
		//yo.setNombre("Harry Potter");
		//yo.setNota(Harry.getNota());
		//Paco.pinta(yo.equals(Harry));
		//yo=Harry.clone();
		//Paco.pinta(yo.toString());
		//yo=Harry;
		//Harry.setNota(8);
		//Paco.pinta(yo.toString());
		//Paco.pinta(yo.hashCode());
		System.out.println(yo.compareTo(Harry)+"\n"+Harry.compareTo(yo));
		//Harry=yo;
		//Paco.pinta(yo.compareTo(Harry));
		//yo.setNombre(Harry.getNombre());
		//Paco.pinta(yo.compareTo(Harry));
		//yo=Harry.clone();
		//Harry.setNombre("Pene");
		System.out.println(yo.getNombre()+" "+Harry.getNombre());
	}
}

