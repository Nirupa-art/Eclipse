package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson4 {
	
	@Test(dataProvider="booksdata")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-type", "application/json").body(payload.Addbook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Hello");
		
		System.out.println(response);
		
		JsonPath js=Reusablemethods.rawToJson(response);
		
		String id=js.getString("ID");
		
		System.out.println(id);
	}
	
	@DataProvider(name="booksdata")
	public Object[][] getData()
	{
		//array - collection of elements
		//multidimentional array- collection of arrays.
		return new Object[][] {{"CPP","111"},{"javac", "144"},{"UNixshell","5565"}};
	}

}
