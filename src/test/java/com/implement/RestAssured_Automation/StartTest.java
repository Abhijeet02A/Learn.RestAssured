package com.implement.RestAssured_Automation;

import org.testng.annotations.Test;

//Static Imports
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class StartTest {
	
	@Test
	public void test() {
		given().when().then();
		
	}
}
