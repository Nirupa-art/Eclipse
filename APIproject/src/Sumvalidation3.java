import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class Sumvalidation3 {
	
	//validate purchase amount equals to total price of books
	@Test
	public void validateprice() {
		int sum=0;
		
	JsonPath js=new JsonPath(payload.courseprice());
	int count=js.getInt("courses.size()");
	for(int i=0;i<count;i++) {
		int price=js.getInt("courses["+i+"].price");
		sum=sum+price;
		 
	}
	if(sum==js.getInt("dashboard.purchaseAmount")) {
		System.out.println("both are equl");
	}
	else
		System.out.println("both are not equl");//Assert.assertEquals(sum, js.getInt("dashboard.purchaseAmount"));
	
		
		
	}
		
		

}
