package TestClasses;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.CommonElement;
import PageObjects.LandingPage;
import PageObjects.OrderPage;
import PageObjects.ProductCataLogue;
import rahulshettyacademy.testComponents.BaseTest;

public class LoginCheck extends BaseTest {
	
	@Test(dataProvider = "Getdata")
	void LoginCheckWithIncrtData(HashMap<String,String> input)
	{
		
		landingPage.loginApplication(input.get("Email"),input.get("Password"));
		Assert.assertEquals(2,4);
	}
////	@Test
//	void logincheckWithListHashmap() throws IOException
//	{
//		landingPage.loginApplication(GetdataHash().get(0).get("Email"),GetdataHash().get(0).get("Password"));
//	}
}
