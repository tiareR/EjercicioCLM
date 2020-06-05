package cml.ejercicio1.metodos;

import java.util.ArrayList;
import java.util.Scanner;

import cml.ejercicio1.entidad.Paciente;

public class Modificar {
	private static Scanner scanIn;

	private ArrayList<Paciente> pacientes;
	
	public Modificar(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
		
	}
	public void modificarPaciente() {
		scanIn = new Scanner(System.in);

		
		System.out.println("Ingrese Dato Cliente RUT:");
		String rut = scanIn.nextLine();
		Paciente paciente = buscarPaciente(rut);
		if (paciente == null) {
			
			System.out.println("El paciente no existe");
			
			}
		
		else {
			System.out.println("Ingrese NOMBRE:");
			String nombre = scanIn.nextLine();
			System.out.println("Ingrese APELLIDO:");
			String apellido = scanIn.nextLine();
			System.out.println("Ingrese  EDAD:");
			Integer edad = Integer.parseInt(scanIn.nextLine());
			System.out.println("Ingrese  ESTADO COVID:");
			Boolean estadoCovid = Boolean.parseBoolean(scanIn.nextLine());
			String fechaDeContagio = "1-1-1";
			if (estadoCovid) {
				System.out.println("Ingrese FECHA CONTAGIO:");
				 fechaDeContagio = scanIn.nextLine();

			}
			paciente.setApellido(apellido);
			paciente.setNombre(nombre);
			paciente.setEdad(edad);
			paciente.setEstadoCovid(estadoCovid);
			paciente.setFechaDeContagio(fechaDeContagio);
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
