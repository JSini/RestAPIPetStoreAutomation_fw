package com.fw.endpoints;

import com.fw.payload.UserPayload;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints {
	
	
		public static Response createUser(UserPayload payload){
					
			Response response = given()
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON)
					.body(payload)
				
				.when()
					.post(Routes.postUrlUser);
			
			return response;
							
			
		}
		
		public static Response getUser(String username){
			
			Response response = given()
					.pathParam("username", username)
					
				.when()
					.get(Routes.getUrlUser);
			
			return response;
							
			
		}
		
		public static Response updateUser(String username, UserPayload payload){
			
			Response response = given()
					.pathParam("username", username)
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON)
					.body(payload)
				
				.when()
					.put(Routes.putUrlUser);
			
			return response;
							
			
		}
		
		public static Response deleteUser(String username){
					
					Response response = given()
							.pathParam("username", username)
							
						.when()
							.delete(Routes.deleteUrlUser);
					
					return response;
									
					
				}

}
