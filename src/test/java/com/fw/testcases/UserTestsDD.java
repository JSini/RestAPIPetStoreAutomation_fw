package com.fw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fw.endpoints.UserEndPoints;
import com.fw.payload.UserPayload;
import com.fw.utilities.DataProviders;

import io.restassured.response.Response;

public class UserTestsDD {
	
	@Test(priority=1, dataProvider="CreateUserData",dataProviderClass=DataProviders.class)
	public void testCreateUser(String userID, String username, String fname, String lname, String useremail, String pwd, String phone) {
		
		UserPayload payload = new UserPayload();
		
		payload.setId(Integer.parseInt(userID));
		payload.setUsername(username);
		payload.setFirstName(fname);
		payload.setLastName(lname);
		payload.setEmail(useremail);
		payload.setPassword(pwd);
		payload.setPhone(phone);
		payload.setUserStatus(0);
		
		Response response = UserEndPoints.createUser(payload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=2, dataProvider="UsernameData", dataProviderClass=DataProviders.class)
	public void testGetUser(String username) {
		
		Response response = UserEndPoints.getUser(username);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=3, dataProvider="UsernameData", dataProviderClass=DataProviders.class)
	public void testdeleteUser(String username) {
		
		Response response = UserEndPoints.deleteUser(username);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
