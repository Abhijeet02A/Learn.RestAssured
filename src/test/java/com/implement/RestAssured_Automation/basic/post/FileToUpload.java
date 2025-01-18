package com.implement.RestAssured_Automation.basic.post;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.io.File;

public class FileToUpload {
	@Test
	public void uploadFile() {
		String attributes = "{'name':'file', 'paren':{'id':'123'}}";
		given()
			.baseUri("https://postman-echo.com")
			.multiPart("File", new File("temp.txt"))
			.multiPart("attributes", attributes, "application/json")
			.log().all()
		.when()
			.post("/post")
		.then()
			.assertThat().statusCode(200).log().all();
	}
}

