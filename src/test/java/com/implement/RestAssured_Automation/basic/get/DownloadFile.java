package com.implement.RestAssured_Automation.basic.get;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.testng.annotations.Test;

public class DownloadFile {
	//TODO: use the base uri and resource to make it complete
	@Test
	public void downloadFile() throws Exception {
		byte[] bytes = given()
			.baseUri("")
		.when()
			.get("")
		.then().log().all()
			.extract().response().asByteArray();
		
		OutputStream os = new FileOutputStream(new File("fileName.txt"));
		os.write(bytes);
		os.close();
	}
}
