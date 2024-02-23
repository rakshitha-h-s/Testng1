package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestExample {
	@Test
	public void testExample() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	void test_2() {
		baseURI = "https://reqres.in/api";
		given().get("users?page=2").then().statusCode(200).body("data[1].id", equalTo(8));

	}

	@Test
	void test_3() {
		baseURI = "https://reqres.in/api";
		Map<String, Object> map1 = new HashMap();
		map1.put("\"name\"", "Rakshitha");
		map1.put("\"address\"", "Hassan");
		//System.out.println(map1);
		JSONObject request = new JSONObject();
		request.put("name", "Rakshitha");
		request.put("address", "Hassan");
		//System.out.println(request.toJSONString());
		given().header("content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("/users").then().statusCode(201);

	}
}
