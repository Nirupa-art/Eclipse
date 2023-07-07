package Satya;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StandAloneTest {
	
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		LandingPage lp=new LandingPage(driver);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		/*driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.cssSelector("input[type='email']:nth-child(1)")).sendKeys("nirupa.thota@gmail.com");
		driver.findElement(By.xpath("(//input[@class='input-text'])[3]")).sendKeys("Password2luma");
		driver.findElement(By.xpath("//fieldset/div/div/button/span")).click();*/
		lp.LoginApplication("nirupa.thota@gmail.com","Password2luma");
		Actions action = new Actions(driver);
		
		/*action.moveToElement(driver.findElement(By.xpath("//div/nav/ul/li[4]/a/span[1]")));//mve to the  arrow
		action.perform();
		driver.findElement(By.xpath("(//div/nav/ul/li[4]/ul/li/a/span)[2]")).click();//click fitness equipment*/
		Productpage pp=new Productpage(driver,action);
		pp.loadproducts();
		//List<WebElement> items=pp.getProductList();
		
		pp.addproductToCart("Sprite Foam Roller");
		
		
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-item")));
		List<WebElement> items=driver.findElements(By.cssSelector(".product-item"));// take the items in to list*/
		
		//select the product with name Sprite foam roller , based on the name matching found in tag a.
		
		//WebElement prod=items.stream().filter(pr->pr.findElement(By.cssSelector("[class='product name product-item-name'] a")).getText().equals("Sprite Foam Roller")).findFirst().orElse(null);
		//Thread.sleep(3000);		
		//prod.click();
		
		
		//Thread.sleep(3000);
		//WebElement AddToCart = prod.findElement(By.cssSelector("button[title='Add to Cart']"));
		//WebElement AddToCart = prod.findElement(By.xpath("//button[@class='action tocart primary']"));xpath not working for this
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(addTocart)); 

//click on addTocart button.
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("a[class='action showcart']")).click();//click the cart
		driver.findElement(By.cssSelector("a[class='action viewcart']")).click();//click "view and edit cart"link
		
		System.out.println("here");
		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".product-item-details a"));
		System.out.println(cartproducts.get(0).getText());
		Boolean match=cartproducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase("Sprite Foam Roller"));
		Assert.assertTrue(match);
		
		
		
		
		
	}
	///additional code
	/*public void getScreenShot(String testcasename) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("User.dir")+"//reports"+ testcasename+".png");
		FileUtils.copyFile(source,file);
		return file;*/

		
	}


