package Standalone.stepdefinitions;

public class stepdefimpl extends basetest {
	
	public landingpage lp;
	public productcatalogue  pc
	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException
	{
		lp=launchApplication();// launch application defined in bastest.java
		//code
	}
	
	@Given("^Logged in with (.*) and (.*)$")
	public void loggedin_uname_pwd(String username, String password)
	{
		 pc=landingpage.loginApplication(username,password);
	}
	@when("^I add product (.*) to the cart$")
	public void I_add_product-to_cart(String productname)
	{
		List<WebElement> products = pc.getproductList();
		pc.addproductToCart(productname);
	}
	
	
}
