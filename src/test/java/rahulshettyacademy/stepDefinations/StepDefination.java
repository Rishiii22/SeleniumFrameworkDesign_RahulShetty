package rahulshettyacademy.stepDefinations;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.testComponents.BaseTest;

public class StepDefination extends BaseTest {

	@Given("I landed on the ecommerce page")
	public void I_landed_on_the_ecommerce_page() throws IOException
	{
		DriverPrerequisite();
		
	}
	@Given("^I logged in with username (.+) and (.+)")
	public void I_logged_in_with_username_name_and_Password(String username,String password)
	{
		landingPage.loginApplication(username,password);
	}
	@When("I add product to the cart") 
	public void I_add_product_to_the_cart()
	{
		productCataLogue.AddProducts("IPHONE");
		productCataLogue.AddProducts("ZARA");
		commonElement.clickonCart();
	}
	@And("checkout and submit the order")
		public void checkout_and_submit_the_order()
		{
		Assert.assertTrue(cartPage.checkForElementPresence("IPHONE"));
		Assert.assertTrue(cartPage.checkForElementPresence("ZARA"));
		cartPage.CheckoutClick();
		checkoutPage.ClickonCountryDropdown("India");
		checkoutPage.SelectCountry("India");
		
		}
	@Then("{string} should appear on screen")
	public void Thank_you_message_should_appear_on_screen(String msg)
	{
		checkoutPage.placeTheorder();
		System.out.println(msg);
	}
	}
	
