package com.implement.RestAssured_Automation.basic.get;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.given;

public class HeadersOperation {
/**
 * passing header in request
 */
	@Test
	public void addHeader() {
		Header header = new Header("Accept", "*/*"); 
		given()
		.header(header)
			.baseUri("https://reqres.in/")
		.when()
			.get("/api/users/2")
		.then().assertThat().statusCode(200);
	}
	
	/**
	 * Validationg header in response
	 */
	@Test
	public void verifyResposneHeader() {
		given()
			.baseUri("https://reqres.in/")
		.when()
			.get("/api/users/2")
		.then().log().all()
			.assertThat().statusCode(200)
//			.header("", "")
			;
	}
	
	/**
	 * extract headers from response
	 */
	@Test
	public void extractHeader() {
		Headers headers = given()
			.baseUri("https://reqres.in/")
		.when()
			.get("/api/users/2")
		.then()
			.extract()
			.headers();
		System.out.println(headers.toString());
	}
}
