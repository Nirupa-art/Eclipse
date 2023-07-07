package Reporting.Extentreports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSample {
	ExtentReports extent;
	@BeforeTest
	public void config() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";// gives the current project  path.
		//Extentreports , ExtentsparkReporter mostly used for here
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("web automation results");//set the report name as web automation results.
		reporter.config().setDocumentTitle("Test results");
		
		 extent=new ExtentReports();
		//ExtentSparkReporter creates all config necessary for reporting. ExtentReports is main class wich handles reporting.
		 extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Rupa");
	}
	
	@Test
	public void ERS() {
		
		ExtentTest test=extent.createTest("Initial demo");// this is a mandatory step.here test is the object which holds the result report.
		WebDriver driver=new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		System.out.println(driver.getTitle());
		test.fail("sample Result do not match");
		extent.flush();
		
	}

}
