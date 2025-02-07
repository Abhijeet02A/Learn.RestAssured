package com.spotify.oauth2.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static com.spotify.oauth2.api.Route.BASE_PATH_VERSION;

import static com.spotify.oauth2.api.AuthenticationToken.refreshToken;

public class SpotifySpecBuilder {
	
	private static String getRenewedAccessToken() {
		return refreshToken();
	}
	
	public static RequestSpecification getRequestSpecification() {
		return new RequestSpecBuilder()
				.setBaseUri("https://api.spotify.com" + BASE_PATH_VERSION)
				.setContentType(ContentType.JSON)
				.addHeader("Authorization", "Bearer " + SpotifySpecBuilder.getRenewedAccessToken())
				.log(LogDetail.ALL).build();
	
	}
	
	public static ResponseSpecification getResponseSpecification() {
		return new ResponseSpecBuilder()
				.log(LogDetail.ALL).build();
		
	}
}
