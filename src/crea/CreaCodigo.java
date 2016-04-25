package crea;

import hogwartsMalDiseñado.EscribeFichero;

public class CreaCodigo {

	public static void main(String[] args) {
		EscribeFichero fichero=new EscribeFichero("ProgramaChorra.java",false);
		fichero.escribe("package ejercicios3;");
		fichero.escribe("public class ProgramaChorra {");
		fichero.escribe("public static void main(String[] args){");
		fichero.escribe("char[] escribe={'H','O','L','A',' ','M','U','N','D','O'};");
		fichero.escribe("System.out.println(escribe);");
		fichero.escribe("} }");
	}

}
