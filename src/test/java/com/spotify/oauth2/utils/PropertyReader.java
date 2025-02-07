package com.spotify.oauth2.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static Properties propertyLoader(String filePath) {
		Properties properties = new Properties();
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(filePath));
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("failed to load properties file " + filePath);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Properties file not found " + filePath);
		}
		return properties;
	}
}
