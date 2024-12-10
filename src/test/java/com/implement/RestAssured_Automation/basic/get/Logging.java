package com.implement.RestAssured_Automation.basic.get;

import static io.restassured.RestAssured.given;
import static io.restassured.config.RestAssuredConfig.config;

import org.testng.annotations.Test;
import io.restassured.config.LogConfig;


public class Logging {
/**
 * Hide important headers while printing logs
 */
	@Test
	public void blackListHeader() {
		given().
			baseUri("https://reqres.in/")
			.config(config().logConfig(LogConfig.logConfig().blacklistHeader("Accept")))
			.log().all()
		.when()
			.get("api/unknown").
		then();		
	}

	@Test
	public void printHeaderLogs() {
		given().
			baseUri("https://reqres.in/").
		when()
			.get("api/unknown").
		then().
			log().headers();
	}
	/**
	 * Print only if there is error
	 */
	@Test
	public void printLogForError() {
		given().
		baseUri("https://reqres.in/").log().all().
	when()
		.get("api/unknown").
	then().
		log().ifError().assertThat().statusCode(203);
	}
	/**
	 * Print if validation fail
	 */
	@Test
	public void printLogForValidationFail() {
		given().
		baseUri("https://reqres.in/")
		.config(config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
	.when()
		.get("api/unknown").
	then().
		log().ifError().assertThat().statusCode(201);
	}
}
