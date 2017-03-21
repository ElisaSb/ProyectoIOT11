package com.iesvirgendelcarmen.IO.teoria;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Vamos a escribir datos formateados a un fichero
//no escribimos bytes, sino datos como int, double, boolean
//incluso cadenas
public class Ficheros7 {

	public static void main(String[] args) {
		//Generamos el stream salida sobre un fichero
		//debemos usar la clase DataOutputStream
		//y lo hacemos sobre un buffer para que sea mas eficiente
		try (DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									"ficherosSalida/formateado1.dat")));)
		{
			int numeroEntero = 1200;
			double numeroDouble = 2.25;
			char caracter = 'a';
			boolean tipoBoolean = true;
			String cadena = "esto es una cadena";
			out.writeInt(numeroEntero);
			out.writeDouble(numeroDouble);
			out.writeChar(caracter);
			out.writeBoolean(tipoBoolean);
			out.writeUTF(cadena);
		} catch (FileNotFoundException e) {
			System.out.println("No puedo acceder al fichero");
		} catch (IOException e1) {
			System.out.println("Error IO");

		}
		//****************************************************
		//vamos a leerlos usando InputStream
		try (BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(
							"ficherosSalida/formateado1.dat"));)
		{//vamos a mostrar los bytes a la salida estándar
			int c;
			while ((c = in.read()) != -1)
				System.out.println((char)c);
			
		} catch (FileNotFoundException e) {
			System.out.print("No puedo acceder al fichero");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Error IO");
		}
		//******************************************************
		//Vamos a leerlos usando un datainputstream
		try (DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(
							"ficherosSalida/formateado1.dat")));)
		{
			int numeroIntLeido = in.readInt();
			double numeroDoubleLeido = in.readDouble();
			char caracterLeido = in.readChar();
			boolean booleanLeido = in.readBoolean();
			String cadenaLeida = in.readUTF();
			System.out.println("Entero: " + numeroIntLeido);
			System.out.println("Double: " + numeroDoubleLeido);
			System.out.println("Caracter: " + caracterLeido);
			System.out.println("Boolean: " + booleanLeido);
			System.out.println("Cadena: " + cadenaLeida);

		} catch (FileNotFoundException e) {
			System.out.print("No puedo acceder al fichero");
		} catch (IOException e1) {
			System.out.println("Error IO");
		}
		
		
		
		
		
		
		
		
		
	}

}