package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

/**
 * TODO: How to use Builder annotation in eclipse IDE 
 * or How you can use same project in both eclipse and intelij IDE
 */
// ow to 
//@Value	//can remove the access specifier and does work of getter and setter
//@Data	//Does work of getter and setter
@Getter @Setter
//NOTE: will use below annotations for using the POJO as a builder pattern
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatePlayList {

	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("public")
	private Boolean _public;
	
	public CreatePlayList(String name, String description, Boolean _public) {
		super();
		this.name = name;
		this.description = description;
		this._public = _public;
	}

	public CreatePlayList() {
		// TODO Auto-generated constructor stub
	}
	
	public CreatePlayList setName(String name) {
		this.name = name;
		return this;
	}
	
	public CreatePlayList setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public CreatePlayList setPublic(Boolean _public) {
		this._public = _public;
		return this;
	}
	
	
}