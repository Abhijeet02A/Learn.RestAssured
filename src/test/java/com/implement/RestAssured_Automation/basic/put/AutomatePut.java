package com.implement.RestAssured_Automation.basic.put;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class AutomatePut {
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
	
	@Test
	public void updateData() {
		String payload = "{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"zion resident\"\r\n"
						+ "}";
		
		
		given(requestSpecification)
			.body(payload)
		.when()
			.put("api/users/2")
		.then().spec(responseSpecification);
	}
}
