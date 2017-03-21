package com.iesvirgendelcarmen.IO.teoria;

import java.io.File;
import java.util.Scanner;


public class Ficheros1 {

	public static void main(String[] args) {
		// Abrimos un Scanner para solicitar el fichero/directorio
		// a examinar
		System.out.println("Introduce el nombre fichero/carpeta");
		Scanner in = new Scanner(System.in);
		// creamos el descriptor al fichero (con un objeto File)
		File fileIn = new File(in.next()); //recojemos el path 
		in.close();
		//comprobamos si existe ese path
		if (fileIn.exists()){
			// cabecera formateada 
			System.out.printf("%20s %10s %10s %5s%n", "NOMBRE",
					"DIRECTORIO", "TAMA�O","OCULTO");
			//llamamos a un m�todo para que nos de datos acerca
			//del fichero o directorio
			imprimirDatosFichero(fileIn);
		}
		else
			System.out.println("El fichero/directorio NO existe");

	}

	private static void imprimirDatosFichero(File fileIn) {
		//comprobamos si es un directorio
		if (fileIn.isDirectory()){
			//damos la informaci�n de las propiedades del directorio
			//nombre, directorio, tama�o y oculto. Todo formateado
			System.out.printf("%20s %5b %15d %5b%n", fileIn.getName(),
				fileIn.isDirectory(), fileIn.length(),
				fileIn.isHidden());
			//obtenemos una colecci�n archivos/directorios que contiene
			File[] ficheros = fileIn.listFiles();
			//con un bucle for, para cada fichero volvemos a hacer lo
			//mismo 
			for (File fichero : ficheros){
				//usamos recursividad
				imprimirDatosFichero(fichero);
			}
		}
		// en caso que no sea un directorio, damos la informaci�n
		//sobre el fichero regular: nombre, �directorio?, 
		//tama�o y �oculto? 
		//los datos se devulven formateados
		else
			System.out.printf("%20s %5b %15d %5b%n", fileIn.getName(),
					fileIn.isDirectory(), fileIn.length(),
					fileIn.isHidden());
		
	}

}