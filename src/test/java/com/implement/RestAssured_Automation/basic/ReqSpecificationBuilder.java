package com.implement.RestAssured_Automation.basic;

import static io.restassured.RestAssured.get;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class ReqSpecificationBuilder {

	
	/**
	 * Initiate the RequestSpecification reference using RequestSpecBuilder
	 */
	@BeforeClass
	public void beforeClass() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://reqres.in/");
		requestSpecBuilder.addHeader("Accept", "*/*");
		requestSpecBuilder.log(LogDetail.ALL).build();
		
		//This is called default request specification as is 
		RestAssured.requestSpecification = requestSpecBuilder.build();
	}
	

	/**
	 * using RequestSpecification reference in given
	 */
	@Test
	public void validateGetWithOK() {
		Response response = get("/api/users/2").
		then()
				.log().all().extract().response();
		System.out.println(response.statusCode());
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
