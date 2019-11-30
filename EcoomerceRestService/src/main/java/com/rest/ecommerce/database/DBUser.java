package com.rest.ecommerce.database;

public class DBUser {
	
	DBConnection dbConnection;
	
	String tableName = "users";
	
	public void insert(int id, String name, String email, String password, String contact, String city, String address) {
		
		dbConnection = new DBConnection();
		
		String sql = "INSERT INTO "+tableName+"(id, name, email, password, contact, city, address) "
				+ "VALUES ("+id+",'"+name+"','"+email+"','"+password+"','"+contact+"','"+city+"','"+address+"')";
		
		dbConnection.executeUpdate(sql);
		
	}
	
	public void delete() {
		
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
