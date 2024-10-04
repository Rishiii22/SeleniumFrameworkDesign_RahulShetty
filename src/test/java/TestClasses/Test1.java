package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.CommonElement;
import PageObjects.LandingPage;
import PageObjects.ProductCataLogue;
import PageObjects.OrderPage;
import rahulshettyacademy.testComponents.BaseTest;
import rahulshettyacademy.testComponents.WebDriverDeclaration;

public class Test1 extends BaseTest {
	 
	@Test
	void TestOrderProducts()
	{		
		landingPage.loginApplication("test34@gmail.com","Testing21");
		productCataLogue.AddProducts("IPHONE");
		productCataLogue.AddProducts("ZARA");
		commonElement.clickonCart();
		Assert.assertTrue(cartPage.checkForElementPresence("IPHONE"));
		Assert.assertTrue(cartPage.checkForElementPresence("ZARA"));
		cartPage.CheckoutClick();
		checkoutPage.ClickonCountryDropdown("India");
		checkoutPage.SelectCountry("India");
		checkoutPage.placeTheorder();
	}
	@Test
	void VerifyPresenceoforders()
	{
		landingPage.loginApplication("test34@gmail.com","Testing21");
		commonElement.clickonOrders();
		Assert.assertTrue(orderPage.CheckForItemAvaliability("IPHONE"));
		Assert.assertTrue(orderPage.CheckForItemAvaliability("ZARA"));
	}
	@Test
	void verifyPresenceoforders1()
	{
		landingPage.loginApplication("test34@gmail.com","Testing21");
		commonElement.clickonOrders();
		Assert.assertTrue(orderPage.CheckForItemAvaliability("IPHONE"));
		Assert.assertTrue(orderPage.CheckForItemAvaliability("ZARAsd"));
	}
	@Test
	void verifyPresenceoforders2()
	{
		landingPage.loginApplication("test34@gmail.com","Testing21");
		commonElement.clickonOrders();
		Assert.assertTrue(orderPage.CheckForItemAvaliability("IPHONE"));
		Assert.assertTrue(orderPage.CheckForItemAvaliability("ZARA"));
	}
	
}
