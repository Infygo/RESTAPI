package oAuth;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import jsonpayload.jsonpath;
import pojo.GetCourses;

public class Oauth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// given - all input details
		// when - Submit the API - resource, http method
		// then - Validate the response

		// Bottom to Top approach

		// get the authorisation code - open chrome browser and hit the url in the
		// browser
		// use the endpoint url - add the query parameters and construct the url
		// get the auth code url and login part manually
        String [] actualCourseTitles = {"Selenium Webdriver Java", "Cypress", "Protractor"};
        
		/* Authorisation url 
		 * https://accounts.google.com/o/oauth2/v2/auth
		 * ?scope=https://www.googleapis.com/auth/userinfo.email
		 * &auth_url=https://accounts.google.com/o/oauth2/v2/auth
		 * &client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com
		 * &response_type=code 
		 * &redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyapi
		 */
		
		// set the auth code received from above link and replace it under the code field in the below url 
		String authCodeUrl = "https://rahulshettyacademy.com/getCourse.php?state=verifyapi&code=4%2F0AY0e-g6NpdojexHEHpNp0wTQ7yIlt_pfQ_WP9ugsN5G6ogntSJCNCeLCJWlTFgBQR55hYg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent#";

		String partialCode = authCodeUrl.split("code=")[1];
		String actualAuthCode = partialCode.split("&scope")[0];
		System.out.println(actualAuthCode);

		// get the access token assuming we have the auth code
		String accessTokenResponse = given().urlEncodingEnabled(false).queryParam("code", actualAuthCode)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code").when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();

		// Extract only the Access token variable from the accessToken string
		JsonPath jsp = jsonpath.rawToJson(accessTokenResponse);
		String accessToken = jsp.get("access_token");

		// send the access token assuming we have one
		String courseList = given().queryParam("access_token", accessToken).when().log().all()
				.get("https://rahulshettyacademy.com/getCourse.php").asString();

		System.out.println(courseList);
		
		/* Deserialisation using Pojo classes */
		
		GetCourses getCoursesObject = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
				                      .when() 
				                      .get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class);
		
		System.out.println(getCoursesObject.getLinkedin());
		
		// json querying - get the price of Api course SoapUI Webservices testing
		
		for(int i =0; i<getCoursesObject.getCourses().getApi().size(); i++) {
			if(getCoursesObject.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println("SoapUi course Price:" + getCoursesObject.getCourses().getApi().get(i).getPrice());
			}
		}
		
		// json java query all the course titles of Web Automation json key 
		ArrayList<String> expectedCourseList = new ArrayList<String>();
		for(int i =0; i < getCoursesObject.getCourses().getWebAutomation().size(); i++) {
			expectedCourseList.add(getCoursesObject.getCourses().getWebAutomation().get(i).getCourseTitle());
		}
		List<String>actualCourseList = Arrays.asList(actualCourseTitles);
		
		for(int i=0; i< expectedCourseList.size(); i++) {
			if(expectedCourseList.get(i).equalsIgnoreCase(actualCourseTitles[i])) {
				System.out.println("Coursetitles matches");
			}
		}
		Assert.assertTrue(expectedCourseList.equals(actualCourseList));
		
	}

}
