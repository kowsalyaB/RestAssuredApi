package DemoAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_REQUEST {

	@Test
	public void ValidateAllJsonResponse()
	{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api/users";

		//Request Object has created
		RequestSpecification httpRequest=RestAssured.given();

		//Response Object stored after request
		Response response=httpRequest.request(Method.GET,"/8"); //API Key Value like alphanumaric formet

		//Get all JSON response
		JsonPath jsonpathvalue=response.jsonPath();
		
		String EmailValue=jsonpathvalue.get("email");
		System.out.println("Email Is :"+EmailValue);
		String FirstName=jsonpathvalue.get("first_name");
		System.out.println("First Name Is Is :"+FirstName);
		String LastName=jsonpathvalue.get("last_name");
		System.out.println("Last name Is :"+LastName);
		String Avatar=jsonpathvalue.get("avatar");
		System.out.println("Avatar Is :"+Avatar);
		
		Assert.assertEquals(EmailValue, null);
	}
}
