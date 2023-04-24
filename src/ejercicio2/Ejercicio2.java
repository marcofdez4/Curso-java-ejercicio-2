package ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Empleado emp1 = new Empleado("Marco", "Fernandez", 24, "Sevilla", null, null, null);
		Empleado emp2 = new Empleado("Pablo", "Calle", 24, "Sevilla", null, null, null);
		Empleado emp3 = new Empleado("Miguel", "Reyes", 24, "Sevilla", null, null, null);
		int posicionIngreso = 0;

		List<Empleado> lemp = new ArrayList<>();
		lemp.add(emp1);
		lemp.add(emp2);
		lemp.add(emp3);

		int menu = 99;
		while (menu != 0) {
			System.out.println(
					"Ingrese una operacion:\n" + "0. Salir\n" + "1. agregar empleado\n" + "2. Generar archivo");

			menu = sc.nextInt();
			switch (menu) {
			case 0:
				System.out.println("Saliste del programa, Buen dia!");
				break;
			case 1:
				if(posicionIngreso < 3) {
					try {
						System.out.println("Ingresando empleado: " + (posicionIngreso + 1));
						System.out.println("Ingrese posicion:");
						String posicion = sc.next();
						System.out.println("Ingrese salario (por ejemplo, 1200,05):");
						double salario = sc.nextDouble();
						System.out.println("Ingrese fecha de ingreso con formato dd-MM-YYYY:");
						String fechaIngresoS = sc.next();
						Empleado emp = lemp.get(posicionIngreso);
						emp.setPosicion(posicion);
						emp.setSalario(salario);
						String[] fechas = fechaIngresoS.split("-");
						List<Integer> fechasI = new ArrayList<>();
						for (String f : fechas) {
							Integer fe = Integer.valueOf(f);
							fechasI.add(fe);
						}
						LocalDate fechaIngreso = LocalDate.of(fechasI.get(2), fechasI.get(1), fechasI.get(0));
						emp.setFechaIngreso(fechaIngreso);
						System.out.println("Empleado añadido!");
						
						lemp.set(posicionIngreso, emp);
						posicionIngreso++;
					}
					catch(Exception ex) {
						System.out.println("Dato erroneo!");
					}
				}
				else {
					System.out.println("Has llegado al tope de empleados");
				}
				break;
			case 2:
				try {
					String ruta = "C:\\Users\\mafernandezgon\\Desktop\\workspace_eclipse\\Ejercicio2\\";
					String nombreArchivo = "informacion_empleado_fechaDeHoy.txt";
					String nombreRutaArchivo = ruta + nombreArchivo;

					File archivo = new File(nombreRutaArchivo);
					if (!archivo.exists()) {
						archivo.createNewFile();
					}
					
					
					FileWriter fw= new FileWriter(archivo);
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(int i=0;i<posicionIngreso;i++) {
						Empleado empFi=lemp.get(i);
						String textoFichero = "Nombre: "+empFi.getNombre()+" Apellido: "+empFi.getApellido()
								+ " Ciudad: "+empFi.getCiudad()+" Edad: "+empFi.getEdad()
								+ " Posicion: "+empFi.getPosicion()+" Salario: "+empFi.getSalario()
								+ " Fecha de ingreso: "+empFi.getFechaIngreso()+" Salario neto: "+empFi.calculaSalario()+"\n";
						bw.write(textoFichero);
					}
					System.out.println("Archivo creado");
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("acción erronea");
				
			}
		}
	}
}
