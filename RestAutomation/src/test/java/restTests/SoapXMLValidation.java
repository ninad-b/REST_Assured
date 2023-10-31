package restTests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SoapXMLValidation {

	@Test
	public void validateSoapXML() throws IOException
	{
		
		File testSoapXMLRequest = new File("./SoapRequests/SoapReqTestFile.xml");
		
		if(testSoapXMLRequest.exists())
			System.out.println(">> File Exists");
		FileInputStream fis = new FileInputStream(testSoapXMLRequest);
		String requestBody = IOUtils.toString(fis, "UTF-8");
		
		baseURI="http://webservices.oorsprong.org/";
		
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(requestBody) //xml file path to be provided to the body
		.when()
			.post("/websamples.countryinfo/CountryInfoService.wso")
		.then()
			.statusCode(200).log().all();
	}
}
