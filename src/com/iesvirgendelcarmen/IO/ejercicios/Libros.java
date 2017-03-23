package com.iesvirgendelcarmen.IO.ejercicios;

public class Libros {
	//atributos
	private String isbn;
	private String titulo;
	private double precio;
	//constructor
	public Libros(String isbn, String titulo, double precio) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "ISBN=" + isbn + " Titulo=" + titulo + " Precio=" + precio;
	}
	
	
}
