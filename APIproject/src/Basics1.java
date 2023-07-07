import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.Reusablemethods;
import files.payload;

public class Basics1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//validate Add place API is working
		//given - all input details
		//when-submit the API - resource, http method
		//Then - validate the response
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		//.body(payload.Addplace()).when().post("maps/api/place/add/json")// static json body from another class
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\msi\\OneDrive\\Desktop\\BDD_RahulShetty\\API_Rahulshetty\\Files\\addplace.json"))))//static json body from another file
		.when().post("maps/api/place/add/json") 
			
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String placeid=js.getString("place_id");
		
		System.out.println(placeid);
		String newaddress="Menifee, california";
		
		//Update details
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+newaddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//get details
		
		String getplaceresponse=given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeid)
		.when().get("maps/api/place/get/json")
		
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1=Reusablemethods.rawToJson(getplaceresponse);
		String actualaddress=js1.getString("address");
		
		Assert.assertEquals(actualaddress, newaddress);
		
		
		
	

}}
