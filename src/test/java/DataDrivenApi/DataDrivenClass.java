package DataDrivenApi;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenClass {

	@Test(dataProvider = "empDataProviding")
	public void PostNewUser(String eName,String eSal,String eAge)
	{
		//Specify base URI
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";

		//Request Object has created
		RequestSpecification httpRequest=RestAssured.given();

		//Request payload sending along with post request
		JSONObject requestParams=new JSONObject();
		requestParams.put("employee_name", eName);
		requestParams.put("employee_salary", eSal);
		requestParams.put("employee_age", eAge);

		httpRequest.header("Content-Type","application/json;charset=utf-8");
		httpRequest.body(requestParams.toJSONString());

		//Send post request
		Response response=httpRequest.request(Method.POST,"/create");

		//Capture response body to perform validations
		String data=response.getBody().asString();

		System.out.println("Response Body Is :"+data);
		Assert.assertEquals(data.contains(eName),true);
		Assert.assertEquals(data.contains(eSal),true);
		Assert.assertEquals(data.contains(eAge),true);

		int Status=response.getStatusCode();
		Assert.assertEquals(Status, 200);
	}

	@DataProvider(name="empDataProviding")
	String [][] GetUser() throws IOException, InterruptedException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/DataDrivenApi/PostData.xlsx";
		int RowNum=XlUtils.getRowCount(path, "Sheet1");
		int CellNum=XlUtils.getCellCount(path, "Sheet1", 1);
		//String empdata[][]= {{"abc123","30000","25",""},{"xyz123","50000","33",""},{"tql784","78000","35",""}};
		String empData[][]=new String[RowNum][CellNum];
		for(int i=1;i<=RowNum;i++)
		{
			for(int j=0;j<CellNum;j++)
			{
				empData[i-1][j]=XlUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return empData;
	}
}
