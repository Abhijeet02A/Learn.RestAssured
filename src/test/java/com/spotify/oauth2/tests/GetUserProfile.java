package com.spotify.oauth2.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetUserProfile {

	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	String accessToken = "";
	
	@BeforeClass
	public void beforeClass() {
		RequestSpecBuilder requestBuilder = new RequestSpecBuilder()
					.setBaseUri("https://api.spotify.com/v1")
					.setContentType(ContentType.JSON)
					.addHeader("Authorization", "Bearer " + accessToken)
					.log(LogDetail.ALL);
		
		requestSpecification = requestBuilder.build();
		
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder()
				.log(LogDetail.ALL);
		
		responseSpecification = responseBuilder.build();
				
	}
	
	@Test
	public void getUserProfile() {
		Response response = given(requestSpecification)
				.basePath("/me")
			.when().get().then()
			.spec(responseSpecification)
			.assertThat()
			.statusCode(200)
			.body("display_name", equalTo("Abhijee_tawari"))
			.extract().response();
		
		System.out.println(response.body().asPrettyString());
	}
}
