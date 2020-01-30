package RestAssuredBasics;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimplePOST {

	@Test
	public void registrationProcess() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender");
		requestParams.put("LastName", "Singh");

		requestParams.put("UserName", "Shah2");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "Shah2@gmail.com");

		request.header("Content-Type", "application/json");

		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
		
		System.out.println(response.getBody().asString());
		
		
		System.out.println("---------USING JSONPATH i AM VALIDATING THE POST CALL RESPONSE");
		JsonPath jsonpathEval=response.jsonPath();
		System.out.println(jsonpathEval.getString("SuccessCode"));
		

	}

}
