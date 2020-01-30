package com.rest.api.get;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPI {

	/**
	 * Bdd Style with API formula car API's
	 * http://ergast.com/api/f1/2017/circuits.json We are doing assertions using the
	 * hamcrest methods like hasSize
	 */

	@Test(enabled = false)
	public void getApiCircitu_1() {
		given().when().log().all().get("http://ergast.com/api/f1/2017/circuits.json").then().log().all().assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));

	}

	/**
	 * NON- BDD Style with API formula car API's
	 * http://ergast.com/api/f1/2017/circuits.json
	 */

	@Test(enabled = false)
	public void getAPICircuti_2() {
		RestAssured.baseURI = "http://ergast.com/api/f1/2017/circuits.json";

		RequestSpecification request = RestAssured.given().log().all();
		Response response = request.get();
		System.out.println(response.prettyPrint());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine());
		System.out.println("===========================");
		System.out.println(response.getHeaders());

		System.out.println(
				"Below I am going to use the JSON path , i.e convert the response to JSON path and then verify");
		JsonPath jspath = new JsonPath(response.asString());
		System.out.println("PRINTING THE ADDRESS");
		//System.out.println(jspath.get("MRData.Circuits[0].circuitId"));

	}

	/**
	 * Non- Bdd Style with goRest API as jsonpath not working as expected with the
	 * above api
	 */

	@Test(enabled = true)
	public void getGoRestAPI() {

		RestAssured.baseURI = "https://gorest.co.in/public-api/users";
		RequestSpecification request = RestAssured.given().log().all();
		request.auth().oauth2("_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k");
		Response response = request.get();
		System.out.println(response.prettyPrint());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine());
		System.out.println("===========================");
		System.out.println(response.getHeaders());
		JsonPath jspath = new JsonPath(response.asString());
		System.out.println("PRINTING THE FIRSTNAME FROM THE FIRST ARRAYS OF RESULT");
		System.out.println(jspath.getString("result[0].first_name"));
	

	}

	/**
	 * Non Bdd Style with Query Params as first name
	 * 
	 */

	@Test(enabled = false)
	public void getGoRestAPIFirstName() {
		RestAssured.baseURI = "https://gorest.co.in/public-api/users";
		RequestSpecification request = RestAssured.given().log().all();
		request.auth().oauth2("_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k");

		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("first_name", "Johnnie");

		Response response = request.queryParams(queryParams).get();
		System.out.println(response.prettyPrint());
		
		
	}

}
