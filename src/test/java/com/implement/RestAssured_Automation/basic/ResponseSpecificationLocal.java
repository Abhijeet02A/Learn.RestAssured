package com.implement.RestAssured_Automation.basic;

import static io.restassured.RestAssured.get;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;

public class ResponseSpecificationLocal {

	
	private ResponseSpecification responsesSpecification;

	/**
	 * Initiate the RequestSpecification reference using RequestSpecBuilder
	 */
	@BeforeClass
	public void beforeClass() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://reqres.in/");
		requestSpecBuilder.addHeader("Accept", "*/*");
		requestSpecBuilder.log(LogDetail.ALL).build();
		RestAssured.requestSpecification = requestSpecBuilder.build();
		
		//Common assertion and lot more...
//		RestAssured.responseSpecification = RestAssured.expect().statusCode(201).contentType(ContentType.JSON);
		
		/**
		 * responseSpecification using the ResponseSpecBuilder Class
		 */
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		responseSpecBuilder.expectStatusCode(201).log(LogDetail.ALL);
		responsesSpecification = responseSpecBuilder.build();
		//Default response specification
//		RestAssured.responseSpecification = responseSpecBuilder.build();
	}
	

	/**
	 * using RequestSpecification reference in given
	 */
	@Test
	public void validateGetWithOK() {
		Response response = get("/api/users/2").
							then().spec(responsesSpecification)
								.log().all().extract().response();
		
		//TODO:perform different operations of response 
	}
	
	/**
	 * Use different methods from it to fetch request details
	 */
	@Test
	public void featchRequestDetail() {
		QueryableRequestSpecification queryRequestSpec = SpecificationQuerier.query(RestAssured.requestSpecification);
			System.out.println(queryRequestSpec.getBaseUri());
	}
}
