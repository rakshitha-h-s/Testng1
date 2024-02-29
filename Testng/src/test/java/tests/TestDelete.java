package tests;
import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
public class TestDelete {
	@Test
	void testDelete()
	{
		baseURI="https://reqres.in";
		when().
		delete("/api/users/2").
		then().
		statusCode(204)
		.log().all();
	}

}
