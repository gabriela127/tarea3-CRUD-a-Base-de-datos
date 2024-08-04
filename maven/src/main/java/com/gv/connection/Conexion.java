package com.gv.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String URL = "jdbc:mariadb://localhost:3307/bd_colegio";
	private static final String USER = "root";
	private static final String PASSWORD = "gabriela127";
	
	public static Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("org.mariadb.jdbc.Driver");
	            connection = DriverManager.getConnection(URL, USER, PASSWORD);
	            System.out.println("Conexion exitosa.");
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println("Error al conectar la base de datos");
	            e.printStackTrace();
	        }
	        return connection;
	    }

	    public static void closeConnection(Connection connection) {
	        if (connection != null) {
	            try {
	                connection.close();
	                System.out.println("Conexion cerrada.");
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
