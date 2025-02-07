package com.spotify.oauth2.utils;

import java.util.Properties;

public class ConfigLoader {

	private final Properties properties;
	private static ConfigLoader configLoader;
	
	private ConfigLoader() {
		properties = PropertyReader.propertyLoader("src/test/resources/properties/config.properties");
	}
	
	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}
	
	public String getClientId() {
		String prop = properties.getProperty("client_id");
		if (prop != null) return prop;
		else throw new RuntimeException("Property is not available...!");
	}
	
	//TODO: Update the remaining code for accessing properties
}
