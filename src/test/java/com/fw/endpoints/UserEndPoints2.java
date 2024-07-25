package com.fw.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import com.fw.payload.UserPayload;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	//method to load urls from routes.properties
	static ResourceBundle getEndpoints() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		
		return routes;
	}
	
	public static Response createUser(UserPayload payload){
		
		String postUrlUser = getEndpoints().getString("postUrl");
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
			
			.when()
				.post(postUrlUser);
		
		return response;
						
		
	}
	
	public static Response getUser(String username){
		
		String getUrlUser = getEndpoints().getString("getUrl");
		Response response = given()
				.pathParam("username", username)
				
			.when()
				.get(getUrlUser);
		
		return response;
						
		
	}
	
	public static Response updateUser(String username, UserPayload payload){
		
		String putUrlUser = getEndpoints().getString("updateUrl");
		Response response = given()
				.pathParam("username", username)
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
			
			.when()
				.put(putUrlUser);
		
		return response;
						
		
	}
	
	public static Response deleteUser(String username){
		String deleteUrlUser = getEndpoints().getString("deleteUrl");
		Response response = given()
					.pathParam("username", username)
						
				.when()
					.delete(deleteUrlUser);
				
		return response;
								
				
			}

}
