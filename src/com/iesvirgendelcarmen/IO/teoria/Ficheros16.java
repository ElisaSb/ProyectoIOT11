package com.iesvirgendelcarmen.IO.teoria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* programa para probar la clase Scanner
 * usando ficheros de entrada
 */
public class Ficheros16 {
	public static void main(String[] args) {
		//creo una lista dinamica para guardar objetos persona
		List<Persona> listaPersonas = new ArrayList<>();//vacia
		try (Scanner in = new Scanner (new File("ficherosEntrada/personas.txt"));){
			in.useDelimiter("(\\s*,\\s*)|(\\r)"); //espacio coma y espacio
			while (in.hasNext()) {
				/*String nombre = in.next();
				int edad = in.nextInt();
				boolean hombre = in.nextBoolean();*/
				//Persona persona = new Persona(in.next(),in.nextInt(),in.nextBoolean());
				listaPersonas.add (new Persona(in.next(),in.nextInt(),in.nextBoolean()));
				//System.out.println(persona);
				//System.out.printf("%s ---%d---%b\n",nombre, edad,hombre);
			}
			System.out.println(listaPersonas);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fichero no encontrado");
		}
	}
}
