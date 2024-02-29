package tests;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
public class TestCustomApiPost {
	@Test
	void testPost() {
		baseURI="http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("name", "Rakshitha");
		request.put("rakshitha", "Hassan");
		given().
		config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("ContentType.JSON", ContentType.TEXT)))
		.header("content-Type","ContentType.JSON").contentType("ContentType.JSON").accept("ContentType.JSON")
		.body(request.toJSONString()).when().post("/posts").then().statusCode(201);
	}

}
