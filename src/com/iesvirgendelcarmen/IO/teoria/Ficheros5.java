package com.iesvirgendelcarmen.IO.teoria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*10 (salto de linea) o 32 (espacio en blanco)
 * cambiamos a
 * 45 (guion) */

public class Ficheros5 {
	public static void main(String[] args) {
		File inFile = new File("ficherosEntrada/uno.txt");
		File outFile = new File("ficherosSalida/salida2.txt");
		try (FileInputStream in = new FileInputStream(inFile);FileOutputStream out = new FileOutputStream(outFile);){
			int c;
			while ((c = in.read()) != -1) {
				if (c == 10 || c == 32) {
					//c = 45;
					out.write(45);
				} else {
					out.write(c);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
