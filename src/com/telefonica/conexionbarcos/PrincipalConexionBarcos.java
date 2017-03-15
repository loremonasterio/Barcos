package com.telefonica.conexionbarcos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.telefonica.barcos.Barco;

public class PrincipalConexionBarcos {
	public static void main(String[] args) throws SQLException {
		ConexionBarcos conexion = new ConexionBarcos("barcos","root","");
		ConsultasBarcos consultas = new ConsultasBarcos(conexion);
		Scanner teclado = new Scanner(System.in);
		String opcion = "";
		String tipoBarco = "";
		ArrayList<Barco> carrera = new ArrayList<Barco>();
		while (!opcion.equals("99")){
			System.out.println("");
			System.out.println("--------------------------------------------------------------");
			System.out.println("Bienvenido, elija una de las siguientes opciones, guapi:");
			System.out.println("1 - Crear Barco");	
			System.out.println("2 - Crear Puerto");	
			System.out.println("3 - Mostrar Barcos");	
			System.out.println("4 - Mostrar Puertos");	
			System.out.println("5 - Entrada de Barco a Puerto");	
			System.out.println("6 - Salida de Barco a Puerto");	
			System.out.println("7 - Carrera de barcos");	
			System.out.println("99 - Salir");
			opcion = teclado.nextLine();
			switch(opcion){
				case "1":	System.out.println("Introduce el modelo");
							System.out.println("--------------------------------------------------------------");
							System.out.println("1. Velero");
							System.out.println("2. Fragata");
							System.out.println("3. Portaaviones");
							String Modelo = teclado.nextLine();
							switch (Modelo) {
							case "1":
									tipoBarco = "velero";
								break;
							case "2":
								tipoBarco = "fragata";
							break;
							case "3":
								tipoBarco = "portaaviones";
							break;
							default:
								System.out.println("Opción elegida incorrecta, guapi");
								break;
							}
							System.out.println("Indica la descripción");
							String Descripcion = teclado.nextLine();	
							System.out.println("Indica la matricula");
							String Matricula = teclado.nextLine();	
							if(consultas.createBarco(tipoBarco, Descripcion, Matricula) != -1){
								System.out.println("Barco creado correctamente");
							}else{
								System.out.println("Ha ocurrido un problema al crear el barco");
							}							
							break;
				case "2":	System.out.println("Introduce el nombre del puerto");
							String nombrePuerto = teclado.nextLine();
							System.out.println("Introduce la localización del puerto");
							String localizacionPuerto = teclado.nextLine();
							if(consultas.createPuerto(nombrePuerto, localizacionPuerto) != -1){
								System.out.println("Puerto creado correctamente");
							}else {
								System.out.println("Ha ocurrido un error al crear el puerto");
							}
							break;
				case "3":	System.out.println("Mostrando los Barcos disponibles...");
							System.out.println("--------------------------------------------------------------");
							consultas.showBarcosDisponibles();
							break;
				case "4":	System.out.println("Mostrando puertos disponibles...");
							System.out.println("--------------------------------------------------------------");
							consultas.showPuertosDisponibles();
							break;
				case "5": 	System.out.println("Estos son los Barcos disponibles...");
							System.out.println("--------------------------------------------------------------");
							consultas.showIdBarcos();
							System.out.println("Introduce el id del barco: ");
							int id_barco = Integer.parseInt(teclado.nextLine());
							System.out.println("Estos son los puertos disponibles...");
							System.out.println("--------------------------------------------------------------");
							consultas.showIdPuertos();
							System.out.println("Introduce el id del puerto: ");
							int id_puerto = Integer.parseInt(teclado.nextLine());
							System.out.println("Introduce el peaje: ");
							int peaje = Integer.parseInt(teclado.nextLine());
							if(consultas.atracarBarco(id_barco, id_puerto, peaje) != -1){
								System.out.println("Barco atracado correctamente");
							}else{
								System.out.println("Ha ocurrido un problema al atracar el Barco");
							}
							break;
				case "6":	System.out.println("Estos son los barcos atracados: ");
							System.out.println("--------------------------------------------------------------");
							consultas.showEntradas();
							System.out.println("Introduce el ID del barco que quieres que salga");
							int id_barco_salida = Integer.parseInt(teclado.nextLine());
							System.out.println("Introduce el ID del puerto que quieres que salga");
							int id_puerto_salida = Integer.parseInt(teclado.nextLine());
							if(consultas.salidaBarco(id_barco_salida, id_puerto_salida) != -1){
								System.out.println("Salida de barco correcta");
							}else{
								System.out.println("Ha ocurrido un error en la salida del barco del puerto");
							}
							break;
				case "7":	System.out.println("Estos son los puertos con barcos atracado: ");
							System.out.println("--------------------------------------------------------------");
							consultas.showEntradas();
							System.out.println("Introduce el id del puerto en el que quieres que suceda la carrera: ");
							int id_puerto_carrera = Integer.parseInt(teclado.nextLine());
							carrera=consultas.generarCarrera(id_puerto_carrera);
							System.out.println("Generando carrera en el puerto con el id 11");
							consultas.lanzarCarrera(carrera);
					
							break;
				case "99":	System.out.println("Saliendo del programa... guapi");
							consultas.cerrarConexion();
							break;
				default:	System.out.println("Opción elegida incorrecta, guapi");
				break;
			}
		}
	}
	
}
