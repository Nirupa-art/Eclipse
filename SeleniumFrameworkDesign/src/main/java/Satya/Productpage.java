package Satya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

import java.util.List;

public class Productpage extends AbstractComponents{
	
	WebDriver driver;
	Actions action;
	public Productpage(WebDriver driver, Actions action) {
		//initialization
		super(driver);
		this.driver=driver;
		this.action=action;
		PageFactory.initElements(driver,this);
	}
	//Actions action=new Actions(driver);
		
	@FindBy(css=".product-item")
	List<WebElement> products;
	
	@FindBy(xpath="//div/nav/ul/li[4]/a/span[1]")
	WebElement arrow;
	
	@FindBy(xpath="(//div/nav/ul/li[4]/ul/li/a/span)[2]")
	WebElement fitnessequipment;
	
	public void loadproducts(){
		action.moveToElement(arrow).build().perform();
		fitnessequipment.click();
		
	}
	
	
	
	
	By productsBy=By.cssSelector(".product-item");
	
	public List<WebElement> getProductList(){
		waitforelemnttoAppear(productsBy);
		return products;
	}
	
	public WebElement getproductByName(String productname) {
		WebElement prod=getProductList().stream().filter(pr->
		pr.findElement(By.cssSelector("[class='product name product-item-name'] a")).getText().equals(productname)).findFirst().orElse(null);
	    return prod;
	}
	public void addproductToCart(String productname) {
		WebElement prod=getproductByName(productname);
		action.moveToElement(prod).build().perform();
		prod.findElement(By.cssSelector("button[title='Add to Cart']")).click();
		
	}


}
