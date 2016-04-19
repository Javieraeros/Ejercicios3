package hogwartsMalDiseñado;

public class TestEstudiosMuggles {
	
	public static void main (String args[]) {
		Alumnos c=new Alumnos(10);
		UtilidadesAlumnos uc=new UtilidadesAlumnos();
		double media, desviacion;
		EstudiosMuggles.cargaAlumnos(c);
		//System.out.println(c);
		//EstudiosMuggles.aniadeAlumno(c);
		//System.out.println(c);
		//media=uc.calcularMedia(c);
		//desviacion=uc.calcularDesviacionTipica(c);
		//System.out.println(media+" "+desviacion);
		//EstudiosMuggles.pintarNotasRelativas(c);
		EstudiosMuggles.muestraNotaRelativaAlumno(8,c);
	
	}
}

