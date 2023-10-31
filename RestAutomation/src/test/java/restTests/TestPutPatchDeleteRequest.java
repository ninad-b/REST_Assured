package restTests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestPutPatchDeleteRequest {
	@Test(priority=1)
	public void testRestPost() {
		baseURI = "https://reqres.in";

		JSONObject jsonReq = new JSONObject();
		jsonReq.put("name", "ironman2");
		jsonReq.put("job", "dev");

		given()
			.header("content-type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonReq.toJSONString())
		.when()
			.put("/api/users/2")
		.then()
			.statusCode(200).log().all();
	}
	
	
	@Test(priority=2)
	public void testRestPatch() {
		baseURI = "https://reqres.in";

		JSONObject jsonReq = new JSONObject();
		jsonReq.put("name", "ironman2");
		jsonReq.put("job", "dev");

		given()
			.header("content-type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonReq.toJSONString())
		.when()
			.patch("/api/users/2")
		.then()
			.statusCode(200).log().all();
	}
	
	@Test(priority=3)
	public void testRestDelete() {
		baseURI = "https://reqres.in";
		
		when()
			.delete("/api/users/2")
		.then()
			.statusCode(204).log().all();
	}
}
