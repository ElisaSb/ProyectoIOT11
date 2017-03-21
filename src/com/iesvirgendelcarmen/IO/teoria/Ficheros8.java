package com.iesvirgendelcarmen.IO.teoria;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*programa para serializar objetos de tipo Persona
 * creamos un flujo de dichos objetos y lo vamos a volcar a 
 * un fichero, debemos usar: ObjectOutputStream, 
 * BufferedOutputStream y FileOutputStream
 */
public class Ficheros8 {

	public static void main(String[] args) {
		//creaamos un objeto de tipo persona
		Persona p1 = new Persona("juan garcía garcía" , 25, true);
		Persona p2 = new Persona("luisa hernández pérez" , 65, false);
		//crear el flujo de salida
		try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									"ficherosSalida/ficheroConObjetos.dat")));)
		{
			out.writeObject(p1);
			out.writeObject(p2);
			out.flush();
		} catch (FileNotFoundException e) {
			System.out.println("Error en el fichero");
		} catch (IOException e) {
			System.out.println("Error I/O");
		}

	}

}