package com.iesvirgendelcarmen.IO.teoria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Usando un bufferedreader leemos desde un fichero de texto
 
public class Ficheros12 {

	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(
					new FileReader("ficherosSalida/filewriter1.txt"));) {
			//leemos una línea del fichero
			/*String mensajeLeido = in.readLine();
			System.out.println("Mensaje leido: " + mensajeLeido);
			mensajeLeido = in.readLine();*/
			String mensajeLeido;
			while ((mensajeLeido = in.readLine()) != null) 
				System.out.println("Mensaje leido: " + mensajeLeido);
		} catch (FileNotFoundException e) {
			System.out.println("Error en el fichero");
		} catch (IOException e1) {
			System.out.println("Error I/O");

		}

	}

}
