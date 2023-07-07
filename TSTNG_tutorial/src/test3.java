import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test3 {
	
	@Test
	public  void Demo5() {
		// TODO Auto-generated method stub
     System.out.println("Homepage");
	}
	@Parameters({ "URL"})
	@Test
	public  void Demo6(String urlname) {
		// TODO Auto-generated method stub
     System.out.println("loginpage");
     System.out.println(urlname);
	}
	@Test
	public  void Demo7() {
		// TODO Auto-generated method stub
     System.out.println("nextpage");
	}
	
}
