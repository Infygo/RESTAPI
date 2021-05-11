package jsonpayload;

import io.restassured.path.json.JsonPath;

public class jsonpath {
	
	public static JsonPath rawToJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}

}
