import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonparse2 {
	
	public static void main(String[] args) {
		
		JsonPath js=new JsonPath(payload.courseprice());
		
		//Print no of courses returned by api
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		//print the purchase amount
		
		int amount=js.getInt("dashboard.purchaseAmount");
		System.out.println(amount);
		
		//print title of the first course
		String titlefirstcourse=js.get("courses[0].title");
		System.out.println(titlefirstcourse);
		
		//Print all course titles and their prices
		
		for(int i=0;i<count;i++) {
			
			System.out.println(js.get("courses["+i+"].title").toString());
			System.out.println(js.get("courses["+i+"].price").toString());
			
		}
		
	//Print no: of copies sold by RPA course
      for(int i=0;i<count;i++) {
    	  
    	  if(js.get("courses["+i+"].title").toString().equalsIgnoreCase("RPA"))
    	System.out.println("The numebr of copies of RPA is"+js.getInt("courses["+i+"].copies"));
			
			
			
		}
		
		
	}

}
