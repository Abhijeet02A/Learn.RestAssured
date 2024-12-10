package com.implement.RestAssured_Automation.basic.get;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetResponse {

	/**
	 * Simple get method to check 200 status code
	 */
	@Test
	public void validateGetWithOK() {
		given()
				.baseUri("https://reqres.in/").
		when()
				.get("/api/users/2").
		then()
				.log().all().assertThat().statusCode(200);
	}
	
	
	/**
	 * Validations of Response with using different hamcrest Matcher methods
	 */
	@Test
	public void validateWithHamcrest() {
		given().
				baseUri("https://reqres.in/").
		when()
				.get("api/unknown").
		then().
				log().all()
				.body("page", equalTo(1))		//page is int
				.body("data.id", hasItems(1, 2, 3))		//hasItems to get form collection
				.body("data.name", hasItems("cerulean", "fuchsia rose", "true red"))
				.body("data.size()", equalTo(6))
				.body("support.text", equalTo("Tired of writing endless social media content? Let Content Caddy generate it for you."))
				;
	}
	
	/**
	 * Get response in Response object and perform operation on it
	 * use JsonPath object for further
	 */
	@Test
	public void validateWithResponseObject() {
		Response response = 
		given()
				.baseUri("https://reqres.in/").
		when()
				.get("api/unknown/2").
		then()
				.log().all().extract().response()
				;
		
		JsonPath jsonPath = new JsonPath(response.asString());
		System.err.println(jsonPath.getString("data.name"));
		System.err.println(jsonPath.getJsonObject("data").toString());
		System.err.println(jsonPath.getInt("data.year"));
	}
}
