package Restapi.automation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jsonpayload.jsonpath;
import jsonpayload.payload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;



public class basics {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Add place(API1 -POST) -> Update place with New address(API2-PUT) ->
		// Get(API3-GET) place to validate if New address is present in response

		// given - all input details
		// when - Submit the API - resource, http method
		// then - Validate the response

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String postResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				//.body(payload.Addplace())
				.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\vravindran\\Desktop\\addPlace.json"))))
				.when().post("maps/api/place/add/json")
				.then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract()
				.response().asString();

		System.out.println(postResponse);

		// Extract place id from the response - to update the place with New Address(PUT header)
		JsonPath jsp = jsonpath.rawToJson(postResponse);
		
		//JsonPath jsp = new JsonPath(response);
		
		String placeId = jsp.getString("place_id");
		System.out.println("Added place id using API Post method: "+ placeId);
		
		// http method - Delete - assert using status OK 
		
		/*
		String deleteResponse = given().log().all().queryParams("key", "qaclick123") .header("Content-type", "application/json")
				.body("{\r\n" + 
						"\"place_id\":\""+placeId+"\",\r\n" + 
						"}")
				.when().delete("maps/api/place/delete/json")
				.then().log().all().assertThat()
				.statusCode(200).extract()
				.response().asString();
		
		System.out.println(deleteResponse);
		
		*/
				
		// Update the place using placeid with new address 
		
		String newAddress = "70 winter walk, USA";
		String updateResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat()
		.statusCode(200).body("msg", equalTo("Address successfully updated")).extract()
		.response().asString();
		
		System.out.println("Update response from API:" + updateResponse);
		
		
		// validate if new address is present in the response - GET
		
		
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1 = jsonpath.rawToJson(getPlaceResponse);
		String updatedAddress = js1.getString("address");
		System.out.println("Get updated Address from API:" + updatedAddress);
		Assert.assertEquals(updatedAddress, newAddress);
		
	}

}
