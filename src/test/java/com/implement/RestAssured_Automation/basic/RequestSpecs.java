package com.implement.RestAssured_Automation.basic;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecs {
	RequestSpecification requestSpecification;
	RequestSpecification requestSpecificationWith;

	
	@BeforeClass
	public void beforeClass() {
		requestSpecification = given().baseUri("https://reqres.in/");
	}
	
	@BeforeClass
	public void reqSpecWith() {
		requestSpecificationWith = with().baseUri("https://reqres.in/");
	}

	/**
	 * using RequestSpecification reference in given
	 */
	@Test
	public void validateGetWithOK() {
		given(requestSpecification)
		.when()
				.get("/api/users/2").
		then()
				.log().all().assertThat().statusCode(200);
	}
	
	
	/**
	 * Directly using Request Specification in given without when
	 * RequestSpecification with when() method
	 */
	@Test
	public void validateWithHamcrest() {
		given(requestSpecificationWith)
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
}
