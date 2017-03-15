package com.telefonica.conexionbarcos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.telefonica.barcos.Barco;
import com.telefonica.barcos.Fragata;
import com.telefonica.barcos.Portaaviones;
import com.telefonica.barcos.Velero;

public class ConsultasBarcos {
	Connection con = null;
	
	public ConsultasBarcos(ConexionBarcos con){
		this.con = con.getConexion();
	}
	
	public int createBarco(String modelo, String descripcion, String matricula){
		try {
			String query = "insert into barco (modelo, descripcion, matricula)"+"values (?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, modelo );
			preparedStmt.setString(2, descripcion );
			preparedStmt.setString(3, matricula );
			preparedStmt.execute();
			ResultSet rs = preparedStmt.getGeneratedKeys();
			if (rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return -1;
	}
	
	public int createPuerto(String nombre, String localizacion){
		try {
			String query = "insert into puerto (nombre, localizacion)"+"values (?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, nombre );
			preparedStmt.setString(2, localizacion );
			preparedStmt.execute();
			ResultSet rs = preparedStmt.getGeneratedKeys();
			if (rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return -1;
	}
	
	public void showBarcosDisponibles(){
		try {
			String query = "select * from barco";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				System.out.println("Modelo: "+rs.getString("modelo"));
				System.out.println("Descripción: "+rs.getString("descripcion"));
				System.out.println("Matricula: "+rs.getString("matricula"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}
	}
	
	public void showPuertosDisponibles(){
		try {
			String query = "select * from puerto";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				System.out.println("Nombre: "+rs.getString("nombre"));
				System.out.println("Localización: "+rs.getString("localizacion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}
	}
	
	public int atracarBarco(int id_barco, int id_puerto, int peaje){
		try {
			String query = "insert into entrada (id_puerto, id_barco, fecha_entrada, peaje)"+"values (?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStmt.setInt(1, id_puerto);
			preparedStmt.setInt(2, id_barco);
			Date date = new Date();
			String diaActual= new SimpleDateFormat("yyyy-MM-dd").format(date);
			preparedStmt.setString(3, diaActual);
			preparedStmt.setInt(4, peaje);
			preparedStmt.execute();
			ResultSet rs = preparedStmt.getGeneratedKeys();
			if (rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return -1;
	}
	
	public void showIdBarcos(){
		try {
			String query = "select * from barco";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				System.out.println("Modelo: "+rs.getString("modelo")+" Descripción: "+rs.getString("descripcion"));
				System.out.println("ID Barco: "+rs.getString("id_barco"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}
	}
	public void showIdPuertos(){
		try {
			String query = "select * from puerto";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				System.out.println("Nombre: "+rs.getString("nombre")+" Localización: "+rs.getString("localizacion"));
				System.out.println("ID Puerto: "+rs.getString("id_puerto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}
	}
	
	public int salidaBarco(int id_barco, int id_puerto){
		try {
			String query = "insert into salida (id_puerto, id_barco,fecha_salida)"+"values (?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStmt.setInt(1, id_puerto);
			preparedStmt.setInt(2, id_barco);
			Date date = new Date();
			String diaActual= new SimpleDateFormat("yyyy-MM-dd").format(date);
			preparedStmt.setString(3, diaActual);
			preparedStmt.execute();
			ResultSet rs = preparedStmt.getGeneratedKeys();
			if (rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return -1;
	}
	
	public void showEntradas(){
		try {
			String query = "select * from entrada";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				System.out.println("ID Puerto: "+rs.getString("id_puerto")+" ID Barco: "+rs.getString("id_barco"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}
	}
	
	public ArrayList<Barco> generarCarrera(int id_puerto){
		ArrayList<Barco> array = new ArrayList<Barco>();
		try {
			String query = "select * from entrada join barco on entrada.id_barco = barco.id_barco where id_puerto = "+id_puerto;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				if(rs.getString("modelo").equalsIgnoreCase("velero")){
					array.add(new Velero(rs.getString("matricula")));
				}else if(rs.getString("modelo").equalsIgnoreCase("fragata")){
					array.add(new Fragata(rs.getString("matricula")));
				}else if(rs.getString("modelo").equalsIgnoreCase("portaaviones")){
					array.add(new Portaaviones(rs.getString("matricula")));
				}
			}
			return array;
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}
	return array;
	}
	
	public void lanzarCarrera(ArrayList<Barco> barcos){
		for (int i = 0; i < barcos.size(); i++) {
			barcos.get(i).start();
		}
	}
	
	public void cerrarConexion() throws SQLException{
		con.close();
	}
}
