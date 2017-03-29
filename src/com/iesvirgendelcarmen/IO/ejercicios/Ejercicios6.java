package com.iesvirgendelcarmen.IO.ejercicios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicios6 {
	public static void main(String[] args) {
		//comprobar que entran solo dos argumentos
		if (args.length != 2) {
			System.out.println("error en el nº de argumentos");
			System.exit(1);
		}
		//vamos a crear el path con el argumento
		String path = args[0];
		File fileIn = new File(path);
		System.out.println(path);
		if (!fileIn.exists()) {
			System.err.println("Error, no existe el fichero "+path);
			System.exit(2);
		}
		//comprobamos que el segundo argumento sea un nº
		//y ese nº está comprendido entre 1 y el tamaño del fichero
		int pesoFichero = (int) fileIn.length();
		String argumentosTrozos = args[1];
		int numeroTrozos = Integer.parseInt(argumentosTrozos);
		if (! argumentosTrozos.matches("[1-9]+") || numeroTrozos >= pesoFichero) {
			System.err.println("Error, en l nº de trozos a dividir");
			System.exit(3);
		}
		//calcular el tamaño de los trozos
		int pesoTrozo = pesoFichero / numeroTrozos;
		int pesoTrozoResidual = pesoFichero % numeroTrozos;
		//generar una coleccion de nombre de ficheros de salida
		String[] nombreTrozos = nombrarTrozos(numeroTrozos);
		//generar una coleccion de tamaños de los trozos
		//ejemplo [20,20,20,20,20] [20,20,20,20,21] [19,19,19,19,23]
		int[] tamanoTrozos = generarTamanoTrozos(pesoFichero, numeroTrozos);
		//generamos los trozos (son fichero de salida)
		generarTrozos(fileIn, nombreTrozos, tamanoTrozos);
	}
	public static void generarTrozos(File inFile, String[] nombreTrozos, int[] tamanoTrozos) {
		//preparamos los stream de entrada
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFile));){
			int c;
			int contador = 0;
			int[] bytesFichero = new int[(int) inFile.length()];
			while ((c = in.read()) != -1) {
				bytesFichero[contador] = c;
				contador++;
			}
			for (int i = 0; i < nombreTrozos.length; i++) {
				//sacar el tamaño del trozo
				int tamano = tamanoTrozos[i];
				String nombre = nombreTrozos[i];
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(nombre));
				for (int j = 0; j < bytesFichero.length; j++) {
					out.write(bytesFichero[j]);
					out.flush();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error en el archivo.");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}
	}
	
	public static int[] generarTamanoTrozos(int pesoFichero, int numeroTrozos) {
		int[] tamanoTrozos = new int[numeroTrozos];
		int tamanoNormal = pesoFichero/numeroTrozos;
		int tamanoUltimo = pesoFichero - tamanoNormal * (numeroTrozos - 1);
		for (int i = 0; i < numeroTrozos-1; i++) {
			tamanoTrozos[i] = tamanoNormal;
		}
		tamanoTrozos[numeroTrozos-1] = tamanoUltimo;
		return tamanoTrozos;
	}
	
	public static String[] nombrarTrozos(int numeroTrozos) {
		String[] nombreTrozos = new String[numeroTrozos];
		for (int i = 0; i < numeroTrozos; i++) {
			nombreTrozos[i] = "FicherosSalida/trozo"+i+".txt";
		}
		return nombreTrozos;
	}
}