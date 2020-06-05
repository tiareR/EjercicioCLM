package cml.ejercicio1;

import cml.ejercicio1.entidad.Paciente;
import cml.ejercicio1.metodos.Agregar;
import cml.ejercicio1.metodos.Eliminar;
import cml.ejercicio1.metodos.Modificar;
import cml.ejercicio1.metodos.Opciones;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class Ejecutor {
	private static Scanner scanIn;
	private static ArrayList<Paciente> pacientes;
	private static List<String> contentFile;
	private static String  filename = "C:/input/input.txt";
	
	public static void main(String[] args) throws ParseException {
		contentFile=new ArrayList<String>();
		pacientes=new ArrayList<Paciente>();
		cargarArchivoPacientes(filename);
		Opciones options = new Opciones();
		Agregar agregar = new Agregar(pacientes);
		Eliminar eliminar = new Eliminar(pacientes);
		Modificar modificar = new Modificar(pacientes);
		
		
		Integer opcion = 0;
				
		while (opcion != 4 ) {	
			
			options.mostrarOpciones();
			scanIn= new Scanner(System.in);
			 opcion = Integer.parseInt(scanIn.nextLine());
			
			switch(opcion) 
	        { 
	            case 1: 
	                System.out.println("Agregar Paciente"); 
	                agregar.agregarPaciente();
	                break; 
	            case 2: 
	                System.out.println("Modificar Paciente");
	                modificar.modificarPaciente();
	                break; 
	            case 3: 
	                System.out.println("Eliminar Paciente"); 
	                eliminar.eliminarPaciente();
	                break; 
	            case 4: 
	                System.out.println(opcion); 
	                break; 
	            default: 
	                System.out.println("no match"); 
	        }
			
		}
			
		 	System.out.println("Has Salido"); 
		 	llenarContentFile();
		 	guardarArchivo();
	
		}
	
	public static void cargarArchivoPacientes(String rutaArchivoPacientes) throws ParseException {
	
		try {
			List<String> fileInput = Files.readAllLines(new File(rutaArchivoPacientes).toPath());
			for (String line : fileInput) {
				String[] arguments = line.split(",");
				if (arguments.length > 0) {
									
					String rut = arguments[0].trim();
					String nombre = arguments[1].trim();
					String apellido = arguments[2].trim();
					int edad = Integer.parseInt(arguments[3].trim());
					Boolean estadoCovid = Boolean.parseBoolean(arguments[4].trim());
					String fechaDeContagio = arguments[5].trim();
					
					Paciente newPaciente = new Paciente(rut, nombre, apellido, edad, estadoCovid, fechaDeContagio);
					pacientes.add(newPaciente);
					
				      
				}

			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		
		
	}
	public static void guardarArchivo() {

		try {
			String result = contentFile.stream().collect(Collectors.joining(", "));
			result = result.replace("\r\n,","\r\n");
			Files.write(new File(filename).toPath(), result.getBytes(), StandardOpenOption.WRITE);
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}
	public static void llenarContentFile() {
		if (!pacientes.isEmpty()) {
			for (Paciente paciente : pacientes) {
				contentFile.add(paciente.getRut());
				contentFile.add(paciente.getNombre());
				contentFile.add(paciente.getApellido());
				contentFile.add(String.valueOf(paciente.getEdad()));
				contentFile.add(String.valueOf(paciente.isEstadoCovid()));
				contentFile.add(String.valueOf(paciente.getFechaDeContagio()));
				
				contentFile.add("\r\n");
			
			}
			
			
		}
	}

}




