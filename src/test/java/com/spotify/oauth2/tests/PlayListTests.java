package com.spotify.oauth2.tests;

import static com.spotify.oauth2.api.apiBasics.RestResource.requestPost;
import static com.spotify.oauth2.api.Route.USERS;
import static com.spotify.oauth2.api.Route.PLAYLISTS;



import org.testng.annotations.Test;

import com.spotify.oauth2.pojo.CreatePlayList;

import io.restassured.response.Response;

public class PlayListTests {

	@Test
	public void createPlayList() {

		CreatePlayList bodyOfPlayList = new CreatePlayList()
				.setName("New Songs")
				.setDescription("Adding new songs")
				.setPublic(false);
		
		
		Response response = requestPost(USERS + "/31mt7d2uji4uk5f6f5wgy53fswzu" + PLAYLISTS, bodyOfPlayList);
		response.statusCode();
	}
}
