package com.rest.api.post;

import java.io.File;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class POSTAPI {

	/***
	 * Non-BDD Style--- sending body request as json
	 */

	@Test(enabled = false)
	public void postAPI() {

		RestAssured.baseURI = "https://gorest.co.in/public-api/users";
		RequestSpecification request = RestAssured.given().log().all();
		request.contentType(ContentType.JSON).auth().oauth2("_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k");
		// request.header("Authorization", "Bearer
		// _FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k");
		request.body(
				"{\"first_name\":\"sun\",\"last_name\":\"moon\",\"gender\":\"male\",\"email\":\"sun1@yahoo.com\",\"status\":\"active\"}");
		Response response = request.post();
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());

	}

	@Test(enabled = false)
	public void postAPI_1() {
		RestAssured.baseURI = "https://gorest.co.in/public-api/users";
		RequestSpecification request = RestAssured.given().log().all();
		request.contentType(ContentType.JSON).auth().oauth2("_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k");
		request.body(new File(
				"C:\\Users\\shahul.hameed\\eclipse-workspace\\RestAssuredLearning\\src\\com\\rest\\api\\post\\UserCreationJSON.json"));
		Response response = request.post();
		System.out.println(response.prettyPrint());

	}

	@Test(enabled = true)
	public void postAPI_2() {

		USERPOJO1 usr = new USERPOJO1("sUNDA1","MODNAY","male","SUNDAY11@gmail.com","active");
		ObjectMapper om = new ObjectMapper();
		String usrdata = null;
		try {
			usrdata = om.writeValueAsString(usr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RestAssured.baseURI = "https://gorest.co.in/public-api/users";
		RequestSpecification request = RestAssured.given().log().all();
		request.contentType(ContentType.JSON).auth().oauth2("_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k");
		request.body(usrdata);
		Response response=request.post();
				response.then().assertThat().body("result.first_name", equalTo(usr.getFirst_name()));
		System.out.println(response.prettyPrint());
		
		
		

	}

}
