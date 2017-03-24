package com.iesvirgendelcarmen.IO.ejercicios;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Ejercicios3 {
	public static void main(String[] args) {
		int[] arrayNumeros = Ejercicios1.generar20NumerosAleatoriosEntre20Y40();
		generarFicheroSalida(arrayNumeros);
		generarFicheroSalidaBinario(arrayNumeros);
		int [] arrayEnteros = leerFicheroSalida("FicherosSalida/numeros2.dat");
		System.out.println(Arrays.toString(arrayEnteros));
		System.out.printf("Valor medio de los datos del array vale %.2f\n",Ejercicios2.calcularValorMedio(arrayEnteros));
		int [] arrayEnteros2 = leerFicheroSalidaBinario("FicherosSalida/numeros2Binario.dat");
		System.out.println(Arrays.toString(arrayEnteros2));
		System.out.printf("Valor medio de los datos del array vale %.2f\n",Ejercicios2.calcularValorMedio(arrayEnteros2));
	}
	public static void generarFicheroSalida(int[] arrayNumeros) {
		try (RandomAccessFile out = new RandomAccessFile("FicherosSalida/numeros2.dat", "rw");){
			String cadenaSalida = "";
			for (int numero : arrayNumeros) {
				cadenaSalida += numero + "-";
			}
			out.writeBytes(cadenaSalida.substring(0, cadenaSalida.length() -1));
		} catch (FileNotFoundException e) {
			System.out.println("Error fichero no encontrado");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}
	}
	public static void generarFicheroSalidaBinario(int[] arrayNumeros) {
		try (RandomAccessFile out = new RandomAccessFile("FicherosSalida/numeros2Binario.dat", "rw");){
			for (int numero : arrayNumeros) {
				out.writeInt(numero);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error fichero no encontrado");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}
	}
	public static int[] leerFicheroSalida(String rutaFichero) {
		int[] numeros = new int[20];
			try (RandomAccessFile in = new RandomAccessFile(rutaFichero, "r");){
				String lineaNumeros = in.readLine();
				String[] cadenaNumeros = lineaNumeros.split("-");
				int indice = 0;
				for (String cadenas : cadenaNumeros) {
					numeros[indice] = Integer.parseInt(cadenas);
					indice++;
				}
			} catch (FileNotFoundException e) {
				System.out.println("Error fichero no encontrado");
			} catch (IOException e1) {
				System.out.println("Error I/O.");
			}
		return numeros;
	}
	public static int[] leerFicheroSalidaBinario(String rutaFichero) {
		int[] numeros = new int[20];
			try (RandomAccessFile in = new RandomAccessFile(rutaFichero, "rw");){
				int numero;
				int contador = 0;
				while (true) {
					try{
						numero = in.readInt();
						numeros[contador] = numero;
						contador++;
					}catch (EOFException e){
						System.out.println("Fin de lectura de fichero");
						break;
					}
				}
			} catch (IOException e) {
				System.out.println("Error I/O.");
			}
		return numeros;
	}
}