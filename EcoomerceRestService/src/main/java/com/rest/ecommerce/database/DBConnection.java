package com.rest.ecommerce.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBConnection {
	
	String connectionUrl = "jdbc:sqlserver://proyec2apli.database.windows.net:1433;databaseName=Proyec2Apli;user=Proyec2Apli;password=ProyecApli2";
	
	public ResultSet executeQuery(String sql) {
		
		ResultSet rs = null;
		
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {

            String SQL = "SELECT * FROM items";

            rs = stmt.executeQuery(sql);

        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }	
        
        return rs;
		
	}
	
	public int executeUpdate(String sql) {
		
		int i = 0;
		
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {

            i = stmt.executeUpdate(sql);

        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }	
        
        return i;
		
	}
	
	

	

}
