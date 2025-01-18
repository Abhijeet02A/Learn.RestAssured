package com.implement.RestAssured_Automation.basic.post;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import java.io.File;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class FilePayloadPost {
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
		File file = new File("src/test/resources/payloads/login.json");
		given(requestSpecification)
			.body(file)
		.when()
			.post("api/login")
		.then().spec(responseSpecification).body("token", containsString("QpwL5tke4Pnpja7X4"));
			
	}
}
