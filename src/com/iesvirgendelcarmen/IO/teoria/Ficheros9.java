package com.iesvirgendelcarmen.IO.teoria;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/* el programa va a leer un fichero que tiene serializado dos
 * objetos de tipo Persona, primero lo vamos a leer byte a byte
 * y posteriormente usando la clase ObjectInputStream como un objeto
 */
public class Ficheros9 {

	public static void main(String[] args) {
		//primero intento leer el fichero byte a byte y lo muestro
		//en consola
		//creamos el flujo, de forma clásica
		//cerrando el flujo en un bloque finally
		BufferedInputStream in1 = null;
		try {
			 in1 = new BufferedInputStream(
					new FileInputStream(
							"ficherosSalida/ficheroConObjetos.dat"));
			 //leemos byte a byte el flujo
			 int c; //estos son los bytes del flujo
			 //leemos hasta el final que es hasta que c valga -1
			 while ((c = in1.read()) != -1)
				 System.out.print((char)c);
		} catch (FileNotFoundException e) {
			System.out.println("Error en el fichero");
		} catch (IOException e) {
			System.out.println("Error I/O");
		} finally {
			try {
				in1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("***************************");
		//*************************************************
		//Intentamos leerlo sabiendo que el contenido son objetos
		//de tipo Persona, usamos un ObjectInputStream
		//manejamos excepciones con jdk 1.7
		try (ObjectInputStream in2 = new ObjectInputStream(
				new BufferedInputStream(
					new FileInputStream(
						"ficherosSalida/ficheroConObjetos.dat")));)
		{
			Persona p1 = (Persona) in2.readObject();
			Persona p2 = (Persona) in2.readObject();
			System.out.println(p1);
			System.out.println(p2);
		} catch (FileNotFoundException e) {
			System.out.println("Error en el fichero");
		} catch (IOException e) {
			System.out.println("Error I/O");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		

	}

}