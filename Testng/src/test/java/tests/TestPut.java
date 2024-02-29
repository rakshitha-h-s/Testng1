package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPut {
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
	put("users/2").
	then().
	statusCode(200).
	log().all();
	}
	
	
	
}
