package cml.ejercicio1.metodos;

import java.text.ParseException;

import java.util.ArrayList;

import java.util.Scanner;

import cml.ejercicio1.entidad.Paciente;


public class Agregar {
	private static Scanner scanIn;
	

private ArrayList<Paciente> pacientes;
	public Agregar(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	public void agregarPaciente() throws ParseException {
		scanIn = new Scanner(System.in);

	
		System.out.println("Ingrese Dato Cliente RUT:");
		String rut = scanIn.nextLine();
		if (existePaciente(rut)) {
			
			System.out.println("El paciente ya existe");
			
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
					 
			Paciente newPaciente = new Paciente(rut, nombre, apellido, edad, estadoCovid, fechaDeContagio);
			pacientes.add(newPaciente);
			
	}

	}
	public boolean existePaciente(String rut) {
		boolean encontrado = false; 
		int i=0;
		
		while (i <  pacientes.size() && !encontrado) {
		
			encontrado = pacientes.get(i).getRut().equals(rut);
			i = i + 1;
				
		}
		return encontrado;
	}
	
		

}
