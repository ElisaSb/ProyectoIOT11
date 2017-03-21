package com.iesvirgendelcarmen.IO.teoria;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/* ejemplo sencillo de uso del printwriter
 * Usado para escribir datos formateados
 * en un fichero de TEXTO
 * El formateo lo vamos a hacer con un printf
 */
public class Ficheros13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] personas = {"juan jiménez" , "pedro ramírez", 
				"luisa fernández" , "maría garcía"};
		int[] edad        = {23, 22, 34, 21};
		double[] altura   = {1.55, 1.78, 1.88, 2.00};
		double[] peso     = {56.21, 71.8, 85,3, 80};
		//declaramos un printwriter
		try (PrintWriter out = new PrintWriter("ficherosSalida/printwriter1.txt");
) 		{
			out.printf("%9s%12s%8s%7s%n",
					"NOMBRE", "EDAD", "ALTURA", "PESO");
			for (int i = 0; i < personas.length; i++)
				out.printf("%-15s%6d%8.2f%7.2f%n",
						personas[i], edad[i], altura[i], peso[i]);
				out.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%9s%12s%8s%7s%n",
					"NOMBRE", "EDAD", "ALTURA", "PESO");
		for (int i = 0; i < personas.length; i++)
			System.out.printf("%-15s%6d%8.2f%7.2f%n",
					personas[i], edad[i], altura[i], peso[i]);
	}

}
