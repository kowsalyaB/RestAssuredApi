package org.RestApi.BaseTest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	public static RequestSpecification httpRequest;
	public static Response response;
	public String EmpID="8";
	public Logger logger;

	@BeforeClass
	public void SetUp()
	{
		logger=Logger.getLogger("ApI Test");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}

}
