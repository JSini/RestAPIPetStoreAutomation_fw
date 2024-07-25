package com.fw.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.fw.endpoints.UserEndPoints2;
import com.fw.payload.UserPayload;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class UserTests2 {
	

	//first we have prepare the data which we need for API tests
	Faker faker;
	UserPayload payload;
	public static Logger logger;
	
	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		payload = new UserPayload();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().emailAddress());
		payload.setPassword(faker.internet().password());
		payload.setPhone(faker.phoneNumber().cellPhone());
		payload.setUserStatus(0);
		
		
		//get logger
		logger = LogManager.getLogger("PetStoreAPIFramework");
	}
	
	
	@Test(priority=1)
	//individual API tests
	public void testCreateUser() {
		Response response = UserEndPoints2.createUser(payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("Create user executed");
		
	}
	
	@Test(priority=2)
	public void testGetUser() {
		Response response = UserEndPoints2.getUser(this.payload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("Get user executed");
		
	}
	
	@Test(priority=3)
	public void updateUser() {
		payload.setFirstName(faker.name().firstName());
		payload.setPhone(faker.phoneNumber().cellPhone());
		
		Response response = UserEndPoints2.updateUser(this.payload.getUsername(), payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("Update user executed");
		
		logger.info("Getting updated data...");
		
		Response responsePostUpdate = UserEndPoints2.getUser(this.payload.getUsername());
		responsePostUpdate.then().log().all();
		
	}
	
	@Test(priority=4)
	public void deleteUser() {
		Response response = UserEndPoints2.deleteUser(this.payload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("delete user executed");
	}


}
