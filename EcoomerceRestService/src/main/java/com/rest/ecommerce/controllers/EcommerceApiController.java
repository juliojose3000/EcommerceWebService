package com.rest.ecommerce.controllers;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.ecommerce.data.JsonReader;
import com.rest.ecommerce.database.DBConnection;
import com.rest.ecommerce.database.DBItem;
import com.rest.ecommerce.database.DBUser;
import com.rest.ecommerce.database.DBUserItem;


@RestController
@CrossOrigin
public class EcommerceApiController {	
	
	DBItem dbItem;
	DBUser dbUser;
	DBUserItem dbUserItem;
	String serverHost = "https://loaizacity.000webhostapp.com";
	//String serverHost = "http://localhost";
	
	@RequestMapping(method = RequestMethod.GET, value="/ecommerce/item/readAll")
	public String insertItemsFromJsonOnDataWereHouse() {
	  
		String result = "";
		
		dbItem = new DBItem();
		
		dbItem.deleteItems();
			   
			try {
	  
				JSONArray jsonArray = JsonReader.readJsonArrayFromUrl(serverHost+"/Online_Shopping_Api/api/item/read.php");
				
				for(int i = 0; i<jsonArray.length();i++) {
					
					JSONObject json = jsonArray.getJSONObject(i);
					
					result+=json.toString()+"\n";
					
					dbItem.insertItem(json.getInt("id"), json.getString("name"), json.getInt("price"));
							
				}
				
				System.out.println("Insert all items on datawerehouse");
	
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}

			return result;
			  
	  }
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, value="/ecommerce/user/readAll")
	public String insertUsersFromJsonOnDataWereHouse() {
	  
		String result = "";
		
		dbUser = new DBUser();
		
		dbUser.delete();
			   
			try {
	  
				JSONArray jsonArray = JsonReader.readJsonArrayFromUrl(serverHost+"/Online_Shopping_Api/api/user/read.php");
				
				for(int i = 0; i<jsonArray.length();i++) {
					
					JSONObject json = jsonArray.getJSONObject(i);
					
					result+=json.toString()+"\n";
					
					dbUser.insert(json.getInt("id"), json.getString("name"), json.getString("email"),
							json.getString("password"), json.getString("contact"), json.getString("city"),
							json.getString("address"));
							
				}
				
				System.out.println("Insert all users on datawerehouse");
	
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}

			return result;
			  
	  }
	
	
	
	@RequestMapping(method = RequestMethod.GET, value="/ecommerce/user_item/readAll")
	public String insertUserItemFromJsonOnDataWereHouse() {
	  
		String result = "";
		
		dbUserItem = new DBUserItem();
		
		dbUserItem.delete();
			   
			try {
	  
				JSONArray jsonArray = JsonReader.readJsonArrayFromUrl(serverHost+"/Online_Shopping_Api/api/user_item/read.php");
				
				for(int i = 0; i<jsonArray.length();i++) {
					
					JSONObject json = jsonArray.getJSONObject(i);
					
					result+=json.toString()+"\n";
					
					dbUserItem.insert(json.getInt("id"), json.getInt("user_id"), json.getInt("item_id"), json.getString("status"));
							
				}
				
				System.out.println("Insert all user_items on datawerehouse");
	
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}

			return result;
			  
	  }
	
	
	
	
	
	
	


}
