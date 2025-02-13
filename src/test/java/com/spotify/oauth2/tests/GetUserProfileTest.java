package com.spotify.oauth2.tests;

import static com.spotify.oauth2.api.apiBasics.RestResource.requestGet;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetUserProfileTest extends BaseTest {
	
	@Test
	public void getUserProfile() {
		Response response = requestGet("/me");
		System.out.println(response.body().asPrettyString());
	}
}
