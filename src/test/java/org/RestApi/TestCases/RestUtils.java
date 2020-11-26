package org.RestApi.TestCases;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	public static String Ename()
	{
		String GenerateName=RandomStringUtils.randomAlphabetic(2);
		return ("Kowsi"+GenerateName);
	}
	public static String ESal()
	{
		String GenerateSal=RandomStringUtils.randomNumeric(5);
		return (GenerateSal);
	}
	public static String EAge()
	{
		String GeneratAge=RandomStringUtils.randomNumeric(2);
		return (GeneratAge);
	}

}
