package com.iesvirgendelcarmen.IO.ejercicios;

import java.util.List;

public class Mapa {
	//atributos
	private List<Localidad> listaLocalidades;
	//getters and setters
	public List<Localidad> getListaLocalidad() {
		return listaLocalidades;
	}
	
	public void setLilstaLocalidades(List<Localidad> listaLocalidades) {
		this.listaLocalidades = listaLocalidades;
	}
	
	//metodos
	public void addLocalidad(Localidad localidad) {
		listaLocalidades.add(localidad);
	}
	public String toString() {
		return "listaLocalidades = " + listaLocalidades;
	}
	public double[] obtenerPosicion(String nombreLocalidad){
		double[] posicion = new double[2];
		for (Localidad localidad : listaLocalidades) {
			if (nombreLocalidad.equals(localidad.getNombreLocalidad())){
				posicion[0] = localidad.getLatitudLocalidad();
				posicion[1] = localidad.getLongitudLocalidad();
			}
		}
		return posicion;
	}
}
