package com.spotify.oauth2.tests;

import static io.restassured.RestAssured.given;

import com.spotify.oauth2.pojo.CreatePlayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PlayListTests {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	String accessToken = "";

	@BeforeClass
	public void beforeClass() {
		RequestSpecBuilder requestBuilder = new RequestSpecBuilder().setBaseUri("https://api.spotify.com/v1")
				.addHeader("Authorization", "Bearer " + accessToken).setContentType(ContentType.JSON)
				.log(LogDetail.ALL);

		requestSpecification = requestBuilder.build();

		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder().log(LogDetail.ALL);

		responseSpecification = responseBuilder.build();
	}

	@Test
	public void createPlayList() {

//		String bodyOfRequest = "{\r\n"
//				+ "    \"name\": \"New Playlisert2\",\r\n"
//				+ "    \"description\": \"New playlist description\",\r\n"
//				+ "    \"public\": false\r\n"
//				+ "}";

		// TODO: body using POJO
		CreatePlayList bodyOfPlayList = new CreatePlayList();

		bodyOfPlayList.setDescription("new here");
		bodyOfPlayList.setName("Om nama");
		bodyOfPlayList.setPublic(false);

		given(requestSpecification).body(bodyOfPlayList).when().post("/users/31mt7d2uji4uk5f6f5wgy53fswzu/playlists")
				.then().spec(responseSpecification).assertThat().statusCode(201);
	}
}
