package com.telefonica.conexionbarcos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBarcos {
	private String bd = null;
	private String user = null;
	private String password = null;
	private String server = null;
	private Connection con = null;
	
	public ConexionBarcos(String bd, String user, String password) {
		this.bd = bd;
		this.user = user;
		this.password = password;
		this.server = "jdbc:mysql://localhost/" + bd;//En server tenemos la ruta de nuestra BD local
		this.con = getConexion();
	}
	
	public Connection getConnection() {
		return this.con;
	}
	
	public Connection getConexion() {
		Connection conn = null;//Creamos un objeto de tipo Connection
		// Intentamos controlar los posibles errores, se puede hacer con Throw o con try/catch
		try { Class.forName ("com.mysql.jdbc.Driver").newInstance();		//Creamos una nueva Instancia del driver jdbc
			conn = DriverManager.getConnection(server, user, password);		//Creamos la conexi�n utilizando la clase DriverManager
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			//Con el finally pase lo que pase se ejecutar� lo que pongamos ah�
		}
		return conn;
	}
}
