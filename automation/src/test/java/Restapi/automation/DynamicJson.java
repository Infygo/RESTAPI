package Restapi.automation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsonpayload.jsonpath;
import jsonpayload.payload;

import static io.restassured.RestAssured.*;

public class DynamicJson {
    
	@Test(dataProvider = "BookData")
	public void addBook(String is, String ai) {
		// add book method
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String addBookResponse = given().log().all().header("Content-Type", "application/json")
				.body(payload.addBook(is, ai)).when().post("Library/Addbook.php").then().log().all().assertThat()
				.statusCode(200).extract().asString();

		JsonPath js = jsonpath.rawToJson(addBookResponse);
		String bookId = js.getString("ID");
		System.out.println(bookId);

	}
	

	@Test(dataProvider = "BookIds")
	public void deleteBook(String bookId) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String deleteBookResponse = given().log().all().header("Content-Type", "application/json")
				.body(payload.deleteBook(bookId)).when().post("Library/DeleteBook.php").then().log().all().assertThat()
				.statusCode(200).extract().asString();

		JsonPath jsp = jsonpath.rawToJson(deleteBookResponse);
		System.out.println(jsp.getString("msg"));

	}

	@DataProvider(name = "BookData")
	public Object getBookData() {
		return new Object[][] { { "jkl", "567" }, { "mno", "678" }, { "pqr", "789" } };

	}
	
	@DataProvider(name="BookIds")
	public Object getBookIds() {
		return new Object[] {"jkl567","mno678","pqr789"};
		
	}
}
