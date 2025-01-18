package com.implement.RestAssured_Automation.basic.delete;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AutomateDelete {
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
								.expectStatusCode(204)
								.log(LogDetail.ALL)
								.build();
	}
	
	@Test
	public void removeUser() {
		
		given(requestSpecification)
			.delete("api/users/2")
			.then().spec(responseSpecification);
	}
}
