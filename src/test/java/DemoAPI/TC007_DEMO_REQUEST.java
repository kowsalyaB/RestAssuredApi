package DemoAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_DEMO_REQUEST {

	@Test
	public void AuthTest()
	{
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";

		//Basic Authondication
		PreemptiveBasicAuthScheme AuthScheme=new PreemptiveBasicAuthScheme();
		AuthScheme.setUserName("ToolsQA");
		AuthScheme.setPassword("TestPassword");

		RestAssured.authentication=AuthScheme;

		//Request Object has created
		RequestSpecification httpRequest=RestAssured.given();

		//Response Object stored after request
		Response response=httpRequest.request(Method.GET,"/"); 

		//Print response in console window
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body Is: "+ResponseBody);

		//Status code & Status Line validation
		int Statuscode=response.getStatusCode();
		String Statusline=response.statusLine();
		System.out.println("Status Code Is: "+Statuscode);
		System.out.println("Status Line Is: "+Statusline);
		Assert.assertEquals(Statuscode, 200);
		Assert.assertEquals(Statusline, "HTTP/1.1 200 OK");
	}

}
