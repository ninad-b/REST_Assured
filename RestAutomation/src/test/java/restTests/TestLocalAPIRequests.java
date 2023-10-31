package restTests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestLocalAPIRequests {
	
	@Test(priority=1)
	public void testRestLocalAPIGet()
	{
		baseURI="http://localhost:3000";
		given()
			.get("/employees")
		.then()
			.statusCode(200).log().body();
	}
	
	@Test(priority=2, enabled=true)
	public void testRestLocalAPIPost()
	{
		baseURI="http://localhost:3000";
		
		JSONObject jsonReq = new JSONObject();
		jsonReq.put("first-name", "wonder");
		jsonReq.put("last-name", "woman");
		jsonReq.put("subjectId", 1003);
		given()
			.header("content-type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonReq.toJSONString())
		.when()
			.post("/employees")
		.then()
			.statusCode(201).log().body();
	}
	
	@Test(priority=3)
	public void testRestLocalAPIPut()
	{
		baseURI="http://localhost:3000";
		JSONObject jsonReq = new JSONObject();
		
		//jsonReq.put("first-name", "wonder");
		//jsonReq.put("last-name", "woman");
		jsonReq.put("subjectId", 1002);
		
		given()
			.header("content-type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonReq.toJSONString())
		.when()
			.put("/employees/5")
		.then()
			.statusCode(200).log().body();
	}
	
	@Test(priority=4, enabled=true)
	public void testRestLocalAPIPatch()
	{
		baseURI="http://localhost:3000";
JSONObject jsonReq = new JSONObject();
		
		jsonReq.put("first-name", "fire");
		jsonReq.put("last-name", "womania");
		//jsonReq.put("subjectId", 1002);
		
		given()
			.header("content-type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonReq.toJSONString())
		.when()
			.patch("/employees/5")
		.then()
			.statusCode(200).log().body().and().log().headers();
	}
	
	@Test(priority=5)
	public void testRestLocalAPIDelete()
	{
		baseURI="http://localhost:3000";
		when()
			.delete("/employees/5")
		.then()
			.statusCode(200).log().all();
	}
}
