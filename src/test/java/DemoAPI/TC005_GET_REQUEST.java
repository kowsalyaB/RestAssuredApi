package DemoAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_REQUEST {

	@Test
	public void ValidateJsonResponse()
	{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api/users";

		//Request Object has created
		RequestSpecification httpRequest=RestAssured.given();

		//Response Object stored after request
		Response response=httpRequest.request(Method.GET,"/2"); //API Key Value like alphanumaric formet

		//Print response in console window
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body Is: "+ResponseBody);
		
		//Check response body
		Assert.assertEquals(ResponseBody.contains("janet.weaver@reqres.in"), true);
	}
}
