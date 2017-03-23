package com.iesvirgendelcarmen.IO.ejercicios;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicios1 {
	public static void main(String[] args) {
		/*try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("FicherosSalida/numeros.dat"));PrintWriter out2 = new PrintWriter("FicherosSalida/numeros.txt");){
			for (int i = 0; i < 20; i++) {
				int numeros = (int)(Math.random()*21)+20;
				System.out.println(numeros);
				out2.printf("%d, ",numeros);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el fichero");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Error I/O");
		}*/
		int[] arrayNumeros = generar20NumerosAleatoriosEntre20Y40();
		/*for (int numero : arrarNumeros) {
			System.out.println(numero);
		}*/
		generarFicheroBinario(arrayNumeros);
		generarFicheroTexto(arrayNumeros);
	}
	public static int[] generar20NumerosAleatoriosEntre20Y40() {
		int[] numerosAleatorios = new int[20];
		for (int i = 0; i < 20; i++) {
			int numero = (int)(Math.random()*21)+20;
			numerosAleatorios[i] = numero; 
		}
		return numerosAleatorios;
	}
	public static void generarFicheroBinario(int[] arrayNumeros){
		try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("FicherosSalida/numeros.dat")));){
			for (int numero : arrayNumeros) {
				out.writeInt(numero);
				out.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas con el fichero.");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void generarFicheroTexto(int[] arrayNumeros) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter("FicherosSalida/numeros.txt"));){
			String cadenaSalida = "";
			for (int numero : arrayNumeros) {
				cadenaSalida += numero + "-";
				/*out.write("-"+numero);
				out.flush();*/
			}
			out.write(cadenaSalida.substring(0, cadenaSalida.length() -1));
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas con el fichero.");
		}
	}
}
