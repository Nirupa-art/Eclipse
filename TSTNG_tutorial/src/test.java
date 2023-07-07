import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {

	
	@Test
	public  void Demo1() {
		// TODO Auto-generated method stub
     System.out.println("Rupa");
	}
	@BeforeClass
	public  void Cleardata() {
		// TODO Auto-generated method stub
     System.out.println("Executed before class");
	}
	@AfterClass
	public  void Storedata() {
		// TODO Auto-generated method stub
     System.out.println("Executed after class");
	}
	@Test
	public  void Demo2() {
		// TODO Auto-generated method stub
     System.out.println("Satya");
	}
	@BeforeTest
	public  void Beforemethod() {
		// TODO Auto-generated method stub
     System.out.println("I will execute first");
	}
	
	@AfterTest
	public  void Aftermethod() {
		// TODO Auto-generated method stub
     System.out.println("I will execute last");
	}
	@Test(dependsOnMethods= {"Demo2"})
	public  void Aemo() {
		// TODO Auto-generated method stub
     System.out.println("1st alphabet");
	}
	@Test(groups= {"smoke"})
	public  void Smoketest2() {
		// TODO Auto-generated method stub

		System.out.println("Smoke test for names");
	}
	
	
	}


