package com.rest.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBItem {
	
	DBConnection dbConnection;
	
	String tableName = "items";
	
	public void insertItem(int id, String name, int price) {
		
		dbConnection = new DBConnection();
		
		String sql = "INSERT INTO "+tableName+"(id, name, price) VALUES ("+id+",'"+name+"',"+price+")";
		
		dbConnection.executeUpdate(sql);
		
	}
	
	public void deleteItems() {
		
		dbConnection = new DBConnection();
		
		String sql = "DELETE FROM "+tableName+";";
		
		dbConnection.executeUpdate(sql);

	}
	
	public void selectItems() {
		
		dbConnection = new DBConnection();
		
		String sql = "SELECT * FROM "+tableName+"";
		
		dbConnection.executeQuery(sql);
		
	}

}
