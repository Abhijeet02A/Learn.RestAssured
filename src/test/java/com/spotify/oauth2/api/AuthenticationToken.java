package com.spotify.oauth2.api;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import com.spotify.oauth2.utils.ConfigLoader;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthenticationToken {
	private static String access_token = "BQAW0bOPX4UAHAfQIkz31mJukWYpo1EAB3mCeYN1N7fQulR1WbM2boTmIc9nOHm-0nD5OD1lQ3yLsq800sIwx3DfiNjjmDRBsQUUQOUF12Frqb_dZUVsX2dB7ywixJVuN1Q5VznB_m3c887GYn4KShmeDTuFtnzk-rP1z7wZFvth2jYZ23wXPU035Sio72VZyTTplGS6b_BTvEwcbFQtBzczJYp5HgFcEe7s-XGkknAFBmmXS1lh78cMg3t3vog1zdibqAGIkciJCRZXYTzuQ2k_3V5qJbgs-CYdtA";
	private static String client_id = "9daf27f2bfaa4320b6f9975f00e8b6b5";
	
	public void generateToken() {
		Response resp = given()
		//FIXME: update all this fields in config properties 
			.queryParam("response_type", "code")
			.queryParam("client_id", ConfigLoader.getInstance().getClientId())
			.queryParam("scope", "user-read-private user-read-email")
			.queryParam("state", "34fFs29kd09")
			.queryParam("redirect_uri", "http://localhost:8888/callback")
			.get("https://accounts.spotify.com/authorize").then().log().all().extract().response();
		
		System.out.println(resp.asPrettyString());
	}
	
	//FIXME : Need attention not worked after first run
	//Also add the expiry check of current token
	public static String refreshToken() {
//		Response resp = given()
//				.baseUri("https://accounts.spotify.com")
//				.auth().basic("Authorization", "Basic OWRhZjI3ZjJiZmFhNDMyMGI2Zjk5NzVmMDBlOGI2YjU6N2QzMDdiYzMwYjE2NGFmOTgyZWQyMTY0ZmQzYmJjOWU=")
//				.contentType(ContentType.URLENC)
//				.formParam("refresh_token", access_token)
//				.formParam("grant_type", "refresh_token")
//				.formParam("client_id", client_id)
//				.when().post("/api/token")
//				.then()
//				.log().all()
//				.extract().response();
//		
//		if (resp.statusCode() != 200) {
//			throw new RuntimeException("Error while generating token!!!");
//		}
//		System.out.println(resp.body().asPrettyString());
//		return resp.path("access_token");
		return access_token;
	}
}
