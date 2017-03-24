package com.iesvirgendelcarmen.IO.ejercicios;

import java.io.File;

public class Ejercicios6 {
	public static void main(String[] args) {
		//comprobar que entran solo dos argumentos
		if (args.length != 2) {
			System.out.println("error en el n� de argumentos");
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
		//comprobamos que el segundo argumento sea un n�
		//y ese n� est� comprendido entre 1 y el tama�o del fichero
		int pesoFichero = (int) fileIn.length();
		String argumentosTrozos = args[1];
		int numeroTrozos = Integer.parseInt(argumentosTrozos);
		if (! argumentosTrozos.matches("[1-9]+") || numeroTrozos >= pesoFichero) {
			System.err.println("Error, en l n� de trozos a dividir");
			System.exit(3);
		}
		//calcular el tama�o de los trozos
		int pesoTrozo = pesoFichero / numeroTrozos;
		int pesoTrozoResidual = pesoFichero % numeroTrozos;
		//generar una coleccion de nombre de ficheros de salida
		String[] nombreTrozos = nombrarTrozos(numeroTrozos);
		//generar una coleccion de tama�os de los trozos
		//ejemplo [20,20,20,20,20] [20,20,20,20,21] [19,19,19,19,23]
	}
	public static String[] nombrarTrozos(int numeroTrozos) {
		String[] nombreTrozos = new String[numeroTrozos];
		for (int i = 1; i <= numeroTrozos; i++) {
			nombreTrozos[i] = "FicherosSalida/trozo"+i+".txt";
		}
		return nombreTrozos;
	}
}
