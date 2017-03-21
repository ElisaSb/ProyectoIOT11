package com.iesvirgendelcarmen.IO.teoria;
//clase ejemplo, para que convertirla en un flujo (stream)
//como la clase genera objetos seria Object(Input/Output)Stream
//para que se pueda hacer dicha clase debe implementar una interfaz
//llamada serializable
public class Persona {
	//atributos
	private String nombreCompleto;
	private int edad;
	private boolean sexo; //true si es hombre, false si es mujer
	//constructor
	public Persona(String nombreCompleto, int edad, boolean sexo) {
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.sexo = sexo;
	}
	//getters y setters
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		return nombreCompleto + ", " + edad + " años, hombre: " + sexo;
	}
	
}
