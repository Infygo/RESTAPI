package pojo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

public class SpecBuilderTest {
	// adding a place in google maps api 
	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		AddPlace ap  = new AddPlace();
		ap.setAccuracy(50);
		ap.setAddress("29, side layout, cohen 09");
		ap.setLanguage("French-IN");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("http://google.com");
		ap.setName("Frontline house");
		
		List<String>myTypes = new ArrayList<String>();
		myTypes.add("shoe park");
		myTypes.add("shop");
		
		ap.setTypes(myTypes);
		
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		
		ap.setLocation(loc);		
		
		// Request Spec builder 
		RequestSpecification reqSpecBuilder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		// Response Spec builder 
		ResponseSpecification resSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		//Serialisation using the Java object ap into json 
		RequestSpecification reqSpecObject = given().spec(reqSpecBuilder)
		.body(ap);
		
		
		Response response = reqSpecObject.when().post("maps/api/place/add/json")
		.then().spec(resSpecBuilder).extract().response();
		
		String responseString = response.asString();
		System.out.println(responseString); // response with place id for the json request submitted
		
	}

}
