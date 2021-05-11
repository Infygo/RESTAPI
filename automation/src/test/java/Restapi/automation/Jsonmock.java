package Restapi.automation;

import io.restassured.path.json.JsonPath;
import jsonpayload.payload;

public class Jsonmock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath jsc = new JsonPath(payload.MockCoursePrice());
		
		//JsonPath jsp = jsonpath.rawToJson(payload.MockCoursePrice());

		// print number of courses returned by API mock response
		
		int courseCount = jsc.getInt("courses.size");
		System.out.println("Course count from Mock API response:" + courseCount);
		

		// print purchase Amount
		int purchaseAmount = jsc.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount from Mock API:" + purchaseAmount);
		

		// print title of the first course
		String firstCourseTitle = jsc.getString("courses[0].title");
		System.out.println("First course title: " + firstCourseTitle);
		
		// print all course titles and their prices
		for (int i=0; i<courseCount; i++) {
			System.out.println(jsc.getString("courses["+i+"].title"));
			System.out.println(jsc.getInt("courses["+i+"].price"));
		}
		

		// print no of copies sold by RPA Course
		System.out.println(jsc.getInt("courses[2].copies"));
		
		for(int i=0; i<courseCount;i++) {
			if(jsc.getString("courses["+i+"].title").equals("RPA")) {
				System.out.println("No of copies sold by RPA");
				System.out.println(jsc.getInt("courses["+i+"].copies"));
				break;
			}
		}
		
		// get all the courses and details & dasboard 
		System.out.println(jsc.getMap("dashboard"));
		System.out.println(jsc.getList("courses"));
		
		// check total price matches
		int purchasePrice = jsc.getInt("dashboard.purchaseAmount");
		System.out.println(purchasePrice);
		int totalPrice = 0;
		for(int i=0;i<courseCount;i++) {
			totalPrice += jsc.getInt("courses["+i+"].price") * jsc.getInt("courses["+i+"].copies");
		}
		System.out.println("Totalprice based on calculation:"+totalPrice);
		if(purchasePrice == totalPrice) {
			System.out.println("Price matches");
		}

	}

}
