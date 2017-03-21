package com.iesvirgendelcarmen.IO.teoria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*programa para probar la clase Scanner
 * usando ficheros de entrada
 * El programa hace igual que Fichero16.java
 * pero no usa delimitador en el Scanner
 * y lee el fichero linea a linea
 */
public class Ficheros17 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner (new File("ficherosEntrada/personas.txt"));){
			while (in.hasNextLine()) {
				String linea = in.nextLine();
				String [] trozos = linea.split("\\s*,\\s*");
				Persona persona = new Persona(trozos[0],Integer.parseInt(trozos[1]),Boolean.parseBoolean(trozos[2]));
				System.out.println(persona);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fichero no encontrado");
		}

	}
}
