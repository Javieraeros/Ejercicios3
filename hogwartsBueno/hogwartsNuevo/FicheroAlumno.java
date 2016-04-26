package hogwartsNuevo;

import java.io.*;
import java.util.StringTokenizer;

public class FicheroAlumno {
	
	/*
	 * Interfaz
	 * Cabecera:void muestraAlumnos(String nombreFichero)
	 * Proceso:Lee el fichero deonde estï¿½n almacenados todos los Alumnos y los pinta en pantalla
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
	 * Proceso:Lee el alumno indicado por el parï¿½metro del archivo de texto correspondiente
	 * Precondiciones:nï¿½mero de linea mayor que 0, y menor que fin de fichero
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
				System.out.println("Error, la lï¿½nea debe tiene que existir en el fichero");
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
			System.out.println("Error, la lï¿½nea tiene que ser mayor que 0");
		}
		return devuelve;
	}
	
	/*
	 * Interfaz
	 * Cabecera: String[] leeAlumno(String nombreFichero,int lineaInicio,int numeroLeer)
	 * Proceso:Lee el conjunto de Alumnos igual a numeroLeer, empezando por lineaInicio
	 * Precondiciones:nï¿½mero de linea mayor que 0, y menor que fin de fichero,numeroLeer mayor que 0
	 * Entrada:La ruta del fichero
	 * 			un entero para el primer Alumno
	 * 			un entero para el nï¿½mero de lineas
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
				System.out.println("Error, la lï¿½nea debe tiene que existir en el fichero");
				System.out.println("Asegurate de que existen todas las lï¿½neas");
			}
		}else{
			System.out.println("Error, la lï¿½nea tiene que ser mayor que 0");
		}
		return devuelve;
	}

	/* 
	 * Interfaz 
	 * Cabecera:void escribeTexto(String nombreFichero,String texto)
	 * Proceso:escribe una cadena de texto en el fichero indicado, aï¿½adiendo un salto de lï¿½nea.
	 * 			Lo usaremos para crear un log
	 * Precondiciones:Ningna
	 * Entrada:Una cadena para el nombre(ruta) del fichero
	 * 			Una cadena con el Alumno que queramos escribir
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:El archivo quedarï¿½ escrito y cerrado. Por defecto el archivo no se machaca a si mismo
	 * 					sino que escribe despuï¿½s de la ï¿½ltima escritura
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
	 * Proceso:escribe un alumno (con el mï¿½todo cadena) en el fichero indicado, aï¿½adiendo un salto de lï¿½nea
	 * Precondiciones:Ningna
	 * Entrada:Una cadena para el nombre(ruta) del fichero
	 * 			Un alumno que escribir
	 * Salida:Nada
	 * Entrada/Salida:Nada
	 * Postcondiciones:El archivo quedarï¿½ escrito y cerrado. Por defecto el archivo no se machaca a si mismo
	 * 					sino que escribe despuï¿½s de la ï¿½ltima escritura
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
	 * Postcondiciones:Alumno asociado al nombre, devolverï¿½ alumno null en caso de error
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
			 * por lo que para poner el id de ese alumno, usaremos el ID que nos pasan por parï¿½metro
			 * ya que solo se lo pondremos si el alumno existe gracias a linea!=null
			 */
			//Creaciï¿½n de alumno a travï¿½s de cadena
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
	 * Postcondiciones:El fichero pasado por la ruta qeudarï¿½ escrito
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
		Alumno a; //creo aquí el alumno para ocupar menos espacio en memoria
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
	 * Postcondiciones:El fichero con el alumno guardado si no existe ningún error
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
	 * Postcondiciones:Posible error
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
		}catch(IOException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
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
			System.out.println(e);
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
	 * Falta crear escribeObjetoBinario y leeObjetoBinario, con toda las funciones que hemos creado
	 * para archivos de texto y binarios primitivos. SERIALIZABLE
	 *
	 * Crear AccessRandom, para poder crear ficheros directos.
	 * 
	 * Ordernar ficheros de texto y binario (primitivos y objetos)
	 * 
	 * Cada vez que se cree un alumno guárdalo, pero solo en programa principal, nada de añadir código a métodos
	 * Cada vez que se modifique un alumno,guardalo en el fichero correspondiente
	 * Crea el principal Actualizar, de la forma que te dijo asun(do-while)
	 * Crea un principal que te muestre el fichero correspondiente con la funcionalidad correspondiente
	 * No uses rutas relativas y/o absolutas
	 */
}
