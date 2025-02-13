package com.spotify.oauth2.tests;

import static com.spotify.oauth2.api.apiBasics.RestResource.requestPost;
import static com.spotify.oauth2.api.Route.USERS;
import static com.spotify.oauth2.api.Route.PLAYLISTS;
import static com.spotify.oauth2.utils.FakeUtils.generateDescription;
import static com.spotify.oauth2.utils.FakeUtils.generateName;


import org.testng.annotations.Test;

import com.spotify.oauth2.pojo.CreatePlayList;

import io.restassured.response.Response;

public class PlayListTests extends BaseTest {

	@Test
	public void createPlayList() {

		CreatePlayList bodyOfPlayList = new CreatePlayList()
				.setName(generateName())
				.setDescription(generateDescription())
				.setPublic(false);
		
		
		Response response = requestPost(USERS + "/31mt7d2uji4uk5f6f5wgy53fswzu" + PLAYLISTS, bodyOfPlayList);
		response.statusCode();
	}
}
