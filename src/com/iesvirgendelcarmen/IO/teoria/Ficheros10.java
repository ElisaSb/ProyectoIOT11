package com.iesvirgendelcarmen.IO.teoria;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/* Vamos a realizar lectura/escritura de ficheros 
 * de forma aleatoria, trabajamos con la clase 
 * RandomAccessFile
 */
public class Ficheros10 {

	public static void main(String[] args) {
		//creamos el RandomAccessFile
		try (RandomAccessFile inOut = new RandomAccessFile(
				"ficherosSalida/ficheroRandom.dat","rw");)
		{
			//escribimos el mensaje Hola
			inOut.write(72); //H
			inOut.write(111); //o
			inOut.write(108); //l
			inOut.write(97); //a
			inOut.write(10); //salto de l�nea
 			System.out.println("Tama�o del fichero: " +
					inOut.length() + " bytes");
 			//situamos el puntero al principio
 			inOut.seek(0); //puntero al principio del fichero
 			String linea = inOut.readLine();
 			System.out.println("L�nea leida: " + linea);
 			inOut.write(72); //H
			inOut.write(111); //o
			inOut.write(108); //l
			inOut.write(97); //a
			inOut.write(115); //s
			inOut.write(10); //salto de l�nea
			inOut.seek(5); //el puntero est� en el principio
			//de la segunda l�nea
			linea = inOut.readLine();
 			System.out.println("L�nea leida: " + linea);
 			//Ahora el puntero est� al final del fichero
 			//A�adir 10 n�mero enteros de forma aleatoria
 			Random random = new Random();
 			for (int i = 0; i < 10; i ++){
 				//generamos aleatorio del 1 al 10
 				int numeroAleatorio = random.nextInt(10) + 1; 
 				System.out.print(numeroAleatorio +"  ");
 				inOut.writeInt(numeroAleatorio);
 			}
 			System.out.println("\nTama�o del fichero: " +
					inOut.length() + " bytes");
 			//vamos a leer los n�mero enteros
 			//Ahora el puntero est� al final del fichero
 			inOut.seek(11); //lo colamos al final de los chars
 			for (int i = 0; i < 10; i++){
 				int numero = inOut.readInt();
	 			System.out.printf("N�mero leido: %d%n", numero);
	 			
 			}
 			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e1) {
			System.out.println("Error I/O");
		}	

	}

}