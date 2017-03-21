package com.iesvirgendelcarmen.IO.teoria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*Vamos a escribir en un fichero los bytes de
 * un String. Volcamos bytes a bytes los caracteres
 * de dicho String
 */

public class Ficheros4 {
	
	public static void main(String[] args) {
		//Cadena a volcar en el fichero de texto
		String cadena = "Esto es una cadena\n Añado un caracter con acento á o ó";
		//convertimos la cadena a un array de bytes
		byte[] bytesString = cadena.getBytes();
		System.out.println(Arrays.toString(bytesString));
		//descriptor para el fichero de salida
		File outfile = new File("ficherosSalida/salida1.txt");
		//creamos el flujo de salida
		try (FileOutputStream out = new FileOutputStream(outfile, true);){
			out.write(72);
			out.write(79);
			out.write(76);
			out.write(65);
			//out.write(83);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
