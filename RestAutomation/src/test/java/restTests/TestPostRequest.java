package restTests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class TestPostRequest {
	
	@Test
	public void testRestPost()
	{
		baseURI="https://reqres.in/api";
//		Map<String, Object> dataToBeEntered = new HashMap<String, Object>();
//		dataToBeEntered.put("name", "ironman");
//		dataToBeEntered.put("job", "sdet");
		
		JSONObject jsonReq = new JSONObject();
		jsonReq.put("name", "ironman");
		jsonReq.put("job", "sdet");
		
		given()
			.header("content-type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonReq.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201).log().all();
		
	}
}
