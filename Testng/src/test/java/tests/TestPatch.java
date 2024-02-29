package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;

public class TestPatch {
	@Test
	void testPut() {
	JSONObject obj=new JSONObject();
	obj.put("name","raksh");
	obj.put("job","trainee");
	baseURI="https://reqres.in/api";
	given().
	config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("ContentType.JSON", ContentType.TEXT))).
	header("Content-Type","application/json").
	contentType("ContentType.JSON").
	accept("ContentType.JSON").
	body(obj.toJSONString()).
	when().
	patch("api/users/2").
	then().
	statusCode(200).
	log().all();
	}
	

}
