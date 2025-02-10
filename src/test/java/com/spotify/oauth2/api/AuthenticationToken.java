package com.spotify.oauth2.api;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import com.spotify.oauth2.utils.ConfigLoader;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthenticationToken {
	private static String access_token = "BQBZOnfh2PeyHcK9qqUXgSyykNigtZaQwr4OJ2bC5Sj75bCvEpVERi3x1gFlnR_hS1Y1aVNtnPJYod6ea2_N7ga_qPXy-Udy__BveY8lQgYMzxfMPFtmrHvD5maDZifQf83TYb6O2fE9Zt6Q8qjKUyXQ8Mknvwt6-w6GPQ20SpZD79C2oPtZzIxylNnTxhozdQe40cB1TngvAcKdzM89TFF1rka3Z-gpbQJHzVmixP1wCf7Q6LXGTQ";
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
