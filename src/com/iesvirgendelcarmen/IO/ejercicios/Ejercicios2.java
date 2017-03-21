package com.iesvirgendelcarmen.IO.ejercicios;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicios2 {
	public static void main(String[] args) {
		int [] arrayEnteros = leerArraydeIntdeFicheroBinario("FicherosSalida/numeros.dat");
		//System.out.println(Arrays.toString(arrayEnteros));
		//leerFicheroTexto();
		System.out.printf("Valor medio de los datos del array vale %.2f\n",calcularValorMedio(arrayEnteros));
	}
	public static int[] leerArraydeIntdeFicheroBinario(String nombreFichero) {
		int[] numeros = new int[20];
		try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(nombreFichero)));){
			int numero;
			int contador = 0;
			while (in.available() != 0 ) {
				numero = in.readInt();
				numeros[contador] = numero;
				contador++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el fichero.");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Error I/O.");
		}
		return numeros;
	}
	public static double calcularValorMedio(int[] arrayEnteros) {
		double suma = 0;
		for (int numero : arrayEnteros) {
			suma += numero;
		}
		return 1.0 *suma/arrayEnteros.length;
	}
}
