package cml.ejercicio1.entidad;

import java.util.Date;

public class Paciente {
	
	String rut;	
	String nombre;
	String apellido;
	int edad;
	boolean estadoCovid;
	String fechaDeContagio;
	
	public Paciente(String rut, String nombre, String apellido, Integer edad, boolean estadoCovid, String fechaDeContagio ) {
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.estadoCovid = estadoCovid;
		this.fechaDeContagio = fechaDeContagio; 
	
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isEstadoCovid() {
		return estadoCovid;
	}

	public void setEstadoCovid(boolean estadoCovid) {
		this.estadoCovid = estadoCovid;
	}

	public String getFechaDeContagio() {
		return fechaDeContagio;
	}

	public void setFechaDeContagio(String fechaDeContagio) {
		this.fechaDeContagio = fechaDeContagio;
	}

	public static int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Object get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Paciente remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
