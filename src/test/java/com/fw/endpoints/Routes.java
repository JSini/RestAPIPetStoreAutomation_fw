package com.fw.endpoints;

public class Routes {
	
	/*
	 * https://petstore.swagger.io/v2/user
		https://petstore.swagger.io/v2/user/{username}
		https://petstore.swagger.io/v2/user/{username}
		https://petstore.swagger.io/v2/user/{username}
	 */
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	//User model
	public static String postUrlUser = baseUrl + "/user";
	public static String getUrlUser = baseUrl + "/user/{username}";
	public static String putUrlUser = baseUrl + "/user/{username}";
	public static String deleteUrlUser = baseUrl + "/user/{username}";
	
	//Pet model
	
	
	//Store model
}
