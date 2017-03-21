package com.iesvirgendelcarmen.IO.teoria;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*Escribir un mensaje recibido desde la consola
 * usando la clase Scanner y como stream de entrada
 * System.in. Posteriormente lo escribimos en un fichero 
 * de texto, usando un BufferedWriter
 */
public class Ficheros11 {

	public static void main(String[] args) {
		// recibimos el mensaje de entrada (es una línea)
		try (BufferedWriter out =  new BufferedWriter(
					new FileWriter("ficherosSalida/filewriter1.txt"));
			 Scanner inScanner  = new Scanner(System.in))
		{
			System.out.println("Introduce un mensaje de entrada: ");
			String mensaje = inScanner.nextLine();
			System.out.println("Introduce un nº veces a escribir el mensaje: ");
			int repeticion = inScanner.nextInt();
			for (int i = 0; i < repeticion; i++)
				//escribir el mensaje en stream
				out.write("Mensaje " + (i+1) +" " + mensaje + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}