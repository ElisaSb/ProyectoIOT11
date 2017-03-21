package com.iesvirgendelcarmen.IO.teoria;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class Ficheros2 {

	public static void main(String[] args) {
		//solicitamos mediante Scanner la ruta del directorio
		System.out.println("Introduce la ruta del directorio");
		Scanner in = new Scanner(System.in);
		String path = in.next();
		in.close();
		//creamos el descriptor al directorio
		File dir = new File(path);
		//acabamos el programa si no existe el fichero
		//o existe el fichero pero NO es un directorio
		if (!dir.exists()){
			System.out.println("El fichero no existe");
			//un return sin nada, porque main devuelve un void (nada)
			return;  //sale del método main (acaba el programa)
		}
		if (!dir.isDirectory()){
			System.out.println("El fichero no es un directorio");
			return; //sale del método main (acaba el programa)
		}
		//código que se ejucta en el caso que exista el directorio
		System.out.println("Analizando directorio .....");
		//usamos el método public String[] list(FilenameFilter filter)
		//con la intención de obtener los ficheros *.txt
		
		String[] ficherosTXT = dir.list(new FilenameFilter(){

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".txt");
			}
			
		});
		System.out.println("\n\n" + Arrays.toString(ficherosTXT));
		
		
		
		
		
		
		
	}
;
}