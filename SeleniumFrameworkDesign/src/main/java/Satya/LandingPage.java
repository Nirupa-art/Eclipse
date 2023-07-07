package Satya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Sign In")
	WebElement signin1;
	
	@FindBy(css="input[type='email']:nth-child(1)")
	WebElement emailid;
	
	@FindBy(xpath="(//input[@class='input-text'])[3]")
	WebElement pwd;
	
	@FindBy(xpath="//fieldset/div/div/button/span")
	WebElement loginBtn;
	
	public void LoginApplication(String email,String password) {	
		signin1.click();
		emailid.sendKeys(email);
		pwd.sendKeys(password);
		loginBtn.click();	
	    return;
	}
	

}
