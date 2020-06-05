package cml.ejercicio1.metodos;

import java.util.ArrayList;
import java.util.Scanner;

import cml.ejercicio1.entidad.Paciente;

public class Eliminar {
	private static Scanner scanIn;
	private ArrayList<Paciente> pacientes;
	public Eliminar(ArrayList<Paciente> pacientes) {
	this.pacientes = pacientes;	
		
	}
	
	public void eliminarPaciente() {
		scanIn = new Scanner(System.in);
		System.out.println("Ingrese Dato Cliente RUT:");
		String rut = scanIn.nextLine();
	    
		Paciente paciente = buscarPaciente(rut);
		if (paciente!=null) {
			pacientes.remove(paciente);
		}
	} 
	public Paciente buscarPaciente(String rut) {
		for (Paciente paciente : pacientes) {
	        if (paciente.getRut().equals(rut)) {
	            return paciente;
	        }
	    }
	    return null;
		
	}
	
}
