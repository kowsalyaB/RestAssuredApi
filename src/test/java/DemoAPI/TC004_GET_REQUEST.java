package DemoAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_REQUEST {

	@Test
	public void GetAllHeaders()
	{
		//Specify base URI
				RestAssured.baseURI="https://reqres.in/api";

				//Request Object has created
				RequestSpecification httpRequest=RestAssured.given();

				//Response Object stored after request
				Response response=httpRequest.request(Method.GET,"/employees"); //API Key Value like alphanumaric formet

				//Print response in console window
				String ResponseBody=response.getBody().asString();
				System.out.println("Response Body Is: "+ResponseBody);
				
				//Capture all headers from response
				Headers allHeaders=response.headers();
				
				for(Header headers:allHeaders)
				{
					System.out.println(headers.getName()+" : "+headers.getValue());
				}
	}
}
