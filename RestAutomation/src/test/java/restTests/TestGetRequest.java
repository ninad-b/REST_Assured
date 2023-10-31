package restTests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class TestGetRequest {
	
	@Test
	public void testingRest_1()
	{
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTimeIn(TimeUnit.MICROSECONDS));
		System.out.println(response.getHeader("content-type"));
		
		Assert.assertEquals(response.getStatusCode(), 200, "API call was not successfull");
	}
	
	@Test
	public void testingRest_2()
	{
		baseURI = "https://reqres.in/api";
		given()
			.get("/users?page=2")
			.then().statusCode(200)
			.body("data[0].id",equalTo(5));
		
		//Assert.assertEquals(response.getStatusCode(), 201, "API call was not successfull");
	}
}
