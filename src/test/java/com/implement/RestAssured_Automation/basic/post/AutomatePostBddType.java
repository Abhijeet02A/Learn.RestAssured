package com.implement.RestAssured_Automation.basic.post;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AutomatePostBddType {
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	
	@BeforeClass
	public void setReqResponse() {
		
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecification = requestSpecBuilder
								.setBaseUri("https://reqres.in/")
								.setContentType(ContentType.JSON)
								.build();
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		responseSpecification = responseSpecBuilder
								.expectStatusCode(200)
								.log(LogDetail.ALL)
								.build();
	}
	
	
	/**
	 * Post method BDD style... given when then
	 */
	@Test
	public void writeData() {
		String payload = "{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"cityslicka\"\r\n"
				+ "}";
		
		
		given(requestSpecification)
			.body(payload)
		.when()
			.post("api/login")
		.then().spec(responseSpecification);
			
	}
}
