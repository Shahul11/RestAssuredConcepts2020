package RestAssuredBasics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SimpleGET {

	@Test
	public void GetWeatherDetails() {

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		/**
		 * Response responseAnotherway = httpRequest.get("/Hyderabad");
		 * System.out.println(responseAnotherway.asString());
		 **/
		System.out.println("UNDERSTANDING THE STATUS LINE");

		// System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());

		System.out.println("----------FULL HEADERS------");
		System.out.println(response.getHeaders());

		System.out.println("========UNDERSTANDING THE HEADER=========");
		System.out.println(response.getHeader("Server"));
		System.out.println("Another way to get header");

		System.out.println(response.header("Server"));

		System.out.println("-------UNDERSTADNING THE BODY----------");
		System.out.println(response.getBody().asString());
		System.out.println(response.body().asString());

		System.out.println("----USING JSONPATH----");
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("Temperature received from Response " + jsonPathEvaluator.get("Temperature"));

		System.out.println("---USING VALIDATABLE(Interface) TO VERIFY THE RESPONSE-----");
		ValidatableResponse vr = response.then();
		vr.statusCode(200);

	}

}
