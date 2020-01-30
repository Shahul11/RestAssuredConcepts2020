package com.rest.api.put;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.api.post.USERPOJO1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTapi {

	@Test(enabled = true) /// Doing a post call and creating the user
	public void postAPI_2() {

		USERPOJO1 usr = new USERPOJO1("ThursdaPOST", "ThursdaPOST1", "male", "thursday1@gmail.com", "active");
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
		Response response = request.post();
		response.then().assertThat().body("result.first_name", equalTo(usr.getFirst_name()));
		System.out.println(response.prettyPrint());
		
		String rid=response.then().assertThat().extract().path("result.id");
		System.out.println("The result id is : "+rid);

		// id 1695

		// PUT CALL

		
		usr.setEmail("HelloShahul1@gmail.com");
		ObjectMapper updateUser = new ObjectMapper();
		String updateemail = "";

		try {
			updateemail = updateUser.writeValueAsString(usr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RestAssured.baseURI = "https://gorest.co.in/";
		RequestSpecification request1 = RestAssured.given().log().all();
		request1.contentType(ContentType.JSON).auth().oauth2("_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k");
		request1.body(updateemail);
		Response updatedResponse = request1.put("/public-api/users/"+rid);
		System.out.println("PRINTING AFTET UPDATING THE EMAIL ADDRESS");
		System.out.println(updatedResponse.prettyPrint());

	}

}
