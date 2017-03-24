package com.iesvirgendelcarmen.IO.ejercicios;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LeerLibros {
	public static void main(String[] args) {
		//leer los libros del csv y devolver la coleccion de objetos
		//comprobar que leemos correctamente el fichero
		leerCSV("ficherosEntrada/carpeta1/Libros.csv");
		//crear la lista de objetos Libro diferentes.
		   
	}
	public static void leerCSV(String rutaCSV) {
		List<String> coleccionLineas = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(rutaCSV), "iso-8859-1"));){
			String linea;
			while ((linea = in.readLine()) != null) {
				//System.out.println(linea);
				coleccionLineas.add(linea);
			}
			coleccionLineas.remove(0);
			//System.out.println(coleccionLineas);
			parsearColeccionLineas(coleccionLineas);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Codificación no soportada o fichero no encontrado");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Error I/O");
		}
	}
	public static void parsearColeccionLineas(List<String> coleccionLineas) {
		List<Libros> listaLibros = new ArrayList<>();
		for (String linea : coleccionLineas) {
			String[] campos = linea.split(";");
			/*System.out.println(campos[0] +"-"+ campos[2] +"-"+ Double.parseDouble(campos[10].substring(2).replace(',','.')));*/
			Libros libro = new Libros(campos[0],campos[2],Double.parseDouble(campos[10].substring(2).replace(',','.')));
			listaLibros.add(libro);
			System.out.println(listaLibros);
		}
	}
}












