package DemoAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_REQUEST {
	@Test
	public void VerifySpecificHeaders()
	{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api/users";

		//Request Object has created
		RequestSpecification httpRequest=RestAssured.given();

		//Response Object stored after request
		Response response=httpRequest.request(Method.GET,"/5"); //API Key Value like alphanumaric formet

		//Print response in console window
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body Is: "+ResponseBody);

		//Capture details of headers from response and Validating headers
		String Contenttype=response.header("Content-Type");
		System.out.println("Content Type Is :"+Contenttype);
		Assert.assertEquals(Contenttype, "application/json; charset=utf-8");
		
		String Transferencoding=response.header("Transfer-Encoding");
		System.out.println("Transfer Encoding Is :"+Transferencoding);
		Assert.assertEquals(Transferencoding, "chunked");
		
		String Contentencoding=response.header("Content-Encoding");
		System.out.println("Content Encoding Is :"+Contentencoding);
		Assert.assertEquals(Contentencoding, "gzip");
	}
}
