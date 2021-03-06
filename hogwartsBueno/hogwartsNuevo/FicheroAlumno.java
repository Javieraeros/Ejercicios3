package hogwartsNuevo;

import java.io.*;
import java.nio.file.Files;
import java.util.StringTokenizer;

public class FicheroAlumno {
	
	/*
	 * Interfaz
	 * Cabecera:void muestraAlumnos(String nombreFichero)
	 * Proceso:Lee el fichero deonde est�n almacenados todos los Alumnos y los pinta en pantalla
	 * Precondiciones:Ninguna
	 * Entrada:La ruta del fichero
	 * Salida:nada, pinta en pantalla
	 * Entrada/Salida:Nada
	 * Postcondiciones:Cadena asociada al nombre
	 */
	
	public void muestraAlumnos(String nombreFichero) {
		File archivo = new File(nombreFichero);
		FileReader fichero=null;
		BufferedReader bw=null;
		try {
			
			fichero = new FileReader(archivo);
			bw = new BufferedReader(fichero);
			
			//Lectura anticipada
			String linea=bw.readLine();
			StringTokenizer leeid;
			String id;
			while(linea!=null){
				leeid=new StringTokenizer(linea);
				id=leeid.nextToken();
				if(!id.equals("0")){
					System.out.println(linea);
				}
				linea=bw.readLine();
			}
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(fichero!=null){
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	/*
	 * Interfaz
	 * Cabecera: String leeAlumno(String nombreFichero,int linea)
	 * Proceso:Lee el alumno indicado por el par�metro del archivo de texto correspondiente
	 * Precondiciones:n�mero de linea mayor que 0, y menor que fin de fichero
	 * Entrada:La ruta del fichero
	 * 			un entero para el Alumno
	 * Salida:Una cadena
	 * Entrada/Salida:Nada
	 * Postcondiciones:Cadena asociada al nombre
	 */
	
	public String leeAlumno(String nombreFichero, int linea) {
		String devuelve = null;
		if (linea > 0) {
			File archivo = new File(nombreFichero);
			FileReader fichero=null;
			BufferedReader bw=null;
			try {
				fichero = new FileReader(archivo);
				bw = new BufferedReader(fichero);
				for(int i=1;i<linea;i++){   //Dejo el puntero apuntando a la linea que quiero leer
					bw.readLine();
				}
				devuelve = bw.readLine();
			} catch (IOException e) {
				System.out.println("Error, la l�nea debe tiene que existir en el fichero");
			}finally{
				if(bw!=null){
					try {
						bw.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
				if(fichero!=null){
					try {
						fichero.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}
		}else{
			System.out.println("Error, la línea tiene que ser mayor que 0");
		}
		return devuelve;
	}
	
	/*
	 * Interfaz
	 * Cabecera: String[] leeAlumno(String nombreFichero,int lineaInicio,int numeroLeer)
	 * Proceso:Lee el conjunto de Alumnos igual a numeroLeer, empezando por lineaInicio
	 * Precondiciones:n�mero de linea mayor que 0, y menor que fin de fichero,numeroLeer mayor que 0
	 * Entrada:La ruta del fichero
	 * 			un entero para el primer Alumno
	 * 			un entero para el n�mero de lineas
	 * Salida:Un array de cadenas
	 * Entrada/Salida:Nada
	 * Postcondiciones:Array de cadenas asociada al nombre
	 */
	
	public String[] leeAlumno(String nombreFichero, int lineaInicio,int numeroLeer) {
		String[] devuelve = new String[numeroLeer];
		if (lineaInicio > 0 && numeroLeer>0) {
			try {
				File archivo = new File(nombreFichero);
				FileReader fichero = new FileReader(archivo);
				BufferedReader bw = new BufferedReader(fichero);
				for(int conta=1;conta<lineaInicio;conta++){   //Dejo el puntero apuntando a la linea que quiero leer
					bw.readLine();
				}
				for(int conta=0;conta<numeroLeer;conta++){
					devuelve[conta] = bw.readLine();
				}
				bw.close();
				fichero.close();
			} catch (IOException e) {
				System.out.println("Error, la l�nea debe tiene que existir en el fichero");
				System.out.println("Asegurate de que existen todas las l�neas");
			}
		}else{
			System.out.println("Error, la l�nea tiene que ser mayor que 0");
		}
		return devuelve;
	}

	/* 
	 * Interfaz 
	 * Cabecera:void escribeTexto(String nombreFichero,String texto)
	 * Proceso:escribe una cadena de texto en el fichero indicado, a�adiendo un salto de l�nea.
	 * 			Lo usaremos para crear un log
	 * Precondiciones:Ningna
	 * Entrada:Una cadena para el nombre(ruta) del fichero
	 * 			Una cadena con el Alumno que queramos escribir
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:El archivo quedar� escrito y cerrado. Por defecto el archivo no se machaca a si mismo
	 * 					sino que escribe despu�s de la �ltima escritura
	 */
	
	public void escribeTexto(String nombreFichero, String texto) {
		File archivo = new File(nombreFichero);
		FileWriter fichero=null;
		BufferedWriter bw=null;
		try {
			fichero = new FileWriter(archivo, true);
			bw = new BufferedWriter(fichero);
			bw.write(texto + "\r\n");
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(fichero!=null){
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera:void escribeAlumno(String nombreFichero,Alumno a)
	 * Proceso:escribe un alumno (con el m�todo cadena) en el fichero indicado, a�adiendo un salto de l�nea
	 * Precondiciones:Ningna
	 * Entrada:Una cadena para el nombre(ruta) del fichero
	 * 			Un alumno que escribir
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:El archivo quedar� escrito y cerrado. Por defecto el archivo no se machaca a si mismo
	 * 					sino que escribe despu�s de la �ltima escritura
	 */
	
	public void escribeAlumno(String nombreFichero, Alumno a) {
		File archivo = new File(nombreFichero);
		FileWriter fichero=null;
		BufferedWriter bw=null;
		try {
			fichero = new FileWriter(archivo, true);
			bw = new BufferedWriter(fichero);
			bw.write(a.cadena() + "\r\n");
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(fichero!=null){
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}

	}
	
	/* 
	 * Interfaz 
	 * Cabecera: Alumno convierteLineaAlumno(String nombreFichero,int ID)
	 * Proceso:Devuelve un alumno a partir de la id de dicho alumno y del fichero especificado
	 * Precondiciones:ID mayor que 0
	 * Entrada:Un string como ruta del fichero
	 * 			El id del alumno que queremos leer
	 * Salida:Un alumno
	 * Entrada/Salida:Nada
	 * Postcondiciones:Alumno asociado al nombre, devolver� alumno null en caso de error
	 */
	
	public Alumno convierteAlumno(String nombreFichero,int ID){
		Alumno devuelve=null;
		File leer=new File(nombreFichero);
		FileReader fichero=null;
		BufferedReader br=null;
		try{
			fichero=new FileReader(leer);
			br =new BufferedReader(fichero);
			String linea=br.readLine();
			StringTokenizer alumnoTok=new StringTokenizer(linea);
			while(Integer.parseInt(alumnoTok.nextToken())!=ID && linea!=null){
				linea=br.readLine();
				alumnoTok=new StringTokenizer(linea);
			}
			/*
			 * Al usar el StringTokenizer, el puntero de AlumnoTok apunta al nombre de la linea actual,
			 * por lo que para poner el id de ese alumno, usaremos el ID que nos pasan por par�metro
			 * ya que solo se lo pondremos si el alumno existe gracias a linea!=null
			 */
			//Creaci�n de alumno a trav�s de cadena
			if(linea!=null){ //nos aseguramos de que no ha llegado al final del fichero
				int id=ID;
				String nombre=alumnoTok.nextToken();
				String apellido=alumnoTok.nextToken();
				double nota=Double.parseDouble(alumnoTok.nextToken());
				devuelve=new Alumno(id,nombre,apellido,nota);
			}
			
		}catch(IOException e){
			System.out.println(e);
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(fichero!=null){
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		return devuelve;
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: public void escribeAlumnoBinario(String ruta,Alumno a)
	 * Proceso:escribe un alumno de forma binaria con datos primitivos
	 * Precondiciones:ningura
	 * Entrada:1 cadena para la ruta
	 * 			1 alumno 
	 * Salida:Escribe en el fichero correspondiente
	 * Entrada/Salida:Nada
	 * Postcondiciones:El fichero pasado por la ruta qeudar� escrito
	 */
	
	public void escribeAlumnoBinario(String ruta,Alumno a){
		File archivo=new File(ruta);
		FileOutputStream fichero=null;
		DataOutputStream dos=null;
		try{
			fichero=new FileOutputStream(archivo,true);
			dos=new DataOutputStream(fichero);
			dos.writeInt(a.getID());
			dos.writeInt(a.getNombre().length());
			dos.writeChars(a.getNombre());
			dos.writeInt(a.getApellidos().length());
			dos.writeChars(a.getApellidos());
			dos.writeDouble(a.getNota());
		}catch(IOException e){
			System.out.println(e);
		}finally{
			if(dos!=null){
				try {
					dos.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(fichero!=null){
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: public void muestraAlumnoBinario(String ruta)
	 * Proceso:muestra todos los alumnos del archivo seleccionado
	 * Precondiciones:ningura
	 * Entrada:1 cadena para la ruta
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:Muestra en pantalla todos los alumnos de dicho fichero
	 */
	
	public void muestraAlumnoBinario(String ruta){
		Alumno a; //creo aqu� el alumno para ocupar menos espacio en memoria
		File fichero=new File(ruta);
		FileInputStream ficheroLeer=null;
		DataInputStream lee=null;
		int id,tamanyoNombre,tamanyoApellido;
		String nombre,apellido;
		double nota;
		try {
			ficheroLeer = new FileInputStream(fichero);
			lee=new DataInputStream(ficheroLeer);
			do{
				//Inicio las variables en cada incio del bucle para evitar valores indebidos
				id=0;tamanyoNombre=0;tamanyoApellido=0;
				nombre="";apellido="";
				nota=0.0;
				
				//Leo el id
				id=lee.readInt();
				if(id!=0){  //para evitar mostrar los alumnos borrados por marca
					//Leo el nombre
					tamanyoNombre=lee.readInt();
					for(int i=0;i<tamanyoNombre;i++){
						nombre=nombre+lee.readChar();
					}
					
					//Leo el apellido
					tamanyoApellido=lee.readInt();
					for(int i=0;i<tamanyoApellido;i++){
						apellido=apellido+lee.readChar();
					}
					nota=lee.readDouble();
					a=new Alumno(id,nombre,apellido,nota);
					System.out.println(a.cadena());
				}
			}while(lee.available()>0);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			if(lee!=null){
				try {
					lee.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(ficheroLeer!=null){
				try {
					ficheroLeer.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: public Alumno devuelveAlumnoBinario(String ruta,int id)
	 * Proceso:devuelve el alumno seleccionado mediante el ID
	 * Precondiciones:ninguna
	 * Entrada:1 cadena para la ruta, 1 entero para el ID
	 * Salida:1 alumno
	 * Entrada/Salida:Nada
	 * Postcondiciones:Alumno asociado al nombre
	 */
	
	public Alumno devuelveAlumnoBinario(String ruta,int id){
		Alumno devolver=null;
		File fichero=new File(ruta);
		boolean encontrado=false;
		int idFichero,tamanyoNombre,tamanyoApellido;
		String nombre="", apellido="";
		double nota;
		try{
			FileInputStream leer=new FileInputStream(fichero);
			DataInputStream in=new DataInputStream(leer);
			do{
				idFichero=in.readInt();
				if(idFichero==id){
					encontrado=true;
					tamanyoNombre = in.readInt();
					for (int i = 0; i < tamanyoNombre; i++) {
						nombre=nombre+in.readChar();
					}
					
					tamanyoApellido = in.readInt();
					for (int i = 0; i < tamanyoApellido; i++) {
						apellido=apellido+in.readChar();
					}
					nota=in.readDouble();
					devolver=new Alumno(id,nombre,apellido,nota);
				}else{
					//Puesto que es un fichero secuencial,necesitamos saltarnos al siguiente Alumno
					tamanyoNombre = in.readInt();
					for (int i = 0; i < tamanyoNombre; i++) {
						in.readChar();
					}
					tamanyoApellido = in.readInt();
					for (int i = 0; i < tamanyoApellido; i++) {
						in.readChar();
					}
					in.readDouble();
				}
				in.close();
				leer.close();
			}while(!encontrado && in.available()>0);
		}catch(IOException e){
			System.out.println(e);
		}
		
		return devolver;
	}
		
	 /* 
	 * Interfaz 
	 * Cabecera:public void escribeObjetoAlumno(String ruta,Alumno a)
	 * Proceso:Escribe un objeto alumno en un fichero
	 * Precondiciones:Alumno serializable
	 * Entrada:1 cadena apra la tura del fichero
	 * Salida:Guarda en el fichero el objeto Alumno
	 * Entrada/Salida:Nada
	 * Postcondiciones:El fichero con el alumno guardado si no existe ning�n error
	 */
	
	public void escribeObjetoAlumno(String ruta,Alumno a){
		File fichero=new File(ruta);
		FileOutputStream ficheroBin=null;
		MiOOS escribeBin=null;
		try{
			ficheroBin=new FileOutputStream(fichero,true);
			escribeBin=new MiOOS(ficheroBin);
			escribeBin.writeObject(a);
			escribeBin.close();
			ficheroBin.close();
		}catch(IOException e){
			System.out.println(e);
		}finally{
			if(escribeBin!=null){
				try {
					escribeBin.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(ficheroBin!=null){
				try {
					ficheroBin.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	 /* 
	 * Interfaz 
	 * Cabecera:alumno muestraObjetosAlumno(String ruta)
	 * Proceso:Muestra por pantalla todos los alumnos de la ruta especificada
	 * Precondiciones:Ninguna
	 * Entrada:1 cadena con la ruta del fichero
	 * Salida:Pinta en pantalla
	 * Entrada/Salida:Nada
	 * Postcondiciones:Pinta en pantalla
	 */
	
	public void muestraObjetosAlumno(String ruta){
		File fichero=new File(ruta);
		FileInputStream leer=null;
		ObjectInputStream in=null;
		try{
			leer=new FileInputStream(fichero);
			in=new ObjectInputStream(leer);
			Alumno a;
			a=(Alumno) in.readObject();
			while (a!=null){ //creo que no vale para nada
				System.out.println(a.cadena());
				a=(Alumno) in.readObject();
			}
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}catch(EOFException e){
			
		} catch (IOException e) {
			System.out.println(e);
		}if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		if(leer!=null){
			try {
				leer.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		
	}

	 /* 
	 * Interfaz 
	 * Cabecera: Alumno buscaObjetoAlumno(String ruta, int ID)
	 * Proceso:Devuelve un alumno con el id indicado
	 * Precondiciones:Ninguna
	 * Entrada:1 cadena para la ruta del fichero
	 * 			1 entero para el id
	 * Salida:1 alumno
	 * Entrada/Salida:Nada
	 * Postcondiciones:Alumno asociado al nombre, null si no se enceuntra en el fichero
	 */
	
	public Alumno buscaObjetoAlumno(String ruta, int id){
		Alumno a=null;
		File fichero=new File(ruta);
		FileInputStream leer=null;
		ObjectInputStream in=null;
		try{
			leer=new FileInputStream(fichero);
			in=new ObjectInputStream(leer);
			a=(Alumno) in.readObject();
			while(a.getID()!=id && a!=null){
				a=(Alumno) in.readObject();
			}
		}catch(EOFException e){

		}catch(FileNotFoundException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return a;
	}
	
	/* 
	 * Interfaz 
	 * Cabecera:void escribeAlumnoDirecto(String ruta,Alumno a)
	 * Proceso:Escribe un alumno en un fichero de acceso directo
	 * Precondiciones:Tanto el nombre como el apellido ocupar�n 
	 * 					(m�ximo) 20 caracteres
	 * Entrada:1 cadena para el fichero
	 * 			1 Alumno
	 * Salida:El fichero escrito
	 * Entrada/Salida:Nada
	 * Postcondiciones:El fichero quedar� escrito con el alumno indicado
	 */
	
	public void escribeAlumnoDirecto(String ruta, Alumno a){
		File fichero=new File(ruta);
		RandomAccessFile out=null;
		int tamanyoNombre=a.getNombre().length();
		int tamanyoApellido=a.getApellidos().length();
		String nombre=a.getNombre();
		String apellido=a.getApellidos();
		//Para que ambas cadenas me ocupen lo mismo:
		for(int i=0;i<20-tamanyoNombre;i++){
			nombre=nombre+" ";
		}
		
		for(int i=0;i<20-tamanyoApellido;i++){
			apellido=apellido+" ";
		}
		
		try{
			out=new RandomAccessFile(fichero, "rw");
			out.seek(a.getID()*92);
			out.writeInt(a.getID());
			out.writeChars(nombre);
			out.writeChars(apellido);
			out.writeDouble(a.getNota());
		}catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	 /* 
	 * Interfaz 
	 * Cabecera:void muestraAlumnoDirecto(String ruta)
	 * Proceso:Muestra por pantalla todos los alumnos de la ruta especificada
	 * Precondiciones:Ninguna
	 * Entrada:1 cadena con la ruta del fichero
	 * Salida:Pinta en pantalla
	 * Entrada/Salida:Nada
	 * Postcondiciones:Pinta en pantalla
	 */
	
	public void muestraAlumnoDirecto(String ruta){
		File fichero=new File(ruta);
		RandomAccessFile leer=null;
		Alumno a;
		int contador=0,id;   //Nos servir� para saber en que Alumno estamos
		String nombre,apellido;
		double nota;
		char letra;
		try{
			leer=new RandomAccessFile(fichero,"r");
			while (leer.read()!=-1){
				leer.seek(contador*(92));   //4+2*20+2*20+8
				id=leer.readInt();
				
				//inicializamos nombre para evitar errores
				nombre="";
				for(int i=0;i<20;i++){  //no puedo poner aqui la condicion de letra!=32 porque tiene que leer
										//los 20 caracteres!
					letra=leer.readChar();
					if (letra!=32){     //Para que quede bonito
						nombre=nombre+letra;
					}
				}
				
				//igual para apellido
				apellido="";
				for(int i=0;i<20;i++){
					letra=leer.readChar();
					if(letra!=32){      //Para que quede bonito
						apellido+=letra;
					}
				}
				
				nota=leer.readDouble();
				a=new Alumno(id,nombre,apellido,nota);
				if(a.getID()!=0){
					System.out.println(a.cadena());
				}
				contador++;
			}
		}catch(EOFException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}finally{
			if(leer!=null){
				try {
					leer.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	/* 
	 * Interfaz 
	 * Cabecera: Alumno buscaAlumnoDirecto(String ruta, int ID)
	 * Proceso:Devuelve un alumno con el id indicado
	 * Precondiciones:Ninguna
	 * Entrada:1 cadena para la ruta del fichero
	 * 			1 entero para el id
	 * Salida:1 alumno
	 * Entrada/Salida:Nada
	 * Postcondiciones:Alumno asociado al nombre, null si no se encuentra en el fichero
	 */
	
	public Alumno buscaAlumnoDirecto(String ruta, int idAlumno) {
		File fichero = new File(ruta);
		RandomAccessFile leer = null;
		Alumno a = null;
		String nombre, apellido;
		double nota;
		char letra;
		try {

			leer = new RandomAccessFile(fichero, "r");

			// leerElemento

			leer.seek(idAlumno * (92)); // 4+2*20+2*20+8
			idAlumno = leer.readInt(); // nos da igual leer la ID o no, pero as� nos
									// aseguremos de que hemos seleccionado
									// el que queríamos

			// inicializamos nombre para evitar errores
			nombre = "";
			for (int i = 0; i < 20; i++) { // no puedo poner aqui la condicion
											// de letra!=32 porque tiene que
											// leer
											// los 20 caracteres!
				letra = leer.readChar();
				if (letra != 32) { // Para que quede bonito
					nombre = nombre + letra;
				}
			}

			// igual para apellido
			apellido = "";
			for (int i = 0; i < 20; i++) {
				letra = leer.readChar();
				if (letra != 32) { // Para que quede bonito
					apellido += letra;
				}
			}

			nota = leer.readDouble();
			a = new Alumno(idAlumno, nombre, apellido, nota);
		} catch (EOFException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (leer != null) {
				try {
					leer.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		return a;
	}
	
	/* 
	 * Interfaz 
	 * Cabecera:public int cuentaRegistroObjeto(String ruta)
	 * Proceso:cuenta el número de objetos en un fichero
	 * Precondiciones:Fichero que almacena objetos tipo alumno
	 * Entrada:1 cadena para la ruta
	 * Salida:1 entero que muestera el número de registros
	 * Entrada/Salida:Ninguna
	 * Postcondiciones:entero asociado al nombre,-1 si existe algún error
	 */
	
	public int cuentaRegistroObjeto(String ruta){
		int resultado=-1;
		File fichero=new File(ruta);
		FileInputStream leer = null;
		ObjectInputStream in = null;
		Alumno a;
		try{
			leer=new FileInputStream(fichero);
			in=new ObjectInputStream(leer);
			a=(Alumno) in.readObject();
			resultado=1;
			while(a!=null){
				a=(Alumno) in.readObject();
				resultado++;
			}
		}catch(FileNotFoundException e){
			System.out.println(e);
		} catch (EOFException e) {
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(leer!=null){
				try {
					leer.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		return resultado;
	}
	
	 /* 
	 * Interfaz 
	 * Cabecera: private void parteFicheroSecuencias(String original,String part1,string part2,int secuencia)
	 * Proceso:método que divide un fichero de objetos alumno en 2,siguiendo una secuencia,es decir,
	 * 			creando ficheros en los que mete las "secuencia" primeras,primero en uno y después en otro.
	 * Precondiciones:ARCHIVO DE TIPO OBJETO
	 * Entrada:1 cadena para el archivo original
	 * 		   2 cadenas para lso archivos de la partici�n
	 * 		   1 entero para el n�mero de registros por secuencia
	 * Salida:los 2 archivos particionados
	 * Postcondiciones:El archivo quedará partido en dos, sin ser destruido o modificado
	 */
	
	public void parteFicheroSecuencias(String original,String part1,String part2,int secuencia){
		File fOriginal=new File(original);
		FileInputStream leer=null;
		ObjectInputStream in=null;
		int i,j;
		Alumno a;
		try{
			leer=new FileInputStream(fOriginal);
			in=new ObjectInputStream(leer);
			a=(Alumno) in.readObject();
			while(a!=null){
				for(i=0;a!=null && i<secuencia;i++){
					escribeObjetoAlumno(part1,a);
					a=(Alumno) in.readObject();
				}
				for(j=0;a!=null && j<secuencia;j++){
					escribeObjetoAlumno(part2,a);
					a=(Alumno) in.readObject();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (EOFException e) {

		}catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally{
			if (in!=null){
				try {
					in.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if (leer!=null){
				try {
					leer.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	 /* 
	 * Interfaz 
	 * Cabecera:void mezclaFicheroSecuencia(String nuevo,String fusiona1,String fusiona2,int secuencia)
	 * Proceso:método que fusiona dos ficheros, guardandolo en uno nuevo, de forma ORDENADA de menor a mayor
	 * Precondiciones:Entero mayor que 1
	 * Entrada:1 cadena para el nuevo fichero
	 * 			2 cadenas para cada uno de los ficheros que quieres fusionar
	 * 			1 entero para saber el número de secuencias que vas a mezclar en cada iteración
	 * Salida:El fichero
	 * Entrada/Salida:Ninguna
	 * Postcondiciones:El fichero quedará guardado en la carpeta indicada por la cadena "original"
	 */
	
	public void mezclaFicheroSecuencia(String original, String fusiona1, String fusiona2, int secuencia) {
		File fOriginal = new File(original);
		File fusiona_l = new File(fusiona1);
		File fusiona_2 = new File(fusiona2);
		FileInputStream leer1 = null;
		ObjectInputStream in1 = null;
		FileInputStream leer2 = null;
		ObjectInputStream in2 = null;
		FileOutputStream escribir = null;
		MiOOS out = null;
		Alumno a,b;
		int cont1,cont2,numRegistro1,numRegistro2;
		try {
			leer1 = new FileInputStream(fusiona_l);
			in1 = new ObjectInputStream(leer1);
			leer2 = new FileInputStream(fusiona_2);
			in2 = new ObjectInputStream(leer2);
			escribir = new FileOutputStream(fOriginal,true);
			out = new MiOOS(escribir);
			numRegistro1=cuentaRegistroObjeto(fusiona1);
			numRegistro2=cuentaRegistroObjeto(fusiona2);
			a=(Alumno) in1.readObject();
			numRegistro1--;
			b=(Alumno) in2.readObject();
			numRegistro2--;
			
			
			while (numRegistro1 > 0 || numRegistro2 > 0) { // Mientras quede algo pro leer en un fichero
				
				//Introducimos dependiendo de la secuencia
				for (cont1 = 0, cont2 = 0; cont1 < secuencia && cont2 < secuencia && a != null && b != null;) {
					if (a.getID() < b.getID()) {
						out.writeObject(a);
						if (numRegistro1 > 0) {
							a = (Alumno) in1.readObject();
						} else {
							a = null;
						}
						cont1++;
						numRegistro1--;
					} else {
						out.writeObject(b);
						if (numRegistro2 > 0) {
							b = (Alumno) in2.readObject();
						} else {
							b = null;
						}
						cont2++;
						numRegistro2--;

					}
				}
				
				//Si uno de los dos contadores ha llegado al valor de la secuencia
				if(cont1<secuencia){
					while(a!=null && cont1<secuencia){
						out.writeObject(a);
						if (numRegistro1 > 0) {
							a = (Alumno) in1.readObject();
						} else {
							a = null;
						}
						cont1++;
						numRegistro1--;
					}
				}else{
					while(b!=null && cont2<secuencia){
						out.writeObject(b);
						if (numRegistro2 > 0) {
							b = (Alumno) in2.readObject();
						} else {
							b = null;
						}
						cont2++;
						numRegistro2--;
					}
				}
				if(numRegistro1==0){
					while(numRegistro2>=0){
						out.writeObject(b);
						if (numRegistro2 > 0) {
							b = (Alumno) in2.readObject();
						} else {
							b = null;
						}
						numRegistro2--;
					}
				}
				if(numRegistro2==0){
					while(numRegistro1>=0){
						out.writeObject(a);
						if (numRegistro1 > 0) {
							a = (Alumno) in1.readObject();
						} else {
							a = null;
						}
						numRegistro1--;
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (EOFException e) {
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (in1 != null) {
				try {
					in1.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if (in2 != null) {
				try {
					in2.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if (leer1 != null) {
				try {
					leer1.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if (leer2 != null) {
				try {
					leer2.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if (escribir != null) {
				try {
					escribir.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

	/* 
	 * Interfaz 
	 * Cabecera:void ordenaFicheroObjeto(String ordenar)
	 * Proceso:Ordena un fichero de objetos alumno,guardará una copia llamado copia*** del orignial
	 * Precondiciones:Ninguna
	 * Entrada:Nada
	 * Salida:Nada
	 * Entrada/Salida:1 cadena que representa el fichero a ordenar
	 * Postcondiciones:Se creará un archivo llamado copia**** por seguridad
	 */
	
	public void ordenaFicheroObjeto(String original){
		File fOriginal=new File(original);
		File fCopia=new File(original+"c");
		FileOutputStream originalFOS=null;
		ObjectOutputStream originalOOS=null;
		String aux1=original+"aux1";
		String aux2=original+"aux2";
		FileOutputStream copiaFOS=null;
		ObjectOutputStream copiaOOS=null;
		FileInputStream originalFIS=null;
		ObjectInputStream originalOIS=null;
		Alumno a;
		int tamanyoOriginal;
		
		//Para ordenar:
		File fAux1=new File(aux1);
		File fAux2=new File(aux2);
		FileOutputStream aux1FOS=null;
		ObjectOutputStream aux1OOS=null;
		FileOutputStream aux2FOS=null;
		ObjectOutputStream aux2OOS=null;
		
		//creaFicheroCopia (para evitar stream header malo)
		try{
			copiaFOS=new FileOutputStream(fCopia);
			copiaOOS=new ObjectOutputStream(copiaFOS);
			aux1FOS=new FileOutputStream(fAux1);
			aux1OOS=new ObjectOutputStream(aux1FOS);
			aux2FOS=new FileOutputStream(fAux2);
			aux2OOS=new ObjectOutputStream(aux2FOS);
		}catch(FileNotFoundException e){
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			if(copiaOOS!=null){
				try {
					copiaOOS.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(copiaFOS!=null){
				try {
					copiaFOS.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(aux1OOS!=null){
				try {
					aux1OOS.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(aux1FOS!=null){
				try {
					aux1FOS.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(aux2OOS!=null){
				try {
					aux2OOS.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(aux2FOS!=null){
				try {
					aux2FOS.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		
		//CopiaFichero
		try{
			originalFIS=new FileInputStream(fOriginal);
			originalOIS=new ObjectInputStream(originalFIS);
			a=(Alumno) originalOIS.readObject();
			while(a!=null){
				escribeObjetoAlumno(original+"c", a);
				a=(Alumno) originalOIS.readObject();
			}
		}catch(FileNotFoundException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}catch(EOFException e){
			
		}catch (IOException e) {
			System.out.println(e);
		}finally{
			if(originalOIS!=null){
				try {
					originalOIS.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(originalFIS!=null){
				try {
					originalFIS.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		//ordenaFichero
		tamanyoOriginal=cuentaRegistroObjeto(original);
		for(int i=1;i<tamanyoOriginal;i=i*2){
			parteFicheroSecuencias(original,aux1,aux2,i);
			
			//reescribeOriginal
			try {
				originalFOS = new FileOutputStream(fOriginal);
				originalOOS=new ObjectOutputStream(originalFOS);
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}finally{
				if(originalOOS!=null){
					try {
						originalOOS.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
				if(originalFOS!=null){
					try {
						originalFOS.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}
			
			mezclaFicheroSecuencia(original, aux1, aux2, i);
			
			//reescribeAuxiliares
			try {
				aux1FOS = new FileOutputStream(aux1);
				aux1OOS=new ObjectOutputStream(aux1FOS);
				aux2FOS = new FileOutputStream(aux2);
				aux2OOS=new ObjectOutputStream(aux2FOS);
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}finally{
				if(aux1OOS!=null){
					try {
						aux1OOS.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
				if(aux1FOS!=null){
					try {
						aux1FOS.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
				if(aux2OOS!=null){
					try {
						aux2OOS.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
				if(aux2FOS!=null){
					try {
						aux1FOS.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}
		}
		fAux1.delete();
		fAux2.delete();
	}
	
	/*
	 * Ordernar ficheros de texto y binario (primitivos y objetos) hibrida y externamente
	 * 
	 * Cada vez que se cree un alumno guárdalo, pero solo en programa principal, nada de a�adir c�digo a m�todos
	 * Cada vez que se modifique un alumno,guardalo en el fichero correspondiente
	 * Crea el principal Actualizar, de la forma que te dijo asun(do-while)
	 * Crea un principal que te muestre el fichero correspondiente con la funcionalidad correspondiente
	 * No uses rutas relativas y/o absolutas
	 */
}
