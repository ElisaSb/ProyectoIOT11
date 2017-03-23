package com.iesvirgendelcarmen.IO.ejercicios;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicios2 {
	public static void main(String[] args) {
		int [] arrayEnteros = leerArraydeIntdeFicheroBinario("FicherosSalida/numeros.dat");
		//System.out.println(Arrays.toString(arrayEnteros));
		//leerFicheroTexto();
		System.out.printf("Valor medio de los datos del array vale %.2f\n",calcularValorMedio(arrayEnteros));
		int [] arrayEnteros2 = leerArraydeIntdeFicheroTexto("FicherosSalida/numeros.txt");
		System.out.printf("Valor medio de los datos2 del array vale %.2f\n",calcularValorMedio(arrayEnteros2));
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
	public static int[] leerArraydeIntdeFicheroTexto(String nombreFichero) {
		int[] numeros = new int[20];
		try (BufferedReader in = new BufferedReader(new FileReader("FicherosSalida/numeros.txt"));){
				String lineaNumeros = in.readLine();
				//System.out.println(lineaNumeros);
				String[] cadenaNumeros = lineaNumeros.split("-");
				int indice = 0;
				for (String cadenas : cadenaNumeros) {
					//System.out.println(cadenas);
					numeros[indice] = Integer.parseInt(cadenas);
					indice++;
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el fichero");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Error I/O");
		}
		return numeros;
	}
}
