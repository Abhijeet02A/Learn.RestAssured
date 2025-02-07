package com.spotify.oauth2.api.apiBasics;

import static com.spotify.oauth2.api.SpotifySpecBuilder.getRequestSpecification;
import static com.spotify.oauth2.api.SpotifySpecBuilder.getResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;

public class RestResource {

	public static Response requestGet(String basePath) {
		return given(getRequestSpecification())
			.basePath(basePath)
				.when().get()
				.then().spec(getResponseSpecification())
				.assertThat()
				.extract().response();
	}

	public static Response requestPost(String basePath, Object requestBody) {
		return given(getRequestSpecification())
			.body(requestBody)
			.when()
				.post(basePath)
			.then().spec(getResponseSpecification()).extract().response();
	}
}
