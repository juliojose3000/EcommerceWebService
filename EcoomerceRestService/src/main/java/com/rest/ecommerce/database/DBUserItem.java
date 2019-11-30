package com.rest.ecommerce.database;

public class DBUserItem {
	
	DBConnection dbConnection;
	
	String tableName = "users_items";
	
	public void insert(int id, int userId, int itemId, String status) {
		
		dbConnection = new DBConnection();
		
		String sql = "INSERT INTO "+tableName+"(id, user_id, item_id, status) VALUES ("+id+","+userId+","+itemId+",'"+status+"')";
		
		dbConnection.executeUpdate(sql);
		
	}
	
	public void delete() {
		
		dbConnection = new DBConnection();
		
		String sql = "DELETE FROM "+tableName+";";
		
		dbConnection.executeUpdate(sql);

	}
	
	public void select() {
		
		dbConnection = new DBConnection();
		
		String sql = "SELECT * FROM "+tableName+"";
		
		dbConnection.executeQuery(sql);
		
	}

}
