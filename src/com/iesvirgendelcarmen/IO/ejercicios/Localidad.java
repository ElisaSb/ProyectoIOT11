package com.iesvirgendelcarmen.IO.ejercicios;

public class Localidad {
	private String idLocalidad;
	private double latitudLocalidad;
	private double longitudLocalidad;
	private double altitudLocalidad;
	private String nombreLocalidad;
	private String urlLocalidad;
	private int ano;
	
	public Localidad(String idLocalidad, double latitudLocalidad, double longitudLocalidad, double altitudLocalidad,
			String nombreLocalidad, String urlLocalidad, int ano) {
		this.idLocalidad = idLocalidad;
		this.latitudLocalidad = latitudLocalidad;
		this.longitudLocalidad = longitudLocalidad;
		this.altitudLocalidad = altitudLocalidad;
		this.nombreLocalidad = nombreLocalidad;
		this.urlLocalidad = urlLocalidad;
		this.ano = ano;
	}

	public double getLatitudLocalidad() {
		return latitudLocalidad;
	}

	public double getLongitudLocalidad() {
		return longitudLocalidad;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}
	
	@Override
	public String toString() {
		return "Localidad [idLocalidad=" + idLocalidad + ", latitudLocalidad=" + latitudLocalidad
				+ ", longitudLocalidad=" + longitudLocalidad + ", altitudLocalidad=" + altitudLocalidad
				+ ", nombreLocalidad=" + nombreLocalidad + ", urlLocalidad=" + urlLocalidad + ", ano=" + ano + "]";
	}
}
