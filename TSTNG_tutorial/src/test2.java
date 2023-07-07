import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test2 {

	@Test
	public  void demo3() {
		// TODO Auto-generated method stub

		System.out.println("Homeloan");
	}
	@Test
	public  void demo4() {
		// TODO Auto-generated method stub

		System.out.println("carloan");
	}
	@Test
	public  void miscloan() {
		// TODO Auto-generated method stub

		System.out.println("miscellaneous");
	}
	@Test
	public void fldlistenere() {
		System.out.println("Here I failed the test case");
		Assert.assertEquals("rupa", "rups");//assertion failed
		
	}
	@Test(dataProvider="getdata")
	public  void miscduplicate(String uname, String pwd) {
		// TODO Auto-generated method stub

		System.out.println("duplicateloan");
		
		System.out.println(uname);
		System.out.println(pwd);
	}
	
	@BeforeTest
	public  void beforemethodLoandetails() {
		// TODO Auto-generated method stub

		System.out.println("I will execute first.");
	}
	@Parameters({"URL"})
	@Test(groups= {"smoke"})
	public  void Smoketest1(String uname) {
		// TODO Auto-generated method stub
		System.out.println(uname);
		System.out.println("Smoke test1 for loan");
	}
	@Test(groups= {"smoke"})
	public  void Smoketest2() {
		// TODO Auto-generated method stub

		System.out.println("Smoke test2 for loan");
	}
	@DataProvider
	public Object[] getdata() {
		
		Object[][] obj=new Object[3][2];
		
		obj[0][0]="rupa";
		obj[0][1]="pwd1";
		
		obj[1][0]="Satya";
		obj[1][1]="pwd2";
		
		obj[2][0]="Kanna";
		obj[2][1]="pwd3";
		return obj;
		
	}
	
}
